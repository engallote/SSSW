import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] arr = new long[50];
		for(int i = 1; i < 50; i++)
			arr[i] = (long)Math.pow(2, i);
		for(int test_case = 1; test_case <= T; test_case++)
		{
			long N = sc.nextLong();
			if(N == 1 || N == 2) System.out.println("#" + test_case + " YES");
			else
			{
				boolean flag = false;
				for(int i = 0; i < 50; i++)
					if(arr[i] == N)
					{
						flag = true;
						System.out.println("#" + test_case + " YES");
						break;
					}
				if(!flag) System.out.println("#" + test_case + " NO");
			}
		}
	}
}