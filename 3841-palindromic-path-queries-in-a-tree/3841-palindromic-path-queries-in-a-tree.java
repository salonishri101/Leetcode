import java.util.*;

class Solution {

    int n;
    List<Integer>[] adj;

    int[] parent, depth, size, heavy;
    int[] head, pos;
    int timer;

    SegmentTree seg;

    class SegmentTree {
        int size;
        int[] tree;

        SegmentTree(int n) {
            size = 1;

            while (size < n) {
                size <<= 1;
            }

            tree = new int[2 * size];
        }

        void build(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                tree[size + i] = arr[i];
            }

            for (int i = size - 1; i >= 1; i--) {
                tree[i] = tree[2 * i] ^ tree[2 * i + 1];
            }
        }

        void update(int index, int value) {
            int p = size + index;
            tree[p] = value;
            p >>= 1;

            while (p >= 1) {
                tree[p] = tree[2 * p] ^ tree[2 * p + 1];
                p >>= 1;
            }
        }

        // XOR of range [l, r)
        int query(int l, int r) {
            int ans = 0;

            l += size;
            r += size;

            while (l < r) {
                if ((l & 1) == 1) {
                    ans ^= tree[l++];
                }

                if ((r & 1) == 1) {
                    ans ^= tree[--r];
                }

                l >>= 1;
                r >>= 1;
            }

            return ans;
        }
    }

    public List<Boolean> palindromePath(
            int n,
            int[][] edges,
            String s,
            String[] queries) {

        this.n = n;

        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(heavy, -1);

        // Step 1: Find parent, depth and traversal order.
        int[] order = new int[n];
        int[] stack = new int[n];

        int top = 0;
        int count = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            order[count++] = u;

            for (int v : adj[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;

                stack[top++] = v;
            }
        }

        // Step 2: Calculate subtree sizes and heavy child.
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];

            size[u] = 1;
            int maxSize = 0;

            for (int v : adj[u]) {
                if (parent[v] != u) {
                    continue;
                }

                size[u] += size[v];

                if (size[v] > maxSize) {
                    maxSize = size[v];
                    heavy[u] = v;
                }
            }
        }

        // Step 3: Heavy-Light Decomposition.
        int[] nodeStack = new int[n];
        int[] headStack = new int[n];

        top = 0;
        timer = 0;

        nodeStack[top] = 0;
        headStack[top] = 0;
        top++;

        while (top > 0) {
            top--;

            int start = nodeStack[top];
            int chainHead = headStack[top];

            int u = start;

            while (u != -1) {
                head[u] = chainHead;
                pos[u] = timer++;

                for (int v : adj[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        nodeStack[top] = v;
                        headStack[top] = v;
                        top++;
                    }
                }

                u = heavy[u];
            }
        }

        // Step 4: Convert characters into bitmasks.
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int node = order[i];

            arr[pos[node]] =
                    1 << (s.charAt(node) - 'a');
        }

        seg = new SegmentTree(n);
        seg.build(arr);

        // Step 5: Process queries.
        List<Boolean> answers = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int mask = 1 << (c - 'a');

                seg.update(pos[u], mask);

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = pathQuery(u, v);

                boolean possible =
                        (mask & (mask - 1)) == 0;

                answers.add(possible);
            }
        }

        return answers;
    }

    // XOR of characters on path u -> v.
    int pathQuery(int u, int v) {

        int mask = 0;

        while (head[u] != head[v]) {

            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            mask ^= seg.query(
                    pos[head[u]],
                    pos[u] + 1
            );

            u = parent[head[u]];
        }

        int left = Math.min(pos[u], pos[v]);
        int right = Math.max(pos[u], pos[v]);

        mask ^= seg.query(left, right + 1);

        return mask;
    }
}