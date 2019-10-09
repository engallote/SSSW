import java.util.*;

public class Main {
	static int N;
	static int[][] arr = new int[4][8];
	static boolean[] chk = new boolean[4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			for(int i = 0; i < 4; i++)
				for(int j = 0; j < 8; j++)
					arr[i][j] = sc.nextInt();
			int res = 0;
			while(N > 0)
			{
				N--;
				int idx = sc.nextInt() - 1;
				int num = sc.nextInt();
				Arrays.fill(chk, false);
				if(num == -1) rotateLeft(idx);
				else rotateRight(idx);
			}
			
			res = arr[0][0] + (arr[1][0] * 2) + (arr[2][0] * 4) + (arr[3][0] * 8);
			
			System.out.println("#" + test_case + " " + res);
		}
	}
	private static void rotateRight(int idx) {
		boolean l = false, r = false;
		chk[idx] = true;
		if(idx - 1 >= 0 && !chk[idx-1] && arr[idx][6] != arr[idx-1][2]) l = true;
		if(idx + 1 < 4 && !chk[idx+1] && arr[idx][2] != arr[idx+1][6]) r = true;
		int num = arr[idx][7];
		for(int i = 7; i > 0; i--)
			arr[idx][i] = arr[idx][i-1];
		arr[idx][0] = num;
		if(l) rotateLeft(idx - 1);
		if(r) rotateLeft(idx + 1);
	}
	private static void rotateLeft(int idx) {
		boolean l = false, r = false;
		chk[idx] = true;
		if(idx - 1 >= 0 && !chk[idx-1] && arr[idx][6] != arr[idx-1][2]) l = true;
		if(idx + 1 < 4 && !chk[idx+1] && arr[idx][2] != arr[idx+1][6]) r = true;
		int num = arr[idx][0];
		for(int i = 0; i < 7; i++)
			arr[idx][i] = arr[idx][i+1];
		arr[idx][7] = num;
		if(l) rotateRight(idx - 1);
		if(r) rotateRight(idx + 1);
	}
}