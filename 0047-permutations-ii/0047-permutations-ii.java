import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length && !result.contains(path)) {
            result.add(new ArrayList<>(path));  // Add a copy of the current path
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // Skip already used elements

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, used, path, result);  // Recurse

            // Backtrack
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
