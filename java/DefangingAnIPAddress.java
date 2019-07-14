/*
    1108. Defanging an IP Address
    Given a valid (IPv4) IP address, return a defanged version of that IP address.
    A defanged IP address replaces every period "." with "[.]".
    Example 1:
        Input: address = "1.1.1.1"
        Output: "1[.]1[.]1[.]1"
    Example 2:
        Input: address = "255.100.50.0"
        Output: "255[.]100[.]50[.]0"
    Constraints:
        The given address is a valid IPv4 address.
*/

public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder defangedIp = new StringBuilder(address.length() + 6);
        String[] ipv4 = address.split("\\.");
        return defangedIp.append(ipv4[0]).append("[.]").append(ipv4[1]).append("[.]").append(ipv4[2]).append("[.]")
                .append(ipv4[3]).toString();
    }

    public String defangIPaddr2(String address) {
        StringBuilder defangedIp = new StringBuilder(address.length() + 6);
        for (char c : address.toCharArray()) {
            if (c == '.') {
                defangedIp.append("[.]");
            } else {
                defangedIp.append(c);
            }
        }
        return defangedIp.toString();
    }

    public String defangIPaddr3(String address) {
        char[] defangedIp = new char[address.length() + 6];
        int i = 0;
        for (char c : address.toCharArray()) {
            if (c == '.') {
                defangedIp[i++] = '[';
                defangedIp[i++] = '.';
                defangedIp[i++] = ']';
            } else {
                defangedIp[i++] = c;
            }
        }
        return String.valueOf(defangedIp);
    }
}
