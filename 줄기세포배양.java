import java.util.*;

public class Main {
	static int N, M, res;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	M = sc.nextInt();
        	int K = sc.nextInt();
        	HashSet<String> hs = new HashSet<>();
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < M; j++)
        		{
        			int num = sc.nextInt();
        			if(num == 0) continue;
        			pq.add(new Pair(i, j, num, num, num - 1));
        			hs.add(i+","+j);
        		}
        	PriorityQueue<Pair> tmp = new PriorityQueue<>();
        	for(int t = 0; t < K; t++)
        	{
        		tmp.clear();
        		while(!pq.isEmpty())
        		{
        			Pair p = pq.poll();
//        			System.out.println(p.x + " " + p.y + " " + p.num + " " + p.cnt);
        			if(p.cnt == 0)
        			{
        				for(int i = 0; i < 4; i++)
        				{
        					int nx = p.x + dx[i], ny = p.y + dy[i];
        					String key = nx + "," + ny;
        					if(hs.contains(key)) continue;
        					hs.add(key);
//        					System.out.println("new : " + nx + " " + ny + " " + p.num);
        					tmp.add(new Pair(nx, ny, p.num, p.num, p.num));
        				}
        				if(p.keep - 1 >= 1)
        					tmp.add(new Pair(p.x, p.y, p.num, p.cnt, p.keep - 1));
        			}
        			else
        				tmp.add(new Pair(p.x, p.y, p.num, p.cnt - 1, p.keep));
        		}
//        		System.out.println("---------------");
        		pq.addAll(tmp);
        	}
        	
        	res = pq.size();
        	
            System.out.println("#" + test_case + " " + res);
            
        }
	}		
}
class Pair implements Comparable<Pair>{
	int x, y, num, cnt, keep;
	Pair(int x, int y, int num, int cnt, int keep)
	{
		this.x = x;
		this.y = y;
		this.num = num;
		this.cnt = cnt;
		this.keep = keep;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return -1;
		else if(o.cnt == this.cnt)
		{
			if(o.num > this.num) return 1;
			else if(o.num == this.num) return 0;
			else return -1;
		}
		else return 1;
	}
}