import framework_and_drivers.GUI.View;
import interface_adapters.Controller;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Controller controller = new Controller();
            View view = new View(controller);

            view.show();
        });
    }
}
