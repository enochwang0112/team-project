package usecases.load_monthly_games;

import entities.ChessGame;

import java.util.List;

public interface LoadMonthlyGamesOutputBoundary {
    void setMonthlyGameList(List<ChessGame> gameList);
}
