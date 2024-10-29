package string.medium;

import java.util.ArrayList;

public class ValidIPAddress {
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> validIpAddresses = new ArrayList<String>();

        if (string.length() < 4 || string.length() > 12) {
            return validIpAddresses;
        }

        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] ipAddressParts = new String[]{"", "", "", ""};

            ipAddressParts[0] = string.substring(0, i);
            if (!isValidIpNumber(ipAddressParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                ipAddressParts[1] = string.substring(i, j);
                if (!isValidIpNumber(ipAddressParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    ipAddressParts[2] = string.substring(j, k);
                    ipAddressParts[3] = string.substring(k, string.length());

                    if (isValidIpNumber(ipAddressParts[2]) && isValidIpNumber(ipAddressParts[3])) {
                        validIpAddresses.add(joinIpParts(ipAddressParts));
                    }
                }
            }
        }

        return validIpAddresses;
    }

    public Boolean isValidIpNumber(String str) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(str) <= 255 && Integer.parseInt(str) >= 0;
    }

    public String joinIpParts(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            if (i < strings.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
