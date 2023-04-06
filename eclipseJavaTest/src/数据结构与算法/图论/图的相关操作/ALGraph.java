package 数据结构与算法.图论.图的相关操作;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;


public class ALGraph<T> {
    protected final int MAXSIZE=100;
    protected VNode<String>[] adjList; // 顶点结点信息
    protected int n=50;
    protected int e;
    protected boolean[] visited;//访问标志数组

    public ALGraph() {
        adjList=new VNode[MAXSIZE];
        visited=new boolean[MAXSIZE];
    }
    public void CreateList() {
        int i,j,k;
        String v1,v2;
        ArcNode s;
        Scanner sc=new Scanner(System.in);
        System.out.println("输入图的顶点数及边数");
        System.out.print("顶点数：");
        n=sc.nextInt();
        System.out.print("边数：");
        e=sc.nextInt();
        System.out.println("输入图的顶点信息：");
        for(i=0;i<n;i++) {
            adjList[i]=new VNode<>();
            adjList[i].data=sc.next();
            adjList[i].firstArc=null;
        }
        System.out.println("输入图的边信息：");
        for(k=0;k<e;k++) {
            System.out.print("请输入第"+(k+1)+"条边的两个端点：");
            v1= sc.next();
            v2= sc.next();

            i=LocateVex(v1);
            j=LocateVex(v2);
            if(i>=0 && j>=0) {
                s=new ArcNode();
                s.adjVex=j;
                s.nextArc=adjList[i].firstArc;
                adjList[i].firstArc=s;
            }
        }
    }

    public int LocateVex(String v) {
        int i;
        for(i=0;i<n;i++)
            if(Objects.equals(adjList[i].data, v)) return i;
        return -1;
    }

    public void DisplatAdjList() {
        int i;
        ArcNode p;
        System.out.println("图的邻接表表示：");
        for(i=0;i<n;i++) {
            System.out.print("\n "+adjList[i].data);
            p=adjList[i].firstArc;
            while(p!=null) {
                System.out.print("-->"+p.adjVex);
                p=p.nextArc;
            }
        }
    }
    public void toppSort() throws Exception {
        int count=0;
        int []put=new int[n];//查看顶点是否放入拓扑序列中，未放0，放入1
        int []in=new int[n];//存放顶点入度的数组
        for(int i=0;i<n;i++) {
            ArcNode arc=adjList[i].firstArc;
            while(arc!=null) {
                in[arc.adjVex]++;
                arc=arc.nextArc;//列表不为空 指向点入度++
            }
        }
        System.out.println();
        for(int i=0;i<n;i++) {
            System.out.println(adjList[i].data+"的入度:"+in[i]+" ");
        }
        //入队
        System.out.println();
//        linkQueue Q=new linkQueue();
        ArrayDeque Q = new ArrayDeque();
        for(int i=0;i<n;i++) {
            if(put[i]==0 && in[i]==0){//未放入拓扑序列且入度为0
                put[i]=1;
                Q.offer(adjList[i]);//入队
                ArcNode arc=adjList[i].firstArc;
                while(arc!=null) {
                    in[arc.adjVex]--;
                    arc=arc.nextArc;//列表不为空 指向点入度--
                }break;
            }
        }
        //出队
        while(!Q.isEmpty()) {
            VNode v=(VNode)Q.poll();
            System.out.print(v.data.toString()+" ");
            count++;
            for(int i=0;i<n;i++) {
                if(put[i]==0 && in[i]==0) {
                    put[i]=1;//放入拓扑序列
                    Q.offer(adjList[i]);
                    ArcNode arc=adjList[i].firstArc;
                    while(arc!=null) {
                        in[arc.adjVex]--;
                        arc=arc.nextArc;//列表不为空 指向点入度--
                    }break;
                }
            }
        }
        if(count<n)
            System.out.println("该图存在回路");
        else
            System.out.println("该图无回路");
    }
}
