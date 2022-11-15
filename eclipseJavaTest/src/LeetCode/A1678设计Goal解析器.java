package LeetCode;

public class A1678设计Goal解析器 {
    public static void main(String[] args) {
        System.out.println(interpret("G()"));
    }
    public static String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int length = command.length();
        while (i < length){
            char index = command.charAt(i);
            if (index == 'G'){
                builder.append("G");
                i++;
            } else if (i == length - 2 || index == '(' && command.charAt(i + 1) == ')'){
                builder.append("o");
                i = i + 2;
            } else {
                builder.append("al");
                i += 4;
            }
        }
        return builder.toString();
    }
}
