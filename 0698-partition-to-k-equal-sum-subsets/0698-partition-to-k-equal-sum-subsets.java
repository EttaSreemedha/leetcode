class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % k != 0) return false;

        int target = total / k;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, k, 0, 0, target);
    }
    public boolean backtrack(int[] nums, boolean[] used, int k, int start, int currSum, int target) {
        if (k == 0) return true;
        if (currSum == target) return backtrack(nums, used, k - 1, 0, 0, target);

        for (int i = start; i < nums.length; i++) {
            if (used[i] || currSum + nums[i] > target) continue;
            used[i] = true;
            if (backtrack(nums, used, k, i + 1, currSum + nums[i], target)) return true;
            used[i] = false;
        }
        return false;
    }
}