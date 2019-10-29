import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	String res = "";
        	char[] c = sc.next().toCharArray();
        	int len = c.length;
        	String[] str = new String[len+1];
        	Arrays.fill(str, "");
        	
        	for(int i = 1; i <= c.length; i++)
        	{
        		str[i] = "" + c[i-1];
        	}
        	
        	int H = sc.nextInt();
        	for(int i = 0; i < H; i++)
        	{
        		int insertIdx = sc.nextInt();
        		str[insertIdx] += "-";
        	}
        	
        	for(int i = 0; i <= len; i++)
        	{
        		res += str[i];
        	}
        	System.out.println("#" + test_case + " " + res);
        }
    }
}