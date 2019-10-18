import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        Tree[] tree = new Tree[10001];
        tree[1] = new Tree(1, 1, 2, 3);
        int l = 2, r = 3, cur = 1, len = 2;
        
        
        for(int i = 2; i <= 10000; i++)
        {
        	if(cur == 1)
        		tree[i] = new Tree(i, i + 1, i + l, i + r);
        	else if(cur == len)
        		tree[i] = new Tree(i - 1, i, i + l, i + r);
        	else
        		tree[i] = new Tree(i - 1, i + 1, i + l, i + r);
        	cur++;
        	if(cur > len)
        	{
        		len++;
        		cur = 1;
        		l++;
        		r++;
        	}
        }
        
//        for(int i = 1; i <= 28; i++)
//        	System.out.println(i +", " + tree[i].sidea + " - " + tree[i].sideb);
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int res = 0;
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int[] visit = new int[10001];
        	Arrays.fill(visit, 1000000);
        	if(a > b)
        	{
        		int tmp = a;
        		a = b;
        		b = tmp;
        	}
        	
        	PriorityQueue<Pair> pq = new PriorityQueue<>();
        	pq.add(new Pair(a, 0));
        	visit[a] = 0;
        	while(!pq.isEmpty())
        	{
        		Pair p = pq.poll();
//        		System.out.println(p.num);
        		if(p.num >= b)
        		{
        			res = p.cnt;
        			continue;
        		}
        		
        		if(tree[p.num].left <= 10000 && visit[tree[p.num].left] > p.cnt + 1)
        		{
        			visit[tree[p.num].left] = p.cnt + 1;
        			pq.add(new Pair(tree[p.num].left, p.cnt + 1));
        		}
        		if(tree[p.num].right <= 10000 && visit[tree[p.num].right] > p.cnt + 1)
        		{
        			visit[tree[p.num].right] = p.cnt + 1;
        			pq.add(new Pair(tree[p.num].right, p.cnt + 1));
        		}
        		if(tree[p.num].sidea <= 10000 && visit[tree[p.num].sidea] > p.cnt + 1)
        		{
        			visit[tree[p.num].sidea] = p.cnt + 1;
        			pq.add(new Pair(tree[p.num].sidea, p.cnt + 1));
        		}
        		if(tree[p.num].sideb <= 10000 && visit[tree[p.num].sideb] > p.cnt + 1)
        		{
        			visit[tree[p.num].sideb] = p.cnt + 1;
        			pq.add(new Pair(tree[p.num].sideb, p.cnt + 1));
        		}
        	}
        	System.out.println("#" + test_case + " " + visit[b]);
        }
    }
}
class Tree{
	int sidea, sideb, left, right;
	Tree(int sidea, int sideb, int left, int right)
	{
		this.sidea = sidea;
		this.sideb = sideb;
		this.left = left;
		this.right = right;
	}
}
class Pair implements Comparable<Pair>{
	int num, cnt;
	Pair(int num, int cnt)
	{
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}