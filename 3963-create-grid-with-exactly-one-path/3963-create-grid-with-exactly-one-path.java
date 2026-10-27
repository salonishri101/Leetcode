class Solution {
    public String[] createGrid(int m, int n) {
        
char grid[][]=new char[m][n];



for(int i =0;i<m;i++){
    for(int j =0;j<n;j++){
        grid[i][j]='#';
    }
}




for(int i =0;i<n;i++){
    grid[0][i]='.';
}

for(int i =0;i<m;i++){
    grid[i][n-1]='.';
}




String ans[]=new String[m];
int p =0;
for(int i =0;i<m;i++){

    String curr="";
    for(int j =0;j<n;j++){
        curr+=grid[i][j];
    }
    ans[p++]=curr;
}


return ans;
    }
}