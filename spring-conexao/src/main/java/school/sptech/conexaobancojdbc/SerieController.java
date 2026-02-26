package school.sptech.conexaobancojdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/series")//recurso, sempre no plural
public class SerieController {
    //injeção de dependência
    private final JdbcTemplate jdbcTemplate;

    public SerieController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //.query -> consulta que retorna lista de objeto
    //.queryForObject -> consulta que retorna um objeto
    //.update-> insert,delete,update
    @GetMapping
    public ResponseEntity<List<Serie>> listarSeries(){
        String sql= "select * from serie;";
        List<Serie> series=jdbcTemplate.query(sql, new BeanPropertyRowMapper<Serie>(Serie.class));
        if (series.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(series);
    }

    //pesquisar por id
    @GetMapping("/{id}")
    public ResponseEntity<Serie> exibirSerie(@PathVariable UUID id){
        //String sql="select * from serie where id = "+ id; //permite sql injection
        //String sql="select * from serie where id = "+ a'; DROP TABLE serie; --
        String sql="select * from serie where id = ?"; //forma ideal

        try{
            //Serie serie=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Serie>(Serie.class));
            Serie serie=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Serie>(Serie.class),id);
            return ResponseEntity.status(200).body(serie);
        }catch (Exception e){
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<Serie> criarSerie(@RequestBody Serie novaSerie){
        String sql= "insert into serie (nome,plataforma,nota) values(?,?,?)";
        try{
            jdbcTemplate.update(sql,
                    novaSerie.getNome(),
                    novaSerie.getPlataforma(),
                    novaSerie.getNota()
                    );
            return ResponseEntity.status(201).body(novaSerie);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> atualizarSerie(@PathVariable UUID id, @RequestBody Serie novaSerie){
        String sql= "update serie set nome = ?, plataforma = ?, nota = ? where id = ?";
        try{
            jdbcTemplate.update(sql,
                    novaSerie.getNome(),
                    novaSerie.getPlataforma(),
                    novaSerie.getNota(),
                    id
            );
            return ResponseEntity.status(201).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSerie(@PathVariable UUID id){
        String sql="delete from serie where id = ?";

        try{
            jdbcTemplate.update(sql,id);
            return ResponseEntity.status(204).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }

    //buscar por nome
    @GetMapping("/pesquisar")
    //http://localhost:8080/series/pesquisar?nome=Bre
    public ResponseEntity<List<Serie>> pesquisarSeriePorNome(@RequestParam String nome){
        String sql="select * from serie where nome like ?";

        try{
            List<Serie> series=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Serie>(Serie.class),"%"+nome+"%");
            return ResponseEntity.status(200).body(series);
        }catch (Exception e){
            return ResponseEntity.status(404).build();
        }
    }

}
