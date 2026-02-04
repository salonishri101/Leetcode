class Solution {

      public boolean rec(char[][] board, String word,int r,int c,boolean vis[][],int idx ) {
         
          if(r<0 || r>=board.length || c<0 || c>=board[0].length || vis[r][c] || board[r][c]!=word.charAt(idx)  ){
            return false;
          }
      
          if(idx==word.length()-1 ){
            return true;
          }

          vis[r][c]=true;

          

           boolean found= rec(board,word,r+1,c,vis,idx+1)||
          rec(board,word,r-1,c,vis,idx+1)||
          rec(board,word,r,c+1,vis,idx+1)||
          rec(board,word,r,c-1,vis,idx+1);

         vis[r][c]=false;//backtraking

                 return found;


      }
      

    public boolean exist(char[][] board, String word) {
        

boolean vis[][]= new boolean[board.length][board[0].length];

        char st = word.charAt(0);
       for(int i =0;i<board.length;i++){
        for(int j =0;j<board[0].length;j++){
            if(board[i][j]==st){
                if(rec(board,word,i,j,vis,0)) return true;
            }
        }
       }
       
return false;

    }
}