import java.util.Scanner;

public class Main {
	static int N, M;
	static long res;
	static int[][] arr = new int[5][5];
	static boolean[][] chk = new boolean[5][5];
	static int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = 0;
        	N = sc.nextInt();
        	for(int i = 0; i < 5; i++)
        		for(int j = 0; j < 5; j++)
        			arr[i][j] = sc.nextInt();

        	for(int i = 0; i < 5; i++)
        		for(int j = 0; j < 5; j++)
        		{
        			solve(i, j, 0, true);
        			solve(i, j, 0, false);
        		}
            System.out.println("#" + test_case + " " + res);
        }
    }
	private static void solve(int r, int c, int cnt, boolean up) {
		res = Math.max(res, cnt);
		
		for(int i = 0; i < 4; i++)
		{
			int nr = r + dr[i], nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || chk[nr][nc]) continue;
			if(up && arr[nr][nc] > arr[r][c])
			{
				chk[nr][nc] = true;
				solve(nr, nc, cnt + 1, false);
				chk[nr][nc] = false;
			}
			else if(!up && arr[nr][nc] < arr[r][c])
			{
				chk[nr][nc] = true;
				solve(nr, nc, cnt + 1, true);
				chk[nr][nc] = false;
			}
		}
	}
}