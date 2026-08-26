class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
          int i =0;
          int count=0;
          int minLen =Integer.MAX_VALUE;
           String ans = "";
        //   Arraylist<StringBuilder> ans = new ArrayList<>();
          for(int j =0;j<s.length();j++){
           char ch = s.charAt(j);
           if(ch=='1'){
            count++;
           }



    while(count>k){
             
          if(s.charAt(i)=='1'){
          count--;
          }

        i++;
        
          }

          if(count==k){
              // remove unnecessary zeroes from left
                while (s.charAt(i) == '0') {
                    i++;
                }

                int len = j - i + 1;
                String curr = s.substring(i, j + 1);
            
                if(len<minLen){
                minLen =len;
                ans=curr;
                }else if( minLen==len && curr.compareTo(ans)<0){
                    ans=curr;
                }
          }
           
          }

return ans;


    }
}