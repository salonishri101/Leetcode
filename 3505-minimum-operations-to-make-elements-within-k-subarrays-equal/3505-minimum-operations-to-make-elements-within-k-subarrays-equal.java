
import java.util.*;

class Solution {

    class MedianWindow {

        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;

        void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        void addLow(int val) {
            addMap(low, val);
            lowSize++;
            lowSum += val;
        }

        void addHigh(int val) {
            addMap(high, val);
            highSize++;
            highSum += val;
        }

        int removeLow() {
            int val = low.lastKey();
            removeMap(low, val);
            lowSize--;
            lowSum -= val;
            return val;
        }

        int removeHigh() {
            int val = high.firstKey();
            removeMap(high, val);
            highSize--;
            highSum -= val;
            return val;
        }

        void balance(int x) {

            int target = (x + 1) / 2;

            while (lowSize > target) {
                int val = removeLow();
                addHigh(val);
            }

            while (lowSize < target && highSize > 0) {
                int val = removeHigh();
                addLow(val);
            }
        }

        void add(int val, int x) {

            if (lowSize == 0 || val <= low.lastKey()) {
                addLow(val);
            } else {
                addHigh(val);
            }

            balance(x);
        }

        void remove(int val, int x) {

            if (low.containsKey(val)) {
                removeMap(low, val);
                lowSize--;
                lowSum -= val;
            } else {
                removeMap(high, val);
                highSize--;
                highSum -= val;
            }

            balance(x);
        }

        long getCost() {

            long median = low.lastKey();

            long leftCost = median * lowSize - lowSum;
            long rightCost = highSum - median * highSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        // Step 1: Sliding window median costs

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < x; i++) {
            window.add(nums[i], x);
        }

        cost[0] = window.getCost();

        for (int i = x; i < n; i++) {

            window.remove(nums[i - x], x);
            window.add(nums[i], x);

            cost[i - x + 1] = window.getCost();
        }

        // Step 2: DP

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        for (int j = 1; j <= k; j++) {

            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Skip current element
                curr[i] = curr[i - 1];

                // Select a window of size x
                if (i >= x && prev[i - x] != INF) {

                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}
