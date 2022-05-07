package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lei
 * @date 03/15/2022 4:28 PM
 */
public class StringBuilderKeyDemo {
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap();

        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append((c + 26 - s.charAt(0)) % 26);
                sb.append(' ');
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList());
            }
            map.get(sb.toString()).add(s);
        }

        List<List<String>> res = new ArrayList();
        for (List<String> l : map.values()) {
            res.add(l);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] input = {"abc","bcd","acef","xyz","az","ba","a","z"};
        List<List<String>> lists = groupStrings(input);
    }
}
