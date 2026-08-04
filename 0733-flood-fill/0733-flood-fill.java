class Solution {

class Pair{

    int first;
    int sec;
    Pair(int first,int sec ){
        this.first=first;
        this.sec=sec;
    }
}




    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        

        int orgcol = image[sr][sc];

        // Same color hai toh kuch karna hi nahi
        if (orgcol == color) {
            return image;
        }

       
        boolean vis[][]=new boolean[image.length][image[0].length];
        Queue<Pair> q = new LinkedList<>();
    

        q.add(new Pair(sr,sc));
        
        while(q.size()>0){
            Pair curr=q.poll();
            int i=curr.first;
            int j=curr.sec;
                 
                  image[i][j]=color;


            if(i-1>=0 && (image[i-1][j]==orgcol) && !vis[i-1][j]){
                vis[i-1][j]=true;
                image[i-1][j]=color;
                q.add(new Pair(i-1,j));
            }

            if(j-1>=0 && (image[i][j-1]==orgcol) && !vis[i][j-1]){
                vis[i][j-1]=true;
                image[i][j-1]=color;
                q.add(new Pair(i,j-1));
            }

            if(i+1<image.length && (image[i+1][j]==orgcol) && !vis[i+1][j]){
                vis[i+1][j]=true;
                image[i+1][j]=color;
                q.add(new Pair(i+1,j));
            }

            if(j+1<image[0].length && (image[i][j+1]==orgcol) && !vis[i][j+1]){
                vis[i][j+1]=true;
                image[i][j+1]=color;
                q.add(new Pair(i,j+1));
            }
        }


      return image;

    }
}