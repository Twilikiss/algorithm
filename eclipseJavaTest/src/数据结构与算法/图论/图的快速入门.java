package 数据结构与算法.图论;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 关于的图的相关的知识点和快速入门
 */
public class 图的快速入门 {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] date = new String[]{"A", "B", "C", "D", "E"};
        for (String out : date) {
            graph.insertVertex(out);
        }

        //添加边
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

        graph.showGraph();

        //测试深度优先的代码
        //graph.DFS();

        //System.out.println("wait!下面我们有请广度遍历");
        
        graph.BFS();
    }
}

class Graph {
    private ArrayList<String> vertexList; // 存储图中的节点
    private int[][] edges; // 存储无向图对应的邻接矩阵
    private int numOfEdges; // 图中边的条数
    private boolean[] visited; //记录某个结点有没有访问过

    public Graph(int n) {
        //初始化矩阵和顶点集
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        visited = new boolean[n];
        numOfEdges = 0;
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1     表示顶点1的下标（即是第几个顶点）
     * @param v2     表示顶点2的下标
     * @param weight 两者边上的权值
     * @return void
     * @ClassName Graph
     * @author mlp52
     * @date 2022/11/10 21:23
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    //返回结点的个数
    public int getVertex() {
        return vertexList.size();
    }

    //返回边的个数
    public int getEdges() {
        return numOfEdges;
    }

    //返回下标对应的结点的数据
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    //返回两点之间的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图的邻接矩阵图
    public void showGraph() {
        for (int[] edge : edges) {
            for (int date : edge) {
                System.out.print(" " + date + " ");
            }
            System.out.println("\n");
        }
    }

    /**
     * 得到传入对象第一个邻接结点的下标
     *
     * @param index 要查询的下标
     * @return int 返回结果的下标，没有找到则返回-1
     * @ClassName Graph
     * @author mlp52
     * @date 2022/11/12 21:08
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取【该结点】的【邻接结点】的【下一个邻接结点】
     *
     * @param [index]
     * @return int
     * @ClassName Graph
     * @author mlp52
     * @date 2022/11/12 21:16
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先算法
     *
     * @param
     * @return
     * @ClassName Graph
     * @author mlp52
     * @date 2022/11/12 21:28
     */
    public void DFS(boolean[] isVisited, int index) {
        //首先输出该结点
        if (index != vertexList.size() - 1) {
            System.out.print(getValueByIndex(index) + "->");
        } else {
            System.out.print(getValueByIndex(index));
        }

        //将该结点标记为已访问
        isVisited[index] = true;
        //找到第一个邻接结点
        int firstNeighbor = getFirstNeighbor(index);
        while (firstNeighbor != -1) {
            if (!isVisited[index]) {
                DFS(isVisited, firstNeighbor);
            }
            //如果firstNeighbor已经被访问过了，将firstNeighbor的下一个结点赋值给自身
            firstNeighbor = getNextNeighbor(index, firstNeighbor);
        }
    }

    public void DFS() {
        for (int i = 0; i < vertexList.size(); i++) {
            DFS(visited, i);
        }
    }

    public void BFS(boolean[] isVisited, int index) {
        int u; // 表示队列头结点
        int w; // 邻接结点
        LinkedList<Integer> queue = new LinkedList<>();
        // 访问该结点
        if (index == vertexList.size() - 1) {
        	System.out.print(getValueByIndex(index));
		} else {
			System.out.print(getValueByIndex(index) + "=>");
		}
        // 标记该节点
        isVisited[index] = true;
        // 将节点压入队列
        queue.addLast(index);

        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {// 如果找到了
                if(!isVisited[w]){
                	if (w == vertexList.size() - 1) {
						System.out.print(getValueByIndex(w));
					} else {
						System.out.print(getValueByIndex(w) + "=>");
					}
                    
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u,w);
            }
        }
    }
    public void BFS() {
    	for (int i = 0; i < vertexList.size(); i++) {
			if (!visited[i]) {
				BFS(visited, i);
			}
		}
    }
}
