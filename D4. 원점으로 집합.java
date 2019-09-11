import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			int res = -1;
			int even = 0, odd = 0;
			for(int i = 0; i < N; i++)
			{
				arr[i] = Math.abs(sc.nextInt());
				arr[i] += Math.abs(sc.nextInt());
				if(arr[i] % 2 == 0) even++;
				else odd++;
			}
			
			if(even > 0 && odd > 0)
			{
				System.out.println("#" + test_case + " -1");
				continue;
			}
			boolean flag = true;
			for(int i = 0;; i++)
			{
				flag = true;
				for(int j = 0; j < N; j++)
				{
					if(arr[j] >= i)
						arr[j] -= i;
					else 
					{
						if(i % 2 != 0)
							arr[j] = (arr[j] % 2 == 0) ? 1 : 0;
						else
							arr[j] = (arr[j] % 2 != 0) ? 1 : 0;
					}
					if(arr[j] != 0) flag = false;
				}
				if(flag)
				{
					res = i;
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}