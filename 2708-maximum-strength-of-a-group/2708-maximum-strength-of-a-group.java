import java.util.*;
class Solution {
    public long maxStrength(int[] nums) {
        long[] ans = new long[1];
        ans[0] = Long.MIN_VALUE;
        findSol(nums, 0, new ArrayList<>(), ans);
        if (ans[0] == Long.MIN_VALUE) {
            int max = nums[0];
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        return ans[0];
    }
    public static void findSol(int[] nums, int index, List<Integer> curr, long[] ans) {
        if (index == nums.length) {
            if (curr.size() > 0) {
                long p = 1;
                for (int x : curr) {
                    p *= x;
                }
                ans[0] = Math.max(ans[0], p);
            }
            return;
        }
        curr.add(nums[index]);
        findSol(nums, index + 1, curr, ans);
        curr.remove(curr.size() - 1);
        findSol(nums, index + 1, curr, ans);
    }
}
