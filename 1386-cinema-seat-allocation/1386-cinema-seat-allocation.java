class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }

            map.get(row).add(col);
        }

        // Rows with no reservation can always fit 2 families
        int ans = (n - map.size()) * 2;

        // Check only rows having reservations
        for (HashSet<Integer> set : map.values()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // 2,3,4,5
            for (int i = 2; i <= 5; i++) {
                if (set.contains(i)) {
                    left = false;
                }
            }

            // 4,5,6,7
            for (int i = 4; i <= 7; i++) {
                if (set.contains(i)) {
                    middle = false;
                }
            }

            // 6,7,8,9
            for (int i = 6; i <= 9; i++) {
                if (set.contains(i)) {
                    right = false;
                }
            }

            if (left && right) {
                ans += 2;
            }
            else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}