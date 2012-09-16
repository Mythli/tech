/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gregoriancalendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author Lokaler Benutzer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpecialDateCalculator specialDateCalculator = new SpecialDateCalculator(2012);
        SimpleDateFormat teschlerSpecialFormat = new SimpleDateFormat("EEEE d MMM yyyy");

        System.out.println("New Year day:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.newYearDay().getTime()));

        System.out.println("Holy three kings day:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.holyThreeKings().getTime()));

        System.out.println("Easter sunday:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.easterSunday().getTime()));

        System.out.println("Green Thursday:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.greenThursday().getTime()));

        System.out.println("Karfreitag:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.karFreitag().getTime()));

        System.out.println("Ostermontag:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.osterMontag().getTime()));

        System.out.println("Tag der Arbeit:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.tagDerArbeit().getTime()));

        System.out.println("Christi Himmelfahrt:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.christiHimmelfahrt().getTime()));
        
        System.out.println("Buß und Bettag:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.betDay().getTime()));

        System.out.println("Aschermittwoch:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.AshWendsday().getTime()));

        System.out.println("Frühjahrssend:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.SpringSend().getTime()));

        System.out.println("Sommersend:");
        System.out.println(teschlerSpecialFormat.format(specialDateCalculator.SummerSend().getTime()));
    }

}
