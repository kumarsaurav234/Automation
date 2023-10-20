

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SysInfo {
    static String formattedMacAddress;
    static String password;

    public static void main(String[] args) {
        System.out.println(getFormattedMacAddress());
    }

    public static String getFormattedMacAddress(){
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] macAddress = networkInterface.getHardwareAddress();
                if (macAddress != null) {
                    formattedMacAddress = formatMacAddress(macAddress);
                    password=Encryption.hashSysInfo(formattedMacAddress);
//                    System.out.println(password);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return password;
    }
    private static String formatMacAddress(byte[] macAddress) {
        StringBuilder formattedMacAddress = new StringBuilder();
        for (int i = 0; i < macAddress.length; i++) {
            formattedMacAddress.append(String.format("%02X", macAddress[i]));
            if (i < macAddress.length - 1) {
            }
        }
        return formattedMacAddress.toString();
    }
}
