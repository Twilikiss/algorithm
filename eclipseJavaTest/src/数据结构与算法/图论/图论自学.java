package 数据结构与算法.图论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 跟随《数据结构与算法——python语言描述版》学的
 *
 * @author mlp52
 * @ClassName 图论自学
 * @date 2022/12/7
 */
public class 图论自学 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    //图的深度优先（DFS）
    public void dFS() {

    }
}

/**
 * 邻接矩阵类
 *
 * @author mlp52
 * @ClassName MatGraph
 * @date 2022/12/17 12:21
 */
class MatGraph {
    private int node;
    private int edge;
    private int[][] in;

    public MatGraph(int node, int edge, int[][] in) {
        this.node = node;
        this.edge = edge;
        this.in = Arrays.copyOf(in,in.length);
    }

    public void update(int node, int otherNode ,int value) {
        if (otherNode > in.length - 1) {
            System.out.println("乱来是吧？");
        } else {
            if (otherNode < in[node].length){
                in[node][otherNode] = value;
            } else {
                System.out.println("戳啦！");
            }
        }
    }
}

/**
 * 邻接表类
 * @ClassName AdjGraph
 * @author   mlp52
 * @date  2022/12/18 19:37
 */
class AdjGraph{

}
