class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(s);
        vis.add(s);

        boolean found = false;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String curr = q.poll();

                if (isValid(curr)) {
                    ans.add(curr);
                    found = true;
                }

                // Agar current level par valid mil gaya,
                // next level generate nahi karna
                if (found) {
                    continue;
                }

                // Ek-ek character remove karo
                for (int i = 0; i < curr.length(); i++) {

                    // letters remove karne ki zarurat nahi
                    if (curr.charAt(i) != '(' &&
                        curr.charAt(i) != ')') {
                        continue;
                    }

                    String next =
                        curr.substring(0, i) +
                        curr.substring(i + 1);

                    if (!vis.contains(next)) {
                        vis.add(next);
                        q.add(next);
                    }
                }
            }

            if (found) {
                break;
            }
        }

        return ans;
    }

    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            }
            else if (ch == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}