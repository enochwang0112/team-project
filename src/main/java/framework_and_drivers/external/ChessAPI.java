package framework_and_drivers.external;

import entities.ChessGame;
import usecases.APIInterfaces.IChessRepo;

import java.util.ArrayList;

public class ChessAPI implements IChessRepo {
    @Override
    public ArrayList<ChessGame> getGames(String username) {
        // TODO: Implement this method
        return null;
    }
}
