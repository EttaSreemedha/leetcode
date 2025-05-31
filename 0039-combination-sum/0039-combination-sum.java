import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findSol(candidates, 0, new ArrayList<>(), res, target);
        return res;
    }

    public static void findSol(int[] candidates, int index, List<Integer> curr, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        curr.add(candidates[index]);
        findSol(candidates, index, curr, res, target - candidates[index]);
        curr.remove(curr.size() - 1);

        findSol(candidates, index + 1, curr, res, target);
    }
}
