import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Post {

    // Class fields.
    private int postID;
    private int userID;
    private String typeOfContent;
    private LocalTime timeStamp;
    private LocalDate postDate;
    private int upvotes;
    private int downvotes;
    private String text; 
    String contentType;
    String caption;

    UserProfile user;

    static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root/CS3560";
    static final String USER = "root";
    static final String PASS = "jesspinto@24";
    String query;

    ResultSet rs;
    Connection con;
    Statement st;

    // Constructor.
    public Post(int userID, String caption, String type) {
        this.userID = userID;
        this.caption = caption; 
        typeOfContent = type;
        timeStamp = LocalTime.now();
        postDate = LocalDate.now();
        upvotes = 0;
        downvotes = 0;

    }

    public Post(int userID, int postID){
        this.userID = userID;
        this.postID = postID;
    }
    // num of upvotes and downvotes starts at 0


    public void createPost(int userID, String caption, LocalTime timeStamp){
        query = "INSERT INTO post(user_ID, contentType, caption, timeStamp, upvotes, downvotes) VALUES ("+ userID + ", 'text', '" + caption + "', '" + timeStamp + "', 0, 0);";
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
    // Class methods.
    public void setPostID(int id) {
        postID = id;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root/CS3560", "root", "dawley1407");
            st = con.createStatement();
            st.executeUpdate("USE CS3560;");
            st.executeUpdate("USE post;");
            rs = st.executeQuery("SELECT post_ID FROM post]");
            // UPDATE post SET post_ID = ? WHERE user_ID = ?";
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getPostID() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT post_ID FROM post WHERE user_ID = " + this.userID + " AND caption = '" + this.caption + "';");
            if (rs.next())
            {
                postID = rs.getInt("post_ID");
                return postID;   
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setUserID(int id) {
        userID = id;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root/CS3560", "root", "dawley1407");
            st = con.createStatement();
            st.executeUpdate("USE CS3560;");
            st.executeUpdate("USE post;");
            rs = st.executeQuery("SELECT user_ID FROM post]");
            // UPDATE post SET post_ID = ? WHERE user_ID = ?";
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println(e);
        }
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
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT post_ID FROM post WHERE caption = '" + text + "';");
            rs.next();
            userID = rs.getInt("user_ID");
            // return userID;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userID;
    }

    public void setContentType(String type) {
        typeOfContent = type;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            statement.executeUpdate(
                    "UPDATE post SET contentType = '" + type + "'" + "WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getContentType() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("SELECT contentType FROM post  WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
            rs.next();
            contentType = rs.getString("contentType");
            return contentType;
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public void setTimeStamp() {
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
                    "UPDATE post SET timeStamp = '" + this.timeStamp + "'" + "WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LocalTime getTimeStamp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560");
            ResultSet rs = statement.executeQuery("Select timeStamp FROM post WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
            rs.next();
            String stringTimeStamp = rs.getString("timeStamp");

            // convert string to LocalTime
            LocalTime localTime = LocalTime.parse(stringTimeStamp);
            
            return localTime;



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LocalTime.now();
    }

    public void setPostDate(LocalDate newPostDate){
        postDate = newPostDate;
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
            statement.executeUpdate("UPDATE post SET  = '" + newPostDate.toString()  + "'" + "WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LocalDate getPostDate() {

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
            ResultSet rs = statement.executeQuery("SELECT postDate FROM post WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
            rs.next();
            String stringPostDate = rs.getString("postDate");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(stringPostDate, formatter);
            return localDate;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return LocalDate.now();
    }


    public void addUpvote() {
        upvotes++;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            statement.executeUpdate("UPDATE post SET upvotes= upvotes + 1  WHERE post_ID =" + "'" + postID + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getUpvotes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT upvotes FROM post  WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
            rs.next();
            upvotes = rs.getInt("upvotes");
            return upvotes;
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addDownvote() {
        downvotes++;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            statement.executeUpdate("UPDATE post SET downvotes = downvotes + 1  WHERE post_ID =" + this.postID + " AND user_ID = " + this.userID + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getDownvotes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT downvotes FROM post  WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
            rs.next();
            downvotes = rs.getInt("downvotes");
            return downvotes;
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setCaption(String newCaption){
        caption = newCaption;
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
            statement.executeUpdate("UPDATE post SET caption = '" + newCaption  + "'" + " WHERE post_ID = " + this.postID + " AND user_ID = " + this.userID + ";");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getCaption(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT caption FROM post WHERE user_ID = '" + userID + "' AND post_ID = '" + this.getPostID() + "'");
            rs.next();
            text = rs.getString("caption");
            return text;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return " ";
    }


    public void loadPostTable() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root/CS3560", "root", "dawley1407");
            st = con.createStatement();
            st.executeUpdate("USE CS3560;");
            st.executeUpdate("USE post;");
            rs = st.executeQuery("SELECT userName FROM profile");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 

    public String[] getPosts(int userID){
        ArrayList<String> postList = new ArrayList<>();
        Object[] arr;
        String[] result;
        String[] sample = {"NULL"};
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            ResultSet rs = statement.executeQuery("SELECT caption FROM post WHERE user_ID = '" + userID + "';");
            while(rs.next()){
                postList.add(rs.getString("caption"));
            }
            arr = postList.toArray();
            result = new String[arr.length];
            for (int i =0; i < arr.length;i++ )
            {
                result[i] = arr[i].toString();
            }
            return result;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return sample;
        // convert the list to an array and return it
    }

    public void deletePost(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = con.createStatement();
            statement.executeUpdate("USE CS3560;");
            if (this.getNumberOfComments() > 0)
                statement.executeUpdate("DELETE FROM comment WHERE post_ID= "+ this.getPostID()+ ";");
            statement.executeUpdate("DELETE FROM post WHERE post_ID =" + this.getPostID() + ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String[] getComments(int userID){
        ArrayList<String> commentList = new ArrayList<>();
        Object[] arr;
        String[] result;
        String[] sample = {"NULL"};
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
            ResultSet rs = statement.executeQuery("SELECT * from comment WHERE post_userID = " + userID + ";");
            while(rs.next()){
                commentList.add(rs.getString("comment"));
            }
            arr = commentList.toArray();
            result = new String[arr.length];
            for (int i =0; i < arr.length;i++ )
            {
                result[i] = arr[i].toString();
            }
            return result;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        // convert the list to an array and return it
        return sample;
    }

    public int getNumberOfComments(){
        ArrayList<String> commentList = new ArrayList<>();
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
            ResultSet rs = statement.executeQuery("SELECT * from comment WHERE post_userID = " + this.userID + ";");
            while(rs.next()){
                commentList.add(rs.getString("comment"));
                //System.out.println(rs.getString("comment"));
            }
            return commentList.size(); 
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        // convert the list to an array and return it
        return -1;
    }


}