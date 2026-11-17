import framework_and_drivers.GUI.View;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            view.show();
        });
    }
}
