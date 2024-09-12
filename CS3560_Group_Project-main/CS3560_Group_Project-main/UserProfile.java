import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.net.URL;
import java.awt.Image;
import java.sql.*;

public class UserProfile {
    // Class fields.
    int userID;
    String username;
    String password;
    String userEmail;
    String profileType;

    LocalDate DOB;
    String bio;

    // Profile picture.
    URL iconURL;
    ImageIcon profilePicture;

    static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root/CS3560";
    static final String USER = "root";
    static final String PASS = "jesspinto@24";
    String query;

    // Constructors.
    public UserProfile(String username) {
        this.username = username;
    }

    public UserProfile(int userID) {
        this.userID = userID;
    }

    public UserProfile(String username, String password, String userEmail, String profileType, LocalDate DOB,
            String bio) {
        this.username = username;
        this.userEmail = userEmail;
        this.profileType = profileType;
        this.password = password;
        this.DOB = DOB;
        this.bio = bio;
    }

    public UserProfile(String username, String password, String userEmail, LocalDate DOB, String bio) {
        this.username = username;
        this.userEmail = userEmail;
        this.password = password;
        this.DOB = DOB;
        this.bio = bio;
    }

    // Class methods.

    public void createUser() {
        query = "INSERT INTO profile(userName, password, emailAddress, profileType, dateOfBirth, profilePicture, biography) VALUES "
                + "('" + username + "'" + "," + "'" + password + "'," + "'" + userEmail + "', '" + profileType + "', '"
                + DOB.toString() + "', '" + "icon.toString()" + "', '" + bio + "');";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getUserID(String username1) {
        username = username1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("SELECT user_ID FROM profile WHERE userName = '" + username1 + "';");
            rs.next();
            userID = rs.getInt("user_ID");
            return userID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getUserID() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT user_ID FROM profile WHERE userName = '" + this.username + "';");
            rs.next();
            userID = rs.getInt("user_ID");
            return userID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
        // query = "UPDATE profile";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            statement.executeUpdate(
                    "UPDATE profile SET userName = '" + newUsername + "'" + "WHERE user_ID =" + "'" + userID + "'");
            // statement.executeUpdate("SET userName = " + "'"+ newUsername + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT userName FROM profile WHERE user_ID = " + this.getUserID(username) + ";");
            rs.next();
            username = rs.getString("userName");
            return username;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }


    public String getUsername(int userID1) {
        String username;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT userName FROM profile WHERE user_ID = " + userID1 + ";");
            rs.next();
            username = rs.getString("userName");
            return username;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public String getUsername1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT userName FROM profile WHERE user_ID = " + this.userID + ";");
            rs.next();
            username = rs.getString("userName");
            return username;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public void setUserEmail(String newUserEmail) {
        userEmail = newUserEmail;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            statement.executeUpdate("UPDATE profile SET emailAddress = '" + newUserEmail + "'" + "WHERE user_ID =" + "'"
                    + userID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserEmail() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT emailAddress FROM profile WHERE userName = '" + username + "';");
            rs.next();
            userEmail = rs.getString("emailAddress");
            return userEmail;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public void setPassword(String newPassword) {
        password = newPassword;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            statement.executeUpdate(
                    "UPDATE profile SET password = '" + newPassword + "'" + "WHERE user_ID =" + "'" + userID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getPassword() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("SELECT password FROM profile WHERE userName = '" + username + "';");
            rs.next();
            password = rs.getString("password");
            return password;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public void setDOB(LocalDate newDOB) {
        DOB = newDOB;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            statement.executeUpdate("UPDATE profile SET dateOfBirth = '" + newDOB.toString() + "'" + "WHERE user_ID ="
                    + "'" + userID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LocalDate getDOB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT dateOfBirth FROM profile WHERE userName = '" + username + "';");
            rs.next();
            String stringDOB = rs.getString("emailAddress");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            // convert String to LocalDate
            LocalDate localDate = LocalDate.parse(stringDOB, formatter);
            return localDate;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LocalDate.now();
    }

    public void setBio(String newBio) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            statement.executeUpdate(
                    "UPDATE profile SET biography = '" + newBio + "'" + "WHERE user_ID =" + "'" + userID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getBio() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("SELECT biography FROM profile WHERE user_ID = " + this.userID + ";");
            rs.next();
            bio = rs.getString("biography");
            return bio;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public void setProfilePicture(ImageIcon newProfilePicture) {
        profilePicture = newProfilePicture;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            statement.executeUpdate("UPDATE profile SET profilePicture = '" + newProfilePicture.toString() + "'"
                    + "WHERE user_ID =" + "'" + userID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getProfilePicture() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT profilePicture FROM profile WHERE userName = '" + username + "';");
            rs.next();
            userID = rs.getInt("user_ID");
            return profilePicture;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profilePicture;
    }

    public String getProfileType() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement
                    .executeQuery("SELECT profileType FROM profile WHERE user_ID = '" + this.userID + "';");
            rs.next();
            profileType = rs.getString("profileType");
            return profileType;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public void loadFromDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                    PreparedStatement pstmt = con.prepareStatement(
                            "UPDATE profile SET userName = ?, emailAddress = ?, dateOfBirth = ?, biography = ? WHERE user_ID = ?")) {

                pstmt.setString(1, this.username);
                pstmt.setString(2, this.userEmail);
                pstmt.setString(3, this.DOB.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
                pstmt.setString(4, this.bio);
                pstmt.setInt(5, this.userID);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Update successful!");
                    con.commit();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getPosts(int userID) {
        ArrayList<String> postList = new ArrayList<>();
        Object[] arr;
        String[] result;
        String[] sample = { "NULL" };
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT caption FROM post WHERE user_ID = '" + userID + "';");
            while (rs.next()) {
                postList.add(rs.getString("caption"));
            }
            arr = postList.toArray();
            result = new String[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[i].toString();
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sample;
        // convert the list to an array and return it
    }

    public int getNumberOfPosts(int userID) {
        ArrayList<String> postList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("SELECT caption FROM post WHERE user_ID = '" + userID + "';");
            while (rs.next()) {
                postList.add(rs.getString("caption"));
            }
            return postList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int[] getFriends() {
        ArrayList<Integer> friendList = new ArrayList<>();
        Object[] arr;
        int[] result;
        int[] sample = {0};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT user2_ID FROM friendship WHERE user1_ID = " + userID + ";");
            while (rs.next()) {
                friendList.add(rs.getInt("user2_ID"));
            }
            arr = friendList.toArray();
            result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[i] = Integer.parseInt(arr[i].toString());
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sample;
        // convert the list to an array and return it
    }




    public void befriend(int id2) {
        LocalDate acceptanceDate = LocalDate.now();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");

            // add friends
            statement.executeUpdate("INSERT INTO friendship (user1_ID, user2_ID, acceptanceDate) VALUES (" + this.userID + ", " + id2 + ", '" + acceptanceDate.toString() + "');");
            statement.executeUpdate("INSERT INTO friendship (user1_ID, user2_ID, acceptanceDate) VALUES (" + id2 + ", " + this.userID + ", '" + acceptanceDate.toString() + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFriend(int id2) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            // remove friend
            statement.executeUpdate("DELETE FROM friendship WHERE user1_ID = " + this.userID + " AND user2_ID = " + id2 + ";");
            statement.executeUpdate("DELETE FROM friendship WHERE user1_ID = " + id2 + " AND user2_ID = " + this.userID + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfFriends(){
        ArrayList<String> friendsList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("SELECT * from friendship WHERE user1_ID = " + this.userID + ";");
            while(rs.next()){
                friendsList.add(rs.getString("user2_ID"));
                //System.out.println(rs.getString("comment"));
            }
            return friendsList.size(); 
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        // convert the list to an array and return it
        return -1;
    }

}