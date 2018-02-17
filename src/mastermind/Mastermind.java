package mastermind;

import java.util.Scanner;

import mastermind.exceptions.IncorrectFormatException;

public class Mastermind {

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(GameParameters.getInstance().getWelcomMessage());

        Game game = new Game(GameParameters.getInstance().getColors(),
                GameParameters.getInstance().getTriesNumber(), GameParameters
                .getInstance().getCombinationLength());

        Scanner keyboard = new Scanner(System.in);

        try {
            do {
                System.out.println("Vous >");
                String playerColors = keyboard.nextLine();
                boolean sim = game.tryGame(playerColors);
                if (sim) {
                    System.out.println(game);
                    System.out.println(GameParameters.getInstance()
                            .getWinMessage());
                    break;
                }

                System.out.println(game);

            } while (game.canPlayMore());
            if (game.getTryNumber() > 10) {
                System.out.println(GameParameters.getInstance().getLoseMessage());
            }

        } catch (IncorrectFormatException e) {
            e.printStackTrace();
        }

    }

}
