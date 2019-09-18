import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int[] arr = new int[2001];
			System.out.print("#" + test_case + " ");
			
			int sum = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0; i < N; i++)
			{
				int time = sc.nextInt();
				pq.offer(time);
				arr[time]++;
			}
			
			for(int i = 1; i <= 2000; i++)
			{
				if(arr[i] == 1) sum++;
				if(sum >= A)
				{
					int div = (sum / 2) + (sum % 2);
//					System.out.println(sum + " " + div);
					for(int j = 0; j < div; j++)
					{
						pq.poll();
						System.out.print(i + " ");
					}
					sum -= div;
				}
				else if(!pq.isEmpty() && pq.peek() == i - B)
				{
					int div = (sum / 2) + (sum % 2);
//					System.out.println(sum + " " + div);
					for(int j = 0; j < div; j++)
					{
						pq.poll();
						System.out.print(i + " ");
					}
					sum -= div;
				}
			}
			System.out.println();
		}
	}
}