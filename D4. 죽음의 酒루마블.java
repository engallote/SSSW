import java.util.*;

public class Main {
	static int N, B;
	static final int INF = 10000000;
	static long res, count;
	static long[] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			N = sc.nextInt();
			B = sc.nextInt();//뒤로 이동하는 수
			res = INF;
			count = 0;
			chk = new boolean[N+1];
			arr = new long[N+1];
			arr[0] = -1;
			for(int i = 1; i <= N; i++)
				arr[i] = sc.nextInt();
			
			solve(0, 0, 1);
			System.out.println("#" + test_case + " " + res + " " + count);
		}
	}
	private static void solve(int idx, long drink, long cnt) {
//		System.out.println(idx + " " + drink + " " + cnt);
		for(int jump = 1; jump <= 6; jump++)
		{
			if(idx + jump <= N)
			{
				if(arr[idx + jump] != 0)
				{
					long tmp = (drink + arr[idx + jump] < 0) ? 0 : drink + arr[idx + jump];
					solve(idx + jump, tmp, cnt + 1);
				}
				else if(arr[idx + jump] == 0 && !chk[idx + jump])//처음 밟았다면 뒤로 가기
				{
					chk[idx + jump] = true;
					int index = idx + (jump - B);
					if(index < 1)
						solve(0, drink, cnt + 1);
					else
					{
						Queue<Integer> path = new LinkedList<>();
						while(index > 0 && arr[index] == 0 && !chk[index])
						{
							path.add(index);
							chk[index] = true;
							index -= B;
						}
						if(index <= 0) index = 0;
						if(chk[index]) index = (index - B) > 0 ? index - B : index;
						long tmp = (drink + arr[index] < 0) ? 0 : drink + arr[index];
						
						solve(index, tmp, cnt + 1);
						while(!path.isEmpty()) chk[path.poll()] = false;
					}
					chk[idx + jump] = false;
				}
				else if(chk[idx + jump]) solve(idx + jump, drink, cnt + 1);
				
			}
			else
			{
				if(res > drink)
				{
					res = drink;
					count = cnt;
				}
				else if(res == drink)
				{
					count = Math.min(cnt, count);
				}
			}
		}
	}
}