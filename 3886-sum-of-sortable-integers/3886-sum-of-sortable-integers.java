
import java.util.*;

class Solution {
  public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] freq = new int[100001];
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                int end = start + k;
                int descents = 0;

                // Count circular descents
                for (int j = start; j < end; j++) {
                    int next = (j + 1 == end) ? start : j + 1;

                    if (nums[j] > nums[next]) {
                        descents++;
                    }
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                // Check whether this block has the
                // same elements as its sorted counterpart
                for (int j = start; j < end; j++) {
                    freq[nums[j]]++;
                    freq[sorted[j]]--;
                }

                for (int j = start; j < end; j++) {
                    if (freq[nums[j]] != 0 ||
                        freq[sorted[j]] != 0) {
                        valid = false;
                        break;
                    }
                }

                // Reset frequencies for the next block
                for (int j = start; j < end; j++) {
                    freq[nums[j]] = 0;
                    freq[sorted[j]] = 0;
                }

                if (!valid) {
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
