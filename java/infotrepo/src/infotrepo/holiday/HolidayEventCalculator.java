

package infotrepo.holiday;
import infotrepo.util.StateType;
import java.util.GregorianCalendar;

public class HolidayEventCalculator {
    private int state = StateType.ALL;
    
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
        easterData.day.add(GregorianCalendar.DAY_OF_MONTH, days);        
        
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
        holidayEventData.name = "Gründonnerstag";
        holidayEventData.day.set(GregorianCalendar.YEAR, day.get(GregorianCalendar.YEAR));
        holidayEventData.day.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        holidayEventData.day.set(GregorianCalendar.DAY_OF_MONTH, 6);
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkMaundyThursday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        return holidayEventData;
    }
        
    public HolidayEventData checkGoodFriday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
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
        int golden, century, x, z, d, epact, n;
        golden = (year % 19) + 1; /* E1: metonic cycle */
        century = (year / 100) + 1; /* E2: e.g. 1984 was in 20th C */
        x = (3 * century / 4) - 12; /* E3: leap year correction */
        z = ((8 * century + 5) / 25) - 5; /* E3: sync with moon's orbit */
        d = (5 * year / 4) - x - 10;
        epact = (11 * golden + 20 + z - x) % 30; /* E5: epact */
        if ((epact == 25 && golden > 11) || epact == 24) {
            epact++;
        }
        n = 44 - epact;
        n += 30 * (n < 21 ? 1 : 0); /* E6: */
        n += 7 - ((d + n) % 7);
        
        if (n > 31) {
            holidayEventData.day = new GregorianCalendar(year, 4 - 1, n - 31); /* April */
        }
        else {
            holidayEventData.day = new GregorianCalendar(year, 3 - 1, n); /* March */
        }
        
        holidayEventData.isTrue = this.compareEvents(holidayEventData.day, day);
        return holidayEventData;
    }
    
    public HolidayEventData checkEasterMonday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
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
        return holidayEventData;
    }
    
    public HolidayEventData checkWhitMonday(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
        return holidayEventData;
    }
    
    public HolidayEventData checkCorpusChristi(GregorianCalendar day) {
        HolidayEventData holidayEventData = new HolidayEventData();
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
