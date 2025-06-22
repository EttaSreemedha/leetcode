class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder path, int open, int close, int max) {
        if (path.length() == max * 2) {
            res.add(path.toString());
            return;
        }

        if (open < max) {
            path.append('(');
            backtrack(res, path, open + 1, close, max);
            path.deleteCharAt(path.length() - 1);
        }

        if (close < open) {
            path.append(')');
            backtrack(res, path, open, close + 1, max);
            path.deleteCharAt(path.length() - 1);
        }
    }
}