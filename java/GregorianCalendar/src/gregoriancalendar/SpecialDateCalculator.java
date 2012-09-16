/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gregoriancalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Lokaler Benutzer
 */
public class SpecialDateCalculator {
    private Calendar calendar;


    public SpecialDateCalculator(Calendar calendar) {
        this.calendar = calendar;
    }

    public SpecialDateCalculator(int year) {
        this.calendar = new GregorianCalendar(year, Calendar.JANUARY, 01);
    }

    public Calendar easterSunday()
    {
        int year = this.calendar.get(Calendar.YEAR);

        int i = year % 19;
        int j = year / 100;
        int k = year % 100;
        int l = (19 * i + j - (j / 4) - ((j - ((j + 8) / 25) + 1) / 3) + 15) % 30;
        int m = (32 + 2 * (j % 4) + 2 * (k / 4) - l - (k % 4)) % 7;
        int n = l + m - 7 * ((i + 11 * l + 22 * m) / 451) + 114;
        int month = n / 31;
        int day   = (n % 31) + 1;

        this.calendar.set(Calendar.MONTH, month-1);
        this.calendar.set(Calendar.DAY_OF_MONTH, day);
        return this.calendar;
    }

    private Calendar berechneTageAbOstersonntag(int tage, boolean addieren)
    {
        this.calendar = this.easterSunday();

        if(addieren == true)
            this.calendar.set(Calendar.DAY_OF_YEAR, this.calendar.get(Calendar.DAY_OF_YEAR)+ tage);
        else
            this.calendar.set(Calendar.DAY_OF_YEAR, this.calendar.get(Calendar.DAY_OF_YEAR)- tage);

        return this.calendar;
    }

    public Calendar newYearDay()
    {
        this.calendar.set(Calendar.MONTH, Calendar.JANUARY);
        this.calendar.set(Calendar.DAY_OF_MONTH, 01);
        return this.calendar;
    }

    public Calendar holyThreeKings()
    {
        this.calendar.set(Calendar.MONTH, Calendar.JANUARY);
        this.calendar.set(Calendar.DAY_OF_MONTH, 06);
        
        return this.calendar;
    }

    public Calendar greenThursday()
    {
        this.calendar = this.berechneTageAbOstersonntag(3, false);
        
        return this.calendar;
    }

    public Calendar karFreitag()
    {
        this.calendar = this.berechneTageAbOstersonntag(2, false);
        return this.calendar;
    }

    public Calendar osterMontag()
    {
        this.calendar = this.berechneTageAbOstersonntag(1, true);
        return this.calendar;
    }

    public Calendar tagDerArbeit()
    {
        this.calendar.set(Calendar.MONTH, Calendar.MAY);
        this.calendar.set(Calendar.DAY_OF_MONTH, 01);

        return this.calendar;
    }

    public Calendar christiHimmelfahrt()
    {
        this.calendar = this.berechneTageAbOstersonntag(39, true);
        return this.calendar;
    }

    public Calendar pfingstMontag()
    {
        this.calendar = this.berechneTageAbOstersonntag(50, true);
        return this.calendar;
    }

    public Calendar fronLeichnam()
    {
        this.calendar = this.berechneTageAbOstersonntag(60, true);
        return this.calendar;
    }

    public Calendar ausburgerFriedensfest()
    {
        this.calendar.set(Calendar.MONTH, Calendar.AUGUST);
        this.calendar.set(Calendar.DAY_OF_MONTH, 8);

        return this.calendar;
    }

    public Calendar mariaHimmelfahrt()
    {
        this.calendar.set(Calendar.MONTH, Calendar.AUGUST);
        this.calendar.set(Calendar.DAY_OF_MONTH, 15);

        return this.calendar;
    }

    public Calendar tagDerDeutschenEinheit()
    {
        this.calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        this.calendar.set(Calendar.DAY_OF_MONTH, 03);

        return this.calendar;
    }

    public Calendar reformationsTag()
    {
        this.calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        this.calendar.set(Calendar.DAY_OF_MONTH, 31);

        return this.calendar;
    }

    public Calendar allerheiligen()
    {
        this.calendar.set(Calendar.MONTH, Calendar.MAY);
        this.calendar.set(Calendar.DAY_OF_MONTH, 01);

        return this.calendar;
    }

    public Calendar betDay()
    {
        this.calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        this.calendar.set(Calendar.DAY_OF_MONTH, 23);
        int dayOfWeek = this.calendar.get(Calendar.DAY_OF_WEEK);
        for(int i = 0; i < 7; i++)
        {

            this.calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
            if(dayOfWeek == Calendar.WEDNESDAY)
                break;

            dayOfWeek = dayOfWeek -1;
        }

        return this.calendar;
    }

    public Calendar FirstChristmasDay()
    {
        this.calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        this.calendar.set(Calendar.DAY_OF_MONTH, 25);

        return this.calendar;
    }

    public Calendar SecondChristmasDay()
    {
        this.calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        this.calendar.set(Calendar.DAY_OF_MONTH, 26);

        return this.calendar;
    }

    public Calendar AshWendsday()
    {
        return this.berechneTageAbOstersonntag(46, false);
    }

    public Calendar SpringSend()
    {
        this.calendar = AshWendsday();
        this.calendar.set(Calendar.WEEK_OF_YEAR, this.calendar.get(Calendar.WEEK_OF_YEAR)+3);
        this.calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return this.calendar;
    }

    public Calendar SummerSend()
    {
        this.calendar.set(Calendar.MONTH, Calendar.JULY);
        this.calendar.set(Calendar.DAY_OF_YEAR, this.calendar.get(Calendar.DAY_OF_YEAR)-1);
        this.calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        return this.calendar;
    }
}
