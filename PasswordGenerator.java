

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    
    // Character sets
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useNumbers, boolean useSpecial) {
        StringBuilder characterPool = new StringBuilder();
        Random random = new Random();

        // Add character sets based on user choices
        if (useUpper) characterPool.append(UPPERCASE_LETTERS);
        if (useLower) characterPool.append(LOWERCASE_LETTERS);
        if (useNumbers) characterPool.append(NUMBERS);
        if (useSpecial) characterPool.append(SPECIAL_CHARACTERS);

        // Check if at least one character set is selected
        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        // Generate password
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Password Generator!");

        // Get user preferences for password generation
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean useUpper = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean useLower = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean useNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean useSpecial = scanner.next().equalsIgnoreCase("yes");

        try {
            // Generate and display the password
            String password = generatePassword(length, useUpper, useLower, useNumbers, useSpecial);
            System.out.println("Generated Password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

