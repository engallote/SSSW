import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] p = new int[21];
		
		for(int i = 0; i <= 20; i++)
			p[i] = (int)Math.pow(2, i);
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] ch = sc.next().toCharArray();
			String res = "";
			int cnt = 0, max = 1, sum = 0;
			Queue<Pair> q = new LinkedList<Pair>();
			
			for(int i = ch.length - 1; i >= 0; i--)
			{
				if(ch[i] == 't')//west
				{
					if((90 % p[cnt]) == 0) 
						q.offer(new Pair(90 / p[cnt], 1));
					else
					{
						int g = gcd(90, p[cnt]);
						max = Math.max(p[cnt]/g, max);
						q.offer(new Pair(90 / g, p[cnt] / g));
					}
					i -= 3;
				}
				else
				{
					if((90 % p[cnt]) == 0) 
					{
						if(cnt == 0) q.offer(new Pair(0, 1));
						else q.offer(new Pair(-(90 / p[cnt]), 1));
					}
					else
					{
						int g = gcd(90, p[cnt]);
						max = Math.max(p[cnt]/g, max);
						q.offer(new Pair(-(90 / g), p[cnt] / g));
					}
					i -= 4;
				}
				cnt++;
			}
			
			while(!q.isEmpty())
			{
				Pair pair = q.poll();
//				System.out.println("> " + pair.a + ", " + pair.b);
				if(pair.b == 1) sum += pair.a * max;
				else sum += (pair.a * (max / pair.b));
			}
			if(max != 1) res = sum + "/" + max;
			else res = sum+"";
			System.out.println("#" + test_case + " " + res);
		}
	}

	private static int gcd(int a, int b) {
		if(b == 0) return a;
		if(a < b)
		{
			int tmp = b;
			b = a;
			a = tmp;
		}
		return gcd(b, a % b);
	}
}
class Pair{
	int a, b;
	Pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
}