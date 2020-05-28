import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			
			int res = N * 2;
			int h = 0, m = 0;
			
			h = res / 60;
			m = res % 60;
			
			System.out.println("#" + test_case + " " + h + " " + m);
		}
	}
}