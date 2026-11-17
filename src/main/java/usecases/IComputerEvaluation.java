package usecases;

import entities.ComputerEval;

public interface IComputerEvaluation {
    ComputerEval getEvaluation(String FEN, int depth);
}
