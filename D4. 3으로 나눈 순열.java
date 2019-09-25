import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] num = new int[1000];
		num[0] = 1;
		for(int i = 1; i < 1000; i++)
		{
			num[i] += num[i-1] + 1;
			num[i] %= 3;
		}
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			int res = 0, idx = 0;
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt() % 3;
				
			for(int i = 0; i < N; i++)
			{
				idx = -1;
				if(num[i] != arr[i])
				{
					for(int j = i + 1; j < N; j++)
						if(num[j] != arr[j] && num[i] == arr[j])
						{
							idx = j;
							if(num[j] == arr[i]) break;
						}
					if(idx != -1)
					{
						arr[idx] = arr[i];
						arr[i] = num[i];
						res++;
					}
					
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}