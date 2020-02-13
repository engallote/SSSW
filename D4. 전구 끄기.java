import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++){
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	String ans = "DA";
        	int[] arr = new int[N+1], cost = new int[N+1];
        	Arrays.fill(arr, N - 1);
        	boolean[][] chk = new boolean[N+1][N+1];
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	
        	for(int i = 0; i < M; i++){
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		chk[a][b] = chk[b][a] = true;//off
        		arr[a] -= 1;
        		arr[b] -= 1;
        	}
        	
        	for(int i = 1; i <= N; i++)
        		pq.offer(new Pair(i, arr[i]));
        	
        	while(true){
        		Pair p = pq.poll();
        		if(p.cnt == 0) break;
        		if(cost[p.v] != 0){
        			ans = "NE";
        			break;
        		}
        		cost[p.v] = 1;
        		
        		for(int i = 1; i <= N; i++)
        			if(i != p.v){
        				if(chk[p.v][i]){
        					arr[p.v] += 1;
        					arr[i] += 1;
        				}
        				else{
        					arr[p.v] -= 1;
        					arr[i] -= 1;
        				}
        				chk[p.v][i] = !chk[p.v][i];
        				chk[i][p.v] = chk[p.v][i];
        			}
        		
        		pq.clear();
        		for(int i = 1; i <= N; i++)
        			pq.offer(new Pair(i, arr[i]));
        	}
        	
        	System.out.println("#" + test_case + " " + ans);
        }
    }
}
class Pair implements Comparable<Pair>{
	int v, cnt;
	Pair(int v, int cnt){
		this.v = v;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? 1 : -1;
	}
}