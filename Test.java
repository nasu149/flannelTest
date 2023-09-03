package flannelTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args){
        try {
            String url = "jdbc:postgresql://192.168.56.104:5432/postgres";
            String username = "postgres";
            String password = "postgres";
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement stmt = conn.createStatement();
            String sql = "select * from test";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
