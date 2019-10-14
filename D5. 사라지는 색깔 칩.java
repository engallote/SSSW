import java.util.*;

public class Main {
	static int end = 0;
	static Pair[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	char[] ch = sc.next().toCharArray();
        	arr = new Pair[ch.length];
        	int idx = 0;
        	for(int i = 0; i < ch.length; i++)
        	{
        		char[] tmp = new char[4];
        		if(ch[i] >= '1' && ch[i] <= '4')
        		{
        			int tmpIdx = 0;
        			for(int j = i + 1; j <= i + (ch[i]-'0'); j++)
        				tmp[tmpIdx++] = ch[j];
        			arr[idx++] = new Pair(ch[i]-'0', 0, tmp);
        			i += (ch[i] - '0');
        		}
        		else
        		{
        			tmp[0] = ch[i];
        			arr[idx++] = new Pair(1, 0, tmp);
        		}
        	}
        	end = idx;
        	Pair p;
        	boolean flag = true;
        	while(flag)
        	{
        		flag = false;
        		int cnt = 0;
        		char c = '.';
        		for(int i = 0; i < end; i++)
        		{
        			p = arr[i];
        			if(c == p.c[p.idx])
        				cnt++;
        			else
        			{
        				if(cnt >= 3)
        				{
        					if(remove(i - 1, cnt))
        					{
        						flag = true;
        						break;
        					}
        				}
        				cnt = 1;
        				c = p.c[p.idx];
        			}
        		}
        		if(!flag && cnt >= 3)
        		{
//        			System.out.println("?????" + " " + cnt);
        			if(remove(end - 1, cnt))
        				flag = true;
        		}
        	}
        	
        	System.out.print("#" + test_case + " ");
        	for(int i = 0; i < end; i++)
        		if(arr[i].idx >= 0)
        			System.out.print(arr[i].c[arr[i].idx]);
        	System.out.println();
        }
	}
	private static boolean remove(int idx, int cnt) {
		boolean in = false;//기본칩 안에 색깔칩이 있는지 여부
		int change = -1, count = 0, end2 = (idx - cnt >= -1 ? idx - cnt : -1);
		for(int i = idx; i > end2; i--)
		{
			if(arr[i].num > 1)//가장 마지막에 있는 색깔칩
			{
				in = true;
				change = i;
				break;
			}
		}
		if(in)//기본칩 안에 색깔칩 있다
		{
			for(int i = change - 1; i > end2; i--)
			{
				if(arr[i].num == 1) count++;
				else break;
			}
			if(count > 0)
			{
				for(int i = change; i >= 0; i--)
				{
					if(arr[i].num > 1)//색깔칩이다
						arr[i].idx = (arr[i].idx + count) % arr[i].num;
				}
			}
		}
		else//기본칩 안에 색깔칩이 없다
		{
			if(idx + 1 < end && arr[idx+1].num > 1)//바로 뒤가 색깔칩이다
			{
				for(int i = idx + 1; i >= 0; i--)
				{
					if(arr[i].num > 1)//색깔칩이다
						arr[i].idx = (arr[i].idx + cnt) % arr[i].num;
				}
			}
		}
		
		int remove = 0;
		for(int i = idx; i > end2; i--)//기본칩 지우기
		{
			if(arr[i].num == 1)
			{
				arr[i].idx = -1;
				remove++;
			}
		}
		
		int tmp = Integer.MAX_VALUE, start = (idx - cnt >= 0 ? idx - cnt : 0);
		for(int i = start; i < end; i++)//땡기기
		{
			if(arr[i].idx == -1)
			{
				for(int j = i + 1; j < end; j++)
				{
					if(arr[j].idx >= 0)
					{
						arr[i].c = arr[j].c.clone();
						arr[i].idx = arr[j].idx;
						arr[i].num = arr[j].num;
						arr[j].idx = -1;
						break;
					}
				}
			}
			if(arr[i].idx >= 0) tmp = i + 1;
			else
			{
				if(tmp > i) tmp = i;
				break;
			}
		}
		end = tmp;
//		for(int i = 0; i < end; i++)
//			System.out.print(arr[i].c[arr[i].idx]);
//		System.out.println();
//		System.out.println("----------------------------------------------------------------------");
		if(remove > 0) return true;
		else return false;
	}
}
class Pair{
	int num, idx;
	char[] c = new char[4];
	Pair(int num, int idx, char[] c)
	{
		this.num = num;
		this.idx = idx;
		this.c = c;
	}
}
/*
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static ArrayList<Pair> arr = new ArrayList<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	char[] ch = sc.next().toCharArray();
        	arr.clear();
        	for(int i = 0; i < ch.length; i++)
        	{
        		if(ch[i] >= '1' && ch[i] <= '4')
        		{
        			ArrayList<Character> tmp = new ArrayList<>();
        			for(int j = i + 1; j <= i + (ch[i]-'0'); j++)
        				tmp.add(ch[j]);
        			arr.add(new Pair(ch[i]-'0', 0, tmp));
        			i += (ch[i] - '0');
        		}
        		else
        		{
        			ArrayList<Character> tmp = new ArrayList<>();
        			tmp.add(ch[i]);
        			arr.add(new Pair(1, 0, tmp));
        		}
        	}
        	Pair p;
        	boolean flag = true;
        	while(flag)
        	{
        		flag = false;
        		int cnt = 0;
        		char c = '.';
        		for(int i = 0; i < arr.size(); i++)
        		{
        			p = arr.get(i);
        			if(c == p.c.get(p.idx))
        				cnt++;
        			else
        			{
        				if(cnt >= 3)
        				{
        					if(remove(i - 1, cnt))
        					{
        						flag = true;
        						break;
        					}
        				}
        				cnt = 1;
        				c = p.c.get(p.idx);
        			}
        		}
        		if(!flag && cnt >= 3)
        		{
//        			System.out.println("?????" + " " + cnt);
        			if(remove(arr.size() - 1, cnt))
        				flag = true;
        		}
        	}
        	
        	System.out.print("#" + test_case + " ");
        	for(Pair pp : arr)
        		System.out.print(pp.c.get(pp.idx));
        	System.out.println();
        }
	}
	private static boolean remove(int idx, int cnt) {
		boolean in = false;//기본칩 안에 색깔칩이 있는지 여부
		int change = -1, count = 0;
		for(int i = idx; i > Math.max(-1, idx - cnt); i--)
		{
			if(arr.get(i).c.size() > 1)//가장 마지막에 있는 색깔칩
			{
				in = true;
				change = i;
				break;
			}
		}
		if(in)//기본칩 안에 색깔칩 있다
		{
			for(int i = change - 1; i > Math.max(-1, idx - cnt); i--)
			{
				if(arr.get(i).c.size() == 1) count++;
				else break;
			}
//			if(count == 0) return false;//기본칩이 없다면 나가기
			if(count > 0)
			{
				for(int i = change; i >= 0; i--)
				{
					if(arr.get(i).c.size() > 1)//색깔칩이다
						arr.get(i).idx = (arr.get(i).idx + count) % arr.get(i).c.size();
				}
			}
		}
		else//기본칩 안에 색깔칩이 없다
		{
			if(idx + 1 < arr.size() && arr.get(idx+1).c.size() > 1)//바로 뒤가 색깔칩이다
			{
				for(int i = idx + 1; i >= 0; i--)
				{
					if(arr.get(i).c.size() > 1)//색깔칩이다
						arr.get(i).idx = (arr.get(i).idx + cnt) % arr.get(i).c.size();
				}
			}
		}
		
		int remove = 0;
		for(int i = idx; i > Math.max(-1, idx - cnt); i--)//기본칩 지우기
		{
			if(arr.get(i).c.size() == 1)
			{
				arr.remove(i);
				remove++;
			}
		}
		
//		for(int i = 0; i < arr.size(); i++)
//			System.out.print(arr.get(i).c.get(arr.get(i).idx));
//		System.out.println();
//		System.out.println("----------------------------------------------------------------------");
		if(remove > 0) return true;
		else return false;
	}
}
class Pair{
	int num, idx;
	ArrayList<Character> c = new ArrayList<>();
	Pair(int num, int idx, ArrayList<Character> c)
	{
		this.num = num;
		this.idx = idx;
		this.c = c;
	}
}
*/