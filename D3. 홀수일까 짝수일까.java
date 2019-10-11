import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t <= tc; t++)
        {
        	char[] c = sc.next().toCharArray();
        	int num = c[c.length - 1] - '0';
        	if(num % 2 == 0)
        		System.out.println("#"+t+" "+"Even");
        	else
        		System.out.println("#"+t+" "+"Odd");
        }
    }
}