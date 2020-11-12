package tictactoe;

import java.util.Random;

public class Computer extends Tictactoe {

    @Override
    int[] parseCoordinates() {
        Random r = new Random();
        int[] xy = new int[2];
        while (true) {
            int x = r.nextInt(3) + 1;
            int y = r.nextInt(3) + 1;

            if (!(cellIsOccupied(x-1, y-1))) {
                xy[0] = x - 1;
                xy[1] = y - 1;
                return xy;
            }
        }
    }




    boolean canWin() {
        char c = getNextSymbol();

        if ((cells[0][0] == cells[1][1]) && (cells[1][1] == c)) {
            if (!cellIsOccupied(2,2)){
                return true;
            }
        }
        if ((cells[1][1] == cells[2][2]) && (cells[1][1] == c)){
            if (!cellIsOccupied(0,0)){
                return true;
            }
        }
        if ((cells[0][0] == cells[2][2]) && (cells[0][0] == c)){
            if (!cellIsOccupied(1,1)){
                return true;
            }
        }

        if ((cells[0][2] == cells[1][1]) && (cells[1][1] == c)) {
            if (!cellIsOccupied(2,0)){
                return true;
            }
        }
        if ((cells[1][1] == cells[2][0]) && (cells[1][1] == c)){
            if (!cellIsOccupied(0,2)){
                return true;
            }
        }
        if ((cells[0][2] == cells[2][0]) && (cells[2][0] == c)){
            if (!cellIsOccupied(1,1)){
                return true;
            }
        }


        for (int i = 0; i < 3; ++i) {
            int count = 0, counta = 0;

            for (int j = 0; j < 3; ++j) {

                if (cells[i][j] == c) {
                    ++count;
                }
                if (cells[j][i] == c) {
                    ++counta;
                }

                if (count > 1) {
                    for (int x = 0; x < 3; x++) {
                        if (!cellIsOccupied(i, x)) {
                            return true;
                        }
                    }
                }
                if (counta > 1) {
                    for (int x = 0; x < 3; x++) {
                        if (!cellIsOccupied(x, i)) {
                            return true;
                        }
                    }
                }

            }
        }

        return false;
    }





    int[] win() {
        char c = getNextSymbol();

        if ((cells[0][0] == cells[1][1]) && (cells[1][1] == c)) {
            if (!cellIsOccupied(2,2)){
                return new int[]{2, 2};
            }
        }
        if ((cells[1][1] == cells[2][2]) && (cells[1][1] == c)){
            if (!cellIsOccupied(0,0)){
                return new int[]{0, 0};
            }
        }
        if ((cells[0][0] == cells[2][2]) && (cells[0][0] == c)){
            if (!cellIsOccupied(1,1)){
                return new int[]{1, 1};
            }
        }

        if ((cells[0][2] == cells[1][1]) && (cells[1][1] == c)) {
            if (!cellIsOccupied(2,0)){
                return new int[]{2, 0};
            }
        }
        if ((cells[1][1] == cells[2][0]) && (cells[1][1] == c)){
            if (!cellIsOccupied(0,2)){
                return new int[]{0, 2};
            }
        }
        if ((cells[0][2] == cells[2][0]) && (cells[2][0] == c)){
            if (!cellIsOccupied(1,1)){
                return new int[]{1, 1};
            }
        }


        for (int i = 0; i < 3; ++i) {
            int count = 0, counta = 0;

            for (int j = 0; j < 3; ++j) {

                if (cells[i][j] == c) {
                    ++count;
                }
                if (cells[j][i] == c) {
                    ++counta;
                }

                if (count > 1) {
                    for (int x = 0; x < 3; x++) {
                        if (!cellIsOccupied(i, x)) {
                            return new int[]{i, x};
                        }
                    }
                }
                if (counta > 1) {
                    for (int x = 0; x < 3; x++) {
                        if (!cellIsOccupied(x, i)) {
                            return new int[]{x, i};
                        }
                    }
                }

            }
        }

        return new int[2];
    }


}

