package com.company;

import java.util.*;
public class CompCostAsc implements Comparator {
    public int compare (Object ob1, Object ob2){
        Car car1 = (Car) ob1;
        Car car2 = (Car) ob2;
        if (car1.getCostInHour() < car2.getCostInHour()) return -1;
        else if (car1.getCostInHour() == car2.getCostInHour()) return 0;
        else return 1;
    }
}
