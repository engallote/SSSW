import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] c = sc.next().toCharArray();
			HashSet<Character> hs = new HashSet<>();
			for(char cc : c) hs.add(cc);
			System.out.println("#" + test_case + " " + hs.size());
		}
	}
}