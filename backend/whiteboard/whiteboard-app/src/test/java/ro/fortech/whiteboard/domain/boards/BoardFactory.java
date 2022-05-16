package ro.fortech.whiteboard.domain.boards;

import lombok.experimental.UtilityClass;
import ro.fortech.whiteboard.domain.boards.dto.BoardRequestDto;
import ro.fortech.whiteboard.domain.boards.dto.BoardResponseDto;
import ro.fortech.whiteboard.domain.boards.service.model.Board;
import ro.fortech.whiteboard.domain.teams.service.model.TeamEntity;
import ro.fortech.whiteboard.teams.dataProvider.TeamDataProvider;

import java.time.LocalDateTime;
import java.time.Month;

@UtilityClass
public class BoardFactory {

    private final String ID = "6ff96784-b572-4ada-b430-713819f0128b";
    private final String TITLE = "BoardResponse1";
    private final LocalDateTime CREATE_DATE_TIME = LocalDateTime.of(2000,
            Month.NOVEMBER, 13, 19, 30, 40);
    private final String TEAM_ID = "e46c9ac4-389c-11ec-8d3d-0242ac130003";
    private final TeamEntity TEAM = TeamDataProvider.getTeamEntityMock();

    public static Board getBoard() {
        Board board = new Board();
        board.setId(ID);
        board.setTitle(TITLE);
        board.setCreateDateTime(CREATE_DATE_TIME);
        board.setTeam(TEAM);
        return board;
    }

    public static BoardRequestDto getBoardRequestDto() {
        BoardRequestDto boardRequestDto = new BoardRequestDto();
        boardRequestDto.setId(ID);
        boardRequestDto.setTitle(TITLE);
        boardRequestDto.setTeamId(TEAM_ID);
        return boardRequestDto;
    }

    public static BoardResponseDto getBoardResponseDto() {
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(ID);
        boardResponseDto.setTitle(TITLE);
        boardResponseDto.setCreateDateTime(CREATE_DATE_TIME);
        boardResponseDto.setTeamId(TEAM_ID);
        return boardResponseDto;
    }
}
