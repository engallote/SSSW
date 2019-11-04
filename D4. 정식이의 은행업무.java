import java.util.*;

public class Main {
	static int res;
	static char[] arr1, arr2;
	static boolean[] chk1, chk2;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	res = 0;
        	arr1 = sc.next().toCharArray();
        	arr2 = sc.next().toCharArray();
        	chk1 = new boolean[arr1.length];
        	chk2 = new boolean[arr2.length];
        	hs.clear();
        	
        	int len = arr1.length;
        	for(int i = 0; i < len; i++)
        	{
        		if(arr1[i] == '0')
        		{
        			arr1[i] = '1';
        			int tmp = 0;
        			int two = 1;
        			for(int j = len - 1; j >= 0; j--)
        			{
        				tmp += ((arr1[j] - '0') * two);
        				two *= 2;
//        				if(j < len - 1)
//        					tmp *= 10;
        			}
        			hs.add(tmp);
        			arr1[i] = '0';
        		}
        		else
        		{
        			arr1[i] = '0';
        			int tmp = 0;
        			int two = 1;
        			for(int j = len - 1; j >= 0; j--)
        			{
        				tmp += ((arr1[j] - '0') * two);
        				two *= 2;
//        				if(j < len - 1)
//        					tmp *= 10;
        			}
        			hs.add(tmp);
        			arr1[i] = '1';
        		}
        	}
        	
        	len = arr2.length;
        	Iterator<Integer> it = hs.iterator();
        	while(it.hasNext())
        	{
        		int num = it.next();
        		String num2 = Integer.toString(num, 3);
//        		System.out.println(num + " " + num2);
        		if(num2.length() == len)
        		{
        			int cnt = 0;
        			for(int i = 0; i < len; i++)
        				if(arr2[i] != num2.charAt(i))
        					cnt++;
        			if(cnt == 1)
        			{
        				res = num;
        				break;
        			}
        		}
        	}
        	
        	System.out.println("#" + test_case + " " + res);
        }
	}
}