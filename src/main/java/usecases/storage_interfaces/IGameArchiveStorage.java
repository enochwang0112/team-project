package usecases.storage_interfaces;

import entities.ChessGame;

import java.util.List;

public interface IGameArchiveStorage {
    List<ChessGame> getGames();
    void setGames(List<ChessGame> games);
}
