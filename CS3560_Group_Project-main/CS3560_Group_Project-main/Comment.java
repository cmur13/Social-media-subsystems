import java.sql.*;
import java.util.ArrayList;

public class Comment {
    int commentID;
    int commentUserID;
    int postUserID;
    int postID;
    String comment;

    static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root/CS3560";
    static final String USER = "root";
    static final String PASS = "jesspinto@24";
    String query;

    Post post;

    public Comment(int post_ID, String comment) {
        this.postID = post_ID;
        this.comment = comment;
    }

    public Comment(int post_ID, int postUserID, int commentUserID, String comment) {
        this.postID = post_ID;
        this.comment = comment;
        this.postUserID = postUserID;
        this.commentUserID = commentUserID;
    }

    public void createComment(){
        query = "INSERT INTO comment (post_ID, comment_UserID, post_UserID, comment) VALUES (" + this.postID+ "," + this.commentUserID + "," + this.postUserID + ",'" + this.comment + "');";
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
            statement.executeUpdate(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getComments(){
        ArrayList<String> commentsList = new ArrayList<>();
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
            ResultSet rs = statement.executeQuery("SELECT comment FROM comment WHERE post_ID = '" + this.postID + "';");
            while(rs.next()){
                commentsList.add(rs.getString("comment"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        // convert the list to an array and return it
        return commentsList.toArray(new String[0]);
    }

    // Method to edit an existing comment
    public void editComment(int commentID, String newComment) {
        query = "UPDATE comment SET comment = '" + newComment + "' WHERE comment_ID = " + this.commentID;
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a comment
    public void deleteComment(int commentID) {
        String query = "DELETE FROM comment WHERE comment_ID = " + commentID;
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void setCommentID(int newcommentID) {
        this.commentID = newcommentID;
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
            statement.executeUpdate("UPDATE comment SET comment_ID = " + newcommentID  + " WHERE post_userID =" + + postUserID + " AND comment_userID" + this.commentUserID + ";");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getter method for comment_ID
    public int getCommentID(int commentUserID, int postUserID) {
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
            ResultSet rs = statement.executeQuery("SELECT comment_ID FROM comment WHERE comment_userID = '" + commentUserID+ " AND post_userID = " + postUserID + " AND comment = '" + this.comment + "';");
            rs.next();
            commentID = rs.getInt("comment_ID");
            return commentID;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;
    }
    //setter method for comment_UserID
    public void setCommentUserID(int newcommentUserID) {
        this.commentUserID = newcommentUserID;
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
            statement.executeUpdate("UPDATE comment SET comment_userID = " + commentUserID  + " WHERE post_userID =" +  postUserID + ";");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Getter method for comment_UserID
    public int getCommentUserID() {
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
            ResultSet rs = statement.executeQuery("SELECT comment_userID FROM comment WHERE comment_ID = "  + this.getCommentID(this.commentUserID, this.postUserID)+ ";");
            rs.next();
            commentUserID = rs.getInt("comment_userID");
            return commentUserID;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0;
    }

    // setter method for post_UserID
    public void setPostUserID(int postUserID) {
        this.postUserID = postUserID;
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
            statement.executeUpdate("UPDATE comment SET post_userID = '" + postUserID  + "'" + "WHERE comment =" + "'" + comment + "'");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Getter method for post_UserID
    public int getPostUserID() {
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
            ResultSet rs = statement.executeQuery("SELECT post_userID FROM comment WHERE comment = '" + comment + "';");
            rs.next();
            postUserID = rs.getInt("user_ID");
            return postUserID;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return 0; 
    }
    
}