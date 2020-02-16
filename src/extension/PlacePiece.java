package extension;

import java.util.ArrayList;

public class PlacePiece {
    public void placePiece(char[][] gameBoard, int pos, ArrayList<Integer> playerPositions, ArrayList<Integer> cpuPositions, String user) {
        // inisialisasi symbol
        char symbol = ' ';

        // cek user
        if (user.equals("player")) {
            symbol = 'X';
            // menambah position baru
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            // menambah position baru
            cpuPositions.add(pos);
        }

        // pengisian symbol ke gameBoard
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
}
