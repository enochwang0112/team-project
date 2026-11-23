package framework_and_drivers.GUI;

import interface_adapters.IView;
import interface_adapters.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class View implements IView {
    private final JFrame frame = new JFrame();
    // UI Elements
    private final ChessBoard       chessBoard;
    private final PlayerCard       playerCardBottom;
    private final PlayerCard       playerCardTop;
    private final AnalysisBar      analysisBar;
    private final UserLoader       userLoader;
    private final MonthSelector    monthSelector;
    private final GameSelector     gameSelector;
    private final GameMoveScroller gameMoveScroller;

    private ViewModel viewModel;

    public View(ControllerActions actions){
        // User input panel
        JPanel inputPanel = new JPanel();

        userLoader = new UserLoader(loader -> actions.loadNewUser(loader.getUsername()));
        monthSelector = new MonthSelector();
        gameSelector = new GameSelector();
        gameMoveScroller = new GameMoveScroller();

        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(new Color(45, 52, 54));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));

        inputPanel.add(userLoader);
        inputPanel.add(monthSelector);
        inputPanel.add(gameSelector);
        inputPanel.add(gameMoveScroller);

        // Chess-player panel
        JPanel chessPlayerPanel = new JPanel();

        // TODO: Get rid of these numbers and use ViewModel instead.
        chessBoard = new ChessBoard(60, 40);
        playerCardTop = new PlayerCard(60);
        playerCardBottom = new PlayerCard(60);
        analysisBar = new AnalysisBar(20, 620);
        // height = squareSize*8+2*playerCard+2*(2*vgap)
        // width = height/30
        // vgap = 5 unless otherwise set in playercard

        chessPlayerPanel.setLayout(new BoxLayout(chessPlayerPanel, BoxLayout.Y_AXIS));


        chessPlayerPanel.add(playerCardTop);
        chessPlayerPanel.add(chessBoard);
        chessPlayerPanel.add(playerCardBottom);

        frame.add(inputPanel, BorderLayout.WEST);
        frame.add(chessPlayerPanel, BorderLayout.CENTER);
        frame.add(analysisBar, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void render(ViewModel viewModel){

    }

    /**
     * Sets the frame to be visible. Equivalent to frame.setVisible(true).
     */
    public void show() { frame.setVisible(true); }
}
