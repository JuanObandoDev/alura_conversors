import javax.swing.JOptionPane;

public class Main {

    private static final String[] OPTIONS = {
            "Temperature convertor",
            "Currency convertor"
    };

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

    public static int continueOrNot() {
        return JOptionPane.showConfirmDialog(
                null,
                "Do you want to continue?",
                "Continue",
                JOptionPane.YES_NO_OPTION);
    }
}
