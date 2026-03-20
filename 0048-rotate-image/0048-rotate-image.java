class Solution {
    public void rotate(int[][] matrix) {
        

for(int i =0;i<matrix.length;i++){
    for(int j =i+1;j<matrix[0].length;j++){
        if(i!=j){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
}



for(int i =0;i<matrix.length;i++){
   for(int j =0;j<matrix[0].length/2;j++){

    int temp = matrix[i][j];
    matrix[i][j]=matrix[i][matrix[0].length-j-1];
   matrix[i][matrix[0].length-j-1]=temp; 
}

}

    }
}

//only works for sqr matrix

// int j =0;
// while(j<matrix.length){
// for(int i =0;i<matrix[0].length/2;i++){
//     int temp = matrix[j][i];
//     matrix[j][i]=matrix[j][matrix.length-i-1];
//    matrix[j][matrix.length-i-1]=temp; 
// }
// j++;
// }