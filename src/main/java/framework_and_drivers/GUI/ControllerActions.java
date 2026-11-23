package framework_and_drivers.GUI;

public interface ControllerActions {
    void nextMove();
    void prevMove();
    void setMove(int moveNum);
    void loadNewUser(String username);
    void loadNewGame(int gameNum);
    void loadNewMonth(String month);
}
