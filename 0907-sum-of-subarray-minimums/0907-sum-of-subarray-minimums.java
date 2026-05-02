class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
    Stack<Integer> s= new Stack<>();
        int nse[]= new int[arr.length];
        int pse[]= new int[arr.length];
        for(int i =arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
          nse[i]=s.isEmpty()?n-i:s.peek()-i;
          
          s.push(i);
            
        }

s.clear();

     for(int i =0;i<arr.length;i++){
            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                s.pop();
            }
          pse[i]=s.isEmpty()?i+1:i-s.peek();
          
          s.push(i);
            
        }

//  for (int i = 0; i < n; i++) {
//             sum = (sum + (long)arr[i] * pse[i] * nse[i]) % MOD;
//         }

long sum = 0;
int MOD = (int)1e9 + 7;

for (int i = 0; i < arr.length; i++) {
    long curr = ((long) arr[i] * pse[i] % MOD) * nse[i] % MOD;
    sum = (sum + curr) % MOD;
}

return (int) sum;

    }
}