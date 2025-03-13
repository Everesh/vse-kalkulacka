import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * @(#)GrafikaKalkulacky
 *
 * Tato třída obsluhuje grafické rozhraní kalkulačky. Vlastní fungování kalkulačky upravuje
 * třída Kalkulator, která obsahuje veškerou logiku kalkulačky.
 * 
 * Tato třída je součástí projektu Kalkulacka, studenti by neměli obsah této třídy upravovat.
 *
 * @author     Lubos Pavlicek
 * @version    1.0.1 (26 January 2005)
 */
public class GrafikaKalkulacky 
{

    private JFrame okno;
    private Kalkulator kalk;
    private JTextField display;
    private JLabel info;
    private boolean infoBarevne=true;
    private String [] popiskyTlacitek = {
		  "7","8","9","+",
		  "4","5","6","-",
		  "1","2","3","C",
		  "?","0","?","="  };
   
    /**
     * vnitrni trida pro obsluhu udalosti se stiskem tlacitka
     */
    private class ObsluhaTlacitka implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String prikaz = event.getActionCommand();   
            if (prikaz.equals("+")) {
                kalk.plus();
            }
            if (prikaz.equals("-")) {
                kalk.minus();
            }
            if (prikaz.equals("=")) {
                kalk.rovnaSe();
            }
            if (prikaz.equals("C")) {
                kalk.vymaz();
            }
            if (prikaz.equals("?")) {
                showInfo();
            }
            if (prikaz.equals("0") ||
                prikaz.equals("1") ||
                prikaz.equals("2") ||
                prikaz.equals("3") ||
                prikaz.equals("4") ||
                prikaz.equals("5") ||
                prikaz.equals("6") ||
                prikaz.equals("7") ||
                prikaz.equals("8") ||
                prikaz.equals("9")) {
                int hodnota=Integer.parseInt(prikaz);
                kalk.cislice(hodnota);
            }
            redisplay();
        }
    }
     
    /**
     * Konstruktor pro objekty tridy GrafikaKalkulacky. Vytvori graficke okno kalkulacky
     * a priradi k tlacitkum ovladace.
     */
    public GrafikaKalkulacky(Kalkulator kalk) {
    
        JButton[] tlacitka = new JButton [popiskyTlacitek.length];
    
        JPanel panelTlacitek = new JPanel();
        info = new JLabel();
        display = new JTextField(12);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        JPanel panelDisplay = new JPanel();

        okno=new JFrame();
        this.kalk=kalk;

        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTlacitek.setLayout(new GridLayout(4,4));
        ObsluhaTlacitka obsluhaTlacitka = new ObsluhaTlacitka();
        for (int i=0; i<tlacitka.length;i++){
            tlacitka[i] = new JButton(popiskyTlacitek[i]);
            panelTlacitek.add(tlacitka[i]);
            tlacitka[i].addActionListener(obsluhaTlacitka);
         }
     
        okno.getContentPane().add(panelTlacitek);
      
        panelDisplay.add(display);
        okno.getContentPane().add(panelDisplay,BorderLayout.NORTH);
        okno.getContentPane().add(info,BorderLayout.SOUTH);
        okno.setSize(200,200);
        info.setText(".....");
        redisplay();
    }
    /**
     * metoda zobrazi aktualni hodnotu kalkulacky na displeyi
     */
    private void redisplay() {
        display.setText("" + kalk.getHodnotaKZobrazeni());
    }
    
    /**
     * metoda zobrazi informace o autorovi a verzi
     */
    private void showInfo() {
        info.setText(kalk.getAutor()+" "+kalk.getVerze());
        if (infoBarevne) {
            info.setForeground(Color.BLUE);
            infoBarevne=false;
        }
        else {
            info.setForeground(Color.BLACK);
            infoBarevne=true;
        }
    }
    
    /**
     * metoda zobrazi graficke okno kalkulacky na obrazovce
     */
    public void setVisible () {
        okno.setVisible(true);
    }
    
}
