import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][] chk = new int[N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
				{
					arr[i][j] = sc.nextInt();
					chk[i][j] = 1000000000;
				}
			int fiv = 0, two = 0, number = arr[0][0];
			if(number == 0) fiv = two = 1;
			while(true)
			{
				if(number == 0) break;
				while(number % 2 == 0)
				{
					two++;
					number /= 2;
				}
				while(number % 5 == 0)
				{
					fiv++;
					number /= 5;
				}
				break;
			}
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			pq.add(new Pair(0, 0, two, fiv));
			chk[0][0] = Math.min(two, fiv);
			
			while(!pq.isEmpty())
			{
				Pair p = pq.poll();
				
				if(p.x == N - 1 && p.y == N - 1) break;
				if(p.x + 1 < N && arr[p.x + 1][p.y] != 0)
				{
					int num = arr[p.x + 1][p.y], t = p.two, f = p.fiv;
					
					while(true)
					{
						if(num == 0) break;
						while(num % 2 == 0)
						{
							t++;
							num /= 2;
						}
						while(num % 5 == 0)
						{
							f++;
							num /= 5;
						}
						break;
					}
					
					if(chk[p.x + 1][p.y] > Math.min(t, f))
					{
						chk[p.x + 1][p.y] = Math.min(t, f);
						pq.add(new Pair(p.x + 1, p.y, t, f));
					}
				}
				if(p.y + 1 < N && arr[p.x][p.y + 1] != 0)
				{
					int num = arr[p.x][p.y + 1], t = p.two, f = p.fiv;
					
					while(true)
					{
						if(num == 0) break;
						while(num % 2 == 0)
						{
							t++;
							num /= 2;
						}
						while(num % 5 == 0)
						{
							f++;
							num /= 5;
						}
						break;
					}
					if(chk[p.x][p.y + 1] > Math.min(t, f))
					{
						chk[p.x][p.y + 1] = Math.min(t, f);
						pq.add(new Pair(p.x, p.y + 1, t, f));
					}
				}
			}
			
//			for(int i = 0; i < N; i++)
//			{
//				for(int j = 0; j < N; j++)
//					System.out.print(chk[i][j] + " ");
//				System.out.println();
//			}
			
			System.out.println("#" + test_case + " " + chk[N-1][N-1]); 
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, two, fiv;
	Pair(int x, int y, int two, int fiv)
	{
		this.x = x;
		this.y = y;
		this.two = two;
		this.fiv = fiv;
	}
	@Override
	public int compareTo(Pair o) {
		return Math.min(o.two, o.fiv) > Math.min(this.fiv, this.two) ? -1 : 1;
	}
}