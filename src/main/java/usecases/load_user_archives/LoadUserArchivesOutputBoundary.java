package usecases.load_user_archives;

import entities.ChessGame;

import java.util.List;

public interface LoadUserArchivesOutputBoundary {
    void setMonthList(List<ChessGame> gameArchive);
}
