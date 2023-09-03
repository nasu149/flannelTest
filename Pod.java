package flannelTest;
public class Pod {
    String pod_name;
    String node_name;
    Integer pod_num_in_node;
    String im_ip;
    String im_mac;

    public String getPod_name() {
        return pod_name;
    }
    public void setPod_name(String pod_name) {
        this.pod_name = pod_name;
    }
    public String getNode_name() {
        return node_name;
    }
    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }
    public Integer getPod_num_in_node() {
        return pod_num_in_node;
    }
    public void setPod_num_in_node(Integer pod_num_in_node) {
        this.pod_num_in_node = pod_num_in_node;
    }
    public String getIm_ip() {
        return im_ip;
    }
    public void setIm_ip(String im_ip) {
        this.im_ip = im_ip;
    }
    public String getIm_mac() {
        return im_mac;
    }
    public void setIm_mac(String im_mac) {
        this.im_mac = im_mac;
    }


}
