import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        HashSet<Character> one = new HashSet<>();
        one.add('A');
        one.add('D');
        one.add('O');
        one.add('P');
        one.add('Q');
        one.add('R');
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	char[] a = sc.next().toCharArray();
        	char[] b = sc.next().toCharArray();
        	
        	int alen = a.length, blen = b.length;
        	if(alen != blen)
        	{
        		System.out.println("#" + test_case + " DIFF");
        		continue;
        	}
        	
        	boolean flag = true;
        	for(int i = 0; i < alen; i++)
        	{
        		if((a[i] == 'B' && b[i] == 'B') || (one.contains(a[i]) && one.contains(b[i])) || (a[i] != 'B' && b[i] != 'B' && !one.contains(a[i]) && !one.contains(b[i]))) continue;
        		else
        		{
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag)
        		System.out.println("#" + test_case + " SAME");
        	else
        		System.out.println("#" + test_case + " DIFF");
        }
	}
}