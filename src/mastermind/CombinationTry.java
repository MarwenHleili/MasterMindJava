package mastermind;

import java.util.Arrays;

import mastermind.exceptions.IncorrectFormatException;

public class CombinationTry {

    private String colors;
    private int correct;
    private int exists;
    private int colorLength = 4;

    public CombinationTry(String color, String colorsToCompair)
            throws IncorrectFormatException {
        setColors(color);

        if (color.equals(colorsToCompair)) {
            exists = 0;
            correct = colorLength;
        } else {
            String colort = "";
            String colortc = "";
            for (int i = 0; i < colorLength; i++) {
                if (color.charAt(i) != colorsToCompair.charAt(i)) {
                    colort = colort + color.charAt(i);
                    colortc = colortc + colorsToCompair.charAt(i);
                } else {
                    correct++;
                }
            }

            for (int i = 0; i < colort.length(); i++) {
                colortc = colortc.replaceFirst(colort.charAt(i) + "", ".");
            }
            exists = colortc.length() - colortc.replace(".", "").length();

        }

    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) throws IncorrectFormatException {
        if (colors.length() != colorLength) {
            throw new IncorrectFormatException("Incorrect length");
        }
        for (int i = 0; i < colors.length(); i++) {
            if (!Arrays.toString(GameParameters.getInstance().getColors()).contains(colors.charAt(i) + "")) {
                throw new IncorrectFormatException(colors.charAt(i) + " Is not a definded");
            }
            ;
        }

        this.colors = colors;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getExists() {
        return exists;
    }

    public void setExists(int exists) {
        this.exists = exists;
    }

    @Override
    public String toString() {
        return "| " + colors + " | " + exists + " | " + correct + " | ";
    }

}
