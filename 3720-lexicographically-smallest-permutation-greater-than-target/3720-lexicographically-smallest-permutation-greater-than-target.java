class Solution {

    private String getMinString(int[] freq) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                res.append((char) ('a' + i));
                freq[i]--;
            }
        }

        return res.toString();
    }

    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i = s.length() - 1; i >= 0; i--) {

            int b = target.charAt(i) - 'a';
            freq[b]++;

            boolean negative = false;

            for (int x : freq) {
                if (x < 0) {
                    negative = true;
                    break;
                }
            }

            if (negative) continue;

            for (int j = b + 1; j < 26; j++) {

                if (freq[j] > 0) {
                    freq[j]--;

                    return target.substring(0, i)
                            + (char) ('a' + j)
                            + getMinString(freq);
                }
            }
        }

        return "";
    }
}