package school.sptech.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//interface é um assinatura
public interface HeroiRepository extends JpaRepository<Heroi,Integer> {
    List<Heroi> findByForcaGreaterThan(Integer valor);
    //essa função é da propria biblioteca mas não tem autocomplete por conta do intellij
}
