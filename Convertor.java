import javax.swing.JOptionPane;

/**
 * This class is the parent of all convertors and contains the value to convert
 * 
 * @version 1.0.0
 * @since 1.0.0
 * @see TemperatureConvertor
 * @see CurrencyConvertor
 * 
 * @autor JuanObandoDev
 */
public abstract class Convertor {
    private int valueToConvert;

    /**
     * This constructor calls the method valueToConvert() and sets the value to
     * convert
     */
    public Convertor() {
        this.valueToConvert = valueToConvert();
    }

    /**
     * This method returns the value to convert
     * 
     * @return this.valueToConvert
     */
    public int getValueToConvert() {
        return this.valueToConvert;
    }

    /**
     * This method asks the user for the value to convert and returns it
     * 
     * @return Integer.parseInt(value) || 0 || valueToConvert()
     */
    public int valueToConvert() {
        try {
            String value = JOptionPane.showInputDialog(
                    null,
                    "Enter the value to convert");
            if (value != null) {
                return Integer.parseInt(value);
            }
            JOptionPane.showMessageDialog(
                    null,
                    "Thanks for using the convertor");
            System.exit(0);
            return 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a valid number");
            return valueToConvert();
        }
    }
}
