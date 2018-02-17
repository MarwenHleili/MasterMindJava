package mastermind;

import java.util.Random;

import mastermind.exceptions.IncorrectFormatException;

public class Game {

    private String combination;
    private CombinationTry[] combinationTries;
    private int tryNumber;
    private int maxTries;

    public Game(String[] colors, int triesNumber, int combinationLength) {
        combination = "";
        maxTries = triesNumber;
        combinationTries = new CombinationTry[triesNumber];
        Random r = new Random();
        for (int i = 0; i < combinationLength; i++) {
            int valeur = r.nextInt(colors.length);
            combination = combination + colors[valeur];
        }

        tryNumber = 0;

    }

    public boolean tryGame(String game) throws IncorrectFormatException {

        CombinationTry combinationTry = new CombinationTry(game, combination);
        combinationTries[tryNumber] = combinationTry;
        tryNumber++;
        return game.equals(combination);

    }

    public boolean canPlayMore() {
        return tryNumber < maxTries;
    }

    @Override
    public String toString() {
        String result = "";
        String bar = "|";
        String next = "";

        next = "| " + combination.replaceAll("[A-Z]", ".") + " | . | . | "
                + (tryNumber + 1) + "/" + maxTries + " |\n";

        for (int i = 0; i < next.length() - 3; i++) {
            bar = bar + "-";
        }

        bar = bar + "|\n";

        for (int i = 0; i < tryNumber; i++) {
            result = result + combinationTries[i] + (i + 1) + "/" + maxTries
                    + " |\n";
        }

        result = bar + result;

        if (tryNumber < maxTries) {
            result = result + next;
        }

        result = result + bar;

        return result;
    }

    public int getTryNumber() {
        return tryNumber;
    }

}
