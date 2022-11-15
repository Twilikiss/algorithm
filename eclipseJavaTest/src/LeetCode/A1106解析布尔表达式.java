package LeetCode;

import java.util.*;

/**
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * <p>
 * <p>
 * 示例 1：
 * 输入：expression = "!(f)"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：expression = "|(f,t)"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：expression = "&(t,f)"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 */
public class A1106解析布尔表达式 {
    public static void main(String[] args) {
        System.out.println(parseBoolExpr("|(f,&(t,t))"));
        System.out.println(parseBoolExpr01("|(f,&(t,t))"));
    }

    //代码在第68个案例，即"|(f,&(t,t))"无法通过，代码无法在弹出”t和f“时确定弹出的次数！！！！
    public static boolean parseBoolExpr(String expression) {
        boolean ans = true;
        Stack<Character> operation = new Stack<>();
        Stack<Boolean> date = new Stack<>();
        Map<Character, Boolean> op = new HashMap<>();
        int count = 0;
        op.put('t', true);
        op.put('f', false);
        int pre = 0;
        for (int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            if (temp == ',') {
                continue;
            }
            if (op.containsKey(temp)) {
                count++;
                if (op.get(temp)) {
                    date.push(true);
                } else {
                    date.push(false);
                }
                continue;
            }
            if (temp != ')') {
                operation.push(temp);
            }
            if (operation.size() > 0 && operation.peek() == '(' && temp == ')') {
                operation.pop();
                Character mark = operation.pop();
                boolean[] booleans = new boolean[count];
                if (operation.size() == 0) {
                    int length = date.size();
                    boolean[] sp = new boolean[length];
                    for (int j = 0; j < length; j++) {
                        sp[j] = date.pop();
                    }
                    boolean make = make(mark, sp);
                    ans = make;
                    break;
                }
                for (int j = 0; j < count; j++) {
                    booleans[j] = date.pop();
                }
                boolean make = make(mark, booleans);
                date.push(make);
                count = 0;
            }
        }
        return ans;
    }

    public static boolean make(char mark, boolean[] date) {
        if (mark == '!' && date.length == 1) {
            return !date[0];
        }
        if (mark == '&') {
            boolean ans = true;
            for (int i = 0; i < date.length; i++) {
                if (!date[i]) {
                    ans = false;
                    break;
                }
            }
            return ans;
        }

        boolean ans = false;
        for (int i = 0; i < date.length; i++) {
            if (date[i]) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    public static boolean parseBoolExpr01(String expression) {
        Deque<Character> total = new ArrayDeque<>();
        int length = expression.length();
        for (int i = 0;i < length;i++){
            char index = expression.charAt(i);
            if (index == ','){
                continue;
            } else if (index != ')'){
                total.push(index);
            } else {
                int t = 0, f = 0;
                while (total.peek() != '('){
                    char op = total.pop();
                    if (op == 'f'){
                        f++;
                    } else {
                        t++;
                    }
                }
                total.pop();
                char mark = total.pop();
                switch (mark){
                    case '&':
                        total.push(f == 0 ? 't' : 'f');
                        break;
                    case '|':
                        total.push(t > 0 ? 't' : 'f');
                        break;
                    case '!':
                        total.push(f == 1 ? 't' : 'f');
                        break;
                }
            }
        }
        return total.pop() == 't';
    }
}
