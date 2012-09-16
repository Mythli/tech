/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Lokaler Benutzer
 */
public class Main {

    public static void main ( String[] a ) {
        boolean continueApplication = true;
        while(continueApplication)
        {
            Scanner consoleScanner = new Scanner(System.in);
            float dividend = 0;
            float divisor = 0;
            try
            {
                System.out.println("Geben sie den Dividend an: ");
                dividend = consoleScanner.nextFloat();
                System.out.println("Geben sie den Divisor an: ");
                divisor = consoleScanner.nextFloat();

                if(dividend != 0 && divisor != 0)
                {
                    float result = dividend / divisor;
                    System.out.println(dividend+" / "+divisor+" = "+result);
                } else
                {
                    System.out.println("Eine Division durch 0 ist leider nicht möglich ("+dividend+" / "+divisor+")");
                    continue;
                }
            }
            catch (ArithmeticException ex)
            {
                System.out.println("Das tut uns leid, "+dividend+" konnte nicht durch "+divisor+" geteilt werden: "+ex.getMessage());
            }
            catch (InputMismatchException ex)
            {
                System.out.println("Das tut uns leid, beim verarbeiten der Eingabe ist leider ein Fehler aufgetreten.");
            }
            catch(Exception ex)
            {
                System.out.println("Das tut uns leid, ein unerwarteter Fehler ist aufgetreten: "+ex.getMessage());
            }
            finally {
                try
                {
                    System.out.println("Geben sie 'q' zum beenden der Anwendung oder 'y' um fortzufahren.");
                    String behaviour = consoleScanner.next().toLowerCase();
                    if(behaviour.charAt(0) == 'q')
                        continueApplication = false;
                }
                catch(Exception ex)
                {
                     System.out.println("Das tut uns leid, ein unerwarteter Fehler ist aufgetreten: "+ex.getMessage());
                }
            }
        }
        System.out.println("Vielen dank für die verwendung von xyz.");
    }
}