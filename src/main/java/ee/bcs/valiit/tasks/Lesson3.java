package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) { // jälgi, et ei tuleks mitut maini!
        //System.out.println( factorial( 5));
        //System.out.println(sum(new int[]{1, 2, 3, 4, 5}));
        //System.out.println( sort(new int[] { 5, -6, 9, 12, 7 }));
        //System.out.println(Arrays.toString(sort2(new int[] { 5, -6, 12, 9, 7 })));
        // System.out.println(reverseString ("Marika"));
        //System.out.println(reverseString111 ("Marika"));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(15));

    }


    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        int sum = 0;
        for (int i : x) {
            sum += i;
        }
        return sum;
    }


    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        int faktoriaal = 1; // 1*1= faktoriaal 1; 1*2= fakt.2; 1*2*3= fakt. 3 jne
        for (int i = 1; i <= x; i++) {
            faktoriaal = faktoriaal * i;
        }
        return faktoriaal;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                }
            }

        }
        return a;
    }

    public static int[] sort2(int[] a) {
        // TODO sorteeri massiiv suuruse järgi.
        // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
        for (int j = 0; j < a.length; j++) {
            int minValue = a[j];
            int minIndex = j;
            for (int i = j + 1; i < a.length; i++) {
                if (minValue > a[i]) {
                    minValue = a[i];
                    minIndex = i;
                }
            }
            int temp = a[j];
            a[j] = minValue;
            a[minIndex] = temp;
        }
        return a;
    }


    public static String reverseString(String a) {

        System.out.println("Sisesta:");

        Scanner read = new Scanner(System.in); //System inputist!
        String str = read.nextLine();
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {

            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    public static String reverseString111(String a) {
        // TODO tagasta string tagurpidi
        int size = a.length(); //stringi pikkus
        char[] newWord = new char[size]; //anna väärtus
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {//loop lõpust algusesse
            newWord[j] = a.charAt(i);//vastupidine string algusest lõppu
        }
        return new String(newWord); //viid tagasi järgmise tähe juurde
    }


    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}


