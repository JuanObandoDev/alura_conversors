import javax.swing.JOptionPane;

public class CurrencyConvertor extends Convertor {
    private static final String[] CURRENCIES = {
            "Dollar",
            "Euro",
            "Pound",
            "Yen"
    };
    private String currency;

    public CurrencyConvertor() {
        super();
        this.currency = currency();
    }

    public String currency() {
        String[] options = new String[CURRENCIES.length];
        for (int i = 0; i < CURRENCIES.length; i++) {
            options[i] = "Pesos to " + CURRENCIES[i];
        }
        String selected = (String) JOptionPane.showInputDialog(
                null,
                "Select a currency",
                "Currency converter",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                "None");
        return selected.replace("Pesos to ", "");
    }

    public void showResult() {
        double result = 0;
        switch (this.currency) {
            case "Dollar":
                result = super.getValueToConvert() * 0.00024;
                break;
            case "Euro":
                result = super.getValueToConvert() * 0.00022;
                break;
            case "Pound":
                result = super.getValueToConvert() * 0.00019;
                break;
            case "Yen":
                result = super.getValueToConvert() * 0.03473;
                break;
        }
        JOptionPane.showMessageDialog(
                null,
                "$" + super.getValueToConvert() + " pesos is $" + String.format("%.2f", result) + " " + this.currency);
    }
}
