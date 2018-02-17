package mastermind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Singleton Class
public class GameParameters {

    private InputStream inputStream;
    private static final String PROP_FILE_NAME = "gameConfig.properties";

    private String[] colors;
    private int triesNumber;
    private String welcomMessage;
    private String winMessage;
    private String loseMessage;
    private int combinationLength;

    private static GameParameters instance;

    public static GameParameters getInstance() {
        if (instance == null) {
            instance = new GameParameters();
        }
        return instance;
    }

    private GameParameters() {

        try {

            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(
                    PROP_FILE_NAME);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '"
                        + PROP_FILE_NAME + "' not found in the classpath");
            }

            // get the property value and print it out
            this.setColors(prop.getProperty("colors").split(","));
            this.triesNumber = Integer
                    .parseInt(prop.getProperty("triesNumber"));
            this.setCombinationLength(Integer.parseInt(prop
                    .getProperty("combinationLength")));
            this.welcomMessage = prop.getProperty("welcomMessage");
            this.loseMessage = prop.getProperty("loseMessage");
            this.winMessage = prop.getProperty("winMessage");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {

            }
        }
    }

    public int getTriesNumber() {
        return triesNumber;
    }

    public void setTriesNumber(int triesNumber) {
        this.triesNumber = triesNumber;
    }

    public String getWelcomMessage() {
        return welcomMessage;
    }

    public void setWelcomMessage(String welcomMessage) {
        this.welcomMessage = welcomMessage;
    }

    public String getWinMessage() {
        return winMessage;
    }

    public void setWinMessage(String winMessage) {
        this.winMessage = winMessage;
    }

    public String getLoseMessage() {
        return loseMessage;
    }

    public void setLoseMessage(String loseMessage) {
        this.loseMessage = loseMessage;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public int getCombinationLength() {
        return combinationLength;
    }

    public void setCombinationLength(int combinationLength) {
        this.combinationLength = combinationLength;
    }

}
