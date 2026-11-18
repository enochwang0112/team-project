package interface_adapters;

import java.awt.*;
import java.util.ArrayList;

public class ViewModel {
    public ArrayList<String> monthList;
    public ArrayList<String> gameList;
    public String whitePlayer;
    public String blackPlayer;
    public int whiteRating;
    public int blackRating;
    public Image whitePfp;
    public Image blackPfp;
    public String userColour;
    public String boardStateFEN;
    public String bestMove;
    public double eval;
    public boolean isMated;
    public String[] continuation;
    public int currentMoveNum;
}
