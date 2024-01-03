import Services.Dashboard;
import Services.Login;
import Services.UserProfile;
import domain.Fund;
import domain.Transaction;
import domain.User;

public class App {

    public static void main(String[] args) {
        User user = new User("admin", "12345");
        Login login = new Login(user);
        Dashboard dashboard = new Dashboard();
        Fund funds = new Fund();
        Transaction transaction = new Transaction();
        UserProfile userProfile = new UserProfile();

        if (login.validateUser(user.getPassword())) {
            dashboard.displaySummary();
            dashboard.showNotifications();
            dashboard.showHelp();

            funds.displayFunds();
            transaction.showHistory();
            userProfile.showProfile();
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }

}
