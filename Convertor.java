import javax.swing.JOptionPane;

public abstract class Convertor {
    private int valueToConvert;

    public Convertor() {
        this.valueToConvert = valueToConvert();
    }

    public int getValueToConvert() {
        return this.valueToConvert;
    }

    public int valueToConvert() {
        try {
            String value = JOptionPane.showInputDialog(
                    null,
                    "Enter the value to convert");
            if (value == null) {
                JOptionPane.showMessageDialog(
                        null,
                        "Thanks for using the convertor");
                System.exit(0);
                return 0;
            } else {
                return Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a valid number");
            return valueToConvert();
        }
    }
}
