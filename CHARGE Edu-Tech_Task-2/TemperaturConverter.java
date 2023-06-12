import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature;
        String inputUnit, outputUnit;

        // Take input for temperature value
        System.out.print("Enter the temperature value: ");
        String temperatureInput = scanner.nextLine();

        // Sanitize the input and handle non-numerical values
        try {
            temperature = Double.parseDouble(temperatureInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid temperature value. Please enter a numerical value.");
            return;
        }

        // Take input for input unit
        System.out.print("Enter the input temperature unit (C, F, K): ");
        inputUnit = scanner.nextLine();

        // Take input for output unit
        System.out.print("Enter the output temperature unit (C, F, K): ");
        outputUnit = scanner.nextLine();

        // Convert the temperature
        double convertedTemperature;
        if (inputUnit.equalsIgnoreCase("C")) {
            // Convert from Celsius to the desired unit
            if (outputUnit.equalsIgnoreCase("F")) {
                convertedTemperature = celsiusToFahrenheit(temperature);
            } else if (outputUnit.equalsIgnoreCase("K")) {
                convertedTemperature = celsiusToKelvin(temperature);
            } else {
                System.out.println("Invalid output temperature unit. Please enter C, F, or K.");
                return;
            }
        } else if (inputUnit.equalsIgnoreCase("F")) {
            // Convert from Fahrenheit to the desired unit
            if (outputUnit.equalsIgnoreCase("C")) {
                convertedTemperature = fahrenheitToCelsius(temperature);
            } else if (outputUnit.equalsIgnoreCase("K")) {
                convertedTemperature = fahrenheitToKelvin(temperature);
            } else {
                System.out.println("Invalid output temperature unit. Please enter C, F, or K.");
                return;
            }
        } else if (inputUnit.equalsIgnoreCase("K")) {
            // Convert from Kelvin to the desired unit
            if (outputUnit.equalsIgnoreCase("C")) {
                convertedTemperature = kelvinToCelsius(temperature);
            } else if (outputUnit.equalsIgnoreCase("F")) {
                convertedTemperature = kelvinToFahrenheit(temperature);
            } else {
                System.out.println("Invalid output temperature unit. Please enter C, F, or K.");
                return;
            }
        } else {
            System.out.println("Invalid input temperature unit. Please enter C, F, or K.");
            return;
        }

        // Output the converted temperature
        System.out.println("Converted temperature: " + convertedTemperature + " " + outputUnit);
    }

    // Conversion functions
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin * 9 / 5) - 459.67;
    }
}
