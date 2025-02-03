package DSA.Strings;

public class _3_Defanging_IP_Address {
    public String defangIPaddr(String address) {
        int index = 0;
        StringBuilder ans = new StringBuilder();

        while (index < address.length()) {
            if (address.charAt(index) == '.') {
                ans.append("[.]");
            } else {
                ans.append(address.charAt(index));
            }
            index++;
        }

        return ans.toString();
    }
}
