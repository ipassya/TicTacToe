package extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckWinner {
    // membuat list array dengan asList
    private List topRow = Arrays.asList(1, 2, 3);
    private List midRow = Arrays.asList(4, 5, 6);
    private List botRow = Arrays.asList(7, 8, 9);
    private List leftCol = Arrays.asList(1, 4, 7);
    private List midCol = Arrays.asList(2, 5, 8);
    private List rightCol = Arrays.asList(3, 6, 9);
    private List cross1 = Arrays.asList(1, 5, 9);
    private List cross2 = Arrays.asList(7, 5, 3);

    public String checkWinner(ArrayList<Integer> playerPositions, ArrayList<Integer> cpuPositions) {
        // menambahkan list kedalam winning
        List<List> winning = new ArrayList<List>();
        winning.add(this.topRow);
        winning.add(this.midRow);
        winning.add(this.botRow);
        winning.add(this.leftCol);
        winning.add(this.midCol);
        winning.add(this.rightCol);
        winning.add(this.cross1);
        winning.add(this.cross2);

        // Pengecekan positions
        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Selamat kamu menang! :D";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU menang! :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Seri! :/";
            }
        }

        return "";
    }
}
