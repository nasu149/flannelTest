package flannelTest;
public class Node {
    String node_name;
    String phy_ip;
    String subnet;
    Integer pod_num;

    public String getNode_name() {
        return node_name;
    }
    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }
    public String getPhy_ip() {
        return phy_ip;
    }
    public void setPhy_ip(String phy_ip) {
        this.phy_ip = phy_ip;
    }
    public String getSubnet() {
        return subnet;
    }
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }
    public Integer getPod_num() {
        return pod_num;
    }
    public void setPod_num(Integer pod_num) {
        this.pod_num = pod_num;
    }


}
