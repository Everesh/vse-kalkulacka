/*
 * @(#)Kalkulacka
 *
 * Zakladni trida aplikace, ktera slouzi ke spousteni kalkulacky.
 *
 * @author     Lubos Pavlicek
 * @version    1.0 (31 July 2004)
 */
public class Kalkulacka 
{

    // datove atributy instanci
    Kalkulator kalk;    
    GrafikaKalkulacky gui;
    
    /**
     * Konstruktor pro vytvoreni instance tridy Kalkulacka
     */
    public Kalkulacka() {
        //Inicializujte atributy instance
        kalk = new Kalkulator();
        gui = new GrafikaKalkulacky(kalk);
    }
    
    
    /**
     * metoda show zobrazi kalkulacku na obrazovce
     */
    public void show() {
        gui.setVisible();
    }

}
