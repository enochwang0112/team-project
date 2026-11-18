package framework_and_drivers.GUI;

import interface_adapters.Controller;
import interface_adapters.IView;
import interface_adapters.ViewModel;

import javax.swing.*;
import java.awt.*;

public class View implements IView {
    private final JFrame frame = new JFrame();
    private ViewModel viewModel;
    private ChessBoard chessBoard;
    private PlayerCard playerCardBottom;
    private PlayerCard playerCardTop;
    private AnalysisBar analysisBar;
    private Controller controller;

    public View(Controller controller){
        this.controller = controller;

        JPanel chessPlayerPanel = new JPanel();

        // TODO: Get rid of these numbers and use ViewModel instead.
        chessBoard = new ChessBoard(60, 40);
        playerCardTop = new PlayerCard(60);
        playerCardBottom = new PlayerCard(60);
        analysisBar = new AnalysisBar(20, 620);
        // height = squareSize*8+2*playerCard+2*(2*vgap)
        // width = height/30
        // vgap = 5 unless otherwise set in playercard

        chessPlayerPanel.add(playerCardTop);
        chessPlayerPanel.add(chessBoard);
        chessPlayerPanel.add(playerCardBottom);

        chessPlayerPanel.setLayout(new BoxLayout(chessPlayerPanel, BoxLayout.Y_AXIS));

        frame.add(chessPlayerPanel);
        frame.add(analysisBar, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void render(ViewModel viewModel){
        if (this.viewModel == null) {
            this.viewModel = viewModel;
        }

    }

    /**
     * Sets the frame to be visible. Equivalent to frame.setVisible(true).
     */
    public void show() { frame.setVisible(true); }
}
