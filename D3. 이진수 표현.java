import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[] ch = Integer.toBinaryString(M).toCharArray();
			boolean flag = true;
			for(int i = ch.length - 1; i >= Math.max(ch.length - N, 0); i--)
				if(ch[i] == '0'){
					flag = false;
					break;
				}
			
			System.out.print("#" + test_case + " ");
			if(flag && ch.length >= N) System.out.println("ON");
			else System.out.println("OFF");
		}
	}
}