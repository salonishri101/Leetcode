
class Solution {
    public int minInsertions(String s) {
        int add = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    add++;
                }

                if (open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }

        return add + 2 * open;
    }
}
