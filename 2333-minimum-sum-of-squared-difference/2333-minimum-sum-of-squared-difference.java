
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        long total = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // Enough operations to make all differences zero
        if (k >= total) return 0;

        int low = 0, high = maxDiff;

        // Find the minimum possible maximum difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long needed = 0;

        for (int d : diff) {
            if (d > limit) {
                needed += d - limit;
            }
        }

        long remaining = k - needed;
        long ans = 0;

        for (int d : diff) {
            long value = Math.min(d, limit);

            // Use leftover operations to reduce limit by 1
            if (remaining > 0 && d >= limit && value > 0) {
                value--;
                remaining--;
            }

            ans += value * value;
        }

        return ans;
    }
}
