import java.util.ArrayList;

/**
 * Post class representing a post in the social media simulator
 */
public class Post {
    private int postId;
    private String content;
    private String author;
    private int likes;
    private ArrayList<String> likedUsers;
    private ArrayList<Comment> comments;

    /**
     * Constructor for Post
     * @param postId the unique post ID
     * @param content the post content
     * @param author the author of the post
     */
    public Post(int postId, String content, String author) {
        this.postId = postId;
        this.content = content;
        this.author = author;
        this.likes = 0;
        this.likedUsers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    /**
     * Get the post ID
     * @return the post ID
     */
    public int getPostId() {
        return postId;
    }

    /**
     * Get the post content
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Get the author
     * @return the author name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the number of likes
     * @return the likes count
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Get the list of users who liked this post
     * @return the ArrayList of liked users
     */
    public ArrayList<String> getLikedUsers() {
        return likedUsers;
    }

    /**
     * Get the list of comments
     * @return the ArrayList of comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Add a like to the post by a user (prevent duplicates)
     * @param username the username of the user liking the post
     * @return true if like was added, false if user already liked
     */
    public boolean addLike(String username) {
        if (likedUsers.contains(username)) {
            return false; // User already liked this post
        }
        likedUsers.add(username);
        likes++;
        return true;
    }

    /**
     * Add a comment to the post
     * @param comment the comment to add
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
