package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {
    public static void main ( String [] args ) {

      }





    public static int evenFibonacci(int x){
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int i = 0;
        int j = 1;
        int sum = 0;
        while (j <= x) {
            if ( j % 2 == 0) {
            sum += j;
        }
        int tmp = i;
        i = j;
        j = tmp + j;
        }
        return sum;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0;
        int randomNumber = random.nextInt(100);
        while (true) {
            count++;
            System.out.println("Sisesta number");

        int guess = scanner.nextInt();
        if (guess == randomNumber) {
            System.out.println("Tubli! Arvasid ära " + count + " korraga)");
            break;
        } else if (guess < randomNumber) {
            System.out.println("Proovi uuesti, sisestatud number on liiga väike");
        } else {
            System.out.println("Proovi uuesti, sisestatud number on liiga suur");
        }}
    }





    public static String morseCode(String text){
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -

        return "";
    }
}
