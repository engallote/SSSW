import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	String res = "";
        	Vector<Character> v = new Vector<>();
        	int N = sc.nextInt();
        	boolean[][] chk = new boolean[N][N];
        	
        	for(int i = 0; i < N; i++)
        		v.add(sc.next().charAt(0));
        	
        	PriorityQueue<Pair> q = new PriorityQueue<>();
        	q.add(new Pair(0, N-1, 0, ""));
        	
        	while(!q.isEmpty())
        	{
        		Pair p = q.poll();
        		if(p.cnt == N)
        		{
        			res = p.str;
        			break;
        		}
        		if(!chk[p.s][p.cnt])
        		{
        			chk[p.s][p.cnt] = true;
//        			System.out.println(p.str + v.get(p.s));
        			q.add(new Pair(p.s + 1, p.e, p.cnt + 1, p.str + v.get(p.s)));
        		}
        		if(!chk[p.e][p.cnt])
        		{
        			chk[p.e][p.cnt] = true;
//        			System.out.println(p.str + v.get(p.e));
        			q.add(new Pair(p.s, p.e - 1, p.cnt + 1, p.str + v.get(p.e)));
        		}
        	}
        	System.out.println("#" + test_case + " " + res);
        }
    }
}
class Pair implements Comparable<Pair>{
	int s, e, cnt;
	String str;
	Pair(int s, int e, int cnt, String str)
	{
		this.s = s;
		this.e = e;
		this.cnt = cnt;
		this.str = str;
	}
	@Override
	public int compareTo(Pair o) {
		char[] a = o.str.toCharArray();
		char[] b = this.str.toCharArray();
		int len = Math.min(a.length, b.length);
		for(int i = 0; i < len; i++)
		{
			if(a[i] - 'A' < b[i] - 'A') return 1;
			else if(a[i] - 'A' > b[i] - 'A') return -1;
			else continue;
		}
		if(a.length > b.length) return -1;
		else return 1;
	}
}