class Solution {
    public int minOperations(String s) {
    int n =s.length();    
 boolean sorted=true;

 for(int i =1;i<n;i++){
    if(s.charAt(i-1)>s.charAt(i)){
        sorted=false;
        break;
    }
 }

 if(sorted) return 0;


 //check whether all char are same
boolean allSame=true;
char first=s.charAt(0);
 
 for(int i =1;i<n;i++){
    if(s.charAt(i)!=first){
        allSame=false;
        break;
    }
 }

 if(allSame) return 0;



 char min=s.charAt(0);
 char max=s.charAt(0);

 for(int i =0;i<n;i++){
    min=(char)Math.min(min,s.charAt(i));
    max=(char)Math.max(max,s.charAt(i));
 }


 if(min==s.charAt(0) || max==s.charAt(n-1)) return 1;


 if(n==2) return -1;

        // Count minimum and maximum occurrences
        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == min) minCount++;
            if (s.charAt(i) == max) maxCount++;
        }

        // Three operations only when both extremes are unique
        if (s.charAt(0) == max &&
            s.charAt(n - 1) == min &&
            minCount == 1 &&
            maxCount == 1) {
            return 3;
        }


return 2;

    }
}