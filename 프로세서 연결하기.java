import java.util.*;
 
public class Main {
    static int N, len, res, max;
    static int[][] arr;
    static ArrayList<Pair> aly;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
            N = sc.nextInt();
            arr = new int[N][N];
            max = 0;
            aly = new ArrayList<>();
            for(int i = 0; i < N; i++)
            	for(int j = 0; j < N; j++)
            	{
            		arr[i][j] = sc.nextInt();
            		if(i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
            		if(arr[i][j] == 1)
            			aly.add(new Pair(i, j));
            	}
            len = aly.size();
            res = Integer.MAX_VALUE;
            solve(0, 0, 0);
            System.out.println("#" + test_case + " " + res);
        }
    }
	private static void solve(int idx, int cnt, int sum) {
		if(idx == len)
		{
			if(max < cnt)
			{
				max = cnt;
				res = sum;
			}
			else if(max == cnt)
				res = Math.min(res, sum);
			return;
		}
		for(int i = 0; i < 4; i++)
		{
			int ret = connect(idx, i);
			if(ret == -1)//못 이음
				solve(idx + 1, cnt, sum);
			else
			{
				solve(idx + 1, cnt + 1, sum + ret);
				undo(idx, i);//다시 원래 상태로
			}
		}
	}
	private static int connect(int idx, int d) {
		int sum = 0, x = aly.get(idx).x + dx[d], y = aly.get(idx).y + dy[d];
		//확인
		while(x >= 0 && y >= 0 && x < N && y < N)
		{
			//중간에 다른 선 or 프로세서가 존재
			if(arr[x][y] != 0) return -1;
			
			x += dx[d];
			y += dy[d];
		}			
		//실행
		x = aly.get(idx).x + dx[d];
		y = aly.get(idx).y + dy[d];
		while(x >= 0 && y >= 0 && x < N && y < N)
		{
			sum++;
			arr[x][y] = 2;
			x += dx[d];
			y += dy[d];
		}	
		return sum;
	}
	private static void undo(int idx, int d) {
		int x = aly.get(idx).x + dx[d], y = aly.get(idx).y + dy[d];
		
		while(x >= 0 && y >= 0 && x < N && y< N)
		{
			arr[x][y] = 0;
			x += dx[d];
			y += dy[d];
		}		
	}
}
class Pair{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}