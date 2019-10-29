import java.util.*;

public class Main {
	static int[] arr;
	static int min = Integer.MAX_VALUE, N, B;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int t = 1; t <= tc; t++)
        {
        	N = sc.nextInt();
        	B = sc.nextInt();
        	arr = new int[N];
        	min = Integer.MAX_VALUE;
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	Arrays.sort(arr);
        	solve(0, 0);
//        	System.out.println(min);
        	System.out.println("#" + t + " " + Math.abs(B - min));
        }
    }

	private static void solve(int idx, int sum) {
		if(sum >= B)
			min = Math.min(min, sum);
		if(idx == N) return;
		solve(idx + 1, sum + arr[idx]);
		solve(idx + 1, sum);
	}
}