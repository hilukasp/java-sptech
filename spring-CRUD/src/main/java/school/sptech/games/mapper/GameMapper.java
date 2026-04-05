package school.sptech.games.mapper;

import school.sptech.games.dto.GameRequestDto;
import school.sptech.games.dto.GameResponseDto;
import school.sptech.games.entity.Game;

import java.util.List;

public class GameMapper {

    private GameMapper() {
    }

    public static Game toEntity(GameRequestDto dto) {
        Game game = new Game();
        game.setNome(dto.getNome());
        game.setEmpresa(dto.getEmpresa());
        game.setDataPublicacao(dto.getDataPublicacao());
        game.setNota(dto.getNota());
        game.setCrossplataform(dto.isCrossplataform());
        return game;
    }

    public static GameResponseDto toResponseDto(Game game) {
        GameResponseDto dto = new GameResponseDto();
        dto.setId(game.getId());
        dto.setNome(game.getNome());
        dto.setEmpresa(game.getEmpresa());
        dto.setDataPublicacao(game.getDataPublicacao());
        dto.setNota(game.getNota());
        dto.setCrossplataform(game.isCrossplataform());
        return dto;
    }

    public static List<GameResponseDto> toResponseDto(List<Game> games) {
        return games.stream()
                .map(GameMapper::toResponseDto)
                .toList();
    }
}
