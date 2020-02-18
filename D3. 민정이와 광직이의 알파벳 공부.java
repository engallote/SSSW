import java.util.*;

public class Main {
	static int N;
	static String[] arr;
	static int[][] dp;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	N = sc.nextInt();
        	arr = new String[N];
        	dp = new int[N][1<<N];
        	
        	for(int i = 0; i < N; i++){
        		arr[i] = sc.next();
        		Arrays.fill(dp[i], -1);
        	}
        	
        	Arrays.sort(arr);
        	
        	int res = solve(0, 0);
        	System.out.println("#" + test_case + " " + res);
        }
    }
	private static int solve(int idx, int chk) {
		if(idx == N){
			int[] alp = new int[26];
			for(int i = 0; i < N; i++)
				if((chk&(1<<i))!=0)
					for(char c : arr[i].toCharArray()) 
						++alp[c-'a'];
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < 26; i++){
				min = Math.min(min, alp[i]);
				if(alp[i] == 0) break;
			}
			
			return min > 0 ? 1 : 0;
		}
		if(dp[idx][chk] != -1) return dp[idx][chk];
		int ret = 0;
		
		ret += solve(idx + 1, chk|(1<<idx));
		ret += solve(idx + 1, chk);
			
		return dp[idx][chk] = ret;
	}
}