import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			char[] ch = sc.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			
			for(int i = ch.length - 1; i >= 0; i--) {
				if(ch[i] == 'b') sb.append('d');
				else if(ch[i] == 'd') sb.append('b');
				else if(ch[i] == 'p') sb.append('q');
				else sb.append('p');
			}
			
			System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}