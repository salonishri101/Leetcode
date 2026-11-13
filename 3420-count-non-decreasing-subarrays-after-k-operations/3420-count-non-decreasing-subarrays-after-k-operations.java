
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long ans = 0;
        long cost = 0;

        Deque<int[]> dq = new ArrayDeque<>();

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge smaller elements
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] p = dq.pollLast();

                int nextNum = p[0];
                int nextCount = p[1];

                count += nextCount;

                cost += (long) (num - nextNum) * nextCount;
            }

            dq.offerLast(new int[]{num, count});

            // Reduce window if cost exceeds k
            while (cost > k) {

                int[] p = dq.pollFirst();

                int rightmostNum = p[0];
                int rightmostCount = p[1];

                cost -= (long) (rightmostNum - nums[j]);
                j--;

                if (rightmostCount > 1) {
                    dq.offerFirst(new int[]{
                        rightmostNum,
                        rightmostCount - 1
                    });
                }
            }

            // Count valid subarrays
            ans += j - i + 1;
        }

        return ans;
    }
}
