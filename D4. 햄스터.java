import java.util.*;

public class Main {
	static int N, X, M, cnt;
	static String str;
	static Pair[] arr;
	static PriorityQueue<String> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();//우리 개수
			X = sc.nextInt();//각 우리에 있을 수 있는 최대 햄스터 수
			M = sc.nextInt();//질의 개수
			ans = new PriorityQueue<>();//정답 삽입
			cnt = -1;//최대 햄스터 수
			arr = new Pair[M];//질의문 배열
			int[] res = new int[N+1];//각 우리에 있는 햄스터 배열
			
			for(int i = 0; i < M; i++) 
				arr[i] = new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt());
			
			str = "-1";
			solve(1, res);
//			if(cnt != -1) str = ans.poll();
			System.out.println("#" + test_case + " " + str);
		}
	}
	private static void solve(int idx, int[] res) {
		if(idx > N)
		{
			int sum = 0;
			for(int i = 0; i < M; i++)
			{
				sum = 0;
				for(int j = arr[i].l; j <= arr[i].r; j++)
					sum += res[j];
				
				if(sum != arr[i].s) return;
			}
			
			StringBuilder sb = new StringBuilder();
			sum = 0;
			for(int i = 1; i <= N; i++)
			{
				sum += res[i];
				sb.append(res[i] + " ");
			}
			
			if(cnt < sum)//더 많은 수의 햄스터 배치 찾음
			{
				str = sb.toString().trim();
//				System.out.println(sb.toString() + " ==> " + sum);
//				ans.clear();//refresh
				cnt = sum;
//				ans.offer(sb.toString().trim());
			}
			else if(cnt == sum)//기존 수와 같은 햄스터 수 
			{
				str = sb.toString().trim();
//				System.out.println(sb.toString() + " ==> " + sum);
//				ans.offer(sb.toString().trim());
			}
			
			return;
		}
		
		for(int i = X; i >= 0; i--)
		{
			res[idx] = i;
			solve(idx + 1, res);
			res[idx] = 0;
		}
	}
}
class Pair{
	int l, r, s;
	Pair(int l, int r, int s){
		this.l = l;
		this.r = r;
		this.s = s;
	}
}