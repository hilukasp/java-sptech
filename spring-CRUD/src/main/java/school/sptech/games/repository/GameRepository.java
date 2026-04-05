package school.sptech.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.games.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    boolean existsByNomeAndEmpresa(String nome, String empresa);
    boolean existsByNomeAndEmpresaAndIdNot(String nome, String empresa, Long id);
}
