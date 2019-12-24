import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			int res = -1;
			
			for(int i = N - 1; i >= 0; i--)
			{
				for(int j = i - 1; j >= 0; j--)
					if(arr[i] + arr[j] <= M) res = Math.max(res, arr[i] + arr[j]);
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}