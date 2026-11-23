package usecases.StorageInterfaces;

import entities.ChessGame;

import java.util.List;

public interface IGameArchiveStorage {
    List<ChessGame> getGames();
    void setGames(List<ChessGame> games);
}
