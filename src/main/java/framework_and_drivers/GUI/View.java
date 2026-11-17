package framework_and_drivers.GUI;

import interface_adapters.IView;

import javax.swing.*;
import java.awt.*;

public class View implements IView {
    private final JFrame frame = new JFrame();

    public View(){
        // TODO: Get rid of these numbers and use ViewModel instead.
        ChessBoard chessboard = new ChessBoard(75, 50);
        frame.add(chessboard, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void render(){
        // TODO: Implement this method
    }

    public void show() {
        frame.setVisible(true);
    }
}
