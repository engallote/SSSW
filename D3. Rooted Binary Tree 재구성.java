import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int len = (int)Math.pow(2, N) - 1;
			int[] arr = new int[len];
			int mid = len / 2;
			for(int i = 0; i < len; i++)
				arr[i] = sc.nextInt();
			
			System.out.print("#" + test_case + " ");
			System.out.println(arr[mid]);
			ArrayList<Integer>[] aly = new ArrayList[N];
			for(int i = 0; i < N; i++)
				aly[i] = new ArrayList<>();
			int idx = N - 1, jump = 2;
			boolean[] visit = new boolean[len];
			visit[mid] = true;
			while(idx >= 0)
			{
				int start = -1;
				for(int i = 0; i < len; i++)
					if(!visit[i])
					{
						start = i;
						break;
					}
				if(start == -1) break;
				for(int i = start; i < len; i+=jump)
				{
					visit[i] = true;
					aly[idx].add(arr[i]);
				}
				idx--;
				jump *= 2;
			}
			
			for(int i = 1; i < N; i++)
			{
				for(int next : aly[i])
					System.out.print(next + " ");
				System.out.println();
			}
		}
	}
}