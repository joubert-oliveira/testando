package br.com.digitalschool.so.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Machine {
    private long id;
    private System system;
    private List<Disk> disks = new ArrayList<>();
    private List<MemoryStatus> memoryStatuses = new ArrayList();
    private Cpu cpu;

    public static String getIpAddress() throws SocketException {
        List<String> ipAddresses = new ArrayList<>();
        Pattern pattern = Pattern.compile("(192.168.0.)(\\d)");

        try {
            NetworkInterface.networkInterfaces().forEach(networkInterface -> {
                networkInterface.inetAddresses().forEach(inetAddress -> {
                    if (inetAddress.getHostAddress().matches(pattern.pattern())) {
                        ipAddresses.add(inetAddress.getHostAddress());
                    }
                });
            });
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return ipAddresses.get(0);
    }

    public static String getMacAdress() {
        try {
            InetAddress localIP = InetAddress.getByName(getIpAddress());
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localIP);
            byte[] hardwareAdress = networkInterface.getHardwareAddress();
            String[] hexadecimal = new String[hardwareAdress.length];

            for (int i = 0; i < hardwareAdress.length; i++) {
                hexadecimal[i] = String.format("%02X", hardwareAdress[i]);
            }

            String macAdress = String.join("-", hexadecimal);
            return macAdress;
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}
