package usecases.storage_interfaces;

import entities.ChessGame;

public interface IActiveGameStorage {
    ChessGame getActiveGame();
    void setActiveGame(ChessGame game);
    int getCurrentMove();
    void setCurrentMove(int currentMove);
}
