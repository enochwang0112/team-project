package usecases.StorageInterfaces;

import entities.ChessGame;

public interface IActiveGameDataStorage {
    ChessGame getActiveGame();
    void setActiveGame(ChessGame game);
}
