import java.util.*;
 
public class Main {
    static int N, K;
    static int[] arr;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++){
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];
            dp = new long[1<<(N+1)][101];
             
            for(int j = 0; j < 1<<(N+1); j++)
                Arrays.fill(dp[j], -1);
             
            long res = solve(0, 0);
            System.out.println("#" + test_case + " " + res);
        }
    }
    private static long solve(int idx, int chk) {
        if(idx >= N) return findPer(0, 0, 0);
         
        long ret = 0;
         
        for(int i = 1; i <= N; i++)
            if((chk&(1<<i)) == 0){
                arr[idx] = i;
                ret += solve(idx + 1, chk|(1<<i));
                arr[idx] = 0;
            }
        return ret;
    }
    private static long findPer(int idx, int chk, int sum) {
        if(idx >= N){
            if(sum >= K) return 1;
            return 0;
        }
        if(dp[chk][sum] != -1) return dp[chk][sum];
        long ret = 0;
         
        for(int i = 1; i <= N; i++)
            if((chk&(1<<i)) == 0)
                ret += findPer(idx + 1, chk|(1<<i), sum + Math.max(arr[idx], i));
         
        return dp[chk][sum] = ret;
    }
}