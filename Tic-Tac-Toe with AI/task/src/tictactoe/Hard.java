package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class Hard extends Computer {

    int[] lastmove = new int[2];

    Random random = new Random();
    static final int[][] corners = {{1, 3}, {3, 3}, {1, 1}, {3, 1}};
    static final int[] center = {2, 2};
    static final int[][] middles = {{1, 2}, {3,2}};

    int [] parse(int[] xy) {
        return new int[]{xy[0]-1, xy[1]-1};
    }

    boolean isMatch(int[] array1, int[] array2) {
        if (array1[0] == array2[0]) {
            if (array1[1] == array2[1]) {
                return true;
            }
        }return false;
    }

    int[] firstMoveCounter() {

        if (cellIsOccupied(1, 1)) {
            return parse(corners[random.nextInt(4)]);
        } else {
            return parse(center);
        }

    }

    int [] secondMove() {
        return oppositeCorner(lastmove);
    }

    int[] secondMoveCounter() {

        char ch = getNextSymbol();
        char c = 'A';
        if (ch == 'X') {
            c = 'O';
        }
        if (ch == 'O') {
            c = 'X';
        }

        if ((cells[0][0] == c) && (cells[2][2] == c)) {
            for (int[] a : middles) {
                if (!cellIsOccupied(a)) {
                    return parse(a);
                }
            }
        }
        if ((cells[0][2] == c) && (cells[2][0] == c)) {
            for (int[] a : middles) {
                if (!cellIsOccupied(a)) {
                    return parse(a);
                }
            }
        }

        /*if (cells[1][1] == getNextSymbol()) {
            return getCorner();
        }
        return super.parseCoordinates();*/
        return getCorner();
    }

    int[] getCorner() {
        ArrayList<int[]> array = new ArrayList();
        for (int[] a: corners) {
            if (!cellIsOccupied(a)) {
                array.add(a);
            }
        }
        return parse(array.get(random.nextInt(array.size())));
    }

    int[] oppositeCorner(int[] xy) {
        for (int i = 0; i < 4; ++i) {
            if (isMatch(xy, parse(corners[i]))) {
                return parse(corners[3-i]);
            }
        }
        return new int[0];
    }

    /*int[] triangle() {
        char c = getNextSymbol();

        if (cells[2][2] == c) {
            if (cells[1][3] == c) {
                if (!cellIsOccupied(2, 3)) {
                    return new int[]{2, 3};
                }
            }
            if (cells[1][3] == c) {
                if (!cellIsOccupied(2, 3)) {
                    return new int[]{2, 3};
                }
            }
        } else {
            return super.parseCoordinates();
        }

    }*/


    @Override
    int[] parseCoordinates() {
        if (canWin()) {
            return win();
        }

        if (canGameEnd()) {
            return endGame();
        }

        if (isEmpty()) {
            return parse(corners[random.nextInt(4)]);
        } else if (count() == 1) {
            return firstMoveCounter();
        } else if (count() == 2) {
            return secondMove();
        } else if (count() == 3) {
            return secondMoveCounter();
        }
        return super.parseCoordinates();
    }


    boolean canGameEnd() {

        if ((cells[0][0] == cells[1][1]) && (cells[1][1] == 'X' || cells[1][1] == 'O')) {
            if (!cellIsOccupied(2,2)){
                return true;
            }
        }
        if ((cells[1][1] == cells[2][2]) && (cells[1][1] == 'X' || cells[1][1] == 'O')){
            if (!cellIsOccupied(0,0)){
                return true;
            }
        }
        if ((cells[0][0] == cells[2][2]) && (cells[0][0] == 'X' || cells[0][0] == 'O')){
            if (!cellIsOccupied(1,1)){
                return true;
            }
        }

        if ((cells[0][2] == cells[1][1]) && (cells[1][1] == 'X' || cells[1][1] == 'O')) {
            if (!cellIsOccupied(2,0)){
                return true;
            }
        }
        if ((cells[1][1] == cells[2][0]) && (cells[1][1] == 'X' || cells[1][1] == 'O')){
            if (!cellIsOccupied(0,2)){
                return true;
            }
        }
        if ((cells[0][2] == cells[2][0]) && (cells[2][0] == 'X' || cells[2][0] == 'O')){
            if (!cellIsOccupied(1,1)){
                return true;
            }
        }


        int[] xy = new int[2];

        for (int i = 0; i < 3; ++i) {
            int countX = 0, countO = 0, countXa = 0, countOa = 0;
            for (int j = 0; j < 3; ++j) {

                if (cells[i][j] == 'X') {
                    ++countX;
                }
                if (cells[i][j] == 'O') {
                    ++countO;
                }
                if (cells[j][i] == 'X') {
                    ++countXa;
                }
                if (cells [j][i] == 'O') {
                    ++countOa;
                }

                if (countX > 1 || countO > 1) {
                    for (int x = 0; x < 3; x++) {
                        if (!cellIsOccupied(i, x)) {
                            return true;
                        }
                    }
                }
                if (countXa > 1 || countOa > 1) {
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

    int[] endGame() {


        if ((cells[0][0] == cells[1][1]) && (cells[1][1] == 'X' || cells[1][1] == 'O')) {
            if (!cellIsOccupied(2,2)){
                return new int[] {2, 2};
            }
        }
        if ((cells[1][1] == cells[2][2]) && (cells[1][1] == 'X' || cells[1][1] == 'O')){
            if (!cellIsOccupied(0,0)){
                return new int[] {0, 0};
            }
        }
        if ((cells[0][0] == cells[2][2]) && (cells[0][0] == 'X' || cells[0][0] == 'O')){
            if (!cellIsOccupied(1,1)){
                return new int[] {1, 1};
            }
        }

        if ((cells[0][2] == cells[1][1]) && (cells[1][1] == 'X' || cells[1][1] == 'O')) {
            if (!cellIsOccupied(2,0)){
                return new int[] {2, 0};
            }
        }
        if ((cells[1][1] == cells[2][0]) && (cells[1][1] == 'X' || cells[1][1] == 'O')){
            if (!cellIsOccupied(0,2)){
                return new int[] {0, 2};
            }
        }
        if ((cells[0][2] == cells[2][0]) && (cells[2][0] == 'X' || cells[2][0] == 'O')){
            if (!cellIsOccupied(1,1)){
                return new int[] {1, 1};
            }
        }

        int[] xy = new int[2];

        for (int i = 0; i < 3; ++i) {
            int countX = 0, countO = 0, countXa = 0, countOa = 0;
            for (int j = 0; j < 3; ++j) {

                if (cells[i][j] == 'X') {
                    ++countX;
                }
                if (cells[i][j] == 'O') {
                    ++countO;
                }
                if (cells[j][i] == 'X') {
                    ++countXa;
                }
                if (cells [j][i] == 'O') {
                    ++countOa;
                }

                if (countX > 1 || countO > 1) {
                    for (int x = 0; x < 3; x++) {
                        if (!cellIsOccupied(i, x)) {
                            xy[0] = i;
                            xy[1] = x;
                            return xy;
                        }
                    }
                }
                if (countXa > 1 || countOa > 1) {
                    for (int x = 0; x < 3; x++) {
                        if (!cellIsOccupied(x, i)) {
                            xy[0] = x;
                            xy[1] = i;
                            return xy;
                        }
                    }
                }

            }
        }return xy;
    }


    void play() {
        lastmove = parseCoordinates();
        int x = lastmove[0], y = lastmove[1];
        updateCells(x, y);
        printCells();
        state();
    }

}

