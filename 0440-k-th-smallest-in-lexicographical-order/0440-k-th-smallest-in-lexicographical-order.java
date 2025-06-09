class Solution {
    public int findKthNumber(int n, int k) {
        long prefix = 1;
        k--;

        while (k > 0) {
            long subtreeSize = 0;
            long current = prefix;
            long next = prefix + 1;

            while (current <= n) {
                subtreeSize += Math.min(n + 1, next) - current;
                current *= 10;
                next *= 10;
            }

            if (subtreeSize <= k) {
                prefix++;
                k -= subtreeSize;
            } else {
                prefix *= 10;
                k--;
            }
        }

        return (int) prefix;
    }
}