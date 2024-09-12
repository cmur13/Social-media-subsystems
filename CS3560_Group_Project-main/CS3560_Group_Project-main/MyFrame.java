import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.Flow;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.time.LocalTime;
import javax.swing.*;
import javax.swing.border.Border;

import org.w3c.dom.events.MouseEvent;

public class MyFrame extends JFrame implements ActionListener {

    // Required Panels.

    // Required Buttons.
    JButton signUpButton;
    JButton signInButton;
    JButton submitSignIn;
    JButton nextSignUp;
    JButton backSignUp;
    JButton backAccountSelect;
    JButton backSignIn;
    JButton personalButton;
    JButton businessButton;
    JButton enterHomeNext;
    JButton businessAccountBack;
    JButton selectProfilePicture;
    JButton backBioPicWindow;
    JButton createPostButton;
    JButton makeFriendButton;
    JButton logoutButton;
    JButton deletePostButton;
    JButton uploadPostButton;
    JButton cancelUploadButton;
    JButton postContentButton;
    JButton cancelDeleteButton;
    JButton upvoteButton;
    JButton downvoteButton;
    JButton reloadButton;
    JButton viewCommentsButton;
    JButton removeFriendButton;
    JButton editPostButton;

    // Required Labels.
    JLabel formatSpaces;
    JLabel welcomeLabel;
    JLabel nameLabel;
    JLabel userNamePrompt;
    JLabel passwordPrompt;
    JLabel invalidInfo;
    JLabel questionLabel;
    JLabel emailAddressLabel;
    JLabel DOBPrompt;
    JLabel bioPrompt;
    JLabel profilePicturePrompt;
    JLabel businessNamePrompt;
    JLabel businessEmailPrompt;
    JLabel businessPasswordPrompt;
    JLabel imageChosen;
    JLabel profilePicDisplay;
    JLabel userNameDisplay;
    JLabel friendsLabel;
    JLabel userBioDisplay;
    JLabel postTextPrompt;

    // Required textFields.
    JTextField userNameText;
    JPasswordField passwordText;
    JTextField nameText;
    JTextField emailAddressText;
    JTextField DOBText;
    JTextField bioText;
    JTextField businessNameText;
    JTextField businessEmailText;
    JTextField busiessPasswordPrompt;
    JTextField postText;
    JTextField friendUsername;
    JTextField textField;
    // Required panels.
    JPanel userInfoPanel;
    JPanel makePostPanel;
    JPanel friendsPanel;
    JPanel bioPanel;
    JPanel feedPanel;
    JPanel postPromptPanel;
    JPanel postTextPanel;
    JPanel postUploadPanel;
    JScrollPane scrollPane;
    JPanel deletePanel;
    JPanel cancelDeletePanel;
    JPanel topCommentsPage;
    JPanel commentsPanel;
    JPanel createCommentPanel;
    JPanel friendInfoPanel;
    JPanel friendMakePostPanel;
    JPanel friendsFeedPanel;
    JPanel friends2Panel;
    JPanel chooseFriendPanel;
    JPanel enterUsernamePanel;
    JPanel submitCancelPanel;
    JPanel editPanel;
    JPanel titlePanel;
    JPanel textPanel;
    JPanel submitTextPanel;
    JPanel welcomePanel; 

    // Grid Bag Constraints.
    GridBagConstraints gbc;

    // Required Icons/Images.
    JFileChooser profilePicChooser;
    ImageIcon profilePicture;
    Image image;
    Image newImage;
    Border blackline;
    Border blueline;
    Border redline;
    ImageIcon likeImage = new ImageIcon("like.png");
    ImageIcon dislikeImage = new ImageIcon("dislike.png");

    // User variables.
    UserProfile user;

    // Regular variables.
    String[] posts;
    String[] comments;
    String[] friendsPosts;
    String newFriend;

    // SQL variables. These will change for each team member.
    static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root/CS3650";
    static final String USER = "root";
    static final String PASS = "jesspinto@24";

    int userID = 0;

    public MyFrame(String response) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xB6FFED));
        this.setTitle(response);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
    }

    public void welcomeWindow() {

        this.setLayout(new FlowLayout());
        this.setSize(500, 500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0xB6FFED));
        this.setTitle("Welcome");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setResizable(false);
        this.setTitle("Welcome");

        welcomePanel = new JPanel();
        welcomePanel.setPreferredSize(new Dimension(500,500));
        welcomePanel.setBackground(new Color(0xB6FFED));
        // Label information.
        welcomeLabel = new JLabel("WELCOME!");
        welcomeLabel.setFont(new Font("Consolas", Font.PLAIN, 75));
        welcomeLabel.setFocusable(true);
        welcomeLabel.setPreferredSize(new Dimension(400, 300));

        // Sign up button.
        signUpButton = new JButton();
        // signUpButton.setOpaque(true);
        signUpButton.setText("SIGN UP");
        signUpButton.setBounds(400, 300, 450, 200);
        signUpButton.setFont(new Font("BellMT", Font.BOLD, 15));
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(e -> accountSelectWindow());
        signUpButton.setHorizontalTextPosition(JButton.RIGHT);
        signUpButton.setVerticalTextPosition(JButton.BOTTOM);
        signUpButton.setPreferredSize(new Dimension(100, 50));

        // Sign in button.
        signInButton = new JButton();
        signInButton.setText("SIGN IN");
        signInButton.setFont(new Font("Canva Sans", Font.BOLD, 15));
        signInButton.setFocusable(false);
        signInButton.addActionListener(e -> SignInWindow());
        signInButton.setHorizontalTextPosition(JButton.LEFT);
        signInButton.setVerticalTextPosition(JButton.BOTTOM);
        signInButton.setPreferredSize(new Dimension(100, 50));

        welcomePanel.add(welcomeLabel);
        welcomePanel.add(signInButton);
        welcomePanel.add(signUpButton);
        this.add(welcomePanel);

        this.setVisible(true);
        /* 
        // Add label and button to frame.
        this.add(welcomeLabel);
        this.add(signUpButton);
        this.add(signInButton);
        this.setVisible(true); */

    }

    public void SignInWindow() {
        this.setLayout(new GridBagLayout());

        welcomePanel.setVisible(false);
        GridBagConstraints label = new GridBagConstraints();
        label.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints field = new GridBagConstraints();
        field.insets = new Insets(3, 3, 3, 3);
        field.gridwidth = GridBagConstraints.REMAINDER;

        /* 
        // Remove elements from previous window.
        welcomeLabel.setVisible(false);
        signUpButton.setVisible(false);
        signInButton.setVisible(false); */
        this.setTitle("Sign In");

        // Create new labels to prompt for information.
        userNamePrompt = new JLabel();
        passwordPrompt = new JLabel();

        // Customize labels.
        userNamePrompt.setText("USERNAME: ");
        passwordPrompt.setText("PASSWORD: ");

        // Textbox for userName.
        userNameText = new JTextField(20);

        // Textbox for password.
        passwordText = new JPasswordField(20);

        // Create button to submit form or go back to welcome window.
        submitSignIn = new JButton("SUBMIT");
        submitSignIn.setFont(new Font("League Spartan", Font.BOLD, 15));
        submitSignIn.addActionListener(e -> SignInVerification());
        submitSignIn.setPreferredSize(new Dimension(100, 50));
        backSignIn = new JButton("BACK");
        backSignIn.setFont(new Font("League Spartan", Font.BOLD, 15));
        backSignIn.setPreferredSize(new Dimension(100, 50));
        backSignIn.addActionListener(e -> SignInBack());

        // Add elements from this window to frame.
        this.add(userNamePrompt, label);
        this.add(userNameText, field);
        this.add(passwordPrompt, label);
        this.add(passwordText, field);
        this.add(backSignIn, gbc);
        this.add(submitSignIn, gbc);

    }

    // Window for user to choose between Personal/Business Account
    public void accountSelectWindow() {
        this.setLayout(new FlowLayout());

        welcomePanel.setVisible(false);
        /* 
        welcomeLabel.setVisible(false);
        signUpButton.setVisible(false);
        signInButton.setVisible(false); */
        this.setTitle("Sign Up");

        // label for question
        questionLabel = new JLabel();
        questionLabel.setText("PLEASE CHOOSE ACCOUNT TYPE:");
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setFont(new Font("Consolas", Font.BOLD, 25));
        questionLabel.setPreferredSize(new Dimension(450, 150));
        questionLabel.setForeground(Color.black);
        // questionLabel.setPreferredSize(new Dimension(400,400));

        this.add(questionLabel);

        // Buttons for business and personal accounts
        personalButton = new JButton("PERSONAL");
        personalButton.setFont(new Font("Consolas", Font.BOLD, 16));
        personalButton.setBackground(new Color(0xFF5757));
        personalButton.setForeground(Color.black);
        personalButton.setFocusable(false);
        personalButton.addActionListener(e -> SignUpPersonalWindow());
        personalButton.setPreferredSize(new Dimension(400, 50));

        backAccountSelect = new JButton("BACK");
        backAccountSelect.addActionListener(e -> accountSelectBack());
        backAccountSelect.setPreferredSize(new Dimension(100, 50));
        backAccountSelect.setFont(new Font("Consolas", Font.PLAIN, 16));
        backAccountSelect.setVerticalTextPosition(JButton.BOTTOM);

        businessButton = new JButton("BUSINESS");
        businessButton.setFont(new Font("Consolas", Font.BOLD, 16));
        businessButton.setBackground(new Color(0xFF5757));
        businessButton.setForeground(Color.black);
        businessButton.setFocusable(false);
        businessButton.setPreferredSize(new Dimension(400, 50));
        businessButton.addActionListener(e -> SignUpBusinessWindow());

        this.add(personalButton);
        this.add(businessButton);
        this.add(backAccountSelect);

        this.setVisible(true);
    }

    public void accountSelectBack() {

        personalButton.setVisible(false);
        businessButton.setVisible(false);
        questionLabel.setVisible(false);
        backAccountSelect.setVisible(false);
        welcomeWindow();
    }

    public void SignUpPersonalWindow() {

        this.setLayout(new GridBagLayout());

        // Remove elements from previous window.
        businessButton.setVisible(false);
        personalButton.setVisible(false);
        questionLabel.setVisible(false);
        backAccountSelect.setVisible(false);

        // set the contraints
        GridBagConstraints label = new GridBagConstraints();
        label.insets = new Insets(3, 3, 3, 3);
        GridBagConstraints field = new GridBagConstraints();
        field.insets = new Insets(3, 3, 3, 3);
        field.gridwidth = GridBagConstraints.REMAINDER;

        // Set proper title.
        this.setTitle("Sign Up");

        // Necessary buttons.
        nextSignUp = new JButton("NEXT");
        nextSignUp.addActionListener(e -> BioPicWindow());
        nextSignUp.setPreferredSize(new Dimension(100, 50));
        backSignUp = new JButton("BACK");
        backSignUp.addActionListener(e -> SignUpBack());
        backSignUp.setPreferredSize(new Dimension(100, 50));

        // Labels and text boxes
        nameLabel = new JLabel("NAME:");
        nameText = new JTextField(20);

        userNamePrompt = new JLabel("USERNAME:");
        userNameText = new JTextField(20);
        emailAddressLabel = new JLabel("EMAIL:");
        emailAddressText = new JTextField(20);
        passwordPrompt = new JLabel("PASSWORD:");
        passwordText = new JPasswordField(20);
        DOBPrompt = new JLabel("DOB:");
        DOBText = new JTextField(20);
        DOBText.setText("DD/MM/YYYY");

        // this.add(nameLabel, label);
        // this.add(nameText, field);
        this.add(userNamePrompt, label);
        this.add(userNameText, field);
        this.add(emailAddressLabel, label);
        this.add(emailAddressText, field);
        this.add(passwordPrompt, label);
        this.add(passwordText, field);
        this.add(DOBPrompt, label);
        this.add(DOBText, field);
        this.add(backSignUp, gbc);
        this.add(nextSignUp, gbc);

        //this.setVisible(true);

    }

    public void BioPicWindow() {

        this.setLayout(new FlowLayout());
        // Remove elements from previous window.
        nameLabel.setVisible(false);
        nameText.setVisible(false);
        userNamePrompt.setVisible(false);
        userNameText.setVisible(false);
        emailAddressLabel.setVisible(false);
        emailAddressText.setVisible(false);
        passwordPrompt.setVisible(false);
        passwordText.setVisible(false);
        DOBPrompt.setVisible(false);
        DOBText.setVisible(false);
        backSignUp.setVisible(false);
        nextSignUp.setVisible(false);

        // Create labels.
        bioPrompt = new JLabel();
        bioPrompt.setText("BIOGRAPHY:");
        bioPrompt.setFont(new Font("League Spartan", Font.PLAIN, 35));

        profilePicturePrompt = new JLabel();
        profilePicturePrompt.setText("PROFILE PICTURE:");
        profilePicturePrompt.setFont(new Font("League Spartan", Font.PLAIN, 35));
        profilePicturePrompt.setHorizontalTextPosition(JLabel.CENTER);

        profilePicDisplay = new JLabel(" ");
        profilePicDisplay.setPreferredSize(new Dimension(200, 200));

        // Create textFields.
        bioText = new JTextField();
        bioText.setPreferredSize(new Dimension(350, 100));

        // Create buttons to navigate.
        selectProfilePicture = new JButton("SELECT IMAGE");
        selectProfilePicture.addActionListener(e -> selectProfileImage());
        selectProfilePicture.setPreferredSize(new Dimension(100, 50));
        selectProfilePicture.setVerticalTextPosition(JButton.BOTTOM);
        selectProfilePicture.setHorizontalTextPosition(JButton.CENTER);

        backBioPicWindow = new JButton("BACK");
        backBioPicWindow.setPreferredSize(new Dimension(100, 50));
        backBioPicWindow.addActionListener(e -> backBioPic());
        enterHomeNext = new JButton("NEXT");
        enterHomeNext.setPreferredSize(new Dimension(100, 50));
        enterHomeNext.addActionListener(e -> enterHome());

        this.add(bioPrompt);
        this.add(bioText);
        this.add(profilePicturePrompt);
        this.add(selectProfilePicture);
        this.add(profilePicDisplay);
        this.add(backBioPicWindow);
        this.add(enterHomeNext);
        // this.add(nextToHomepage);
    }

    public void backBioPic() {
        bioPrompt.setVisible(false);
        bioText.setVisible(false);
        profilePicturePrompt.setVisible(false);
        selectProfilePicture.setVisible(false);
        profilePicDisplay.setVisible(false);
        backBioPicWindow.setVisible(false);
        enterHomeNext.setVisible(false);
        SignUpPersonalWindow();

    }

    public void enterHome() {
        // save bio and profile pic information

        // Save personal information.
        // Local Date changes.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = DOBText.getText();

        // convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        String userBio;
        if (bioText.getText().isEmpty()) {
            userBio = " ";
        } else {
            userBio = bioText.getText();
        }

        // Create a new instance.
        user = new UserProfile(userNameText.getText(), passwordText.getText(), emailAddressText.getText(), "personal",
                localDate,
                userBio);
        user.createUser();
        userNameDisplay = new JLabel();
        userNameDisplay.setText(user.getUsername());


        bioPrompt.setVisible(false);
        bioText.setVisible(false);
        profilePicturePrompt.setVisible(false);
        selectProfilePicture.setVisible(false);
        profilePicDisplay.setVisible(false);
        backBioPicWindow.setVisible(false);
        enterHomeNext.setVisible(false);
        homepageWindow();
    }

    public void selectProfileImage() {

        profilePicChooser = new JFileChooser();
        int response = profilePicChooser.showOpenDialog(null);
        String imageString;
        File profilePicFile;
        if (response == JFileChooser.APPROVE_OPTION) {
            profilePicFile = new File(profilePicChooser.getSelectedFile().getAbsolutePath());
            imageString = profilePicFile.toString();
            System.out.println(imageString);
        } else {
            profilePicFile = new File("/Users/jessicapinto/Documents/CS3560_Group_Project/nopfp.webp");
            imageString = profilePicFile.toString();
            profilePicture = new ImageIcon(imageString);
            image = profilePicture.getImage();
        }
        profilePicture = new ImageIcon(imageString);
        image = profilePicture.getImage();
        newImage = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        profilePicture = new ImageIcon(newImage);
        profilePicDisplay.setIcon(profilePicture);

        // Add profilePic info into database.
    }

    public void SignUpBack() {

        nameLabel.setVisible(false);
        nameText.setVisible(false);
        userNamePrompt.setVisible(false);
        userNameText.setVisible(false);
        emailAddressLabel.setVisible(false);
        emailAddressText.setVisible(false);
        passwordPrompt.setVisible(false);
        passwordText.setVisible(false);
        DOBPrompt.setVisible(false);
        DOBText.setVisible(false);
        backSignUp.setVisible(false);
        nextSignUp.setVisible(false);
        backAccountSelect.setVisible(false);
        this.setLayout(new FlowLayout());
        accountSelectWindow();
    }

    public void SignInVerification() {
        String userName = userNameText.getText();
        String password = passwordText.getText();
        String correctPassword;
        // Get user information from DB.
        String userEmail;
        LocalDate userDOB;
        String userBio;

        // Save info for userName display.
        userNameDisplay = new JLabel();
        userNameDisplay.setText(userName);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("SELECT password FROM profile WHERE userName = '" + userName + "';");
            rs.next();
            correctPassword = "";

            try {
                correctPassword = rs.getString("password");
            } catch (SQLException e) {
                userNameText.setBackground(new Color(0xFF5757));
            }

            if (password.equals(correctPassword)) {
                passwordText.setBackground(Color.white);
                userNamePrompt.setVisible(false);
                userNameText.setVisible(false);
                passwordPrompt.setVisible(false);
                backSignIn.setVisible(false);
                submitSignIn.setVisible(false);
                passwordText.setVisible(false);

                // Get information for user to create UserProfile instance.
                rs = statement
                        .executeQuery("SELECT emailAddress FROM profile WHERE password ='" + correctPassword + "';");
                // Get userEmail from profile table.
                rs.next();
                userEmail = rs.getString("emailAddress");

                // Get userDOB from profile table.
                rs = statement
                        .executeQuery("SELECT dateOfBirth FROM profile WHERE password ='" + correctPassword + "';");
                rs.next();
                String userDOBString = rs.getString("dateOfBirth");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                // convert String to LocalDate
                // userDOB = LocalDate.parse(userDOBString, formatter);

                rs = statement.executeQuery("SELECT biography FROM profile WHERE password ='" + correctPassword + "';");
                rs.next();
                userBio = rs.getString("biography");

                user = new UserProfile(userNameText.getText(), passwordText.getText(), userEmail, LocalDate.now(),
                        userBio);

                // Get userBio from profile table.
                homepageWindow();
            } else {
                // Verify information. Display red textbox if password is incorrect.
                passwordText.setBackground(new Color(0xFF5757));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // How to get info from table without creating instance?
        // String correctUserName = signInUser.getUsername();
    }

    public void SignInBack() {

        userNamePrompt.setVisible(false);
        userNameText.setVisible(false);
        passwordPrompt.setVisible(false);
        passwordText.setVisible(false);
        submitSignIn.setVisible(false);
        backSignIn.setVisible(false);
        welcomeWindow();
    }

    public void SignUpBusinessWindow() {

        this.setLayout(new GridBagLayout());

        // set the contraints
        GridBagConstraints label = new GridBagConstraints();
        label.insets = new Insets(10, 10, 10, 3);
        GridBagConstraints field = new GridBagConstraints();
        field.insets = new Insets(10, 10, 10, 3);
        field.gridwidth = GridBagConstraints.REMAINDER;

        // Remove elements from previous window.
        businessButton.setVisible(false);
        personalButton.setVisible(false);
        questionLabel.setVisible(false);
        backAccountSelect.setVisible(false);

        // Information Prompts.
        businessNamePrompt = new JLabel();
        businessNamePrompt.setText("BUSINESS NAME:");
        businessNamePrompt.setFont(new Font("League Spartan", Font.PLAIN, 18));

        businessEmailPrompt = new JLabel();
        businessEmailPrompt.setText("BUSINESS EMAIL:");
        businessEmailPrompt.setFont(new Font("League Spartan", Font.PLAIN, 18));

        businessPasswordPrompt = new JLabel();
        businessPasswordPrompt.setText("PASSWORD: ");

        // Textfields.
        businessNameText = new JTextField(20);
        businessEmailText = new JTextField(20);

        passwordPrompt = new JLabel("PASSWORD:");
        passwordPrompt.setFont(new Font("League Spartan", Font.PLAIN, 18));
        passwordText = new JPasswordField(20);

        bioPrompt = new JLabel();
        bioPrompt.setText("BIOGRAPHY:");
        bioPrompt.setFont(new Font("League Spartan", Font.PLAIN, 18));
        bioText = new JTextField(20);

        // Back and Next Buttons.
        enterHomeNext = new JButton("NEXT");
        enterHomeNext.setPreferredSize(new Dimension(100, 50));
        enterHomeNext.addActionListener(e -> businessEnterHome());
        businessAccountBack = new JButton("BACK");
        businessAccountBack.setPreferredSize(new Dimension(100, 50));
        businessAccountBack.addActionListener(e -> BusinessSignUpBack());

        this.add(businessNamePrompt, label);
        this.add(businessNameText, field);
        this.add(passwordPrompt, label);
        this.add(passwordText, field);
        this.add(businessEmailPrompt, label);
        this.add(businessEmailText, field);
        this.add(bioPrompt, label);
        this.add(bioText, field);
        this.add(businessAccountBack, gbc);
        this.add(enterHomeNext, gbc);

    }

    public void businessEnterHome() {
        String userBio = bioText.getText();
        if (bioText.getText() == null) {
            userBio = "";
        } else {
            userBio = bioText.getText();
        }

        user = new UserProfile(businessNameText.getText(), passwordText.getText(), businessEmailText.getText(),
                "business", LocalDate.now(), userBio);
        user.createUser();

        // Remove previous elements.
        businessNamePrompt.setVisible(false);
        businessNameText.setVisible(false);
        passwordPrompt.setVisible(false);
        passwordText.setVisible(false);
        businessEmailPrompt.setVisible(false);
        businessEmailText.setVisible(false);
        bioPrompt.setVisible(false);
        bioText.setVisible(false);
        businessAccountBack.setVisible(false);
        enterHomeNext.setVisible(false);
        homepageWindow();
    }

    public void BusinessSignUpBack() {
        businessNamePrompt.setVisible(false);
        businessNameText.setVisible(false);
        businessEmailPrompt.setVisible(false);
        businessEmailText.setVisible(false);
        passwordPrompt.setVisible(false);
        passwordText.setVisible(false);
        bioPrompt.setVisible(false);
        bioText.setVisible(false);
        businessAccountBack.setVisible(false);
        enterHomeNext.setVisible(false);
        accountSelectWindow();
    }

    public void homepageWindow() {
        this.setLayout(new BorderLayout());
        this.setTitle("Home");
        this.setResizable(true);
        ;
        // add account's profile pic
        // for now, using SignUp profile pic
        /*
         * image = profilePicture.getImage();
         * newImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
         * profilePicture = user.getProfilePicture();
         * profilePicDisplay.setIcon(profilePicture);
         * 
         * // Border for image
         * blackline = BorderFactory.createLineBorder(Color.black);
         * profilePicDisplay.setPreferredSize(new Dimension(100, 100));
         * profilePicDisplay.setBorder(blackline);
         */

        userInfoPanel = new JPanel();
        userInfoPanel.setBackground(new Color(0xFFC9EA));
        userInfoPanel.setLayout(new BoxLayout(userInfoPanel, BoxLayout.Y_AXIS));

        // Create panel displays for window.
        userNameDisplay = new JLabel();
        userNameDisplay.setText(user.getUsername());
        userNameDisplay.setFont(new Font("BellMT", Font.BOLD, 40));
        userBioDisplay = new JLabel(user.getBio());
        userBioDisplay.setFont(new Font("BellMT", Font.BOLD, 15));

        makePostPanel = new JPanel();
        makePostPanel.setBackground(new Color(0xFFC9EA));
        makePostPanel.setPreferredSize(new Dimension(100, 400));

        friendsPanel = new JPanel();
        friendsPanel.setBackground(new Color(0xFFC9EA));
        friendsPanel.setPreferredSize(new Dimension(200, 400));

        feedPanel = new JPanel();
        feedPanel.setBackground(new Color(0xB6FFED));

        // Post features.
        createPostButton = new JButton("MAKE POST");
        createPostButton.setFont(new Font("Consolas", Font.BOLD, 14));
        createPostButton.setBackground(new Color(0xFF5757));
        createPostButton.setForeground(Color.black);
        createPostButton.setPreferredSize(new Dimension(100, 50));
        createPostButton.addActionListener(e -> createPostWindow());

        deletePostButton = new JButton("DELETE POST");
        deletePostButton.setFont(new Font("Consolas", Font.BOLD, 13));
        deletePostButton.setBackground(new Color(0xFF5757));
        deletePostButton.setForeground(Color.black);
        deletePostButton.setPreferredSize(new Dimension(100, 50));
        deletePostButton.addActionListener(e -> deletePost());

        // Friend features.
        makeFriendButton = new JButton("ADD FRIEND");
        makeFriendButton.setFont(new Font("Consolas", Font.BOLD, 14));
        makeFriendButton.setBackground(new Color(0xFF5757));
        makeFriendButton.setForeground(Color.black);
        makeFriendButton.setPreferredSize(new Dimension(100, 50));
        makeFriendButton.addActionListener(e -> makeFriendPage());

        removeFriendButton = new JButton("REMOVE FRIEND");
        removeFriendButton.setLayout(new FlowLayout());
        removeFriendButton.setFont(new Font("Consolas", Font.BOLD, 10));
        removeFriendButton.setBackground(new Color(0xFF5757));
        removeFriendButton.setForeground(Color.black);
        removeFriendButton.setPreferredSize(new Dimension(100, 50));
        removeFriendButton.addActionListener(e -> removeFriendPage());

        logoutButton = new JButton("LOG OUT");
        logoutButton.setFont(new Font("Consolas", Font.BOLD, 14));
        logoutButton.setBackground(new Color(0xFF5757));
        logoutButton.setForeground(Color.black);
        logoutButton.setPreferredSize(new Dimension(100, 50));
        logoutButton.addActionListener(e -> logOut());

        editPostButton = new JButton("EDIT POST");
        editPostButton.setFont(new Font("Consolas", Font.BOLD, 14));
        editPostButton.setBackground(new Color(0xFF5757));
        editPostButton.setForeground(Color.black);
        editPostButton.setPreferredSize(new Dimension(100, 50));
        editPostButton.addActionListener(e -> editPostWindow());

        // Labels for friends.
        friendsLabel = new JLabel("FRIENDS - " + (user.getNumberOfFriends()));
        friendsLabel.setFont(new Font("BellMT", Font.BOLD, 20));
        friendsLabel.setPreferredSize(new Dimension(135, 35));

        friendsPanel.add(friendsLabel);
        friendsPanel.setLayout(new BoxLayout(friendsPanel, BoxLayout.Y_AXIS));

        // Show all friend's names.
        int[] friendsID = new int[user.getNumberOfFriends()];
        String[] friendsNames = new String[user.getNumberOfFriends()];
        friendsID = user.getFriends();
        for (int k = 0; k < friendsID.length; k++) {
            UserProfile friend = new UserProfile(friendsID[k]);
            friendsNames[k] = friend.getUsername1();

            // Create a new label for each name.
            JButton friendName = new JButton(friendsNames[k]);
            friendsPanel.add(friendName);

            int friendID = friendsID[k];

            friendName.addActionListener(e -> friendProfile(friendID));

        }

        if (user.getNumberOfPosts(user.userID) > 0) {
            // Show the feed with user's own posts.
            posts = new String[user.getNumberOfPosts(user.userID)];
            posts = user.getPosts(user.getUserID());

            // create gridBagConstraints for each post
            for (int i = 0; i < posts.length; i++) {
                feedPanel.setLayout(new GridBagLayout());

                blackline = BorderFactory.createLineBorder(Color.black);
                blueline = BorderFactory.createLineBorder(Color.blue);
                redline = BorderFactory.createLineBorder(Color.red);

                GridBagConstraints label = new GridBagConstraints();
                label.insets = new Insets(10, 10, 10, 3);
                // fix the problem of same row posts?
                label.gridy = i; // set the row for each post

                GridBagConstraints field = new GridBagConstraints();
                field.insets = new Insets(10, 10, 10, 3);
                field.gridwidth = GridBagConstraints.REMAINDER;
                field.gridy = i; // set the row for each post

                JLabel postContent = new JLabel(posts[i]);
                JLabel postUserName = new JLabel("You->");
                postUserName.setPreferredSize(new Dimension(50, 20));
                postUserName.setFont(new Font("Consolas", Font.BOLD, 14));
                postUserName.setBackground(new Color(0x1B1464));
                postContent.setPreferredSize(new Dimension(300, 35));
                postContent.setFont(new Font("Consolas", Font.PLAIN, 20));
                postContent.setVerticalTextPosition(JLabel.BOTTOM);

                postContent.setOpaque(true);
                postContent.getPreferredSize();
                postContent.setBorder(blackline);

                Post post = new Post(user.getUserID(user.getUsername()), posts[i], "text");

                // If it's a business account post, make the post background red.
                if (user.getProfileType().equals("business")) {
                    postContent.setBackground(new Color(0xFFBDBA));
                } else {
                    postContent.setBackground(new Color(0xCAC5FF));
                }

                // Add user's own post to feed.
                feedPanel.add(postUserName, label);
                feedPanel.add(postContent, label);

                upvoteButton = new JButton(scaleImage(likeImage, 35, 35));
                upvoteButton.setPreferredSize(new Dimension(40, 40));
                downvoteButton = new JButton(scaleImage(dislikeImage, 30, 30));
                downvoteButton.setPreferredSize(new Dimension(40, 40));
                upvoteButton.addActionListener(e -> post.addUpvote());
                downvoteButton.addActionListener(e -> post.addDownvote());

                String postText = posts[i];

                // Display the likes.
                JLabel numLikes = new JLabel();
                int likes = post.getUpvotes();
                numLikes.setText(Integer.toString(likes));
                numLikes.setPreferredSize(new Dimension(20, 20));

                JLabel numDislikes = new JLabel();
                int dislikes = post.getDownvotes();
                numDislikes.setText(Integer.toString(dislikes));
                numDislikes.setPreferredSize(new Dimension(20, 20));

                feedPanel.add(upvoteButton, label);
                feedPanel.add(downvoteButton, label);
                feedPanel.add(numLikes, label);
                feedPanel.add(numDislikes, label);
                viewCommentsButton = new JButton("COMMENTS");
                viewCommentsButton.addActionListener(e -> viewCommentsPage(user.getUserID(), postText, "text"));
                feedPanel.add(viewCommentsButton, label);

            }
        }

        scrollPane = new JScrollPane(feedPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // this.add(profilePicDisplay);
        userInfoPanel.add(userNameDisplay);
        userInfoPanel.add(userBioDisplay);

        // Reload to show posts.
        reloadButton = new JButton("RELOAD");
        reloadButton.setFont(new Font("Consolas", Font.BOLD, 14));
        reloadButton.setBackground(new Color(0xFF5757));
        reloadButton.setForeground(Color.black);
        reloadButton.setPreferredSize(new Dimension(100, 50));
        reloadButton.addActionListener(e -> reload());

        makePostPanel.add(createPostButton);
        makePostPanel.add(makeFriendButton);
        makePostPanel.add(deletePostButton);
        makePostPanel.add(reloadButton);
        makePostPanel.add(removeFriendButton);
        makePostPanel.add(editPostButton);
        makePostPanel.add(logoutButton);
        this.add(userInfoPanel, BorderLayout.NORTH);
        this.add(makePostPanel, BorderLayout.WEST);
        this.add(friendsPanel, BorderLayout.EAST);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void reload() {
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        scrollPane.setVisible(false);
        homepageWindow();
    }

    public void removeFriendPage() {
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        scrollPane.setVisible(false);

        chooseFriendPanel = new JPanel();
        chooseFriendPanel.setBackground(new Color(0xB6FFED));
        enterUsernamePanel = new JPanel();
        enterUsernamePanel.setBackground(new Color(0xB6FFED));
        submitCancelPanel = new JPanel();
        submitCancelPanel.setBackground(new Color(0xB6FFED));

        JLabel chooseFriendPrompt = new JLabel("ENTER (EX-)FRIEND USERNAME:");
        chooseFriendPrompt.setPreferredSize(new Dimension(415, 50));
        chooseFriendPrompt.setFont(new Font("Consolas", Font.BOLD, 25));
        chooseFriendPanel.add(chooseFriendPrompt);
        friendUsername = new JTextField();
        // Keep the size below the same.
        friendUsername.setPreferredSize(new Dimension(400, 30));
        enterUsernamePanel.add(friendUsername);

        JButton cancelFriend = new JButton("CANCEL");
        submitCancelPanel.add(cancelFriend);
        cancelFriend.setFont(new Font("Consolas", Font.BOLD, 15));
        cancelFriend.setBackground(new Color(0xFF5757));
        cancelFriend.setForeground(Color.black);
        cancelFriend.setPreferredSize(new Dimension(100, 50));
        cancelFriend.addActionListener(e -> cancelFriend());

        JButton removeFriend = new JButton("REMOVE");
        removeFriend.setFont(new Font("Consolas", Font.BOLD, 15));
        removeFriend.setBackground(new Color(0xFF5757));
        removeFriend.setForeground(Color.black);
        removeFriend.setPreferredSize(new Dimension(100, 50));
        removeFriend.addActionListener(e -> cancelFriend());
        submitCancelPanel.add(removeFriend);
        removeFriend.addActionListener(e -> removeFriend());

        this.add(chooseFriendPanel, BorderLayout.NORTH);
        this.add(enterUsernamePanel, BorderLayout.CENTER);
        this.add(submitCancelPanel, BorderLayout.SOUTH);
    }

    public void removeFriend() {
        chooseFriendPanel.setVisible(false);
        enterUsernamePanel.setVisible(false);
        submitCancelPanel.setVisible(false);

        UserProfile oldFriend = new UserProfile(friendUsername.getText());
        user.removeFriend(oldFriend.getUserID());
        homepageWindow();
    }

    public void makeFriendPage() {
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        scrollPane.setVisible(false);

        chooseFriendPanel = new JPanel();
        chooseFriendPanel.setBackground(new Color(0xB6FFED));
        enterUsernamePanel = new JPanel();
        enterUsernamePanel.setBackground(new Color(0xB6FFED));
        submitCancelPanel = new JPanel();
        submitCancelPanel.setBackground(new Color(0xB6FFED));

        JLabel chooseFriendPrompt = new JLabel("ENTER FRIEND USERNAME:");
        chooseFriendPrompt.setPreferredSize(new Dimension(415, 50));
        chooseFriendPrompt.setFont(new Font("Consolas", Font.BOLD, 25));
        chooseFriendPanel.add(chooseFriendPrompt);
        friendUsername = new JTextField();
        // Keep the size below the same.
        friendUsername.setPreferredSize(new Dimension(400, 30));
        enterUsernamePanel.add(friendUsername);

        JButton cancelFriend = new JButton("CANCEL");
        cancelFriend.setFont(new Font("Consolas", Font.BOLD, 15));
        cancelFriend.setBackground(new Color(0xFF5757));
        cancelFriend.setForeground(Color.black);
        cancelFriend.setPreferredSize(new Dimension(100, 50));
        submitCancelPanel.add(cancelFriend);
        cancelFriend.addActionListener(e -> cancelFriend());

        JButton addFriend = new JButton("ADD");
        addFriend.setFont(new Font("Consolas", Font.BOLD, 15));
        addFriend.setBackground(new Color(0xFF5757));
        addFriend.setForeground(Color.black);
        addFriend.setPreferredSize(new Dimension(100, 50));
        submitCancelPanel.add(addFriend);
        addFriend.addActionListener(e -> addFriend());

        this.add(chooseFriendPanel, BorderLayout.NORTH);
        this.add(enterUsernamePanel, BorderLayout.CENTER);
        this.add(submitCancelPanel, BorderLayout.SOUTH);
    }

    public void cancelFriend() {
        chooseFriendPanel.setVisible(false);
        enterUsernamePanel.setVisible(false);
        submitCancelPanel.setVisible(false);
        homepageWindow();
    }

    public void addFriend() {
        chooseFriendPanel.setVisible(false);
        enterUsernamePanel.setVisible(false);
        submitCancelPanel.setVisible(false);
        if (friendUsername.getText() == null) {
            homepageWindow();
        } else {
            UserProfile newFriend = new UserProfile(friendUsername.getText());
            user.befriend(newFriend.getUserID());
            homepageWindow();
        }
    }

    // click on friends profile:
    public void friendProfile(int friendsID) {

        this.setLayout(new BorderLayout());
        UserProfile friend = new UserProfile(friendsID);
        this.setTitle("Friend - " + friend.getUsername(friendsID));
        this.setResizable(true);

        makePostPanel.setVisible(false);
        userInfoPanel.setVisible(false);
        friendsPanel.setVisible(false);
        scrollPane.setVisible(false);
        // add account's profile pic
        // for now, using SignUp profile pic
        /*
         * image = profilePicture.getImage();
         * newImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
         * profilePicture = user.getProfilePicture();
         * profilePicDisplay.setIcon(profilePicture);
         * 
         * // Border for image
         * blackline = BorderFactory.createLineBorder(Color.black);
         * profilePicDisplay.setPreferredSize(new Dimension(100, 100));
         * profilePicDisplay.setBorder(blackline);
         */

        JLabel friendUserNameDisplay = new JLabel(friend.getUsername(friendsID));
        friendUserNameDisplay.setFont(new Font("BellMT", Font.BOLD, 40));

        JLabel friendBioDisplay = new JLabel(friend.getBio());
        friendBioDisplay.setFont(new Font("BellMT", Font.BOLD, 15));

        friendInfoPanel = new JPanel();
        friendInfoPanel.setBackground(new Color(0xFFC9EA));
        friendInfoPanel.setLayout(new BoxLayout(friendInfoPanel, BoxLayout.Y_AXIS));

        friendMakePostPanel = new JPanel();
        friendMakePostPanel.setBackground(new Color(0xFFC9EA));
        friendMakePostPanel.setPreferredSize(new Dimension(100, 400));

        friendsFeedPanel = new JPanel();
        friendsFeedPanel.setBackground(new Color(0xB6FFED));

        JLabel friends2Label = new JLabel("FRIENDS");
        friends2Label.setFont(new Font("BellMT", Font.BOLD, 20));
        friends2Label.setPreferredSize(new Dimension(135, 35));

        friends2Panel = new JPanel();
        friends2Panel.setLayout(new BoxLayout(friends2Panel, BoxLayout.Y_AXIS));
        friends2Panel.setBackground(new Color(0xFFC9EA));
        friends2Panel.setPreferredSize(new Dimension(200, 400));

        int[] friendsID2 = new int[friend.getNumberOfFriends()];
        String[] friendsNames2 = new String[friend.getNumberOfFriends()];
        friendsID2 = friend.getFriends();
        for (int k = 0; k < friendsID2.length; k++) {
            UserProfile friend2 = new UserProfile(friendsID2[k]);
            friendsNames2[k] = friend2.getUsername(friendsID2[k]);

            // Create a new label for each name.
            JLabel friendName = new JLabel(friendsNames2[k]);
            friendName.setFont(new Font("Consolas", Font.BOLD, 14));
            friendName.setPreferredSize(new Dimension(100, 20));
            friends2Panel.add(friendName);
        }

        // Show friends' posts.
        friendsPosts = new String[friend.getNumberOfPosts(friendsID)];
        friendsPosts = user.getPosts(friendsID);

        for (int i = 0; i < friendsPosts.length; i++) {
            friendsFeedPanel.setLayout(new GridBagLayout());

            blackline = BorderFactory.createLineBorder(Color.black);

            GridBagConstraints label = new GridBagConstraints();
            label.insets = new Insets(10, 10, 10, 3);
            // fix the problem of same row posts?
            label.gridy = i; // set the row for each post

            GridBagConstraints field = new GridBagConstraints();
            field.insets = new Insets(10, 10, 10, 3);
            field.gridwidth = GridBagConstraints.REMAINDER;
            field.gridy = i; // set the row for each post

            JLabel postContent = new JLabel(friendsPosts[i]);
            JLabel postUserName = new JLabel(friend.getUsername(friendsID) + "->");
            postUserName.setPreferredSize(new Dimension(65, 20));
            postUserName.setFont(new Font("Consolas", Font.BOLD, 14));
            postUserName.setBackground(new Color(0x1B1464));
            postContent.setPreferredSize(new Dimension(300, 35));
            postContent.setFont(new Font("Consolas", Font.PLAIN, 20));
            postContent.setVerticalTextPosition(JLabel.BOTTOM);

            postContent.setOpaque(true);
            postContent.getPreferredSize();
            postContent.setBorder(blackline);

            Post friendsPost = new Post(friendsID, friendsPosts[i], "text");

            // If it's a business account post, make the post background red.
            if (friend.getProfileType().equals("business")) {
                postContent.setBackground(new Color(0xFFBDBA));
            } else {
                postContent.setBackground(new Color(0xCAC5FF));
            }

            friendsFeedPanel.add(postUserName, label);
            friendsFeedPanel.add(postContent, label);

            upvoteButton = new JButton(scaleImage(likeImage, 35, 35));
            upvoteButton.setPreferredSize(new Dimension(40, 40));
            downvoteButton = new JButton(scaleImage(dislikeImage, 30, 30));
            downvoteButton.setPreferredSize(new Dimension(40, 40));
            upvoteButton.addActionListener(e -> friendsPost.addUpvote());
            downvoteButton.addActionListener(e -> friendsPost.addDownvote());

            String postText = friendsPosts[i];

            // Display the likes.
            JLabel numLikes = new JLabel();
            int likes = friendsPost.getUpvotes();
            numLikes.setText(Integer.toString(likes));
            numLikes.setPreferredSize(new Dimension(20, 20));

            JLabel numDislikes = new JLabel();
            int dislikes = friendsPost.getDownvotes();
            numDislikes.setText(Integer.toString(dislikes));
            numDislikes.setPreferredSize(new Dimension(20, 20));

            friendsFeedPanel.add(upvoteButton, label);
            friendsFeedPanel.add(downvoteButton, label);
            friendsFeedPanel.add(numLikes, label);
            friendsFeedPanel.add(numDislikes, label);
            viewCommentsButton = new JButton("COMMENTS");
            viewCommentsButton.addActionListener(e -> viewFriendsCommentsPage(friendsID, postText, "text"));
            friendsFeedPanel.add(viewCommentsButton, label);

        }

        scrollPane = new JScrollPane(friendsFeedPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        friendInfoPanel.add(friendUserNameDisplay);
        friendInfoPanel.add(friendBioDisplay);

        JButton backFriendProfile = new JButton("HOME");
        friendMakePostPanel.add(backFriendProfile);
        backFriendProfile.addActionListener(e -> friendsToHome());
        backFriendProfile.setFont(new Font("Consolas", Font.BOLD, 14));
        backFriendProfile.setBackground(new Color(0xFF5757));
        backFriendProfile.setForeground(Color.black);
        backFriendProfile.setPreferredSize(new Dimension(100, 50));

        this.add(friendInfoPanel, BorderLayout.NORTH);
        this.add(friendMakePostPanel, BorderLayout.WEST);
        this.add(friends2Panel, BorderLayout.EAST);
        this.add(scrollPane, BorderLayout.CENTER);
        // either allow back or friend of friends.
    }

    public void friendsToHome() {
        friendInfoPanel.setVisible(false);
        friendMakePostPanel.setVisible(false);
        friends2Panel.setVisible(false);
        scrollPane.setVisible(false);
        homepageWindow();
    }

    public void viewCommentsPage(int userID, String commentContent, String text) {
        this.setLayout(new BorderLayout());
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        feedPanel.setVisible(false);
        scrollPane.setVisible(false);

        // Title of the page, top panel.
        topCommentsPage = new JPanel();
        JLabel commentsTitle = new JLabel("COMMENTS");
        commentsTitle.setPreferredSize(new Dimension(200, 50));
        commentsTitle.setFont(new Font("Consolas", Font.BOLD, 25));
        topCommentsPage.setBackground(new Color(0xB6FFED));

        topCommentsPage.add((commentsTitle));

        // Show the actual comments.
        commentsPanel = new JPanel();
        commentsPanel.setLayout(new FlowLayout());
        commentsPanel.setBackground(new Color(0xB6FFED));
        blackline = BorderFactory.createLineBorder(Color.black);

        Post post = new Post(userID, commentContent, "text");
        comments = new String[post.getNumberOfComments()];
        comments = post.getComments(user.getUserID());
        // Display each comment and who wrote the comment.

        for (int j = 0; j < comments.length; j++) {

            // Create a comment object to get userProfile info.

            // Get the commentUserID for this post.
            int commentUserID = 0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                Statement statement = con.createStatement();
                statement.executeUpdate("USE CS3560");
                // ResultSet rs = statement.executeQuery("SELECT comment_userID FROM comment
                // WHERE post_userID = "+ user.getUserID()+ " AND " + "comment = '" +
                // comments[j]+ "';");
                ResultSet rs = statement.executeQuery("SELECT comment_userID FROM comment WHERE post_ID = "
                        + post.getPostID() + " AND " + "comment = '" + comments[j] + "';");
                if (rs.next()) {
                    commentUserID = rs.getInt("comment_userID");

                    // Comment newComment = new Comment(post.getPostID(), comments[j]);
                    UserProfile commentUser = new UserProfile(commentUserID);

                    // Create label to show username of commentor.
                    JLabel commentUserLabel = new JLabel(commentUser.getUsername(commentUserID) + "->");
                    commentUserLabel.setFont(new Font("Consolas", Font.BOLD, 15));

                    // Create a label to display the comment itself
                    JLabel comment = new JLabel(comments[j]);
                    comment.setLayout(new FlowLayout());
                    comment.setPreferredSize(new Dimension(200, 20));
                    comment.setFont(new Font("Consolas", Font.PLAIN, 13));
                    comment.setBackground(Color.WHITE);
                    comment.setForeground(Color.BLACK);
                    comment.setOpaque(true);
                    comment.setBorder(blackline);

                    commentsPanel.add(commentUserLabel);
                    commentsPanel.add(comment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        // Panel to create and add comments.
        createCommentPanel = new JPanel();
        JLabel createCommentLabel = new JLabel("ADD COMMENT: ");
        createCommentPanel.setBackground(new Color(0xB6FFED));
        JTextField commentText = new JTextField();
        commentText.setPreferredSize(new Dimension(200, 30));

        // Back button
        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Consolas", Font.BOLD, 15));
        backButton.setBackground(new Color(0xFF5757));
        backButton.setForeground(Color.black);
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.addActionListener(e -> cancelComment());
        JButton submitButton = new JButton("SUBMIT");
        submitButton.setFont(new Font("Consolas", Font.BOLD, 15));
        submitButton.setBackground(new Color(0xFF5757));
        submitButton.setForeground(Color.black);
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.addActionListener(e -> cancelComment());

        int postID = post.getPostID();
        int postUserID = userID;
        submitButton.addActionListener(e -> submitComment(postID, postUserID, commentText.getText()));

        createCommentPanel.add(backButton);
        createCommentPanel.add(createCommentLabel);
        createCommentPanel.add(commentText);
        createCommentPanel.add(submitButton);

        this.add(topCommentsPage, BorderLayout.NORTH);
        this.add(commentsPanel, BorderLayout.CENTER);
        this.add(createCommentPanel, BorderLayout.SOUTH);

    }

    public void viewFriendsCommentsPage(int userID, String commentContent, String text) {
        this.setLayout(new BorderLayout());
        friendInfoPanel.setVisible(false);
        friendMakePostPanel.setVisible(false);
        friends2Panel.setVisible(false);
        friendsFeedPanel.setVisible(false);
        scrollPane.setVisible(false);

        // Title of the page, top panel.
        topCommentsPage = new JPanel();
        JLabel commentsTitle = new JLabel("COMMENTS");
        commentsTitle.setPreferredSize(new Dimension(200, 50));
        commentsTitle.setFont(new Font("Consolas", Font.BOLD, 25));
        topCommentsPage.setBackground(new Color(0xB6FFED));
        topCommentsPage.add((commentsTitle));

        // Show the actual comments.
        commentsPanel = new JPanel();
        commentsPanel.setLayout(new FlowLayout());
        commentsPanel.setBackground(new Color(0xB6FFED));
        blackline = BorderFactory.createLineBorder(Color.black);

        Post post = new Post(userID, commentContent, "text");
        // UserProfile friend = new UserProfile(userID);
        comments = new String[post.getNumberOfComments()];
        comments = post.getComments(userID);
        // Display each comment and who wrote the comment.

        for (int j = 0; j < comments.length; j++) {

            // Create a comment object to get userProfile info.

            // Get the commentUserID for this post.
            int commentUserID = 0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                Statement statement = con.createStatement();
                statement.executeUpdate("USE CS3560");
                // ResultSet rs = statement.executeQuery("SELECT comment_userID FROM comment
                // WHERE post_userID = "+ user.getUserID()+ " AND " + "comment = '" +
                // comments[j]+ "';");
                ResultSet rs = statement.executeQuery("SELECT comment_userID FROM comment WHERE post_ID = "
                        + post.getPostID() + " AND " + "comment = '" + comments[j] + "';");
                if (rs.next()) {
                    commentUserID = rs.getInt("comment_userID");

                    // Comment newComment = new Comment(post.getPostID(), comments[j]);
                    UserProfile commentUser = new UserProfile(commentUserID);

                    // Create label to show username of commentor.
                    JLabel commentUserLabel = new JLabel(commentUser.getUsername(commentUserID) + "->");
                    commentUserLabel.setFont(new Font("Consolas", Font.BOLD, 15));

                    // Create a label to display the comment itself
                    JLabel comment = new JLabel(comments[j]);
                    comment.setLayout(new FlowLayout());
                    comment.setPreferredSize(new Dimension(200, 20));
                    comment.setFont(new Font("Consolas", Font.BOLD, 13));
                    comment.setBackground(Color.WHITE);
                    comment.setForeground(Color.BLACK);
                    comment.setOpaque(true);
                    comment.setBorder(blackline);

                    commentsPanel.add(commentUserLabel);
                    commentsPanel.add(comment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        // Panel to create and add comments.
        createCommentPanel = new JPanel();
        JLabel createCommentLabel = new JLabel("ADD COMMENT: ");
        createCommentPanel.setBackground(new Color(0xB6FFED));
        JTextField commentText = new JTextField();
        commentText.setPreferredSize(new Dimension(200, 30));

        int postID = post.getPostID();
        int postUserID = userID;

        // Back button
        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Consolas", Font.BOLD, 15));
        backButton.setBackground(new Color(0xFF5757));
        backButton.setForeground(Color.black);
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.addActionListener(e -> cancelFriendComment(userID));

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setFont(new Font("Consolas", Font.BOLD, 15));
        submitButton.setBackground(new Color(0xFF5757));
        submitButton.setForeground(Color.black);
        submitButton.setPreferredSize(new Dimension(100, 50));
        submitButton.addActionListener(e -> submitFriendCommment(postID, postUserID, commentText.getText()));

        createCommentPanel.add(backButton);
        createCommentPanel.add(createCommentLabel);
        createCommentPanel.add(commentText);
        createCommentPanel.add(submitButton);

        this.add(topCommentsPage, BorderLayout.NORTH);
        this.add(commentsPanel, BorderLayout.CENTER);
        this.add(createCommentPanel, BorderLayout.SOUTH);

    }

    public void submitFriendCommment(int postID, int postUserID, String comment) {

        if (comment == null) {
            friendProfile(postUserID);
        } else {
            Comment newComment = new Comment(postID, postUserID, user.getUserID(), comment);
            newComment.createComment();
            topCommentsPage.setVisible(false);
            commentsPanel.setVisible(false);
            createCommentPanel.setVisible(false);
            friendProfile(postUserID);
        }
    }

    public void cancelComment() {
        topCommentsPage.setVisible(false);
        commentsPanel.setVisible(false);
        createCommentPanel.setVisible(false);
        homepageWindow();
    }

    public void cancelFriendComment(int friendsID) {
        topCommentsPage.setVisible(false);
        commentsPanel.setVisible(false);
        createCommentPanel.setVisible(false);
        friendProfile(friendsID);
    }

    public void submitComment(int postID, int postUserID, String comment) {
        Comment newComment = new Comment(postID, postUserID, user.getUserID(), comment);
        newComment.createComment();
        topCommentsPage.setVisible(false);
        commentsPanel.setVisible(false);
        createCommentPanel.setVisible(false);
        homepageWindow();
    }

    public void createPostWindow() {
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        scrollPane.setVisible(false);
        feedPanel.setVisible(false);

        // Panels for separation.
        postPromptPanel = new JPanel();
        postPromptPanel.setBackground(new Color(0xB6FFED));
        postTextPanel = new JPanel();
        postTextPanel.setBackground(new Color(0xB6FFED));
        postUploadPanel = new JPanel();
        postUploadPanel.setBackground(new Color(0xB6FFED));

        // Textbox and Label for post information.
        postTextPrompt = new JLabel("WRITE POST HERE:");
        postTextPrompt.setFont(new Font("Consolas", Font.BOLD, 25));
        postText = new JTextField();
        postText.setPreferredSize(new Dimension(400, 400));

        // Upload Post button.
        uploadPostButton = new JButton("UPLOAD");
        uploadPostButton.setFont(new Font("Consolas", Font.BOLD, 15));
        uploadPostButton.setBackground(new Color(0xFF5757));
        uploadPostButton.setForeground(Color.black);
        uploadPostButton.setPreferredSize(new Dimension(100, 50));
        uploadPostButton.addActionListener(e -> uploadPost());

        cancelUploadButton = new JButton("CANCEL");
        cancelUploadButton.setFont(new Font("Consolas", Font.BOLD, 15));
        cancelUploadButton.setBackground(new Color(0xFF5757));
        cancelUploadButton.setForeground(Color.black);
        cancelUploadButton.setPreferredSize(new Dimension(100, 50));
        cancelUploadButton.addActionListener(e -> cancelUpload());

        // Labels to prompt for post information.

        postPromptPanel.add(postTextPrompt);
        postTextPanel.add(postText);
        postUploadPanel.add(uploadPostButton);
        postUploadPanel.add(cancelUploadButton);
        this.add(postPromptPanel, BorderLayout.NORTH);
        this.add(postTextPanel, BorderLayout.CENTER);
        this.add(postUploadPanel, BorderLayout.SOUTH);

    }

    public void uploadPost() {
        String newPostText = postText.getText();
        Post newPost = new Post(user.getUserID(user.getUsername()), newPostText, "text");
        newPost.createPost(user.getUserID(user.getUsername()), newPostText, LocalTime.now());

        // Remove elements from this window.
        postPromptPanel.setVisible(false);
        postTextPanel.setVisible(false);
        postUploadPanel.setVisible(false);
        homepageWindow();
    }

    public void deletePost() {

        feedPanel.setVisible(false);
        feedPanel.remove(scrollPane);
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        scrollPane.setVisible(false);

        deletePanel = new JPanel();
        deletePanel.setBackground(new Color(0xB6FFED));

        cancelDeleteButton = new JButton("CANCEL");
        cancelDeleteButton.setFont(new Font("Consolas", Font.BOLD, 15));
        cancelDeleteButton.setBackground(new Color(0xFF5757));
        cancelDeleteButton.setForeground(Color.black);
        cancelDeleteButton.setPreferredSize(new Dimension(100, 50));
        cancelDeleteButton.addActionListener(e -> deleteToHome());

        cancelDeletePanel = new JPanel();
        cancelDeletePanel.setBackground(new Color(0xB6FFED));
        cancelDeletePanel.add(cancelDeleteButton);

        if (user.getNumberOfPosts(user.getUserID()) > 0) {
            posts = new String[user.getNumberOfPosts(user.userID)];
            posts = user.getPosts(user.getUserID());
            for (int i = 0; i < posts.length; i++) {
                feedPanel.setLayout(new GridBagLayout());

                GridBagConstraints label = new GridBagConstraints();
                label.insets = new Insets(10, 10, 10, 3);
                GridBagConstraints field = new GridBagConstraints();
                field.insets = new Insets(10, 10, 10, 3);
                field.gridwidth = GridBagConstraints.REMAINDER;

                JButton postContentButton = new JButton(posts[i]);
                JLabel postUserName = new JLabel("You->");
                postUserName.setPreferredSize(new Dimension(50, 20));
                postUserName.setFont(new Font("Consolas", Font.BOLD, 14));
                postUserName.setBackground(new Color(0x1B1464));
                postContentButton.setPreferredSize(new Dimension(300, 35));
                postContentButton.setFont(new Font("Consolas", Font.PLAIN, 20));
                postContentButton.setVerticalTextPosition(JLabel.CENTER);
                postContentButton.setBackground(new Color(0xCAC5FF));
                postContentButton.setFocusable(false);
                postContentButton.setOpaque(true);
                postContentButton.getPreferredSize();

                String postContent = posts[i];
                postContentButton
                        .addActionListener(e -> deleteToHome(user.getUserID(user.getUsername()), postContent, "text"));
                deletePanel.add(postContentButton, field);
                // Add user's own post to feed.

            }

        }
        this.add(deletePanel, BorderLayout.CENTER);
        this.add(cancelDeletePanel, BorderLayout.SOUTH);

    }

    public void deleteToHome(int userID, String post, String type) {
        // Create new post object.
        Post postToDelete = new Post(userID, post, type);
        postToDelete.deletePost();
        deletePanel.setVisible(false);
        cancelDeletePanel.setVisible(false);
        homepageWindow();
    }

    public void deleteToHome() {
        deletePanel.setVisible(false);
        cancelDeletePanel.setVisible(false);
        homepageWindow();
    }

    public void cancelUpload() {
        postPromptPanel.setVisible(false);
        postTextPanel.setVisible(false);
        postUploadPanel.setVisible(false);
        homepageWindow();
    }

    public void cancelDelete() {
        deletePanel.setVisible(false);
        cancelDeletePanel.setVisible(false);
        homepageWindow();
    }

    public void editPostWindow() {

        feedPanel.setVisible(false);
        feedPanel.remove(scrollPane);
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        scrollPane.setVisible(false);

        editPanel = new JPanel();
        editPanel.setBackground(new Color(0xB6FFED));

        if(user.getNumberOfPosts(user.getUserID())>0)
        {
            posts = new String[user.getNumberOfPosts(user.userID)];
            posts = user.getPosts(user.getUserID());
            for (int i = 0; i < posts.length; i++) {
                feedPanel.setLayout(new GridBagLayout());

                GridBagConstraints label = new GridBagConstraints();
                label.insets = new Insets(10, 10, 10, 3);
                GridBagConstraints field = new GridBagConstraints();
                field.insets = new Insets(10, 10, 10, 3);
                field.gridwidth = GridBagConstraints.REMAINDER;

                JButton postContentButton = new JButton(posts[i]);
                JLabel postUserName = new JLabel("You->");
                postUserName.setPreferredSize(new Dimension(50, 20));
                postUserName.setFont(new Font("Consolas", Font.BOLD, 14));
                postUserName.setBackground(new Color(0x1B1464));
                postContentButton.setPreferredSize(new Dimension(300, 35));
                postContentButton.setFont(new Font("Consolas", Font.PLAIN, 20));
                postContentButton.setVerticalTextPosition(JLabel.CENTER);
                postContentButton.setBackground(new Color(0xCAC5FF));
                postContentButton.setFocusable(false);
                postContentButton.setOpaque(true);
                postContentButton.getPreferredSize();

                String postContent = posts[i];

                postContentButton
                        .addActionListener(e -> getCaption(postContent));

                // Add user's own post to feed.
                this.add(editPanel, BorderLayout.CENTER);
                editPanel.add(postContentButton, field);
            }
        }
        else{
            homepageWindow();
        }
    }

    public void getCaption(String postContent) {
        editPanel.setVisible(false);

        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0xB6FFED));
        textPanel = new JPanel();
        textPanel.setBackground(new Color(0xB6FFED));
        submitTextPanel = new JPanel();
        submitTextPanel.setBackground(new Color(0xB6FFED));

        JLabel textPrompt = new JLabel("ENTER NEW TEXT:");
        textPrompt.setPreferredSize(new Dimension(415, 50));
        textPrompt.setFont(new Font("Consolas", Font.BOLD, 25));
        textField = new JTextField();
        textField.setText(postContent);
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setPreferredSize(new Dimension(400, 30));

        Post post = new Post(user.getUserID(), postContent, "text");
        int postID = post.getPostID();

        JButton submitNewCaption = new JButton("EDIT");
        submitNewCaption.addActionListener(e -> changeText(user.getUserID(), postContent, "text", postID));
        submitNewCaption.setFont(new Font("Consolas", Font.BOLD, 15));
        submitNewCaption.setBackground(new Color(0xFF5757));
        submitNewCaption.setForeground(Color.black);
        submitNewCaption.setPreferredSize(new Dimension(100, 50));

        submitTextPanel.add(submitNewCaption);
        JButton cancelNewCaption = new JButton("CANCEL");
        cancelNewCaption.setFont(new Font("Consolas", Font.BOLD, 15));
        cancelNewCaption.setBackground(new Color(0xFF5757));
        cancelNewCaption.setForeground(Color.black);
        cancelNewCaption.setPreferredSize(new Dimension(100, 50));
        cancelNewCaption.addActionListener(e -> cancelEdit());
        submitTextPanel.add(cancelNewCaption);
        

        titlePanel.add(textPrompt);
        textPanel.add(textField);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(textPanel, BorderLayout.CENTER);
        this.add(submitTextPanel, BorderLayout.SOUTH);

        // .addActionListener(e -> changeText(user.getUserID(), postContent, "text"));

    }

    public void cancelEdit() {
        titlePanel.setVisible(false);
        textPanel.setVisible(false);
        submitTextPanel.setVisible(false);
        homepageWindow();
    }

    public void changeText(int userID, String caption, String type, int postID) {
        Post post = new Post(userID, postID);
        String text = textField.getText();
        post.setCaption(text);
        titlePanel.setVisible(false);
        textPanel.setVisible(false);
        submitTextPanel.setVisible(false);
        homepageWindow();

    }

    public void logOut() {
        scrollPane.setVisible(false);
        userInfoPanel.setVisible(false);
        makePostPanel.setVisible(false);
        friendsPanel.setVisible(false);
        feedPanel.setVisible(false);
        welcomeWindow();
    }

    public ImageIcon scaleImage(ImageIcon icon, int l, int w) {
        Image image = icon.getImage(); // transform it
        Image newimg = image.getScaledInstance(l, w, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        icon = new ImageIcon(newimg); // transform it back
        return icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}