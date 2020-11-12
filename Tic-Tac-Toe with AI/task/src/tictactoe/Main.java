package tictactoe;

import java.util.Scanner;

public class Main {

    static void userVuser(Tictactoe game) {
        game.printCells();
        while (!game.isOver()) {
            game.play();
            if (game.isOver()) {
                break;
            }
            game.play();
        }
    }

    static void easyVeasy(Tictactoe game) {
        Easy easy = new Easy();

        game.printCells();
        while (!game.isOver()) {
            System.out.println("Making move level \"easy\"");
            easy.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"easy\"");
            easy.play();
        }
    }

    static void userVeasy(Tictactoe game) {
        Easy easy = new Easy();

        game.printCells();
        while (!game.isOver()) {
            game.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"easy\"");
            easy.play();
        }
    }

    static void userVmedium(Tictactoe game) {
        Medium medium = new Medium();

        game.printCells();
        while (!game.isOver()) {
            game.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"medium\"");
            medium.play();
        }
    }

    static void mediumVmedium(Tictactoe game) {
        Medium medium = new Medium();

        game.printCells();
        while (!game.isOver()) {
            System.out.println("Making move level \"medium\"");
            medium.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"medium\"");
            medium.play();
        }
    }

    static void easyVmedium(Tictactoe game) {
        Easy easy = new Easy();
        Medium medium = new Medium();

        game.printCells();
        while (!game.isOver()) {
            System.out.println("Making move level \"easy\"");
            easy.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"medium\"");
            medium.play();
        }
    }

    static void userVhard(Tictactoe game) {
        Hard hard = new Hard();

        game.printCells();
        while (!game.isOver()) {
            game.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"hard\"");
            hard.play();
        }
    }

    static void hardVhard(Tictactoe game) {
        Hard hard = new Hard();
        Hard hard2 = new Hard();

        game.printCells();
        while (!game.isOver()) {
            System.out.println("Making move level \"hard\"");
            hard.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"hard\"");
            hard2.play();
        }
    }

    static void easyVhard(Tictactoe game) {
        Easy easy = new Easy();
        Hard hard = new Hard();

        game.printCells();
        while (!game.isOver()) {
            System.out.println("Making move level \"easy\"");
            easy.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"hard\"");
            hard.play();
        }
    }

    static void mediumVhard(Tictactoe game) {
        Medium medium = new Medium();
        Hard hard = new Hard();

        game.printCells();
        while (!game.isOver()) {
            System.out.println("Making move level \"medium\"");
            medium.play();
            if (game.isOver()) {
                break;
            }
            System.out.println("Making move level \"hard\"");
            hard.play();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        gameloop: while (true) {
            Tictactoe game = new Tictactoe();
            Tictactoe.cells = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
            System.out.println("Input command: ");
            String action = scanner.nextLine();

            switch (action) {
                case "exit":
                    break gameloop;
                case "start easy easy":
                    easyVeasy(game);
                    break;
                case "start user user":
                    userVuser(game);
                    break;
                case "start easy user":
                case "start user easy":
                    userVeasy(game);
                    break;
                case "start medium user":
                case "start user medium":
                    userVmedium(game);
                    break;
                case "start medium medium":
                    mediumVmedium(game);
                    break;
                case "start easy medium":
                case "start medium easy":
                    easyVmedium(game);
                    break;
                case "start hard user":
                case "start user hard":
                    userVhard(game);
                    break;
                case "start hard hard":
                    hardVhard(game);
                    break;
                case "start easy hard":
                case "start hard easy":
                    easyVhard(game);
                    break;
                case "start hard medium":
                case "start medium hard":
                    mediumVhard(game);
                    break;
                default:
                    System.out.println("Bad parameters!");
            }

        }

    }
}
