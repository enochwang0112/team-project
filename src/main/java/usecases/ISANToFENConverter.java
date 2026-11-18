package usecases;

import java.util.ArrayList;

public interface ISANToFENConverter {
    ArrayList<String> sanToFen(String startPos, String sanString);

}
