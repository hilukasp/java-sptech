package school.sptech.exemplo_relacionamento.service;

import org.springframework.stereotype.Service;
import school.sptech.exemplo_relacionamento.exception.CursoNaoEncontradoException;
import school.sptech.exemplo_relacionamento.exception.ProfessorNaoEncontradoException;
import school.sptech.exemplo_relacionamento.model.Curso;
import school.sptech.exemplo_relacionamento.model.Professor;
import school.sptech.exemplo_relacionamento.repository.CursoRepository;
import school.sptech.exemplo_relacionamento.repository.ProfessorRepository;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    public CursoService(CursoRepository cursoRepository, ProfessorRepository professorRepository) {
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
    }


    public Curso criar(Curso curso, Integer professorId) {
//        if (!professorRepository.existsById(professorId)){
//            throw new ProfessorNaoEncontradoException(professorId);
//        }

        Professor professorEntidade=professorRepository.findById(professorId).orElseThrow(()->new ProfessorNaoEncontradoException(professorId));
        curso.setProfessor(professorEntidade);

        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Integer id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new CursoNaoEncontradoException(id));
    }

    public Curso atualizar(Integer id, Curso cursoAtualizado,Integer professorId) {
        if (!cursoRepository.existsById(id)) {
            throw new CursoNaoEncontradoException(id);
        }
        Professor professorEntidade=professorRepository.findById(professorId).orElseThrow(()->new ProfessorNaoEncontradoException(professorId));
        cursoAtualizado.setProfessor(professorEntidade);
        cursoAtualizado.setId(id);
        return cursoRepository.save(cursoAtualizado);
    }

    public void deletar(Integer id) {
        if (!cursoRepository.existsById(id)) {
            throw new CursoNaoEncontradoException(id);
        }
        cursoRepository.deleteById(id);
    }

    public Double getMedia() {
        return cursoRepository.getMedia();
    }
}
