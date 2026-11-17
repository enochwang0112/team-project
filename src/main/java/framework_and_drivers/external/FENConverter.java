package framework_and_drivers.external;

import interface_adapters.IFENToArrayConverter;
import usecases.ISANToFENConverter;
import utils.RegexHelper;

public class FENConverter implements ISANToFENConverter, IFENToArrayConverter {
    @Override
    public String sanToFen(String sanString) {
        // TODO: Implement this method
        return "";
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
                rows[b] = rows[b].replace("" + i, String.valueOf("*").repeat(i));
            }
        }
        for (int i = 0; i < rows.length; i++){
            board[i] = rows[i].toCharArray();
        }
        return board;
    }

}
