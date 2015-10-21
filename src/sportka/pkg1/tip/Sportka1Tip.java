// Sportka - hádání jednoho čísla
// Program vygeneruje 6 neopakujících se náhodných čísel ze 49
// Uživatel tipuje a program kontroluje trefu a pravděpodobnost
//
// TODO: uživatel nesmí hádat dvakrát stejné číslo

package sportka.pkg1.tip;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sportka1Tip {

    public static void main(String[] args) {
        final int POCET_HODU = 6;
        // o jednu více, než max. hodnota
        final int ROZSAH_HODU = 49;
        // seznam vylosovaných čísel
        ArrayList<Integer> vylosovano = new ArrayList<>();
        // losování zadaného počtu neopakujících se čísel
        for (int i = 1; i <= POCET_HODU; i++) {
            Random ran = new Random();
            // parametr je hodnota: nextInt(max - min + 1) + min
            // chceme tedy (49 - 1 + 1) + 1
            int právěpadlo = ran.nextInt(ROZSAH_HODU)+1;
            // generujeme náhodné dokud nebude jiné, než už máme
            while (vylosovano.contains(právěpadlo)) {
                // generuje další číslo
                právěpadlo = ran.nextInt(ROZSAH_HODU)+1;
            }
            vylosovano.add(právěpadlo);
        }
        // kontrolní výpis
        System.out.println("Vylosovaná čísla:");
        for (Integer cislo : vylosovano) {
            System.out.print(cislo + " ");
        }
        System.out.println();
        // uživatel zadává čísla, my odpovídáme (ukončení nulou)
        System.out.print("Vlož číslo: ");
        Scanner vstup = new Scanner(System.in);
        int hádanéčíslo = vstup.nextInt();
        int počettrefil = 0;
        int pokusů = 0;
        while (hádanéčíslo != 0) {
            pokusů++;
            if (vylosovano.contains(hádanéčíslo)) {
                počettrefil++;
                System.out.println("Trefil ses! Už "+
                        počettrefil+" krát.");
            } else {
                System.out.println("Netrefil :-(");
            }
            // úspěšnost v procentech na 1 desetinné místo
            System.out.printf("Úspěšnost: %.1f %%\n",
                    (double) počettrefil/pokusů*100);
            System.out.print("Vlož číslo: ");
            hádanéčíslo = vstup.nextInt();
        }
    }
}
