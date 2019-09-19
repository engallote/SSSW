import java.util.*;

public class Main {
	static int N, M, res = 0;
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char[N][M];
			res = 0;
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			
			for(int i = 0; i < N - 1; i++)
				for(int j = 0; j < M - 1; j++)
					if(arr[i][j] == '1')
					{
						if(res == 0) res = 1;
						solve(i, j);
					}
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static void solve(int x, int y) {
		int l = y - 1, r = y + 1, row = x + 1, num = 0;
		while(l >= 0 && r < M && row + num - 1 < N)
		{
			if(arr[row][l] == '0' || arr[row][r] == '0') break;
			num++;
			if(row + num - 1 >= N) break;
			l--;
			r++;
			row++;
		}
		if(res > num + 1) return;
		for(; num > 0; num--)
			if(find(x + num, y - num, y + num))
			{
				res = Math.max(res, num + 1);
				break;
			}
	}
	private static boolean find(int row, int l, int r) {
		if(l < 0 || r >= M || row >= N) return false;
		while(l <= r)
		{
			if(arr[row][l] == '0' || arr[row][r] == '0') return false;
			row++;
			if(row == N) break;
			l++;
			r--;
		}
		return l >= r ? true : false;
	}
}