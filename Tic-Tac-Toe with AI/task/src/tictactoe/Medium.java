package tictactoe;

public class Medium extends Computer {
    @Override
    int[] parseCoordinates() {
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
        }
        return super.parseCoordinates();
    }
}
