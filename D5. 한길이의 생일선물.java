import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int Q = sc.nextInt();
			int idx = N;
			int[] arr = new int[N];
			Queue<Integer> q = new LinkedList<Integer>();
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			
			for(int i = 0; i < N; i++){
				arr[i] = sc.nextInt();
				pq.offer(new Pair(arr[i], i + 1));
			}
			
			for(int i = 0; i < Q; i++) 
				q.offer(sc.nextInt());
			
			boolean flag;
			int cnt = 0;
			while(!q.isEmpty()) {
				int x = q.poll();
				flag = false;
				while(!pq.isEmpty()) {
					Pair p = pq.poll();
					if(p.idx > idx) continue;
					
					if(p.num >= x) {
						flag = true;
						--idx;
						if(p.idx < idx) pq.offer(p);
						if(q.isEmpty() && cnt == 0) ++idx;
						break;
					}
					else {
						idx = Math.min(idx, p.idx);
						++cnt;
					}
				}
				if(!flag) {
					idx = 0;
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + idx);
		}
	}
}
class Pair implements Comparable<Pair>{
	int num, idx;
	Pair(int num, int idx){
		this.num = num;
		this.idx = idx;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else if(o.num == this.num) return o.idx > this.idx ? -1 : 1;
		else return 1;
	}
}