import java.util.*;

public class Main {
	static int N, res;
	static ArrayList<Integer>[] arr;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			chk = new int[N+1];
			arr = new ArrayList[N+1];
			res = 0;
			for(int i = 1; i <= N; i++) 
				arr[i] = new ArrayList<>();
			
			for(int i = 0; i < N; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a].add(b);
				arr[b].add(a);
			}
			chk[1] = 1;
			
			solve(1);
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static void solve(int idx) {
		for(int next : arr[idx])
		{
			if(chk[next] == 0)
			{
				chk[next] = chk[idx] + 1;
				solve(next);
			}
			else if(chk[next] < chk[idx])//사이클!
			{
				res = Math.max(res, chk[idx] - chk[next] + 1);
			}
		}
	}
}