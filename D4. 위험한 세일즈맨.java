import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int V, E, res, s, e;
	static int[] chk;
	static HashSet<Long> visit;
	static boolean[] danger;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	V = Integer.parseInt(st.nextToken());
        	E = Integer.parseInt(st.nextToken());
        	s = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	res = -1;
        	chk = new int[V+1];
        	visit = new HashSet<>();
        	arr = new ArrayList[V+1];
        	Arrays.fill(chk, Integer.MAX_VALUE);
        	danger = new boolean[V+1];
        	int N = Integer.parseInt(br.readLine());
        	for(int i = 0; i < N; i++)
        	{
        		int num = Integer.parseInt(br.readLine());
        		danger[num] = true;
        	}
        	
        	for(int i = 1; i <= V; i++)
        		arr[i] = new ArrayList<>();
        	
        	for(int i = 0; i < E; i++)
        	{
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		arr[a].add(b);
        		arr[b].add(a);
        	}
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	pq.add(new Pair(s, 0));
        	chk[s] = 0;
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
        		if(p.x == e)
        		{
        			res = p.c;
        			break;
        		}
        		if(arr[p.x].size() == 0) continue;
        		for(int next : arr[p.x])
        		{
        			if(danger[next] && !visit.contains((long)p.x*1000+next) && chk[next] >= p.c + 1)
        			{
//        				System.out.println(p.x + " - > " + next);
        				visit.add((long)p.x*1000+next);
        				chk[next] = p.c + 1;
        				pq.add(new Pair(next, p.c + 1));
        			}
        			else if(chk[next] >= p.c && !visit.contains((long)p.x*1000+next))
        			{
//        				System.out.println(p.x + " - > " + next);
        				visit.add((long)p.x*1000+next);
        				chk[next] = p.c;
        				pq.add(new Pair(next, p.c));
        			}
        		}
        	}
        	if(res == -1) res = 0;
        	bw.write("#" + test_case + "\n" + res + "\n");
//        	System.out.println("#" + test_case);
//        	System.out.println(res == -1 ? 0 : res);
        }
        bw.flush();
    }
}
class Pair implements Comparable<Pair>{
	int x, c;
	Pair(int x, int c)
	{
		this.x = x;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? -1 : 1;
	}
}