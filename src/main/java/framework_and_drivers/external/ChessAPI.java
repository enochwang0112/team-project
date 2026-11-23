package framework_and_drivers.external;

import entities.ChessGame;
import usecases.APIInterfaces.IChessRepo;
import usecases.APIInterfaces.IUserProfileRepo;

import java.awt.*;
import java.util.ArrayList;

public class ChessAPI implements IChessRepo, IUserProfileRepo {
    @Override
    public ArrayList<ChessGame> getGames(String username) {
        // TODO: Implement this method
        return null;
    }

    public Image getProfilePicture(String username){
        // TODO: Implement this method
        return null;
    }
}
