import java.util.*;

public class Main {
	static int N, res, sx, sy;
	static int[][] arr;
	static int[] dx = {1, 1, -1, -1}, dy = {1, -1, -1, 1};
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	arr = new int[N][N];
        	res = -1;
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			arr[i][j] = sc.nextInt();
        	
        	for(int i = 0; i < N - 1; i++)
        		for(int j = 1; j < N - 1; j++)
        		{
//        			System.out.println("start : " + i + " " + j);
        			sx = i;
        			sy = j;
        			solve(i, j, 0, 0);
        		}
        	
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int x, int y, int idx, int cnt) {
		if(idx == 4)
		{
			if(x == sx && y == sy) res = Math.max(res, cnt);
			return;
		}
		if(x < 0 || y < 0 || x >= N || y >= N || hs.contains(arr[x][y])) return;
		hs.add(arr[x][y]);
		solve(x + dx[idx], y + dy[idx], idx, cnt + 1);
		solve(x + dx[idx], y + dy[idx], idx + 1, cnt + 1);
		hs.remove(arr[x][y]);
	}
}