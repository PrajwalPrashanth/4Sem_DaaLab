import java.util.*;
public class KnapsackDynamic
{
	public static int max(int a, int b )
	{
		return(a>b)?a:b;
	}
	public static void knapsack(int n,int w[],int p[],int m,int v[][])
	{
		int x[]=new int[n+1];
		int i=0,j=0;
		for(i=0;i<=n;i++)
			for(j=0;j<=m;j++)
				if( i==0 || j==0)
					v[i][j]=0;
				else if (w[i]>j)
					v[i][j]=v[i-1][j];
				else
					v[i][j]=max(v[i-1][j],v[i-1][j-w[i]]+p[i]);
		System.out.println("Output is");
		for(i=0;i<=n;i++)
		{
				for(j=0;j<=m;j++)
					System.out.print(v[i][j]+"\t");
			System.out.println();
		}
		System.out.println("optimal solution is"+v[n][m]);
		for(i=1;i<=n;i++)
			x[i]=0;
		i=n;
		j=m;
		while(i!=0||j!=0)
		{
			if(v[i][j]!=v[i-1][j])
			{
				x[i]=1;
				j-=w[i];
			}
			i=i-1;
		}
		for(i=1;i<=n;i++)
			System.out.println("x["+i+"]"+"="+x[i]);
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no. of objects");
		int n=sc.nextInt();
		int w[]=new int[n+1];
		System.out.println("enter the wieghts");
		for(int i=1;i<=n;i++)
			w[i]=sc.nextInt();
		int p[]=new int[n+1];
		System.out.println("enter profits");
		for(int i=1;i<=n;i++)
			p[i]=sc.nextInt();
		System.out.println("enter capacity");
		int m=sc.nextInt();
		int v[][]=new int[n+1][m+1];
		knapsack(n,w,p,m,v);
	}
}	
/*
---------------------------------------------------OUTPUT---------------------------------------
enter no. of objects
4
enter the wieghts
2 1 3 2
enter profits
12 10 20 15
enter capacity
5
Output is
0	0	0	0	0	0	
0	0	12	12	12	12	
0	10	12	22	22	22	
0	10	12	22	30	32	
0	10	15	25	30	37	
optimal solution is37
x[1]=1
x[2]=1
x[3]=0
x[4]=1
*/