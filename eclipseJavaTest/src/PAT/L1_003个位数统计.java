package PAT;

import java.util.Scanner;

class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int[] total = new int[10];
        for (int i = 0;i < number.length();i++){
            Integer index = Integer.valueOf(String.valueOf(number.charAt(i)));
            total[index]++;
        }
        for (int i = 0;i < 10;i++){
            if (total[i] != 0){
                System.out.println(i + ":" + total[i]);
            }
        }
    }
}
