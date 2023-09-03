package flannelTest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Exec {
    public static void main(String[] args){
        System.out.print(getIP());
    }

    public static int getNodeNumer(){
        String phyIP = getIP();
        String[] splitIP = phyIP.split(".");
        String nodeNumber = splitIP[splitIP.length-1];
        int result = Integer.parseInt(nodeNumber);
        return result;
    }

    public static String getSubnet(){
        int nodeNumer = getNodeNumer();
        String result = "10.0.";
        result += nodeNumer;
        result += ".0/24";
        return result;
    }
    
    public static String getIP(){

        try {
            //
            Enumeration<?> testMIP = NetworkInterface.getNetworkInterfaces();

            //
            if (null != testMIP) {

                //
                while (testMIP.hasMoreElements()) {

                    //
                    NetworkInterface testNI = (NetworkInterface) testMIP.nextElement();

                    String nic = "VirtualBox Host-Only Ethernet Adapter";
                    //String nic = "enp0s8";
                    if (testNI.getDisplayName().equals(nic)){
                    //if(true){
                        //
                        System.out.println("net IF is " + testNI.getDisplayName() + " ");

                        //
                        Enumeration<?> testInA = testNI.getInetAddresses();
                        //while (testInA.hasMoreElements()) {
                            InetAddress testIP = (InetAddress)testInA.nextElement();
                            System.out.println(testIP);
                        //}
                        return testIP.toString().substring(1);
                    }

                }
            } else {
                System.out.println("IF not ");
            }

        } catch (SocketException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return null;
    }
}
