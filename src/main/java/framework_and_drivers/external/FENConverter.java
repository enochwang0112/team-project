package framework_and_drivers.external;

import com.github.bhlangonijr.chesslib.Board;
import interface_adapters.IFENToArrayConverter;
import usecases.ISANToFENConverter;
import utils.RegexHelper;

import java.util.ArrayList;

public class FENConverter implements ISANToFENConverter, IFENToArrayConverter {
    /**
     * Converts a SAN string and a FEN startPos to
     * an arraylist of FEN strings.
     *
     * @param startPos The startPos of the game in FEN.
     * @param input The SAN notation of the game, starting at move 1.
     * @return An arraylist containing all the board states in FEN notation.
     */
    @Override
    public ArrayList<String> sanToFen(String startPos, String input) {
        ArrayList<String> FENList = new ArrayList<>();

        Board board = new Board();
        board.loadFromFen(startPos);
        FENList.add(board.getFen(true, true));

        String cleanedSan = input.replaceAll("\\d+\\.+\\s*", "").trim();
        if (!cleanedSan.isEmpty()) {
            for (String san : cleanedSan.split("\\s+")) {
                board.doMove(san);
                FENList.add(board.getFen(true, true));
            }
        }

        return FENList;
    }

    /**
     * Converts a FEN string into an array of chars.
     * The array follows the form
     * [[a1, b1, ..., h1], [a2, b2, ..., h2], ..., [a8, b8, ..., h8]]
     * and has the same piece notation as FEN with '*' being a blank square.
     *
     * @param fen The FEN to convert.
     * @return An array of chars with the representing a chess board in the above format.
     */
    @Override
    public char[][] FENToArray(String fen) {
        char[][] board = new char[8][8];
        String[] rows = RegexHelper
                .parseRegex("(?:.*?/){7}.*?(?= )", fen)
                .get(0)
                .split("/");

        for (int i = 1; i < 9; i++){
            for (int b = 0; b < rows.length; b++){
                rows[b] = rows[b].replace("" + i, "*".repeat(i));
            }
        }
        for (int i = 0; i < rows.length; i++){
            board[i] = rows[i].toCharArray();
        }
        return board;
    }

}
