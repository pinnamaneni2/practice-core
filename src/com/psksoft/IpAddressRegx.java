
package com.psksoft;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IpAddressRegx {
    public static void main(String[] args) {
        String ipPattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        //String ipAddress = "192.168.1.360";

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the Ip address for validation");
        String ipAddress = scanner.nextLine();

        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ipAddress);

        if (matcher.matches()) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }
    }
}