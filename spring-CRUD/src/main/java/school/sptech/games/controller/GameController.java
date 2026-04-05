package school.sptech.games.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.games.dto.GameRequestDto;
import school.sptech.games.dto.GameResponseDto;
import school.sptech.games.entity.Game;
import school.sptech.games.mapper.GameMapper;
import school.sptech.games.service.GameService;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService service;


    public GameController(GameService service ) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GameResponseDto>> listar() {
        //serviço
        List<Game> games = service.listar();

        //dto
        List<GameResponseDto> response = GameMapper.toResponseDto(games);

        //retorno
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDto> buscarPorId(@PathVariable Long id) {
        //servico
        Game game = service.buscarPorId(id);

        //dto
        GameResponseDto responseDto= GameMapper.toResponseDto(game);

        //retorno
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<GameResponseDto> criar(@RequestBody @Valid GameRequestDto dto) {
        //dto
        Game game = GameMapper.toEntity(dto);

        //servico
        Game salvo = service.cadastrarGame(game);

        //dto
        GameResponseDto responseDto=GameMapper.toResponseDto(salvo);

        //retorno
        return ResponseEntity.status(201).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameResponseDto> atualizar(@PathVariable Long id, @RequestBody @Valid GameRequestDto dto) {
        //dto
        Game game = GameMapper.toEntity(dto);

        //servico
        Game salvo = service.atualizarGame(game,id);

        //dto
        GameResponseDto responseDto=GameMapper.toResponseDto(salvo);

        //retorno
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarGame(id);
        return ResponseEntity.noContent().build();
    }
}
