import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			char[] ch = sc.next().toCharArray();
			long b = 0, sum = 0;
			
			for(int i = 0; i < ch.length; i++){
				if(ch[i] == 'B') ++b;
				else if(ch[i] == 'W') sum += b;
			}
			
			System.out.println("#" + test_case + " " + sum);
		}
	}
}