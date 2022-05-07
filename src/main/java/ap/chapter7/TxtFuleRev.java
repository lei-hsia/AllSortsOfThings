package ap.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lei
 * @date 01/09/2022 10:46 AM
 */
public class TxtFuleRev {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Type the number of line: ");
        int b = scan.nextInt();
        scan.nextLine();
        System.out.println("Line: " + b);


        for (int i = 0; i < b; i++){
            int c = i + 1;
            System.out.println("Type your " + c + " line: ");
            System.out.println(">>>>>>");
            String a = scan.nextLine();
            list.add(a);
        }

        for (int i = 0; i < b; i++){
            String str = list.get(i);
            System.out.println(str);
        }

        System.out.println("Reverse: ");

        for (int i = b - 1; i < b; i--){
            String str = list.get(i);
            System.out.println(str);
            if (i == 0) break;
        }

    }
}
