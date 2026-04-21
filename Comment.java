/**
 * Comment class representing a comment on a post
 */
public class Comment {
    private String username;
    private String text;

    /**
     * Constructor for Comment
     * @param username the username of the person commenting
     * @param text the comment text
     */
    public Comment(String username, String text) {
        this.username = username;
        this.text = text;
    }

    /**
     * Get the username of the commenter
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the comment text
     * @return the text
     */
    public String getText() {
        return text;
    }
}
