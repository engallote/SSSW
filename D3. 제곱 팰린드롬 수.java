import java.util.*;

public class Main {
	static int N, M;
	static int[] dp = new int[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i <= 1000; i++){
			if(solve(i)) dp[i] = dp[i-1] + 1;
			else dp[i] = dp[i-1];
		}
		
		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.println("#" + test_case + " " + (dp[M] - dp[N-1]));
		}
	}
	private static boolean solve(int n) {
		char[] ch = Integer.toString(n).toCharArray();
		int l = 0, r = ch.length - 1;
		while(l <= r){
			if(ch[l] != ch[r]) return false;
			++l;
			--r;
		}
		
		double tmp = Math.sqrt(n);
		int idx = Double.toString(tmp).indexOf('.');
		long num = Long.parseLong(Double.toString(tmp).substring(idx+1));
		
		if(num != 0) return false;
		
		ch = Integer.toString((int)tmp).toCharArray();
		l = 0;
		r = ch.length - 1;
		while(l <= r){
			if(ch[l] != ch[r]) return false;
			++l;
			--r;
		}
		
		return true;
	}
}