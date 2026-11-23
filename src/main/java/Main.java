import framework_and_drivers.ControllerActions;
import framework_and_drivers.GUI.View;
import interface_adapters.Controllers.GameArchiveController;
import interface_adapters.Controllers.ReplayController;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            ReplayController replayController = new ReplayController();
            GameArchiveController gameArchiveController = new GameArchiveController();
            ControllerActions controllerActions = new ControllerActions() {
                @Override
                public void nextMove() {
                    replayController.nextMove();
                }

                @Override
                public void prevMove() {
                    replayController.prevMove();
                }

                @Override
                public void setMove(int moveNum) {
                    replayController.setMove(moveNum);
                }

                @Override
                public void loadNewUser(String username) {
                    gameArchiveController.loadNewUser(username);
                }

                @Override
                public void loadNewGame(int gameNum) {
                    gameArchiveController.loadNewGame(gameNum);
                }

                @Override
                public void loadNewMonth(String month) {
                    gameArchiveController.loadNewMonth(month);
                }
            };
            View view = new View(controllerActions);

            view.show();
        });
    }
}
