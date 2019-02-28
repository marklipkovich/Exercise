import java.util.HashMap;

public class lengthOfLongestSubstring {

    private int lengthOf(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int max = 0;
        int endPrev = 0;
        int endNew;
        for (int i = 0; i < s.length(); i++) {
            if (hmap.containsKey(s.charAt(i))) {
                endNew = hmap.get(s.charAt(i)) ;
                max = Math.max (max, hmap.size());
                hmap.put(s.charAt(i), i);
                for (int j = endPrev; j < endNew ; j++) {
                    if  (hmap.containsKey(s.charAt(j)) && (hmap.get(s.charAt(j)) < endNew ))
                            hmap.remove(s.charAt(j));
                }
                endPrev = endNew;
            }
            else hmap.put(s.charAt(i), i);
        }
    return Math.max (max, hmap.size());
    }

    private int lengthOf1(String s) {
        if (s.length() == 0) return 0;
        int j = 0;
        int ind;
        int maxTemp = 1;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            ind = s.substring(j, i).indexOf(s.charAt(i));
            if (ind == -1) maxTemp = maxTemp +1;
            else {
                j = j + ind +1;
                max = Math.max (max, maxTemp);
                maxTemp = i -j + 1;
            }
        }
        return Math.max (max, maxTemp);
    }

    public int lengthOf2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String arg[]) {

        lengthOfLongestSubstring obj = new lengthOfLongestSubstring();
        System.out.println(obj.lengthOf2("abcab"));
    }
}
