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
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			int res = arr[N-1] + 1;
			
			for(int i = N - 1; i > 0; i--)
				res += arr[i] + 1;
			res += arr[0];
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}