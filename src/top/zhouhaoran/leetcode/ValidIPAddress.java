package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.regex.Pattern;


public class ValidIPAddress {
    public static void main(String[] args) {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        String IP = "1.0.1.";
        System.out.println(validIPAddress.validIPAddress3(IP));
    }

    public String validIPAddress(String IP) {
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern patternIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

        if (IP.contains(".")) {
            return patternIPv4.matcher(IP).matches() ? "IPv4" : "Neither";
        } else if (IP.contains(":")) {
            return patternIPv6.matcher(IP).matches() ? "IPv6" : "Neither";
        }

        return "Neither";
    }

    public String validIPAddress2(String IP) {
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        Pattern patternIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
        Pattern patternIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){2,7}" + chunkIPv6 + "$");

        if (IP.contains(".")) {
            return patternIPv4.matcher(IP).matches() ? "IPv4" : "Neither";
        } else if (IP.contains(":")) {
            return patternIPv6.matcher(IP).matches() ? "IPv6" : "Neither";
        }

        return "Neither";
    }

    public String validIPAddress3(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validIPv4Address(IP) ? "IPv4" : "Neither";
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validIPv6Address(IP) ? "IPv6" : "Neither";
        }

        return "Neither";
    }

    private boolean validIPv4Address(String IP) {
        String[] ipArray = IP.split("\\.", -1);

        for (String ipChunk : ipArray) {
            if (ipChunk.length() == 0 || ipChunk.length() > 3) {
                return false;
            }
            if (ipChunk.charAt(0) == '0' && ipChunk.length() > 1) {
                return false;
            }

            for (char c : ipChunk.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }

            if (Integer.parseInt(ipChunk) > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPv6Address(String IP) {
        String[] ipArray = IP.split("\\:", -1);
        String indices = "0123456789abcdefABCDEF";

        for (String ipChunk : ipArray) {
            if (ipChunk.length() == 0 || ipChunk.length() > 4) {
                return false;
            }

            for (char c : ipChunk.toCharArray()) {
                if (indices.indexOf(c) == -1) {
                    return false;
                }
            }
        }

        return true;
    }

}
