import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			char[] ch1 = sc.next().toCharArray();
			char[] ch2 = sc.next().toCharArray();
			char[] ch3 = sc.next().toCharArray();
			HashSet<Character> hs = new HashSet<>();
			int res = 0;
			
			for(int i = 0; i < N; i++){
				hs.clear();
				hs.add(ch1[i]);
				hs.add(ch2[i]);
				hs.add(ch3[i]);
				
				if(hs.size() == 3) res += 2;
				else if(hs.size() == 2) res += 1;
			}
			
			System.out.println("#" + test_case + " " + res);
		}
	}
}