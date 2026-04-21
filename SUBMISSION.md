## Social Media Simulator - Complete Java Console Application

**A full-featured social media platform built in pure Java using core OOP principles.**

---

### Project Structure

```
.
├── User.java                    # User class (username, password)
├── Post.java                    # Post class (content, likes, comments)
├── Comment.java                 # Comment class (author, text)
└── SocialMediaSimulator.java    # Main application with console UI
```

---

### Class Overview

#### 1. **User.java**
- Stores user credentials (username, password)
- Getters and setters for username and password
- Simple, clean OOP design

#### 2. **Comment.java**
- Represents a single comment on a post
- Stores commenter's username and comment text
- Immutable design (no setters)

#### 3. **Post.java**
- Represents a social media post
- Auto-incrementing Post ID
- Manages likes with duplicate prevention
- Stores ArrayList of comments
- Methods: `addLike()`, `addComment()`, getters

#### 4. **SocialMediaSimulator.java** (Main Class)
- Entry point of the application
- Console-based UI with formatted menus
- Static data storage using ArrayLists (users, posts)
- Session management (loggedInUser)
- All core features: signup, login, post, like, comment, logout

---

### Features

✓ **User Authentication**
  - Signup with duplicate username prevention
  - Login with password verification
  - Session management

✓ **Post Management**
  - Create posts with auto-incrementing ID
  - View complete feed with all posts

✓ **Like System**
  - Add likes to posts
  - Prevent duplicate likes per user (unique constraint)
  - Display like count

✓ **Comments**
  - Comment on any post
  - Display all comments with author

✓ **Error Handling**
  - Invalid post IDs
  - Duplicate usernames
  - Empty inputs
  - Invalid menu choices
  - Non-numeric input

---

### How to Run

1. **Compile all Java files:**
   ```bash
   javac User.java Comment.java Post.java SocialMediaSimulator.java
   ```

2. **Run the main application:**
   ```bash
   java SocialMediaSimulator
   ```

---

### Sample Output / Usage Flow

```
╔════════════════════════════════════════╗
║   Welcome to Social Media Simulator   ║
╚════════════════════════════════════════╝

╔════════════════ MAIN MENU ════════════════╗
║  1. Signup                                ║
║  2. Login                                 ║
║  3. Exit                                  ║
╚═══════════════════════════════════════════╝
Enter your choice (1-3): 1

╔════════════════ SIGNUP ════════════════╗
Enter username: alice
Enter password: pass123
✓ Signup successful! You can now login.

╔════════════════ MAIN MENU ════════════════╗
║  1. Signup                                ║
║  2. Login                                 ║
║  3. Exit                                  ║
╚═══════════════════════════════════════════╝
Enter your choice (1-3): 2

╔════════════════ LOGIN ════════════════╗
Enter username: alice
Enter password: pass123
✓ Login successful! Welcome, alice!

╔════════════════ USER MENU ════════════════╗
║  1. Create Post                           ║
║  2. View Feed                             ║
║  3. Like Post                             ║
║  4. Comment on Post                       ║
║  5. Logout                                ║
╚═══════════════════════════════════════════╝
Enter your choice (1-5): 1

╔════════════════ CREATE POST ════════════════╗
Enter post content: Hello everyone! This is my first post.
✓ Post created successfully with ID: 1

╔════════════════ USER MENU ════════════════╗
║  1. Create Post                           ║
║  2. View Feed                             ║
║  3. Like Post                             ║
║  4. Comment on Post                       ║
║  5. Logout                                ║
╚═══════════════════════════════════════════╝
Enter your choice (1-5): 2

╔════════════════ FEED ════════════════╗

┌─────────────────────────────────────────┐
│ Post ID: 1
│ Author: alice
│ Content: Hello everyone! This is my first post.
│ Likes: 0
│ No comments yet
└─────────────────────────────────────────┘

╔════════════════ USER MENU ════════════════╗
║  1. Create Post                           ║
║  2. View Feed                             ║
║  3. Like Post                             ║
║  4. Comment on Post                       ║
║  5. Logout                                ║
╚═══════════════════════════════════════════╝
Enter your choice (1-5): 5

✓ You have been logged out. Goodbye, alice!

```

---

### Code Quality Highlights

✓ **Proper OOP Design**
  - Separate classes for User, Post, Comment
  - Encapsulation with private fields
  - Clear getter/setter methods
  - Well-documented with JavaDoc comments

✓ **Data Structures**
  - ArrayList for dynamic user storage
  - ArrayList for post storage
  - ArrayList for tracking liked users (prevents duplicates)
  - ArrayList for comment storage

✓ **Error Handling**
  - Input validation
  - Boundary checking
  - Exception handling for numeric input
  - User-friendly error messages with ✗ symbols

✓ **User Experience**
  - Formatted box-style menus
  - Clear success (✓) and error (✗) indicators
  - Intuitive navigation
  - Session management

---

### Key Implementation Details

**Duplicate Like Prevention:**
```java
public boolean addLike(String username) {
    if (likedUsers.contains(username)) {
        return false; // User already liked this post
    }
    likedUsers.add(username);
    likes++;
    return true;
}
```

**Post ID Counter:**
```java
private static int postIdCounter = 1;
// Incremented each time a post is created
Post newPost = new Post(postIdCounter++, content, loggedInUser.getUsername());
```

**Session Management:**
```java
private static User loggedInUser = null;
// Set on login, cleared on logout
```

---

### File Sizes

- `User.java` - 50 lines
- `Comment.java` - 34 lines
- `Post.java` - 99 lines
- `SocialMediaSimulator.java` - 344 lines
- **Total: 527 lines of production-ready code**

---

### For College Submission

This project demonstrates:
✓ Object-Oriented Programming (multiple classes with proper encapsulation)
✓ Data Structures (ArrayLists for dynamic storage)
✓ Exception Handling (try-catch for input validation)
✓ Control Flow (switch statements, loops, conditionals)
✓ User Input/Output (Scanner for console interaction)
✓ Algorithm Design (duplicate prevention in likes)
✓ Clean Code Practices (documentation, meaningful naming, separation of concerns)

All requirements met. Ready to submit.
