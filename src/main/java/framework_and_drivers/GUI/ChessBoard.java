package framework_and_drivers.GUI;

import utils.JSONParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class ChessBoard extends JPanel{
    private static final Logger logger = Logger.getLogger(ChessBoard.class.getName());
    private static final Map<Character, ImageIcon> pieceIcons = new HashMap<>();
    private final JLabel[][] board = new JLabel[8][8];
    private static final char[][] initialPos = {{'r','n','b','q','k','b','n','r'},
                                                {'p','p','p','p','p','p','p','p'},
                                                {'*','*','*','*','*','*','*','*'},
                                                {'*','*','*','*','*','*','*','*'},
                                                {'*','*','*','*','*','*','*','*'},
                                                {'*','*','*','*','*','*','*','*'},
                                                {'P','P','P','P','P','P','P','P'},
                                                {'R','N','B','Q','K','B','N','R'}};


    public ChessBoard(int squareSize, int pieceSize){
        loadPieceImages(pieceSize);

        setLayout(new GridLayout(8, 8));
        setPreferredSize(new Dimension(8 * squareSize, 8 * squareSize));

        Color lightSquare = new Color(240, 217, 181);
        Color darkSquare = new Color(181, 136, 99);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JLabel square = new JLabel();
                board[row][col] = square;

                square.setOpaque(true);
                square.setBackground((row + col) % 2 == 0 ? lightSquare : darkSquare);

                char pieceKey = initialPos[row][col];
                if (!(pieceKey == '*')) {
                    square.setIcon(pieceIcons.get(pieceKey));
                }
                else{
                    square.setIcon(null);
                }
                square.setHorizontalAlignment(SwingConstants.CENTER);
                square.setVerticalAlignment(SwingConstants.CENTER);

                add(square);
            }
        }
    }

    /**
     * Sets the position of board.
     *
     * @param positionArray An array of chars representing the chess board.
     *                      The array follows the form
     *                      [[a1, b1, ..., h1], [a2, b2, ..., h2], ..., [a8, b8, ..., h8]]
     *                      and has the same piece notation as FEN with '*' being a blank square.
     *                      Player color will not reverse the position.
     */
    public void setBoardState(char[][] positionArray){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char pieceKey = positionArray[row][col];
                JLabel square = board[row][col];
                if (!(pieceKey == '*')) {
                    square.setIcon(pieceIcons.get(pieceKey));
                }
                else{
                    square.setIcon(null);
                }
            }
        }
    }

    private static void loadPieceImages(int pieceSize) {
        Map<Character, String> pieces = new HashMap<>(Map.ofEntries(
                Map.entry('R', "rook-w"),
                Map.entry('N', "knight-w"),
                Map.entry('B', "bishop-w"),
                Map.entry('Q', "queen-w"),
                Map.entry('K', "king-w"),
                Map.entry('P', "pawn-w"),
                Map.entry('r', "rook-b"),
                Map.entry('n', "knight-b"),
                Map.entry('b', "bishop-b"),
                Map.entry('q', "queen-b"),
                Map.entry('k', "king-b"),
                Map.entry('p', "pawn-b")
        ));

        for (char piece : pieces.keySet()) {
            try {
                URL imgUrl = ChessBoard.class.getResource("/" + pieces.get(piece) + ".png");
                if (imgUrl == null) {
                    System.err.println("Missing image: /resources/" + pieces.get(piece) + ".png");
                    continue;
                }
                BufferedImage original = ImageIO.read(imgUrl);
                Image scaled = original.getScaledInstance(-1, pieceSize, Image.SCALE_DEFAULT);
                pieceIcons.put(piece, new ImageIcon(scaled));
            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }
    }
}
