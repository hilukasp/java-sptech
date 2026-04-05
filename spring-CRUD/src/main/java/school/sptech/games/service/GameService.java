package school.sptech.games.service;

import org.springframework.stereotype.Service;
import school.sptech.games.entity.Game;
import school.sptech.games.exception.EntidadeConflitoException;
import school.sptech.games.exception.EntidadeNaoEncontradoException;
import school.sptech.games.repository.GameRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> listar(){
        return repository.findAll();
    }

    public Game buscarPorId(Long id){
        Optional<Game> gameOptional= repository.findById(id);

        if (gameOptional.isEmpty()){
            throw new EntidadeNaoEncontradoException("entidade não existe");
        }
        return gameOptional.get();
    }

    public Game cadastrarGame(Game gameParaCadastrar){
        if (repository.existsByNomeAndEmpresa(gameParaCadastrar.getNome(), gameParaCadastrar.getEmpresa())){
            throw new EntidadeConflitoException("Duplicidade");
        }
        Game gameRegistrado = repository.save(gameParaCadastrar);
        return gameRegistrado;
    }

    public Game atualizarGame(Game gameParaAtualizar, Long id){
        if (!repository.existsById(id)){
            throw new EntidadeNaoEncontradoException("não existe");
        }
        if (repository.existsByNomeAndEmpresaAndIdNot(gameParaAtualizar.getNome(),gameParaAtualizar.getEmpresa(),gameParaAtualizar.getId())){
            throw new EntidadeConflitoException("");
        }
        gameParaAtualizar.setId(id);
        Game gameAtualizado=repository.save(gameParaAtualizar);
        return gameAtualizado;
    }

    public void deletarGame(Long id){
        if (!repository.existsById(id)){
            throw new EntidadeNaoEncontradoException("");
        }
        repository.deleteById(id);
    }
}
