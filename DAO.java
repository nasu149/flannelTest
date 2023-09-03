package flannelTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    Connection conn = null;

    public void connect() throws Exception{
        String url = "jdbc:postgresql://192.168.56.104:5432/postgres";
        String username = "postgres";
        String password = "postgres";
        this.conn = DriverManager.getConnection(url, username, password);
    }

    public void addNode(Node node) throws Exception{
        String node_name = node.getNode_name();
        String phy_ip = node.getPhy_ip();
        String subnet = node.getSubnet();
        Integer pod_num = node.getPod_num();

        this.connect();
        String sql = "insert into node_table values(?, ?, ?, ?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, node_name);
        pstmt.setString(2, phy_ip);
        pstmt.setString(3, subnet);
        pstmt.setInt(4, pod_num);

        int result = pstmt.executeUpdate();
        System.out.println("addNode added " + result);
        this.conn.close();
    }

    public void addPod(Pod pod) throws Exception{
        String pod_name = pod.getPod_name();
        String node_name = pod.getNode_name();
        Integer pod_num_in_node = pod.getPod_num_in_node();
        String im_ip = pod.getIm_ip();
        String im_mac = pod.getIm_mac();
        
        this.connect();
        String sql = "insert into pod_table values(?, ?, ?, ?, ?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, pod_name);
        pstmt.setString(2, node_name);
        pstmt.setInt(3, pod_num_in_node);
        pstmt.setString(4, im_ip);
        pstmt.setString(5, im_mac);

        int result = pstmt.executeUpdate();
        System.out.println("addPod added " + result);
        this.conn.close();
    }


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
