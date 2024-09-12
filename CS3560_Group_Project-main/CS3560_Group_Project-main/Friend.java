import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

public class Friend {
    // Class Fields.
    public int user1_id; // ID of original user itself.
    public int user2_id; // ID of user's new potential friend.
    public LocalDate requestDate;
    public LocalDate acceptanceDate;
    public LocalDate friendshipEndDate;

    // SQL variables. These will change for each team member.
    static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root/CS3650";
    static final String USER = "root";
    static final String PASS = "jesspinto@24";

    // Constructors.
    public Friend(int user1_id, int user2_id) {
        this.user1_id = user1_id;
        this.user2_id = user2_id;
        
    }

    public void befriend(int id1, int id2){
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
            
            // add friends
            statement.executeUpdate("INSERT INTO friendship (user_ID1, user_ID2) VALUES (" + id1 + ", " + id2 + ")");
            statement.executeUpdate("INSERT INTO friendship (user_ID2, user_ID1) VALUES (" + id2 + ", " + id1 + ")");
            // acceptance date upon success
            acceptanceDate = LocalDate.now();
            statement.executeUpdate("INSERT INTO friendship (acceptanceDate) VALUES (" + acceptanceDate + ")");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getFriend(){
        // gets user2_id from instance of user1_id which is the current user
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
            ResultSet rs = statement.executeQuery("SELECT user2_ID FROM frienship WHERE user1_ID = '" + user1_id + "';");
            rs.next();
            user2_id = rs.getInt("user2_ID");
            return user2_id;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;
    }

    // Class Methods.
    /*
    public void sendFriendRequest(int user1_id, int user2_id) {
        // send request to friend
        // request date
        requestDate = LocalDate.now();
    }*/

    /*
    public void acceptFriendRequest() {
        // add friend to list for both

        // acceptance date
        acceptanceDate = LocalDate.now();
    }*/

    /*
    public void denyFriendRequest() {
        //
    }*/

    public void removeFriend(int id1, int id2) {
        // remove from list of friends for both
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
            
            // remove friend
            statement.executeUpdate("DELETE FROM friendship WHERE (user1_ID = " + id1 + " AND user2_ID = " + id2 + ") AND (user1_ID = " + id2 + " AND user2_ID = " + id1 + ")");
            // friendship end
            friendshipEndDate = LocalDate.now();
            statement.executeUpdate("INSERT INTO friendship (friendshipEndDate) VALUES (" + friendshipEndDate + ")");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
