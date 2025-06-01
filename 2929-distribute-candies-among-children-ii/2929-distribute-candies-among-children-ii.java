class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;
        int mini = Math.min(limit, n);
        for (int i = 0; i <= mini; i++) 
        {
            if (n - i <= 2 * limit) 
            res += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return res;
    }
}