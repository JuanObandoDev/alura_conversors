import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class TemperatureConvertor extends Convertor {
    private String temperature;
    private String destinyTemperature;
    private static final Map<String, Double> TEMPERATURES = new HashMap<String, Double>();

    public TemperatureConvertor() {
        super();
        TEMPERATURES.put("Fahrenheit", (super.getValueToConvert() * 1.8) + 32);
        TEMPERATURES.put("Kelvin", super.getValueToConvert() + 273.15);
        this.destinyTemperature = setDestinyTemperature();
    }

    public String setDestinyTemperature() {
        String[] options = generateTemperatureOptions();
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

    public String[] generateTemperatureOptions() {
        String[] options = new String[TEMPERATURES.size()];
        int j = 0;
        for (int i = 0; i < options.length; i++) {
            if (i < 4) {
                options[i] = "Celsius to " + TEMPERATURES.keySet().toArray()[i];
            } else {
                options[i] = TEMPERATURES.keySet().toArray()[j] + " to Celsius";
                j++;
            }
        }
        return options;
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
