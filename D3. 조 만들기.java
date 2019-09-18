import java.util.*;

public class Main {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			
			int sw = 1, cnt = 1;
			int[] arr = new int[K];
			while(cnt <= N * K)
			{
				if(sw == 1)//정방향
				{
					for(int i = 0; i < K; i++)
					{
						arr[i] += cnt;
						cnt++;
					}
				}
				else
				{
					for(int i = K-1; i >= 0; i--)
					{
						arr[i] += cnt;
						cnt++;
					}
				}
				sw *= -1;
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < K; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}