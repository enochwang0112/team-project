package usecases.navigate_game;

import entities.ChessGame;
import usecases.storage_interfaces.IActiveGameStorage;
import usecases.storage_interfaces.IEvaluationStorage;

public class NavigateGameInteractor implements INavigateGame{
    private final IActiveGameStorage storage;
    private final IEvaluationStorage evaluation;
    private final NavigateGameOutputBoundary output;

    public NavigateGameInteractor(IActiveGameStorage storage,
                                  IEvaluationStorage evaluation,
                                  NavigateGameOutputBoundary output) {
        this.storage = storage;
        this.evaluation = evaluation;
        this.output = output;
    }

    @Override
    public void nextMove() {
        setMove(storage.getCurrentMove() + 1);
    }

    @Override
    public void prevMove() {
        setMove(storage.getCurrentMove() - 1);
    }

    @Override
    public void setMove(int moveNum) {
        ChessGame game = storage.getActiveGame();
        if (game == null) {
            // output.presentFailure
            return;
        }

        // Will implement the rest of this once ChessGame entity is implemented.
    }
}
