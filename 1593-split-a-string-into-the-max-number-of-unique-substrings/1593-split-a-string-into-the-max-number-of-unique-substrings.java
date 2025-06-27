import java.util.*;

public class Solution {
    List<String> result = new ArrayList<>();
    int max = 0;

    public int maxUniqueSplit(String s) {
        backtrack(s, 0, new HashSet<>(), new ArrayList<>());
        return result.size(); // or return result if you want actual substrings
    }

    private void backtrack(String s, int start, Set<String> used, List<String> path) {
        if (start == s.length()) {
            if (path.size() > max) {
                max = path.size();
                result = new ArrayList<>(path); // save current best path
            }
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (!used.contains(sub)) {
                used.add(sub);
                path.add(sub);

                backtrack(s, end, used, path);

                used.remove(sub);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<String> getResult() {
        return result;
    }
}
