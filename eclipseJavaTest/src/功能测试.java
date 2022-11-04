public class 功能测试 {
    public static void main(String[] args) {
        for (int i = 0;i < 3;i ++){
            for (int j = 0;j < 4;j++){
                for (int k = 0;k < 4;k++){
                    if (i == j){
                        break;
                    }
                    System.out.println(i + " " + j);
                }

            }
        }
    }
}

class StringOp {
    //判断字符串数字的个数
    public int countNum(String date) {
        int ans = 0;
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (Character.isDigit(c)) {
                ans++;
            }
        }
        return ans;
    }
}