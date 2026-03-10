package school.sptech.jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/herois")
public class HeroiController {
    private final HeroiRepository heroiRepository;

    public HeroiController(HeroiRepository heroiRepository) {
        this.heroiRepository = heroiRepository;
    }

    @GetMapping
    public ResponseEntity<List<Heroi>> listarHerois(){
        List<Heroi> herois = heroiRepository.findAll();
        if(herois.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(herois);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Heroi> listarPorId(@PathVariable Integer id){
        Optional<Heroi> heroiOptional = heroiRepository.findById(id);
        //Option uma classe do java que te auxilia com valores que podem vir nulo ou não
        if(heroiOptional.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        Heroi heroi=heroiOptional.get();
        return ResponseEntity.status(200).body(heroi);

    }

    @PostMapping
    public ResponseEntity<Heroi> criarHeroi(@RequestBody HeroiDTO heroiDTO){
        //save serve pro post e put
        //Heroi heroiCriado=heroiRepository.save(heroi);

        Heroi heroiCriado=new Heroi();
        heroiCriado.setNome(heroiDTO.getNome());
        heroiCriado.setForca(heroiDTO.getForca());
        heroiCriado.setArma(heroiDTO.getArma());
        heroiCriado.setTemCapa(heroiDTO.getTemCapa());

        Heroi heroiSalvo=heroiRepository.save(heroiCriado);
        return ResponseEntity.status(201).body(heroiSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Heroi> atualizarHeroi(@PathVariable Integer id, @RequestBody HeroiDTO heroiDTO){

        boolean heroi=heroiRepository.existsById(id);//retorna int
        if (!heroi){
            return ResponseEntity.status(404).build();
        }

        Heroi heroiAtualizado=new Heroi();
        heroiAtualizado.setId(id);
        heroiAtualizado.setNome(heroiDTO.getNome());
        heroiAtualizado.setForca(heroiDTO.getForca());
        heroiAtualizado.setArma(heroiDTO.getArma());
        heroiAtualizado.setTemCapa(heroiDTO.getTemCapa());

        Heroi heroiSalvo=heroiRepository.save(heroiAtualizado);
        return ResponseEntity.status(201).body(heroiSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Heroi> deletarHeroi(@PathVariable Integer id){
        boolean heroi = heroiRepository.existsById(id);
        if (heroi){
            heroiRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();

    }

    @GetMapping("/buscar")
    //http://localhost:8080/herois/buscar/forca?maiorQue=70
    public ResponseEntity<List<Heroi>> buscarHeroiForca(@RequestParam Integer forcaMaiorQue){
//        List<Heroi> herois= heroiRepository.findAll().stream().filter(heroi -> heroi.getForca()>forcaMaiorQue).toList();
        List<Heroi> herois= heroiRepository.findByForcaGreaterThan(forcaMaiorQue);
        if (herois.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(herois);
    }
}
