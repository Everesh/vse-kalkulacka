/**
 *
 * Tato třída provádí vlastní výpočty kalkulátoru. Třída má tři skupiny metod:
 * a) pomocí metody getHodnotaKZobrazeni grafická třída zjištuje co má zobrazit na
 *    displayi,
 * b) metody cislice, plus, minus, rovnaSe a vymaz se volají při stisknutí příslušné
 *    klávesy na kalkulačce,
 * c) metody getAutor a getVerze jsou informační
 * 
 * Třída není dokončena - úkolem studentů je tuto třídu dokončit, tj. navrhnout datové
 * atributy instancí třídy a dokončit obsah metod.
 *
 * @author     Lubos Pavlicek
 * @version    1.0 (31 July 2004)
 */
public class Kalkulator 
{

    private int hodnotaZobrazeni;
    private int prvniOperant;
    private char operator;
    private boolean noveCislo = true;

    private final int ZADNA_OPERACE = 0;

    /**
     *  konstruktor třídy
     */
    public Kalkulator () {
        hodnotaZobrazeni = 0;
    }

    /**
     * Metoda vrací hodnotu, která se má zobrazit na displayi kalkulacky. Tato metoda
     * se obvykle volá po zavolání metody odpovídající stisku tlačítka.
     * 
     * @return   hodnota k zobrazení
     */
 
    public int getHodnotaKZobrazeni() {
        return hodnotaZobrazeni;
    }

    /**
     * metoda se volá při stisknutí tlačítka s číslicí na kalkulačce. Parametrem
     * je hodnota na stisknuté klávese.
     * 
     * @param hodnota    hodnota na stisknutém tlačítku, hodnota je v rozsahu
     *                   od 0 do 9
     */
    public void cislice(int hodnota) {
        if (noveCislo) {
            hodnotaZobrazeni = hodnota;
            noveCislo = false;
        } else {
            hodnotaZobrazeni = (hodnotaZobrazeni * 10) + hodnota;
        }
    }

    /**
     * metoda se volá při stisknutí tlačítka "+" (plus) na kalkulačce
     */
    public void plus() {
        prvniOperant = hodnotaZobrazeni;
        hodnotaZobrazeni = 0;
        operator = '+';
        noveCislo = true;
    }

    /**
     * metoda se volá při stisknutí tlačítka "-" (minus) na kalkulačce
     */
    public void minus() {
        prvniOperant = hodnotaZobrazeni;
        hodnotaZobrazeni = 0;
        operator = '-';
        noveCislo = true;
    }

    /**
     * metoda se volá při stisknutí tlačítka "=" (rovná se) na kalkulačce
     */
    public void rovnaSe() {
        if (operator == '+')
            hodnotaZobrazeni = prvniOperant + hodnotaZobrazeni;
        else if (operator == '-')
            hodnotaZobrazeni = prvniOperant - hodnotaZobrazeni;
        operator = ' ';
        noveCislo = true;
    }
    
    /**
     * metoda se volá při stisknutí tlačítka "C" (clear) na kalkulačce
     */
    public void vymaz() {
        hodnotaZobrazeni = 0;
        operator = ' ';
        noveCislo = true;
        prvniOperant = 0;
    }

    /**
     * metoda vrací jméno autora, např. "autor: Jan Novák"
     * 
     * @return   řetězec se jménem autora
     */    
    public String getAutor() {
        return "Jan Jurka";
    }
    
    /**
     * metoda vrací označení verze, např. "verze 1.0.3"
     * 
     * @return   řetězec s verzí programu
     */
    public String getVerze() {
        return "0.1.patch-3";
    }
    
}
