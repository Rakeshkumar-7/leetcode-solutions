//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        int[] prefix = new int[n];
        int cur = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(i == 0){
                prefix[i] = arr[i];
            }else{
                prefix[i] = arr[i] + prefix[i-1];
            }
            map.put(prefix[i], i);
        }
        
        // System.out.println(Arrays.toString(prefix));
        
        int max = 0;
        for(int i=0; i<n; i++){
            if(map.containsKey(prefix[i]) && map.get(prefix[i]) != i){
                max = Math.max(map.get(prefix[i]) - i, max);
            }
            if(prefix[i] == 0){
                max = Math.max(i+1, max);
            }
        }
        
        return max;
    }
}