import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] cost = new int[N + 1], weight = new int[M + 1], space = new int[N + 1];
			int[] arr = new int[2 * M];
			int res = 0, len = 2 * M;
			
			for(int i = 1; i <= N; i++) cost[i] = sc.nextInt();
			for(int i = 1; i <= M; i++) weight[i] = sc.nextInt();
			for(int i = 0; i < len; i++) arr[i] = sc.nextInt();
			
			boolean flag = true;
			while(flag) {
				flag = false;
				for(int i = 0; i < len; i++) {
					if(arr[i] > 0) {//in
						for(int j = 1; j <= N; j++)
							if(space[j] == 0) {
								space[j] = arr[i];
								res += cost[j] * weight[arr[i]];
								arr[i] = 0;
								flag = true;
								break;
							}
					}
					else if(arr[i] < 0) {//out
						for(int j = 1; j <= N; j++)
							if(space[j] == -arr[i]) {
								space[j] = 0;
								arr[i] = 0;
								flag = true;
								break;
							}
					}
					if(flag) break;
				}
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}