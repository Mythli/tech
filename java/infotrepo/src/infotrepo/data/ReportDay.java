package infotrepo.data;

import infotrepo.holiday.HolidayEventData;
import java.util.GregorianCalendar;


public class ReportDay {
    private ReportDayData data;
    
    public ReportDay() {
       data = new ReportDayData();
    }
    
    public ReportDay(ReportDayData data) {
        this.setData(data);
    }

    public ReportDayType getReportDayType() {
        if(this.getHolidayEventData() != null) {
            if(this.getHolidayEventData().isTrue) {
                return ReportDayType.HOLIDAY;
            }
        }
        if(this.getTrainingBreak() != null) {
            if(this.getTrainingBreak().isWithinTimeSpan(this.getDay())) {
                if(this.getTrainingBreak().hasSchoolDays()) {
                    if(this.getTrainingBreak().isSchoolDay(this.getDay().get(GregorianCalendar.DAY_OF_WEEK))) {
                        return ReportDayType.SCHOOL_DAY;
                    }
                }
                return ReportDayType.TRAINING_BREAK_DAY;
            }
        }
        if(this.getSchoolSpan().isSchoolDay(this.getDay().get(GregorianCalendar.DAY_OF_WEEK))) {
            return ReportDayType.SCHOOL_DAY;
        }
        return ReportDayType.WORK_DAY;
    }
    
    /**
     * @return the data
     */
    public ReportDayData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(ReportDayData data) {
        this.data = data;
    }

    /**
     * @return the day
     */
    public GregorianCalendar getDay() {
        return this.getData().day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(GregorianCalendar day) {
        this.getData().day = day;
    }

    /**
     * @return the holidayEventData
     */
    public HolidayEventData getHolidayEventData() {
        return this.getData().holidayEventData;
    }

    /**
     * @param holidayEventData the holidayEventData to set
     */
    public void setHolidayEventData(HolidayEventData holidayEventData) {
        this.getData().holidayEventData = holidayEventData;
    }

    /**
     * @return the trainingBreak
     */
    public TrainingBreak getTrainingBreak() {
        return this.getData().trainingBreak;
    }

    /**
     * @param trainingBreak the trainingBreak to set
     */
    public void setTrainingBreak(TrainingBreak trainingBreak) {
        this.getData().trainingBreak = trainingBreak;
    }

    /**
     * @return the schoolDayData
     */
    public SchoolSpan getSchoolSpan() {
        return this.getData().schoolSpan;
    }

    /**
     * @param schoolDayData the schoolDayData to set
     */
    public void setSchoolSpan(SchoolSpan schoolDayData) {
        this.getData().schoolSpan = schoolDayData;
    }
}
