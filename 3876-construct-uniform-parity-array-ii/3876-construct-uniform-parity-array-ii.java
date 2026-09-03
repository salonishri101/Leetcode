class Solution {
    public boolean uniformArray(int[] nums1) {
        


        int min = Integer.MAX_VALUE;

        for (int x : nums1) {
            min = Math.min(min, x);
        }

        // Minimum even hai -> minimum ki parity change nahi ho sakti
        // Isliye saare elements even hone chahiye
        if (min % 2 == 0) {
            for (int x : nums1) {
                if (x % 2 != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}