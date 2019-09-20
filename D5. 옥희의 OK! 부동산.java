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
			arr = new int[N+1];
			
			for(int i = 1; i <= N; i++)
				arr[i] = sc.nextInt();
			
			int res = 0;
			for(int i = 1; i <= N; i++)
			{
				int num = 0;
				for(int j = i; j <= N; j++)
				{
					num += arr[j];
					if(num == M)
					{
						res++;
						break;
					}
					else if(num > M) break;
				}
					
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}