package framework_and_drivers.GUI;

import interface_adapters.IView;
import interface_adapters.ViewModel;

import javax.swing.*;
import java.awt.*;

public class View implements IView {
    private final JFrame frame = new JFrame();

    public View(){
        // TODO: Get rid of these numbers and use ViewModel instead.
        ChessBoard chessboard = new ChessBoard(60, 40);
        PlayerCard playerCardTop = new PlayerCard(60);
        PlayerCard playerCardBottom = new PlayerCard(60);

        frame.add(playerCardTop, BorderLayout.NORTH);
        frame.add(chessboard, BorderLayout.CENTER);
        frame.add(playerCardBottom, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void render(ViewModel viewModel){
        // TODO: Implement this method
    }

    public void show() {
        frame.setVisible(true);
    }
}
