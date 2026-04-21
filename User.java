/**
 * User class representing a user in the social media simulator
 */
public class User {
    private String username;
    private String password;

    /**
     * Constructor for User
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Get the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the username
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set the password
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
