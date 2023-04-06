package BlueBridgeCup.JavaB_2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 在平面直角坐标系中，两点可以确定一条直线。如果有多点在一条直线上， 那线么这些点中任意两点确定的直是同一条。 给定平面上 2 × 3 个整点 {(x,
 * y)|0 ≤ x < 2, 0 ≤ y < 3, x ∈ Z, y ∈ Z}，即横坐标 是 0 到 1 (包含 0 和 1) 之间的整数、纵坐标是 0 到
 * 2 (包含 0 和 2) 之间的整数 的点。这些点一共确定了 11 条不同的直线。 给定平面上 20 × 21 个整点 {(x, y)|0 ≤ x <
 * 20, 0 ≤ y < 21, x ∈ Z, y ∈ Z}，即横 坐标是 0 到 19 (包含 0 和 19) 之间的整数、纵坐标是 0 到 20 (包含
 * 0 和 20) 之 间的整数的点。请问这些点一共确定了多少条不同的直线。
 * 
 * @author mlp52
 *
 */
public class No03 {
	public static void main(String[] args) {
		// 创建一个HashSet存储直线的斜率k,和截距b
		HashSet<Map<Double, Double>> lines = new HashSet<>();

		// 通过list<Map<>>（Java的map字典）保存所有的点
		List<Map<Integer, Integer>> points = new ArrayList<>();
	

		// 遍历并保存所有点
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 21; y++) {
				Map<Integer, Integer> map = new HashMap<>();
				map.put(x, y);
				points.add(map);
			}
		}
		// 通过两个点来计算斜率k
		for (int i = 0; i < points.size(); i++) {
			for (int j = i + 1; j < points.size(); j++) {
				// 初始化所需点的值
				double x1 = 0;
				double y1 = 0;
				double x2 = 0;
				double y2 = 0;
				for(Map.Entry<Integer, Integer> entry : points.get(i).entrySet() ) {
					x1 = entry.getKey();
					y1 = entry.getValue();
				}
				
				for(Map.Entry<Integer,Integer> entry : points.get(j).entrySet()) {
					x2 = entry.getKey();
					y2 = entry.getValue();
				}
				//垂直和平行于x轴
				if (x1 == x2 || y1 == y2) {
					continue;
				}
				
				//计算斜率和截距
				double k = (y2 - y1) / (x2 - x1);
				double b = (x2 * y1 - x1 * y2) / (x2 - x1);
				Map<Double,Double> tempMap = new HashMap<>();
				tempMap.put(k, b);
				lines.add(tempMap);
			}
		}
		
		System.out.println(lines.size() + 20 + 21);
	}
}
