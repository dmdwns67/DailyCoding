package leet3;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set hs = new HashSet();
        int start = 0, end = 0;
        int ans = 0;

        while( end < s.length() ) {
            if(hs.contains(s.charAt(end))) {
                hs.remove(s.charAt(start));
                start++;
            } else {
                hs.add(s.charAt(end));
                end++;
                ans = Math.max(ans, end-start);
            }
        }
        return ans;
    }
}
