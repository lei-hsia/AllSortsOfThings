package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lei
 * @date 04/28/2022 2:54 PM
 */
public class AllOne {

    private Map<String, Integer> key2freq;
    private Map<Integer, Set<String>> freq2keys;
    private int max, min;

    public AllOne() {
        key2freq = new HashMap<>();
        freq2keys = new HashMap<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    public void inc(String key) {
        int freq = key2freq.get(key) == null ? 0 : key2freq.get(key);
        if (freq2keys.get(freq) != null) {
            freq2keys.get(freq).remove(key);
        }
        if (min == freq && freq2keys.get(min).isEmpty()) {
            min = Integer.MAX_VALUE;
        }

        key2freq.put(key, key2freq.getOrDefault(key, 0) + 1);

        int newFreq = key2freq.get(key);
        max = Math.max(max, newFreq);
        min = Math.min(min, newFreq);

        if (freq2keys.get(newFreq) == null) {
            freq2keys.put(newFreq, new HashSet<>());
        }
        freq2keys.get(newFreq).add(key);
    }

    public void dec(String key) {
        int freq = key2freq.get(key) == null ? 0 : key2freq.get(key);
        if (freq2keys.get(freq) != null) {
            freq2keys.get(freq).remove(key);
        }
        if (max == freq && freq2keys.get(max).isEmpty()) {
            max = Integer.MIN_VALUE;
        }

        key2freq.put(key, key2freq.get(key) - 1);
        if (key2freq.get(key) == 0) {
            key2freq.remove(key);
        }

        int newFreq = key2freq.getOrDefault(key, 0);
        max = Math.max(max, newFreq);
        min = Math.min(min, newFreq);

        if (newFreq != 0) {
            if (freq2keys.get(newFreq) == null) {
                freq2keys.put(newFreq, new HashSet<>());
            }
            freq2keys.get(newFreq).add(key);
        }
    }

    public String getMaxKey() {
        if (freq2keys.keySet().isEmpty())
            return "";

        Set<String> s = freq2keys.get(max);
        if (s == null || s.isEmpty())
            return "";

        return s.iterator().next();
    }

    public String getMinKey() {
        if (freq2keys.keySet().isEmpty())
            return "";

        Set<String> s = freq2keys.get(min);
        if (s == null || s.isEmpty())
            return "";

        return s.iterator().next();
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("a");
        obj.inc("b");obj.inc("b");obj.inc("b");obj.inc("b");obj.inc("b");
        obj.dec("b");obj.dec("b");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */