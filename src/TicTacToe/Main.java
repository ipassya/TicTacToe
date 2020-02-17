package TicTacToe;

import extension.PlacePiece;
import extension.CheckWinner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Collections, membuat ArrayList generic
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        // membuat gameBoard
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        GameBoard board = new GameBoard();
        board.printGameBoard(gameBoard);

        PlacePiece place = new PlacePiece();
        CheckWinner winner = new CheckWinner();

        while (true) {
            Scanner inputUser = new Scanner(System.in);
            System.out.print("Masukkan posisi [1-9] : ");
            // mengambil input dari scanner untuk posisi player
            int playerPos = inputUser.nextInt();
            while (playerPos <= 0 || playerPos >= 10) {
                System.out.print("Posisi salah, Masukan nilai posisi [1-9] : ");
                playerPos = inputUser.nextInt();
            }
            // memeriksa positions pada ArrayList
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.print("Posisi terisi, Masukkan posisi yang kosong [1-9] : ");
                playerPos = inputUser.nextInt();
                while (playerPos <= 0 || playerPos >= 10) {
                    System.out.print("Posisi salah, Masukan nilai posisi [1-9] : ");
                    playerPos = inputUser.nextInt();
                }
            }

            place.placePiece(gameBoard, playerPos, playerPositions, cpuPositions, "player");

            String result = winner.checkWinner(playerPositions, cpuPositions);
            if (result.length() > 0) {
                board.printGameBoard(gameBoard);
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            // mengambil input dari rand untuk posisi cpu
            int cpuPos = rand.nextInt(9) + 1;
            // memeriksa positions pada ArrayList
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            place.placePiece(gameBoard, cpuPos, playerPositions, cpuPositions, "cpu");

            board.printGameBoard(gameBoard);

            result = winner.checkWinner(playerPositions, cpuPositions);
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            System.out.println(result);
        }
    }
}
