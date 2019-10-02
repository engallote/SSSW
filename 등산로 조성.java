import java.util.*;

public class Main {
	static int N, K, res;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	K = sc.nextInt();
        	chk = new boolean[N][N];
//        	ArrayList<Integer> path = new ArrayList<>();
        	arr = new int[N][N];
        	res = 0;
        	int max = 0;
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        		{
        			arr[i][j] = sc.nextInt();
        			max = Math.max(max, arr[i][j]);
        		}
        	
        	for(int i = 0; i < N; i++)
        		for(int j = 0; j < N; j++)
        			if(arr[i][j] == max)
            		{
        				for(int k = 0; k < N; k++)
        					Arrays.fill(chk[k], false);
        				chk[i][j] = true;
            			solve(i, j, arr[i][j], 1, 1);
            		}
        	
            System.out.println("#" + test_case + " " + res);
        }
	}
	private static void solve(int x, int y, int num, int k, int cnt) {
		res = Math.max(res, cnt);
//		for(int p : path)
//			System.out.print(p + " ");
//		System.out.println();
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] || (k == 0 && arr[nx][ny] >= num)) continue;
			
			if(k == 1 && arr[nx][ny] >= num)//±ðÀ» ¼ö ÀÖ´Ù
			{
				for(int j = 1; j <= K; j++)
				{
					if(arr[nx][ny] - j < num)
					{
						chk[nx][ny] = true;
//						path.add(arr[nx][ny]-j);
						solve(nx, ny, arr[nx][ny] - j, 0, cnt + 1);
//						path.remove(path.size()-1);
						chk[nx][ny] = false;
					}
				}
			}
			if(arr[nx][ny] < num)
			{
				chk[nx][ny] = true;
//				path.add(arr[nx][ny]);
				solve(nx, ny, arr[nx][ny], k, cnt + 1);
//				path.remove(path.size()-1);
				chk[nx][ny] = false;
			}
		}
	}		
}