import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), num = 0, res = 0, N;
		boolean[] arr = new boolean[200001];
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			sc.nextLine();
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			res = 0;
			Arrays.fill(arr, false);
			for(int i = 1; i <= N; i++)
			{
				num = Integer.parseInt(st.nextToken());
				if(!arr[num-1]) res++;
				arr[num] = true;
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}