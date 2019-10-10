import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int res = 0, len = (int)Math.pow(2, N), a, b, size;
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0; i < len / 2; i++)
			{
				a = sc.nextInt();
				b = sc.nextInt();
				res += Math.abs(a - b);
				q.offer(Math.max(a, b));
			}
			len /= 2;
			while(len > 1)
			{
				size = q.size();
				while(size > 0 && !q.isEmpty())
				{
					size -= 2;
					a = q.poll();
					b = q.poll();
					res += Math.abs(a-b);
					q.offer(Math.max(a, b));
				}
				len /= 2;
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}