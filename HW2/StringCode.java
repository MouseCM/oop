import java.util.HashSet;

public class StringCode {
    public static String blowup(String s) {
        String result = "";
        String prev = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(prev != "") {
                int num = Integer.parseInt(prev);
                for(int j = 0; j < num; j++) {
                    result += c;
                }
            }

            if (c >= '0' && c <= '9') {
                prev = "";
                prev += c;
            } else {
                result += c;
                prev = "";
            }
        }

        return result;
    }

    public static int maxRun(String str) {
        if (str == null || str.isEmpty()) return 0;

        int max = 1;
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }

        return max;
    }

    public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len <= 0) return false;
        if (len > a.length() || len > b.length()) return false;

        HashSet<String> substrings = new HashSet<>();

        for (int i = 0; i <= a.length() - len; i++) {
            substrings.add(a.substring(i, i + len));
        }

        for (int i = 0; i <= b.length() - len; i++) {
            if (substrings.contains(b.substring(i, i + len))) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(blowup("12x"));
        System.out.println(maxRun("aacccccv"));
        System.out.println(stringIntersect("aabbbbbb", "bbb", 3));
    }

}
