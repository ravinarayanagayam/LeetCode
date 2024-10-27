class Solution {
    public String validIPAddress(String queryIP) {

        if (queryIP.contains(".") && !queryIP.endsWith(".")) {
            String[] s = queryIP.split("\\.");
            if (s.length == 4) {
                boolean allMatch = true;
                for (String s1 : s) {
                    int a = 0;
                    try {
                        a = Integer.parseInt(s1);
                    } catch (NumberFormatException e) {
                        allMatch = false;
                        break;
                    }
                    if (!(a >= 0 && a <= 255)) {
                        allMatch = false;
                        break;
                    }
                    if (s1.startsWith("0")) {
                        if (a != 0 || s1.length() > 1) {
                            allMatch = false;
                            break;
                        }
                    }
                }
                if (allMatch)
                    return "IPv4";
            }
            return "Neither";
        } else if (queryIP.contains(":") && !queryIP.endsWith(":")) {
            String[] s = queryIP.split("\\:");
            if (s.length == 8) {
                boolean allMatch = true;
                outer: for (String s1 : s) {
                    // System.out.println(s1);
                    if (!(s1.length() >= 1 && s1.length() <= 4)) {
                        allMatch = false;
                        break;
                    }
                    for (int i = 0; i < s1.length(); i++) {
                        if (!((s1.charAt(i) >= '0' && s1.charAt(i) <= '9') ||
                                (s1.charAt(i) >= 'a' && s1.charAt(i) <= 'f') ||
                                (s1.charAt(i) >= 'A' && s1.charAt(i) <= 'F'))) {
                            allMatch = false;
                            break outer;
                        }
                    }
                }
                if (allMatch)
                    return "IPv6";
            }

        }
        return "Neither";
    }
}