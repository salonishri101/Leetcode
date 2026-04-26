class Solution {
    public double myPow(double x, int n) {
        
if(n==0){
    return 1;
}


if(n<0){

      if (n == Integer.MIN_VALUE) {
                // Shift by one to avoid overflow
                return (1 / x) * myPow(1 / x, -(n + 1));
            }
    x=1/x;
    n=-n;
}
double half=myPow(x,n/2);

if(n%2==0){
return half*half;
}else{
    return x*half*half;
}




    }
}