package framework_and_drivers.storage;

import entities.ChessGame;
import entities.ComputerEval;
import usecases.storage_interfaces.IActiveGameStorage;
import usecases.storage_interfaces.IEvaluationStorage;
import usecases.storage_interfaces.IGameArchiveStorage;

import java.util.ArrayList;
import java.util.List;

public class SessionMemory implements IGameArchiveStorage, IEvaluationStorage, IActiveGameStorage {

    ArrayList<ChessGame> gameArchive;
    ComputerEval evaluation;
    ChessGame activeGame;
    int currentMove;
    String fen;

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
    public String getFEN() {
        return this.fen;
    }

    @Override
    public void setFEN(String fen) {
        this.fen = fen;
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
