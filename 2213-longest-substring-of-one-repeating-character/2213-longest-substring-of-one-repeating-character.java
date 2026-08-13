class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            best = 1;
            len = 1;
        }
    }

    Node[] tree;

    Node merge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node res = new Node(a.leftChar);

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.len = a.len + b.len;

        // prefix
        res.prefix = a.prefix;

        if (a.prefix == a.len &&
            a.rightChar == b.leftChar) {

            res.prefix = a.len + b.prefix;
        }

        // suffix
        res.suffix = b.suffix;

        if (b.suffix == b.len &&
            a.rightChar == b.leftChar) {

            res.suffix = b.len + a.suffix;
        }

        // best
        res.best = Math.max(a.best, b.best);

        if (a.rightChar == b.leftChar) {
            res.best = Math.max(
                res.best,
                a.suffix + b.prefix
            );
        }

        return res;
    }

    void build(char[] s, int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(s[l]);
            return;
        }

        int mid = (l + r) / 2;

        build(s, 2 * node, l, mid);
        build(s, 2 * node + 1, mid + 1, r);

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    void update(char[] s, int node, int l, int r, int idx) {

        if (l == r) {
            tree[node] = new Node(s[idx]);
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(s, 2 * node, l, mid, idx);
        } else {
            update(s, 2 * node + 1, mid + 1, r, idx);
        }

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();

        char[] arr = s.toCharArray();

        tree = new Node[4 * n];

        build(arr, 1, 0, n - 1);

        int k = queryIndices.length;

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int idx = queryIndices[i];

            arr[idx] = queryCharacters.charAt(i);

            update(arr, 1, 0, n - 1, idx);

            ans[i] = tree[1].best;
        }

        return ans;
    }
}