package usecases.StorageInterfaces;

import entities.ComputerEval;

public interface IEvaluationStorage {
    ComputerEval getComputerEval();
    void setComputerEval(ComputerEval evaluation);
}
