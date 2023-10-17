package Main;

import java.io.FilterInputStream;
import java.util.Scanner;

public class ScannerAux {

    public static String scanText() {
        Scanner sc = new Scanner(new FilterInputStream(System.in){public void close(){}});
        String text = sc.next();
        sc.close();
        return text;
    }

    public static int scanInt(){
        Scanner sc = new Scanner(new FilterInputStream(System.in){public void close(){}});
        int res = sc.nextInt();
        sc.close();
        return res;
    }
    
    public static long scanLong(){
        Scanner sc = new Scanner(new FilterInputStream(System.in){public void close(){}});
        long res = sc.nextLong();
        sc.close();
        return res;
    }
}