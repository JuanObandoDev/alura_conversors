import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * this class is the child of Convertor and converts currencies
 * 
 * @version 1.0.0
 * @since 1.0.0
 * @see Convertor
 * 
 * @autor JuanObandoDev
 */
public class CurrencyConvertor extends Convertor {
    private static final Map<String, Double> CURRENCIES = new HashMap<String, Double>();
    private String destinyCurrency;

    /**
     * This constructor calls the method currency() and sets the currency
     */
    public CurrencyConvertor() {
        super();
        CURRENCIES.put("Dollars", 0.00024);
        CURRENCIES.put("Euros", 0.00022);
        CURRENCIES.put("Pounds", 0.00019);
        CURRENCIES.put("Yens", 0.03473);
        this.destinyCurrency = setDestinyCurrency();
    }

    /**
     * This method returns the currency to convert
     * 
     * @return separateSelection(selected)
     * @see #separateSelection(String selected)
     */
    public String setDestinyCurrency() {
        String[] options = generateCurrencyOptions();
        String selected = (String) JOptionPane.showInputDialog(
                null,
                "Select a currency",
                "Currency converter",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                "None");
        return super.separateSelection(selected);
    }

    /**
     * This method generates the options for the currency convertor
     * 
     * @return options
     */
    public String[] generateCurrencyOptions() {
        String[] options = new String[CURRENCIES.size() * 2];
        int j = 0;
        for (int i = 0; i < options.length; i++) {
            if (i < 4) {
                options[i] = "Pesos to " + CURRENCIES.keySet().toArray()[i];
            } else {
                options[i] = CURRENCIES.keySet().toArray()[j] + " to Pesos";
                j++;
            }
        }
        return options;
    }

    /**
     * This method shows the result of the convertion
     * 
     * @see Convertor#getValueToConvert()
     */
    public void showResult() {
        double result = 0;
        if (super.getOrigin().equals("Pesos")) {
            result = super.getValueToConvert() * CURRENCIES.get(this.destinyCurrency);
        } else {
            result = super.getValueToConvert() / CURRENCIES.get(super.getOrigin());
        }
        JOptionPane.showMessageDialog(
                null,
                "$" + super.getValueToConvert() + " " + super.getOrigin() + " is $" + String.format("%.2f", result)
                        + " "
                        + this.destinyCurrency);
    }
}
