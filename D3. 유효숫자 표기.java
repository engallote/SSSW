import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			char[] ch = sc.next().toCharArray();
			double N = Double.parseDouble(ch[0]+"."+ch[1] + "" + ch[2]);
			String str = String.format("%.1f", N);
			int len = ch.length - 1;
			
			if(ch[0] == '9' && ch[1] == '9' && (ch[2] >= '5' && ch[2] <= '9')){
				str = "1.0";
				len += 1;
			}
			
			System.out.println("#" + test_case + " " + str + "*10^" + len);
		}
	}
}