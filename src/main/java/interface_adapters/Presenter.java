package interface_adapters;

import usecases.EvaluationOutputBoundary;
import usecases.EvaluationOutputData;
import usecases.UserGamesOutputBoundary;
import usecases.UserGamesOutputData;

public class Presenter implements EvaluationOutputBoundary, UserGamesOutputBoundary {
    @Override
    public void takeEvaluation(EvaluationOutputData outputData) {
        // TODO: Implement this method
    }

    @Override
    public void takeUserGames(UserGamesOutputData outputData) {
        // TODO: Implement this method
    }
}
