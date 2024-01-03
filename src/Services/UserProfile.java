package Services;
import domain.Image;
import domain.User;

public class UserProfile {
    private User userData;

    public UserProfile() {
        this.userData = new User("testuser", "testemail@example.com");
    }

    public User showProfile() {
        System.out.println("Profile displayed.");
        return userData;
    }

    public boolean editProfile(User newData) {
        System.out.println("Profile edited.\nNew Username: " + newData.getUsername());
        this.userData = newData;
        return true;
    }

    public boolean changeEmail(String newEmail) {
        System.out.println("Email changed: " + newEmail);
        userData.setEmail(newEmail);
        return true;
    }

    public String uploadProfilePic(Image image) {
        System.out.println("Profile picture uploaded.\nFile name: " + image.getFileName());
        return "Profile Picture Path";
    }

}