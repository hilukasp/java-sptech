package school.sptech.exemplo_relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.exemplo_relacionamento.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    @Query("Select avg (c.nota) From Curso c")
    Double getMedia();
}
