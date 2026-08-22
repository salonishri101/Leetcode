class Solution {
    public boolean checkDivisibility(int n) {
        
       int sum =0;
       int product=1;
       int copy=n;

while(n>0){
int rem=n%10;
n/=10;
sum+=rem;
product*=rem;
}


if(copy%(sum+product)==0){
    return true;
}

return false;
    }
}