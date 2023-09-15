import javax.swing.JOptionPane;

/**
 * This class init the program and contains the main method
 * 
 * @version 1.0.0
 * @since 1.0.0
 * @see TemperatureConvertor
 * @see CurrencyConvertor
 * 
 * @autor JuanObandoDev
 */
public class Main {
    /**
     * This array contains the options of convertors
     */
    private static final String[] OPTIONS = {
            "Temperature convertor",
            "Currency convertor"
    };

    /**
     * This method is the main method and init the program
     * 
     * @param args
     */
    public static void main(String[] args) {
        int option = 0;
        try {
            do {
                String selected = mainMenu();
                switch (selected) {
                    case "Temperature convertor":
                        TemperatureConvertor temperatureConvertor = new TemperatureConvertor();
                        temperatureConvertor.showResult();
                        break;
                    case "Currency convertor":
                        CurrencyConvertor currencyConvertor = new CurrencyConvertor();
                        currencyConvertor.showResult();
                        break;
                }
                option = continueOrNot();
            } while (option != 1);
        } catch (NullPointerException e) {
            // Nothing here because the user clicked the cancel button
        } finally {
            JOptionPane.showMessageDialog(
                    null,
                    "Thanks for using the convertor");
        }
    }

    /**
     * This method shows the main menu
     * 
     * @return (String) JOptionPane.showInputDialog
     */
    public static String mainMenu() {
        return (String) JOptionPane.showInputDialog(
                null,
                "Select a convertor",
                "Convertor",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                OPTIONS,
                "None");
    }

    /**
     * This method asks the user if he wants to continue
     * 
     * @return JOptionPane.showConfirmDialog
     */
    public static int continueOrNot() {
        return JOptionPane.showConfirmDialog(
                null,
                "Do you want to continue?",
                "Continue",
                JOptionPane.YES_NO_OPTION);
    }
}
