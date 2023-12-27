package Services;


import domain.User;
import java.util.Scanner;

public class Login {
    User user;
    private int maxAttempts = 3;

    public boolean isPasswordCorrect(String enteredPassword) {
        String userPassword = user.getPassword();
        return enteredPassword.equals(userPassword);
    }

    public void promptForPassword() {
        Scanner scanner = new Scanner(System.in);

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter your password: ");
            String enteredPassword = scanner.nextLine();

            if (isPasswordCorrect(enteredPassword)) {
                System.out.println("Login successful");
                return;
            } else {
                System.out.println("Incorrect password. Attempts remaining: " + (maxAttempts - attempt));
            }
        }
        System.out.println("Too many incorrect attempts. Account locked.");
    }
}
