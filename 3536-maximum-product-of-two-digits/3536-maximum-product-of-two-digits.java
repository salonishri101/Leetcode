class Solution {
    public int maxProduct(int n) {
       int first=Integer.MIN_VALUE;
       int sec=Integer.MIN_VALUE;
    while(n>0){
        int digit=n%10;
        n=n/10;
        if(digit>=first){
            sec=first;
            first=digit;
        }else if(sec<digit &&  digit<first){
            sec=digit;
        }

    }
  return first*sec;

    }
}