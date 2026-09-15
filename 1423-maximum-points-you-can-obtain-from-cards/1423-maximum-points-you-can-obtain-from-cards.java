class Solution {
    public int maxScore(int[] cardPoints, int k) {
        

int n =cardPoints.length;
int i =0;
int j =n-k;

int minsum =0;
int totalsum=0;
for(int p=0;p<n;p++){
    totalsum+=cardPoints[p];
}

int ans =0;

for(int p=0;p<j;p++){
    minsum+=cardPoints[p];
}

 ans = totalsum - minsum;

while(j<n){

minsum+=cardPoints[j];
minsum-=cardPoints[i];
i++;
j++;

ans=Math.max(ans,totalsum-minsum);





}



return ans;



    }
}