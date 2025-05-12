public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) 
            return "";
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd-length palindrome (center at i)
            int len1 = expandAroundCenter(s, i, i);
            // even-length palindrome (center between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > end - start + 1) {
                // update window [start..end]
                start = i - (len - 1) / 2;
                end   = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // returns length of palindrome by expanding as far as possible
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // right and left are now one step beyond the palindrome
        return right - left - 1;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("babad")); // “bab” or “aba”
        System.out.println(sol.longestPalindrome("cbbd"));  // “bb”
    }
}
