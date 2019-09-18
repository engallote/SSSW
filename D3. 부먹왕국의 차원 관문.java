import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int D = sc.nextInt();
			int len = N + 2, cnt = 0;
			int[] arr = new int[len];
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			for(int i = 1; i <= N; i++)
			{
				arr[i] = sc.nextInt();
				if(arr[i] == 1) 
				{
					q.add(i);
					cnt++;
				}
			}
			q.add(N+1);
			if(D == 1)
			{
				System.out.println("#" + test_case + " " + (N - cnt));
				continue;
			}
			int res = 0, start = q.poll();
			
			while(!q.isEmpty())
			{
				int next = q.poll();
				if(next - start > D)
				{
					int div = (next - start - 1) / D;
					res += div;
				}
				start = next;
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}