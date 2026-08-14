class Solution {




public void dfs(char[][] board,int r,int c,boolean [][] vis){

       if(r<0 || c<0 || r>=board.length || c>=board[0].length|| vis[r][c] || board[r][c] != 'O' ){
        return;
       }

      vis[r][c]=true;
       
        
            dfs(board,r+1,c,vis);
            dfs(board,r-1,c,vis);
            dfs(board,r,c+1,vis);
            dfs(board,r,c-1,vis);
        
    


}


    public void solve(char[][] board) {
        
    boolean [][] vis= new boolean[board.length][board[0].length];

  int n = board.length;
         int m = board[0].length;
     for(int i =0;i<n;i++){
        if(board[i][0]=='O'){
            dfs(board,i,0,vis);
        }
     }

       for(int j=1;j<m;j++){
        if(board[n-1][j]=='O'){
            dfs(board,n-1,j,vis);
        }
     }

       for(int i =n-2;i>=0;i--){
        if(board[i][m-1]=='O'){
           dfs(board,i,m-1,vis);
        }
     }

       for(int j =m-1;j>=1;j--){
        if(board[0][j]=='O'){
            dfs(board,0,j,vis);
        }
     }

    for(int i =0;i<n;i++){
        for(int j =0;j<m;j++){
            if(board[i][j]=='O' && !vis[i][j] ){
                board[i][j]='X';
            }
        }
       }



    }
}