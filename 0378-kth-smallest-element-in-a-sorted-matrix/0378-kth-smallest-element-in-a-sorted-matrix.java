class Solution {
    public int kthSmallest(int[][] matrix, int k) {


        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        
           
        for(int i =0;i<matrix.length;i++){
            pq.add (new int[]{matrix[i][0],i,0});
        }
       int ans= 0;
       while(k>0){

          int cur[]=pq.poll();
          ans=cur[0];

          int row=cur[1];
          int col=cur[2];
          if(col+1<matrix.length){
            pq.add(new int[]{matrix[row][col+1],row,col+1});
          }
          k--;

       }
        
       return ans;     
    }
}                                    