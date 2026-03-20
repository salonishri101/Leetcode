class Solution {
    public void setZeroes(int[][] matrix) {
        
int x=1,y=1;
for(int i =0;i<matrix[0].length;i++){
    if(matrix[0][i]==0){
        x=0;
        break;
    }
}


for(int i =0;i<matrix.length;i++){
    if(matrix[i][0]==0){
        y=0;
        break;
    }
}


for(int i =1;i<matrix.length;i++){
    for(int j =1;j<matrix[0].length;j++){
if(matrix[i][j]==0){
    matrix[i][0]=0;
    matrix[0][j]=0;
}
    }
}


for(int i =1;i<matrix.length;i++){
     if(matrix[i][0]==0){
       for(int j =1;j<matrix[0].length;j++){
        matrix[i][j]=0;
       } 
     }
}

for(int i =1;i<matrix[0].length;i++){
     if(matrix[0][i]==0){
       for(int j =1;j<matrix.length;j++){
        matrix[j][i]=0;
       } 
     }
}



if(x==0){
  for(int i =0;i<matrix[0].length;i++){
     matrix[0][i]=0;
  }  
}

if(y==0){
  for(int i =0;i<matrix.length;i++){
     matrix[i][0]=0;
  }  
}


    }
}