import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        String[] num = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111",
        		"0111011", "0110111", "0001011"};
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int res = 0;
        	Vector<Integer> v = new Vector<>();
        	for(int i = 0; i < N; i++)
        	{
        		char[] c = sc.next().toCharArray();
        		if(v.size() == 8) continue;
        		for(int j = c.length - 1; j >= 0; j--)
        		{
        			if(c[j] == '1')
        			{
        				int idx = j;
        				StringBuilder s = new StringBuilder();
        				for(int k = 6; k >= 0; k--)
        				{
        					s.append(c[idx]);
        					idx--;
        				}
        				s.reverse();
        				for(int k = 0; k < 10; k++)
        					if(s.toString().equals(num[k]))
        					{
        						v.add(k);
        						break;
        					}
        				j = idx + 2;
        			}
        		}
        	}
//        	for(int i = 0; i < v.size(); i++)
//        		System.out.println(">>>> " + v.get(i));
        	int tmp = (v.get(1) + v.get(3) + v.get(5) + v.get(7)) * 3 + v.get(0) + v.get(2) + v.get(4) + v.get(6);
        	if(tmp % 10 == 0)
        		for(int i = 0; i < v.size(); i++)
        			res += v.get(i);
        	else
        		res = 0;
        	System.out.println("#" + test_case + " " + res);
        }
	}
}