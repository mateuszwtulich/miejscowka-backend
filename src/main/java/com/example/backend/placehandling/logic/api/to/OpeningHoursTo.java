package com.example.backend.placehandling.logic.api.to;

import java.util.Objects;

public class OpeningHoursTo {
    private String mondayOpeningHour;

    private String mondayClosingHour;

    private String tuesdayOpeningHour;

    private String tuesdayClosingHour;

    private String wednesdayOpeningHour;

    private String wednesdayClosingHour;

    private String thursdayOpeningHour;

    private String thursdayClosingHour;

    private String fridayOpeningHour;

    private String fridayClosingHour;

    private String saturdayOpeningHour;

    private String saturdayClosingHour;

    private String sundayOpeningHour;

    private String sundayClosingHour;

    public OpeningHoursTo() {
    }

    public OpeningHoursTo(String mondayOpeningHour, String mondayClosingHour, String tuesdayOpeningHour, String tuesdayClosingHour, String wednesdayOpeningHour, String wednesdayClosingHour, String thursdayOpeningHour, String thursdayClosingHour, String fridayOpeningHour, String fridayClosingHour, String saturdayOpeningHour, String saturdayClosingHour, String sundayOpeningHour, String sundayClosingHour) {
        this.mondayOpeningHour = mondayOpeningHour;
        this.mondayClosingHour = mondayClosingHour;
        this.tuesdayOpeningHour = tuesdayOpeningHour;
        this.tuesdayClosingHour = tuesdayClosingHour;
        this.wednesdayOpeningHour = wednesdayOpeningHour;
        this.wednesdayClosingHour = wednesdayClosingHour;
        this.thursdayOpeningHour = thursdayOpeningHour;
        this.thursdayClosingHour = thursdayClosingHour;
        this.fridayOpeningHour = fridayOpeningHour;
        this.fridayClosingHour = fridayClosingHour;
        this.saturdayOpeningHour = saturdayOpeningHour;
        this.saturdayClosingHour = saturdayClosingHour;
        this.sundayOpeningHour = sundayOpeningHour;
        this.sundayClosingHour = sundayClosingHour;
    }

    public String getMondayOpeningHour() {
        return mondayOpeningHour;
    }

    public void setMondayOpeningHour(String mondayOpeningHour) {
        this.mondayOpeningHour = mondayOpeningHour;
    }

    public String getMondayClosingHour() {
        return mondayClosingHour;
    }

    public void setMondayClosingHour(String mondayClosingHour) {
        this.mondayClosingHour = mondayClosingHour;
    }

    public String getTuesdayOpeningHour() {
        return tuesdayOpeningHour;
    }

    public void setTuesdayOpeningHour(String tuesdayOpeningHour) {
        this.tuesdayOpeningHour = tuesdayOpeningHour;
    }

    public String getTuesdayClosingHour() {
        return tuesdayClosingHour;
    }

    public void setTuesdayClosingHour(String tuesdayClosingHour) {
        this.tuesdayClosingHour = tuesdayClosingHour;
    }

    public String getWednesdayOpeningHour() {
        return wednesdayOpeningHour;
    }

    public void setWednesdayOpeningHour(String wednesdayOpeningHour) {
        this.wednesdayOpeningHour = wednesdayOpeningHour;
    }

    public String getWednesdayClosingHour() {
        return wednesdayClosingHour;
    }

    public void setWednesdayClosingHour(String wednesdayClosingHour) {
        this.wednesdayClosingHour = wednesdayClosingHour;
    }

    public String getThursdayOpeningHour() {
        return thursdayOpeningHour;
    }

    public void setThursdayOpeningHour(String thursdayOpeningHour) {
        this.thursdayOpeningHour = thursdayOpeningHour;
    }

    public String getThursdayClosingHour() {
        return thursdayClosingHour;
    }

    public void setThursdayClosingHour(String thursdayClosingHour) {
        this.thursdayClosingHour = thursdayClosingHour;
    }

    public String getFridayOpeningHour() {
        return fridayOpeningHour;
    }

    public void setFridayOpeningHour(String fridayOpeningHour) {
        this.fridayOpeningHour = fridayOpeningHour;
    }

    public String getFridayClosingHour() {
        return fridayClosingHour;
    }

    public void setFridayClosingHour(String fridayClosingHour) {
        this.fridayClosingHour = fridayClosingHour;
    }

    public String getSaturdayOpeningHour() {
        return saturdayOpeningHour;
    }

    public void setSaturdayOpeningHour(String saturdayOpeningHour) {
        this.saturdayOpeningHour = saturdayOpeningHour;
    }

    public String getSaturdayClosingHour() {
        return saturdayClosingHour;
    }

    public void setSaturdayClosingHour(String saturdayClosingHour) {
        this.saturdayClosingHour = saturdayClosingHour;
    }

    public String getSundayOpeningHour() {
        return sundayOpeningHour;
    }

    public void setSundayOpeningHour(String sundayOpeningHour) {
        this.sundayOpeningHour = sundayOpeningHour;
    }

    public String getSundayClosingHour() {
        return sundayClosingHour;
    }

    public void setSundayClosingHour(String sundayClosingHour) {
        this.sundayClosingHour = sundayClosingHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OpeningHoursTo that = (OpeningHoursTo) o;
        return Objects.equals(mondayOpeningHour, that.mondayOpeningHour) &&
                Objects.equals(mondayClosingHour, that.mondayClosingHour) &&
                Objects.equals(tuesdayOpeningHour, that.tuesdayOpeningHour) &&
                Objects.equals(tuesdayClosingHour, that.tuesdayClosingHour) &&
                Objects.equals(wednesdayOpeningHour, that.wednesdayOpeningHour) &&
                Objects.equals(wednesdayClosingHour, that.wednesdayClosingHour) &&
                Objects.equals(thursdayOpeningHour, that.thursdayOpeningHour) &&
                Objects.equals(thursdayClosingHour, that.thursdayClosingHour) &&
                Objects.equals(fridayOpeningHour, that.fridayOpeningHour) &&
                Objects.equals(fridayClosingHour, that.fridayClosingHour) &&
                Objects.equals(saturdayOpeningHour, that.saturdayOpeningHour) &&
                Objects.equals(saturdayClosingHour, that.saturdayClosingHour) &&
                Objects.equals(sundayOpeningHour, that.sundayOpeningHour) &&
                Objects.equals(sundayClosingHour, that.sundayClosingHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mondayOpeningHour, mondayClosingHour, tuesdayOpeningHour, tuesdayClosingHour, wednesdayOpeningHour, wednesdayClosingHour, thursdayOpeningHour, thursdayClosingHour, fridayOpeningHour, fridayClosingHour, saturdayOpeningHour, saturdayClosingHour, sundayOpeningHour, sundayClosingHour);
    }

}
