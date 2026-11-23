package usecases.api_interfaces;

import entities.ComputerEval;

public interface IComputerEvaluation {
    ComputerEval getEvaluation(String FEN, int depth);
}
