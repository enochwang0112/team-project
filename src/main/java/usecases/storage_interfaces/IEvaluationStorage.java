package usecases.storage_interfaces;

import entities.ComputerEval;

public interface IEvaluationStorage {
    ComputerEval getComputerEval();
    void setComputerEval(ComputerEval evaluation);
    String getFEN();
    void setFEN(String fen);
}
