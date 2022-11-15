package luogu;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> date = new ArrayList<>();
        if (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.length() >= 2) {
                date.add(line);
            }
        }

    }
}
