

package infotrepo.holiday;
import infotrepo.util.StateType;
import java.text.DateFormat;
import java.util.GregorianCalendar;

public class HolidayEventCalculator {
    private int state = StateType.NONE;
    
    public HolidayEventCalculator() {
        
    }
    
    public HolidayEventCalculator(int state) {
        this.setState(state);
    }
    
    private boolean compareEvents(GregorianCalendar date, GregorianCalendar compareTo) {
        if(date.get(GregorianCalendar.MONTH) == compareTo.get(GregorianCalendar.MONTH) && date.get(GregorianCalendar.DAY_OF_YEAR) == compareTo.get(GregorianCalendar.DAY_OF_YEAR)) {
            return true;
        }
        
        return false;
    }
    
    private GregorianCalendar calculateDaysFromEaster(GregorianCalendar day, int days) {
        HolidayEventData easterData = this.checkEasterSunday(day);
        easterData.day.set(GregorianCalendar.DAY_OF_MONTH, easterData.day.get(GregorianCalendar.DAY_OF_MONTH) + days);  
              
        
        return easterData.day;
    }
    
    public HolidayEventData isHoliday(GregorianCalendar day) {
        HolidayEventData holidayEventData;
                
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.JANUARY) {
            holidayEventData = this.checkNewYearDay(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
            holidayEventData = this.checkEpiphany(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.AUGUST) {
            holidayEventData = this.checkPeaceOfAugsburg(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
            
            holidayEventData = this.checkAssumption(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.OCTOBER) {
            holidayEventData = this.checkDayOfGermanUnity(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
            holidayEventData = this.checkReformationDay(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.NOVEMBER) {
            holidayEventData = this.checkAllSaintsDay(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
            holidayEventData = this.checkRepentanceAndPrayer(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.DECEMBER) {
            holidayEventData = this.checkFirstChristmasDay(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
            holidayEventData = this.checkSecondChristmasDay(day);
            if(holidayEventData.isHoliday) {
                return holidayEventData;
            }
        }
        
        holidayEventData = this.checkMaundyThursday(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkGoodFriday(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkEasterMonday(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkFirstChristmasDay(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkLabourDay(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkAscensionOfChristi(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkWhitMonday(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkCorpusChristi(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkSunday(day);
        if(holidayEventData.isHoliday) {
            return holidayEventData;
        }
        
        return holidayEventData;
    }
    
    public HolidayEventData isWorkDay(GregorianCalendar day) {
        HolidayEventData holidayEventData;
                
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.JANUARY) {
            holidayEventData = this.checkNewYearDay(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
            holidayEventData = this.checkEpiphany(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.AUGUST) {
            holidayEventData = this.checkPeaceOfAugsburg(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
            
            holidayEventData = this.checkAssumption(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.OCTOBER) {
            holidayEventData = this.checkDayOfGermanUnity(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
            holidayEventData = this.checkReformationDay(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.NOVEMBER) {
            holidayEventData = this.checkAllSaintsDay(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
            holidayEventData = this.checkRepentanceAndPrayer(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
        }
        
        if(day.get(GregorianCalendar.MONTH) == GregorianCalendar.DECEMBER) {
            holidayEventData = this.checkFirstChristmasDay(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
            holidayEventData = this.checkSecondChristmasDay(day);
            if(holidayEventData.isWorkDay) {
                return holidayEventData;
            }
        }
        
        holidayEventData = this.checkMaundyThursday(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkGoodFriday(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkEasterMonday(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkFirstChristmasDay(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkLabourDay(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkAscensionOfChristi(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkWhitMonday(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkCorpusChristi(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        holidayEventData = this.checkSunday(day);
        if(holidayEventData.isWorkDay) {
            return holidayEventData;
        }
        
        return holidayEventData;
    }
    
    public HolidayEventData checkSunday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.SUNDAY;
        holidayEventData.name = "Sonntag";
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, day.get(GregorianCalendar.MONTH));
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, day.get(GregorianCalendar.DAY_OF_MONTH));
        holidayEventData.day.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.SUNDAY);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkNewYearDay(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.NEW_YEAR_DAY;
        holidayEventData.name = "Neujahrstag";
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 1);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }  
    
    public HolidayEventData checkEpiphany(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.EPIPHANY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Heilige Drei Könige";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 6);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkMaundyThursday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.MAUNDY_THURSDAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Gründonnerstag";
        holidayEventData.day = this.calculateDaysFromEaster(day, -3);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
        
    public HolidayEventData checkGoodFriday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.GOOD_FRIDAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Karfreitag";
        holidayEventData.day = this.calculateDaysFromEaster(day, -2);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkEasterSunday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.EASTER_SUNDAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Ostersonntag";
        
        int year = day.get(GregorianCalendar.YEAR);
        if (year <= 1582) {
            throw new IllegalArgumentException(
                    "Algorithm invalid before April 1583");
        }
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int L = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * L) / 451;
        int month = (h + L - 7 * m + 114)  /31;
        int easterDay = ((h + L - 7 * m + 114) % 31) + 1;
        
        holidayEventData.day.set(GregorianCalendar.YEAR, year);
        holidayEventData.day.set(GregorianCalendar.MONTH, (month - 1));
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, easterDay);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkEasterMonday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.EASTER_MONDAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Ostermontag";
        holidayEventData.day = this.calculateDaysFromEaster(day, 1);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkLabourDay(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.LABOUR_DAY;
        holidayEventData.name = "Tag der Arbeit";
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 1);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkAscensionOfChristi(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.ASCENSION_OF_CHRIST;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Christi Himmelfahrt";
        holidayEventData.day = this.calculateDaysFromEaster(day, 39);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkWhitMonday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.WHIT_MONDAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Pfingstmontag";
        holidayEventData.day = this.calculateDaysFromEaster(day, 50);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkCorpusChristi(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.CORPUS_CHRISTI;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Fronleichnam";
        holidayEventData.day = this.calculateDaysFromEaster(day, 60);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkPeaceOfAugsburg(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.PEACE_OF_AUGSBURG;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Augsburger Friedensfest";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.AUGUST);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 8);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkAssumption(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.ASSUMPTION;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Maria Himmelfahrt";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.AUGUST);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 15);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
     
    public HolidayEventData checkDayOfGermanUnity(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.DAY_OF_GERMAN_UNITY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Tag der deutschen Einheit";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.OCTOBER);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 3);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    public HolidayEventData checkReformationDay(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.EPIPHANY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Gründonnerstag";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.OCTOBER);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 31);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
       
    public HolidayEventData checkAllSaintsDay(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.ALL_SAINTS_DAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Allerheiligen";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.NOVEMBER);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 1);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkRepentanceAndPrayer(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.REPENTANCE_AND_PRAYER;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "Buß- und Bettag";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.SEPTEMBER);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 23);
        if(holidayEventData.day.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.WEDNESDAY) {
            holidayEventData.day.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.THURSDAY);
        }
        while(holidayEventData.day.get(GregorianCalendar.DAY_OF_WEEK) != GregorianCalendar.WEDNESDAY) {
            holidayEventData.day.set(GregorianCalendar.DAY_OF_WEEK, holidayEventData.day.get(GregorianCalendar.DAY_OF_WEEK)-1);
        }        
        return holidayEventData;
    }
     
    public HolidayEventData checkFirstChristmasDay(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.FIRST_CHRISTMAS_DAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "1. Weihnachtstag";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.DECEMBER);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 25);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkSecondChristmasDay(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        holidayEventData.type = HolidayEventType.SECOND_CHRISTMAS_DAY;
        holidayEventData.isHoliday = true;
        holidayEventData.isWorkDay = false;
        holidayEventData.name = "2. Weihnachtstag";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.DECEMBER);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 26);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }
}
