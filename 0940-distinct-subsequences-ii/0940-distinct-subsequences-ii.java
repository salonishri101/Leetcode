class Solution {
    public int distinctSubseqII(String s) {

        long[] end = new long[26];
        long total = 0;
        long MOD = 1000000007;

        for (char ch : s.toCharArray()) {

            int idx = ch - 'a';

            long add = (total + 1) % MOD;

            total = (total + add - end[idx] + MOD) % MOD;

            end[idx] = add;
        }

        return (int) total;
    }
}