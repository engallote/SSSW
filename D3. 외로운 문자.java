import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			char[] ch = sc.next().toCharArray();
			int[] alp = new int[26];
			
			for(char c : ch)
				alp[c-'a'] += 1;
			
			System.out.print("#" + test_case + " ");
			boolean flag = true;
			for(int i = 0; i < 26; i++)
				if(alp[i] % 2 != 0) {
					flag = false;
					System.out.print((char)(i+'a'));
				}
			if(flag) System.out.println("Good");
			else System.out.println();
		}
	}
}