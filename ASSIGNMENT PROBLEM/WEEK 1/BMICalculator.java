import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status for one person
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to meters
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 24.9) {
            status = "Normal";
        } else if (bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{
            String.format("%.2f", heightCm),
            String.format("%.2f", weight),
            String.format("%.2f", bmi),
            status
        };
    }

    // Method to compute BMI & status for all persons
    public static String[][] computeAllBMI(double[][] heightWeightData) {
        String[][] result = new String[heightWeightData.length][4];

        for (int i = 0; i < heightWeightData.length; i++) {
            double weight = heightWeightData[i][0];
            double height = heightWeightData[i][1];
            result[i] = calculateBMI(weight, height);
        }

        return result;
    }

    // Method to display results in tabular format
    public static void displayTable(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] heightWeightData = new double[10][2];

        // Take input for 10 people
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            heightWeightData[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            heightWeightData[i][1] = sc.nextDouble();
        }

        // Compute and display results
        String[][] result = computeAllBMI(heightWeightData);
        displayTable(result);

        sc.close();
    }
}
