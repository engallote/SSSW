import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			long N = sc.nextLong();
			long num = (long)Math.sqrt(N * 2);
			
			System.out.print("#" + test_case + " ");
			if(num * (num + 1) / 2 == N) System.out.println(num);
			else System.out.println(-1);
		}
	}
}