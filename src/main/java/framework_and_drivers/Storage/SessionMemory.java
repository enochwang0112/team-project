package framework_and_drivers.Storage;

import entities.ChessGame;
import entities.ComputerEval;
import usecases.StorageInterfaces.IActiveGameDataStorage;
import usecases.StorageInterfaces.IEvaluationStorage;
import usecases.StorageInterfaces.IGameArchiveStorage;

import java.util.ArrayList;
import java.util.List;

public class SessionMemory implements IGameArchiveStorage, IEvaluationStorage, IActiveGameDataStorage {

    ArrayList<ChessGame> gameArchive;
    ComputerEval evaluation;
    ChessGame activeGame;
    int currentMove;

    @Override
    public List<ChessGame> getGames() {
        return this.gameArchive;
    }

    @Override
    public void setGames(List<ChessGame> games) {
        this.gameArchive = new ArrayList<>(games);
    }

    @Override
    public ComputerEval getComputerEval() {
        return this.evaluation;
    }

    @Override
    public void setComputerEval(ComputerEval evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public ChessGame getActiveGame() {
        return this.activeGame;
    }

    @Override
    public void setActiveGame(ChessGame game) {
        this.activeGame = game;
    }

    public int getCurrentMove(){
        return this.currentMove;
    }

    public void setCurrentMove(int currentMove) {
        this.currentMove = currentMove;
    }
}
