package 数据结构与算法练习;

/**
 * 稀疏数组的练习和思路和的代码实现
 * 利用原始数组来生成稀疏数组
 * 利用稀疏数组的数据创建数组
 * 
 * @author mlp52
 *
 */
public class sparseArrays {
	public static void main(String[] args) {
		// 创建原始的二维数组11*11，1代表黑棋子，2代表蓝子，0表示没有棋子
		int[][] chessArr01 = new int[11][11];
		chessArr01[1][2] = 1;
		chessArr01[2][3] = 2;
		chessArr01[3][4] = 3;

		// 输出原始数组
		System.out.println("原始的二维数组");
		for (int[] data : chessArr01) {
			for (int item : data) {
				System.out.printf("%d\t", item);
			}

			System.out.println();
		}

		// 将二维数组转换为稀疏数组
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr01[i][j] != 0) {
					sum++;
				}
			}
		}

		//创建稀疏数组
		int[][] sparseArr = new int[sum + 1][3];
		//给稀疏数组赋值
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		//遍历二维数组，将原数组的数据存到稀疏数组中去
		int row = 0;
		for (int i = 0; i < 11; i++) {
			
			for (int j = 0; j < 11; j++) {
				if (chessArr01[i][j] != 0) {
					row++;
					sparseArr[row][0] = i;
					sparseArr[row][1] = j;
					sparseArr[row][2] = chessArr01[i][j];
				}
			}
		}
		
		System.out.println("*****************************************************************************");
		//输出稀疏数组的情况
		System.out.println("转换为稀疏数组");
		for(int[] data : sparseArr) {
			for(int item : data) {
				System.out.printf("%d\t", item);
			}
			System.out.println();
		}
		
		System.out.println("*****************************************************************************");
		//将稀疏数组转换为普通的二维数组
		//创建二维数组
		int[][] outArr = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		//遍历取出稀疏数组存储的数据
		for(int i = 1;i < sparseArr[0][2] + 1;i++) {
			outArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		//遍历输出还原的二维数组
		System.out.println("还原的二维数组");
		for (int[] data : outArr) {
			for (int item : data) {
				System.out.printf("%d\t", item);
			}

			System.out.println();
		}

	}
}
