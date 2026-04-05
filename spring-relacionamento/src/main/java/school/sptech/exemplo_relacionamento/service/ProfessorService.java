package school.sptech.exemplo_relacionamento.service;

import org.springframework.stereotype.Service;
import school.sptech.exemplo_relacionamento.exception.ProfessorNaoEncontradoException;
import school.sptech.exemplo_relacionamento.model.Professor;
import school.sptech.exemplo_relacionamento.repository.ProfessorRepository;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor criar(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNaoEncontradoException(id));
    }

    public Professor atualizar(Integer id, Professor professorAtualizado) {
        Professor professorExistente = professorRepository.findById(id)
                .orElseThrow(() -> new ProfessorNaoEncontradoException(id));

        professorAtualizado.setId(id);
        return professorRepository.save(professorAtualizado);
    }

    public void deletar(Integer id) {
        if (!professorRepository.existsById(id)) {
            throw new ProfessorNaoEncontradoException(id);
        }
        professorRepository.deleteById(id);
    }
}
