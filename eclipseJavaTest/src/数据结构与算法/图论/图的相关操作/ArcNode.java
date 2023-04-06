package 数据结构与算法.图论.图的相关操作;

public class ArcNode {
    int adjVex;//在vex数组中的位置
    ArcNode nextArc;//顶点的下一个邻接顶点

    public ArcNode() {
        adjVex=0;
        nextArc=null;
    }
}
