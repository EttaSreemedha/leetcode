import java.util.*;

class Solution {
    int maxLen = 0;
    List<String> seen = new ArrayList<>();

    public int longestSubsequence(String s, int k) {
        backtrack(s, 0, new StringBuilder(), k);
        return maxLen;
    }

    public void backtrack(String s, int index, StringBuilder curr, int k) {
        if (index == s.length()) {
            if (curr.length() == 0) return;

            String bin = curr.toString();

            if (!seen.contains(bin)) {
                seen.add(bin);
                try {
                    long val = Long.parseLong(bin, 2); // ✅ Inbuilt binary conversion
                    if (val <= k) {
                        maxLen = Math.max(maxLen, bin.length());
                    }
                } catch (NumberFormatException e) {
                    // Skip this binary if it overflows long
                }
            }
            return;
        }

        // Include current character
        curr.append(s.charAt(index));
        backtrack(s, index + 1, curr, k);
        curr.deleteCharAt(curr.length() - 1); // Backtrack

        // Exclude current character
        backtrack(s, index + 1, curr, k);
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "1010";
        int k = 5;
        System.out.println("Longest valid subsequence length: " + sol.longestSubsequence(s, k));
    }
}
