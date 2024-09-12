import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CS3560", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select userName from profile");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
