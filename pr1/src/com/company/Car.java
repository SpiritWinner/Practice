package com.company;

public class Car implements Comparable <Car> {
    private final static String CAR_FORMAT_STRING = "Car: %-7s | %-10s | %-12s | %-8.2f | %-10.2f | %-7d |";
    private String id;
    private String mark;
    private String typ;
    private double mileage;
    private double costInHour;
    private int maxTime;

    public Car() {
        id = "";
        mark = "";
        typ = "";
        mileage = 0.0;
        costInHour = 0.0;
        maxTime = 0;
    }

    public Car(String id, String mark, String typ, double mileage, double costInHour, int maxTime) {
        this.id = id;
        this.mark = mark;
        this.typ = typ;
        this.mileage = mileage;
        this.costInHour = costInHour;
        this.maxTime = maxTime;
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getMark() {return mark;}

    public void setMark(String mark) {this.mark = mark;}

    public String getTyp() {return typ;}

    public void setTyp(String typ) {this.typ = typ;}

    public double getMileage() {return mileage;}

    public void setMileage(double mileage) {this.mileage = mileage;}

    public double getCostInHour() {return costInHour; }

    public void setCostInHour(double costInHour) {this.costInHour = costInHour;}

    public int getMaxTime() {return maxTime;}

    public void setMaxTime(int maxTime) {this.maxTime = maxTime;}

    public String toString(){
        return String.format(CAR_FORMAT_STRING, id, mark, typ, mileage, costInHour, maxTime);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id.equals(car.id);
    }

    public int hashCode() {
        return + 11 * id.hashCode()
                + 13 * mark.hashCode()
                + 15 * typ.hashCode()
                + 17 * (new Double(mileage)).hashCode()
                + 19 * (new Double(costInHour)).hashCode()
                + 21 * (new Integer(maxTime)).hashCode();
    }
    public int compareTo(Car car) {
        return (this.id.compareTo(car.id));
    }
}