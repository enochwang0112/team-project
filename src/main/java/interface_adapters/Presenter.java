package interface_adapters;

import usecases.navigate_game.NavigateGameOutputBoundary;

public class Presenter implements NavigateGameOutputBoundary{
    @Override
    public void updateGame(String fen, int moveNum) {
        // TODO: Implement this
    }
}
