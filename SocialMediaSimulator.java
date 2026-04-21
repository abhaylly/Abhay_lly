import java.util.ArrayList;
import java.util.Scanner;

/**
 * SocialMediaSimulator - A complete Java console application for a social media platform
 * Features: User registration, login, post creation, likes, comments, and feed viewing
 */
public class SocialMediaSimulator {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Post> posts = new ArrayList<>();
    private static int postIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static User loggedInUser = null;

    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   Welcome to Social Media Simulator   ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        boolean running = true;
        while (running) {
            if (loggedInUser == null) {
                displayMainMenu();
                int choice = getMenuChoice(3);
                switch (choice) {
                    case 1:
                        handleSignup();
                        break;
                    case 2:
                        handleLogin();
                        break;
                    case 3:
                        running = false;
                        System.out.println("\n✓ Thank you for using Social Media Simulator. Goodbye!");
                        break;
                    default:
                        System.out.println("✗ Invalid choice. Please try again.\n");
                }
            } else {
                displayUserMenu();
                int choice = getMenuChoice(5);
                switch (choice) {
                    case 1:
                        handleCreatePost();
                        break;
                    case 2:
                        handleViewFeed();
                        break;
                    case 3:
                        handleLikePost();
                        break;
                    case 4:
                        handleCommentPost();
                        break;
                    case 5:
                        handleLogout();
                        break;
                    default:
                        System.out.println("✗ Invalid choice. Please try again.\n");
                }
            }
        }
        scanner.close();
    }

    /**
     * Display the main menu when user is not logged in
     */
    private static void displayMainMenu() {
        System.out.println("\n╔════════════════ MAIN MENU ════════════════╗");
        System.out.println("║  1. Signup                                ║");
        System.out.println("║  2. Login                                 ║");
        System.out.println("║  3. Exit                                  ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.print("Enter your choice (1-3): ");
    }

    /**
     * Display the user menu after login
     */
    private static void displayUserMenu() {
        System.out.println("\n╔════════════════ USER MENU ════════════════╗");
        System.out.println("║  1. Create Post                           ║");
        System.out.println("║  2. View Feed                             ║");
        System.out.println("║  3. Like Post                             ║");
        System.out.println("║  4. Comment on Post                       ║");
        System.out.println("║  5. Logout                                ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        System.out.print("Enter your choice (1-5): ");
    }

    /**
     * Get a valid menu choice from the user
     * @param maxChoice the maximum valid choice
     * @return the user's choice
     */
    private static int getMenuChoice(int maxChoice) {
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("✗ Input cannot be empty. Please try again.");
                System.out.print("Enter your choice: ");
                return getMenuChoice(maxChoice);
            }
            int choice = Integer.parseInt(input);
            if (choice < 1 || choice > maxChoice) {
                System.out.println("✗ Please enter a valid choice between 1 and " + maxChoice);
                System.out.print("Enter your choice: ");
                return getMenuChoice(maxChoice);
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            return getMenuChoice(maxChoice);
        }
    }

    /**
     * Handle user signup
     */
    private static void handleSignup() {
        System.out.println("\n╔════════════════ SIGNUP ════════════════╗");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println("✗ Username cannot be empty.\n");
            return;
        }

        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("✗ Username already exists. Please choose a different one.\n");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        if (password.isEmpty()) {
            System.out.println("✗ Password cannot be empty.\n");
            return;
        }

        users.add(new User(username, password));
        System.out.println("✓ Signup successful! You can now login.\n");
    }

    /**
     * Handle user login
     */
    private static void handleLogin() {
        System.out.println("\n╔════════════════ LOGIN ════════════════╗");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println("✗ Username cannot be empty.\n");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        if (password.isEmpty()) {
            System.out.println("✗ Password cannot be empty.\n");
            return;
        }

        // Check credentials
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                if (user.getPassword().equals(password)) {
                    loggedInUser = user;
                    System.out.println("✓ Login successful! Welcome, " + loggedInUser.getUsername() + "!\n");
                    return;
                } else {
                    System.out.println("✗ Incorrect password. Please try again.\n");
                    return;
                }
            }
        }
        System.out.println("✗ Username not found. Please signup first.\n");
    }

    /**
     * Handle post creation
     */
    private static void handleCreatePost() {
        System.out.println("\n╔════════════════ CREATE POST ════════════════╗");
        System.out.print("Enter post content: ");
        String content = scanner.nextLine().trim();

        if (content.isEmpty()) {
            System.out.println("✗ Post content cannot be empty.\n");
            return;
        }

        Post newPost = new Post(postIdCounter++, content, loggedInUser.getUsername());
        posts.add(newPost);
        System.out.println("✓ Post created successfully with ID: " + newPost.getPostId() + "\n");
    }

    /**
     * Handle viewing the feed
     */
    private static void handleViewFeed() {
        System.out.println("\n╔════════════════ FEED ════════════════╗");
        if (posts.isEmpty()) {
            System.out.println("No posts yet. Be the first to create one!\n");
            return;
        }

        for (Post post : posts) {
            displayPost(post);
        }
    }

    /**
     * Display a single post with all its details
     * @param post the post to display
     */
    private static void displayPost(Post post) {
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│ Post ID: " + post.getPostId());
        System.out.println("│ Author: " + post.getAuthor());
        System.out.println("│ Content: " + post.getContent());
        System.out.println("│ Likes: " + post.getLikes());

        if (!post.getComments().isEmpty()) {
            System.out.println("│ Comments:");
            for (Comment comment : post.getComments()) {
                System.out.println("│   - " + comment.getUsername() + ": " + comment.getText());
            }
        } else {
            System.out.println("│ No comments yet");
        }
        System.out.println("└─────────────────────────────────────────┘");
    }

    /**
     * Handle liking a post
     */
    private static void handleLikePost() {
        System.out.println("\n╔════════════════ LIKE POST ════════════════╗");
        if (posts.isEmpty()) {
            System.out.println("✗ No posts to like yet.\n");
            return;
        }

        System.out.print("Enter Post ID to like: ");
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("✗ Input cannot be empty.\n");
                return;
            }
            int postId = Integer.parseInt(input);

            Post targetPost = findPostById(postId);
            if (targetPost == null) {
                System.out.println("✗ Post ID not found.\n");
                return;
            }

            if (targetPost.addLike(loggedInUser.getUsername())) {
                System.out.println("✓ You liked the post!\n");
            } else {
                System.out.println("✗ You have already liked this post.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid Post ID. Please enter a number.\n");
        }
    }

    /**
     * Handle commenting on a post
     */
    private static void handleCommentPost() {
        System.out.println("\n╔════════════════ COMMENT ON POST ════════════════╗");
        if (posts.isEmpty()) {
            System.out.println("✗ No posts to comment on yet.\n");
            return;
        }

        System.out.print("Enter Post ID to comment on: ");
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("✗ Input cannot be empty.\n");
                return;
            }
            int postId = Integer.parseInt(input);

            Post targetPost = findPostById(postId);
            if (targetPost == null) {
                System.out.println("✗ Post ID not found.\n");
                return;
            }

            System.out.print("Enter your comment: ");
            String commentText = scanner.nextLine().trim();
            if (commentText.isEmpty()) {
                System.out.println("✗ Comment cannot be empty.\n");
                return;
            }

            Comment newComment = new Comment(loggedInUser.getUsername(), commentText);
            targetPost.addComment(newComment);
            System.out.println("✓ Comment added successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid Post ID. Please enter a number.\n");
        }
    }

    /**
     * Handle user logout
     */
    private static void handleLogout() {
        System.out.println("\n✓ You have been logged out. Goodbye, " + loggedInUser.getUsername() + "!\n");
        loggedInUser = null;
    }

    /**
     * Find a post by its ID
     * @param postId the ID to search for
     * @return the Post if found, null otherwise
     */
    private static Post findPostById(int postId) {
        for (Post post : posts) {
            if (post.getPostId() == postId) {
                return post;
            }
        }
        return null;
    }
}
