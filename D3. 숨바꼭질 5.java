import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
            int K = sc.nextInt();
            int res = -1;
            int[][] chk = new int[2][500001];
            for(int i = 0; i < 2; i++)
            	Arrays.fill(chk[i], Integer.MAX_VALUE);
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(N, 0));
            chk[0][N] = 0;
            
            while(!pq.isEmpty())
            {
            	Pair p = pq.poll();
            	
            	if(p.x + 1 <= 500000 && chk[(p.cnt + 1) % 2][p.x + 1] > p.cnt + 1)
            	{
            		chk[(p.cnt + 1) % 2][p.x + 1] = p.cnt + 1;
            		pq.add(new Pair(p.x + 1, p.cnt + 1));
            	}
            	if(p.x * 2 <= 500000 && chk[(p.cnt + 1) % 2][p.x * 2] > p.cnt + 1)
            	{
            		chk[(p.cnt + 1) % 2][p.x * 2] = p.cnt + 1;
            		pq.add(new Pair(p.x * 2, p.cnt + 1));
            	}
            	if(p.x - 1 >= 0 && chk[(p.cnt + 1) % 2][p.x - 1] > p.cnt + 1)
            	{
            		chk[(p.cnt + 1) % 2][p.x - 1] = p.cnt + 1;
            		pq.add(new Pair(p.x - 1, p.cnt + 1));
            	}
            }
            
            int cur = K, time = 0;
            while(cur <= 500000)
            {
            	if(cur < 0)
            	{
            		cur += time;
            		time++;
            		continue;
            	}
            	
            	if(chk[time%2][cur] <= time)
            	{
            		res = time;
            		break;
            	}
            	cur += time + 1;
            	time++;
            }
            System.out.println("#" + test_case + " " + res);
        }
	}
}
class Pair implements Comparable<Pair>{
	int x, cnt;
	Pair(int x, int cnt)
	{
		this.x = x;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}
//https://blog.naver.com/amjong2/221503772543