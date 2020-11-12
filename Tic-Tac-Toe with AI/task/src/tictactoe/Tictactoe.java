package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tictactoe {

    Scanner scanner = new Scanner(System.in);
    static char[][] cells = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
    static int[] xy = new int[2];

    void printCells() {
        System.out.println("---------");
        for (int i = 2; i >= 0; --i) {
            System.out.printf("| %c %c %c |\n", cells[0][i], cells[1][i], cells[2][i]);
        }
        System.out.println("---------");
    }

    int[] parseCoordinates() {
        int[] xy = new int[2];
        System.out.println("Enter the coordinates:");
        try {
            int x = scanner.nextInt(), y = scanner.nextInt();

            if (((x < 1 || x > 3) || (y < 1 || y > 3))) {
                System.out.println("Coordinates should be from 1 to 3!");
                return parseCoordinates();
            } else if (cellIsOccupied(x-1, y-1)) {
                System.out.println("This cell is occupied! Choose another one!");
                return parseCoordinates();
            } else {
                xy[0] = x-1;
                xy[1] = y-1;
                return xy;
            }

        } catch (InputMismatchException e) {
            System.out.println("You should enter numbers!");
            scanner.next();
            return parseCoordinates();
        }
    }

    boolean cellIsOccupied(int x, int y) {
        if (cells[x][y] == '_' || cells[x][y] == 0) {
            return false;
        } else {
            return true;
        }
    }

    boolean cellIsOccupied(int[] xy) {
        int x = xy[0]-1;
        int y = xy[1]-1;
        return cellIsOccupied(x, y);
    }

    void updateCells(int x, int y) {
        cells[x][y] = getNextSymbol();
    }

    char getNextSymbol() {
        int Xcount = 0, Ocount = 0;
        for (char[] c: cells) {
            for (char ch: c) {
                if (ch == 'X') {
                    ++Xcount;
                }
                if (ch == 'O') {
                    ++Ocount;
                }
            }
        }

        if (Ocount < Xcount) {
            return 'O';
        } else {
            return 'X';
        }
    }

    static boolean winpattern(char c, char[][] arr) {

        boolean pattern = false;
        int across = 0;
        int down = 0;

        if ((arr[0][0] == arr[1][1]) && (arr[1][1] == arr[2][2]) && (arr[1][1] == c)) {
            pattern = true;
            return pattern;
        }

        if ((arr[0][2] == arr[1][1]) && (arr[1][1] == arr[2][0]) && (arr[1][1] == c)) {
            pattern = true;
            return pattern;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == c) {
                    ++across;
                }
                if (arr[j][i] == c) {
                    ++down;
                }
            }
            if (across == 3 || down == 3) {
                pattern = true;
                return pattern;
            }
            across = 0;
            down = 0;
        }

        return pattern;
    }

    void state() {
        if (winpattern('X', cells)) {
            System.out.println("X wins");
            System.out.println();
        } else if (winpattern('O', cells)) {
            System.out.println("O wins");
            System.out.println();
        } else if (isFull()) {
            System.out.println("Draw");
            System.out.println();
        } else {
            return;
        }
    }

    boolean isOver() {
        boolean over = false;
        if (winpattern('X', cells)) {
            return true;
        } else if (winpattern('O', cells)) {
            return true;
        } else if (isFull()) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        for (char[] c: cells) {
            for (char ch: c) {
                if (ch == '_' || ch == 0) {
                    return false;
                }
            }
        }return true;
    }

    boolean isEmpty() {
        for (char[] c: cells) {
            for (char ch: c) {
                if (ch == 'X' || ch == 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    int count() {
        int i = 0;
        for (char[] c: cells) {
            for (char ch: c) {
                if (ch == 'X' || ch == 'O') {
                    ++i;
                }
            }
        }return i;
    }

    void play() {
        xy = parseCoordinates();
        int x = xy[0], y = xy[1];
        updateCells(x, y);
        printCells();
        state();
    }

}

