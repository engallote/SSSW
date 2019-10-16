import java.util.*;

public class Main {
	static int N, M, len, res;
	static char[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = Integer.MAX_VALUE;
        	arr = sc.next().toCharArray();
        	len = arr.length;
        	N = sc.nextInt();
        	M = sc.nextInt();
        	if(arr[0] == '0')
        	{
        		for(int i = 0; i < N; i++)
        			arr[i] = (arr[i] == '0') ? '1' : '0';
        		solve(0, 1);
        	}
        	else
        		solve(0, 0);
        	if(res == Integer.MAX_VALUE) res = -1;
            System.out.println("#" + test_case + " " + res);
        }
    }
	private static void solve(int idx, int cnt) {
		if(idx == len)
		{
//			for(char c : arr)
//				System.out.print(c+"");
//			System.out.println("====");
			res = Math.min(res, cnt);
			return;
		}
		if(idx + 1 < len && arr[idx] == '1' && arr[idx+1] == '1')
			solve(idx + 1, cnt);
		if(idx == len - 1 && arr[idx] == '1')
			solve(idx + 1, cnt);
		if(idx + N < len)
		{
			char[] tmp = new char[N];
			int index = 0;
			for(int j = idx + 1; j <= idx + N; j++)
				tmp[index++] = arr[j];
			for(int j = idx + 1; j <= idx + N; j++)
				arr[j] = (arr[j] == '1') ? '0' : '1';
			if(arr[idx+1] == '1')
				solve(idx + 1, cnt + 1);
			index = 0;
			for(int j = idx + 1; j <= idx + N; j++)
				arr[j] = tmp[index++];
		}
	}
}