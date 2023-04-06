package 数据结构与算法.图论.图的相关操作;

public class AVOMain {
    public static void main(String[] args) throws Exception {

        ALGraph<String> g=new ALGraph<String>();
        g.CreateList();
        g.DisplatAdjList();
        g.toppSort();
    }
}