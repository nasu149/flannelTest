package flannelTest;
import java.util.ArrayList;

public class NodeManage {
    int nodeNumer;

    int pod_num;
    ArrayList<String> pod_names = new ArrayList<String>();
    int pod_latest_num=0;

    private static NodeManage nodeManage = new NodeManage();

    private NodeManage(){
        this.nodeNumer = Exec.getNodeNumer();
    }

    public static NodeManage getInstance(){
        return nodeManage;
    }
    public int getPod_num() {
        this.pod_num = this.pod_names.size();
        return this.pod_num;
    }

    public ArrayList<String> getPod_names() {
        return pod_names;
    }

    public String addAndGetPod_names() {
        this.pod_latest_num++;
        String podName = "pod" + (pod_latest_num);
        podName += "_node" + nodeNumer;
        pod_names.add(podName);
        return podName;
    }

    public int getPod_latest_num() {
        return pod_latest_num;
    }



}
