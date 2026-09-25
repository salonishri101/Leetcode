class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression);
        
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        int i = 0;

        while (i < s.length()) {

            Set<String> current;

            if (s.charAt(i) == '{') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') count++;
                    else if (s.charAt(j) == '}') count--;
                    j++;
                }

                // remove outer {}
                current = solve(s.substring(i + 1, j - 1));
                i = j;

            } else {
                current = new HashSet<>();
                current.add(String.valueOf(s.charAt(i)));
                i++;
            }

            // Cartesian product = concatenate
            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : current) {
                    next.add(a + b);
                }
            }

            result = next;

            // Skip comma
            if (i < s.length() && s.charAt(i) == ',') {
                Set<String> right = solve(s.substring(i + 1));

                result.addAll(right);
                break;
            }
        }

        return result;
    }
}