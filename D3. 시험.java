import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int t = sc.nextInt();
			int p = sc.nextInt() - 1;
			sc.nextLine();
			int[][] arr =  new int[N][t + 1];
			int[] jumsu = new int[t], pass = new int[N], score = new int[N];
			int idx = 0, i, j, num = 0;
			StringTokenizer st;
			for(i = 0; i < N; i++)
			{
				idx = 0;
				st = new StringTokenizer(sc.nextLine());
				for(j = 0; j < t; j++)
				{
					num = Integer.parseInt(st.nextToken());
					if(num == 1) 
					{
						arr[i][idx] = j;
						++idx;
						++pass[i];
					}
					else ++jumsu[j];
				}
				arr[i][idx] = -1;
			}
			
			for(j = 0; j < t && arr[p][j] != -1; j++)
				score[p] += jumsu[arr[p][j]];
			
			int rate = 1;
			for(i = 0; i < N; i++)
			{
				if(i == p) continue;
				for(j = 0; j < t && arr[i][j] != -1; j++)
					score[i] += jumsu[arr[i][j]];
				if(score[i] > score[p] || (score[i] == score[p] && pass[i] > pass[p]) || (score[i] == score[p] && pass[i] == pass[p] && i < p))
					++rate;
			}
			
			System.out.println("#" + test_case + " " + score[p] + " " + rate);
		}
	}
}