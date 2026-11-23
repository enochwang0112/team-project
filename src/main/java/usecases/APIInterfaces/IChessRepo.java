package usecases.APIInterfaces;

import entities.ChessGame;

import java.util.ArrayList;

public interface IChessRepo {
    ArrayList<ChessGame> getGames(String username);
}
