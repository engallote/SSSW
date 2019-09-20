import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				arr[i] = num;
			}
			Arrays.sort(arr);
			
			int H = 0, l = 1, r = Integer.MAX_VALUE - 1, mid;
			while(l <= r)
			{
				mid = (l + r) / 2;
				int sum = 0;
				for(int i = 0; i < N; i++)
					if(arr[i] >= mid)
					{
						sum = N - i;
						break;
					}
				
				if(sum >= mid)
				{
//					System.out.println(mid + " " + sum);
					H = Math.max(mid, H);
					l = mid + 1;
				}
				else r = mid - 1;
			}
			System.out.println("#" + test_case + " " + H);
		}
	}
}