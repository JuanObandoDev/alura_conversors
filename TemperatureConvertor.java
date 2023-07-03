import javax.swing.JOptionPane;

public class TemperatureConvertor extends Convertor {
    private String temperature;
    private final String[] TEMPERATURES = {
            "Fahrenheit",
            "Kelvin"
    };

    public TemperatureConvertor() {
        super();
        this.temperature = temperature();
    }

    public String temperature() {
        String[] options = new String[TEMPERATURES.length];
        for (int i = 0; i < TEMPERATURES.length; i++) {
            options[i] = "Celsius to " + TEMPERATURES[i];
        }
        String selected = (String) JOptionPane.showInputDialog(
                null,
                "Select a temperature",
                "Temperature converter",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                "None");
        return selected.replace("Celsius to ", "");
    }

    public void showResult() {
        String result = "";
        switch (this.temperature) {
            case "Fahrenheit":
                result = String.format("%.2f", (super.getValueToConvert() * 1.8) + 32) + "F°";
                break;
            case "Kelvin":
                result = String.format("%.2f", super.getValueToConvert() + 273.15) + "K°";
                break;
        }
        JOptionPane.showMessageDialog(
                null,
                super.getValueToConvert() + "C° = " + result);
    }
}
