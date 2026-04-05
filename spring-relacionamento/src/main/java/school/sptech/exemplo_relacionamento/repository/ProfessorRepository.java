package school.sptech.exemplo_relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exemplo_relacionamento.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
