package 数据结构与算法.图论.图的相关操作;

public class VNode<T> {
    T data;
    ArcNode firstArc;//第一个邻接点

    public VNode(){
        data=null;
        firstArc=null;
    }
}
