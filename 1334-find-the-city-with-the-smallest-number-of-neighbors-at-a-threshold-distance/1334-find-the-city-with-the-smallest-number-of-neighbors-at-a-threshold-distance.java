class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int dist[][] =new int[n][n];
        for(int i =0;i<n;i++){
        Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        for(int []edge:edges){
            int u =edge[0];
            int v =edge[1];
            int wt =edge[2];
          dist[u][v]=wt;
          dist[v][u]=wt;
        
        }


        for(int k =0;k<n;k++){
            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }



        int count[] = new int[n];
        Arrays.fill(count,0);
            for(int i =0;i<n;i++){
                for(int j =0;j<n;j++){

               if( i!=j && dist[i][j]<=distanceThreshold){
                count[i]++;
               }
                }
            }

               int min =Integer.MAX_VALUE;
               int ans=-1;
            for(int i =0;i<n;i++){
                if(count[i]<=min){
                    min=count[i];
                    ans=i;

                }
            }
return ans;
        
    }
}