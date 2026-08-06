class Solution {

public int product(int num){
      int mul=1;
        while(num>0){
         int rem =num%10;
         mul*=rem;
         num/=10;
        }

        return mul;
}





    public int smallestNumber(int n, int t) {
        

       int i =n;
     while(i>=n){{
        int mul=product(i);
        if(mul%t==0) return i;
        i++;
     }

     }

   
return -1;
    

    }
}