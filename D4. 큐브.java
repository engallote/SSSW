import java.util.*;

public class Main {
	static int N, max, count;
	static int[] arr = new int[466], num = new int[466];
	static int[][] arr2 = new int[17][466];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        num[1] = 1;
        for(int i = 2; i < 465; i++)
        	num[i] = (int)Math.pow(i, 3);
        num[465] = 100000001;
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	N = sc.nextInt();
        	Arrays.fill(arr, 0);
        	for(int i = 0; i < 17; i++)
        		Arrays.fill(arr2[i], 0);
        	count = 0;
        	max = 0;
    		solve(0, 1, 0);
        	System.out.println("#" + test_case + " " + count + " " + max);
        }
    }
	private static void solve(int cnt, int idx, int now) {
		if(count <= cnt && max < now)
		{
//			System.out.println(now + ", " + cnt);
			count = cnt;
			max = now;
		}
		if(num[idx] + now > N) return;
		for(int i = idx; i < 465; i++)
		{
			int tmp = num[i] + now;
			if((arr2[cnt][i] == 0 || arr[i] <= tmp) && tmp <= N && tmp < num[i+1])
			{
				arr2[cnt][i] = i;
				arr[i] = tmp;
				solve(cnt + 1, i, tmp);
			}
		}
	}
}