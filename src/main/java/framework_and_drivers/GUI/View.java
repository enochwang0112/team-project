package framework_and_drivers.GUI;

import interface_adapters.IView;
import interface_adapters.ViewModel;

import javax.swing.*;
import java.awt.*;

public class View implements IView {
    private final JFrame frame = new JFrame();

    public View(){
        JPanel panel1 = new JPanel();

        // TODO: Get rid of these numbers and use ViewModel instead.
        ChessBoard chessboard = new ChessBoard(60, 40);
        PlayerCard playerCardTop = new PlayerCard(60);
        PlayerCard playerCardBottom = new PlayerCard(60);
        AnalysisBar analysisBar = new AnalysisBar(20, 620);
        // width is height/30 and height is squareSize*8+2*playerCard+2*(2*vgap)
        // vgap = 5 unless otherwise set in playercard

        panel1.add(playerCardTop);
        panel1.add(chessboard);
        panel1.add(playerCardBottom);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        frame.add(panel1);
        frame.add(analysisBar, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void render(ViewModel viewModel){
        // TODO: Implement this method
    }

    /**
     * Sets the frame to be visible. Equivalent to setVisible(true).
     */
    public void show() { frame.setVisible(true); }
}
