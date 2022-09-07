import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureConverter {

    // Celcius to Fahrenheit
    static double celciusToFahrenheit (double celcius) {
        double Fahrenheit = (celcius * 9 / 5) + 32;
        return Fahrenheit;
    }

    // Celcius to Kelvin
    static double celciusToKelvin (double celcius) {
        double kelvin = celcius + 273.15;
        return kelvin;
    }

    // Fahrenheit to Celcius
    static double fahrenheitToCelcius (double fahrenheit) {
        double celcius = (fahrenheit - 32) * 5 / 9;
        return celcius;
    }

    // Fahrenheit to Kelvin
    static double fahrenheitToKelvin (double fahrenheit) {
        double kelvin = (fahrenheit - 32) * 5 / 9 + 273.15;
        return kelvin;
    }

    // Kelvin to Fahrenheit
    static double kelvinToFahrenheit (double kelvin) {
        double fahrenheit = (kelvin - 273.15) * 9 / 5 + 32;
        return fahrenheit;
    }

    // Kelvin to Celcius
    static double kelvinToCelcius (double kelvin) {
        double celcius = kelvin - 273.15;
        return celcius;
    }

    static Scanner input = new Scanner(System.in); // static method can use only static variable

    // read temperature from user
    static double temperatureFromUser (String scale) {
        System.out.print("Enter the " + scale + " temperature: ");
        double userInput = input.nextDouble();
        return userInput;
    }

    // display result
    static void convertedTemperature (double result, String scale) {
        System.out.printf("The %s temperature: %.2f\n\n", scale, result);
    }

    public static void main(String[] args) {

        do {
            // display menu
            System.out.println("1) Celcius to Fahrenheit\n2) Celcius to Kelvin\n3) Fahrenheit to Celcius\n4) Fahrenheit to Kelvin\n5) Kelvin to Celcius\n6) Kelvin to Fahrenheit\n7) Exit");
            System.out.print("\nEnter your choice: ");

            int choice = input.nextInt();
            double userInput = 0;
            switch (choice) {
                case 1:
                    userInput = temperatureFromUser("Celcius");
                    convertedTemperature(celciusToFahrenheit(userInput), "Fahrenheit");
                    break;
                case 2:
                    userInput = temperatureFromUser("Celcius");
                    convertedTemperature(celciusToKelvin(userInput), "Kelvin");
                    break;
                case 3:
                    userInput = temperatureFromUser("Fahrenheit");
                    convertedTemperature(fahrenheitToCelcius(userInput), "Celcius");
                    break;
                case 4:
                    userInput = temperatureFromUser("Fahrenheit");
                    convertedTemperature(fahrenheitToKelvin(userInput), "Kelvin");
                    break;
                case 5:
                    userInput = temperatureFromUser("Kelvin");
                    convertedTemperature(kelvinToCelcius(userInput), "Celcius");
                    break;
                case 6:
                    userInput = temperatureFromUser("Kelvin");
                    convertedTemperature(kelvinToFahrenheit(userInput), "Fahrenheit");
                    break;
                case 7:
                    System.out.println("Bye bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (true);
    }
}






















