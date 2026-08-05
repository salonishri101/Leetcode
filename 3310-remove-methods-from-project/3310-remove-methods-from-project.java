class Solution {


    public void dfs(int node,List<List<Integer>> graph ,boolean suspicious[] ){
              suspicious[node]=true;
               for (int next : graph.get(node)) {

            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
         }



    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
          

     



          List<List<Integer>> graph = new ArrayList<>();
            

            for(int i =0;i<n;i++){
             graph.add(new ArrayList<>());
            }


            for(int [] edge:invocations){
                int a=edge[0];
                int b =edge[1];

                graph.get(a).add(b);
            }


            boolean suspicious[] = new boolean[n];
            dfs(k, graph, suspicious);

             

                     //  Check karo koi normal method suspicious ko call
        // kar raha hai ya nahi

        for (int[] edge : invocations) {

            int a = edge[0];
            int b = edge[1];

            if (!suspicious[a] && suspicious[b]) {

                // Remove nahi kar sakte
                // Isliye sab return karo

                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        // 4. Suspicious methods hata do
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;


    }
}