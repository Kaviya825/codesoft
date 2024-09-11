import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Input marks for each subject
        System.out.print("Enter number of subjects: ");
        int num = scan.nextInt();

        int[] marks = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scan.nextInt();
        }

        // Calculate total marks
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }

        // Calculate average percentage
        double average = (double) total / num;

        // Assign grade based on average percentage
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + String.format("%.2f", average) + "%");
        System.out.println("Grade: " + grade);
    }
}
