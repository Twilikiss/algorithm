package luogu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] date = new String[n];
        for (int i = 0;i < n;i++){
            date[i] = scanner.nextLine();
        }
        String head = scanner.nextLine();
        Arrays.sort(date,(x , y) -> y.length() - x.length());
        System.out.println("s");
    }
}
