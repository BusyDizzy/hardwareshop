package com.antontkach.hardwareshop;

import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.model.Laptop;

import java.math.BigDecimal;

public class ProductTestData {

    public static final MatcherFactory.Matcher<Desktop> DESKTOP_MATCHER = MatcherFactory.usingEqualsComparator(Desktop.class);

    public static final MatcherFactory.Matcher<Laptop> LAPTOP_MATCHER = MatcherFactory.usingEqualsComparator(Laptop.class);

    public static final int NOT_FOUND = 100;

    public static final int DESKTOP1_ID = 1;

    public static final int DESKTOP2_ID = 2;

    public static final int DESKTOP3_ID = 3;

    public static final int LAPTOP1_ID = 4;

    public static final int LAPTOP2_ID = 5;

    public static final int LAPTOP3_ID = 6;

    public static final Desktop desktop1 = new Desktop(DESKTOP1_ID, "D001", "ASUS",
            new BigDecimal("789.00"), 17, Desktop.FormFactor.DESKTOP, "Desktop");

    public static final Desktop desktop2 = new Desktop(DESKTOP2_ID, "D002", "KINGDEL",
            new BigDecimal("567.00"), 5, Desktop.FormFactor.NETTOP, "Desktop");

    public static final Desktop desktop3 = new Desktop(DESKTOP3_ID, "D003", "MICRO-STAR",
            new BigDecimal("912.00"), 26, Desktop.FormFactor.MONOBLOCK, "Desktop");


    public static Desktop getUpdated() {
        return new Desktop(DESKTOP3_ID, "D004", "AMD", new BigDecimal("1333.00"),
                9, Desktop.FormFactor.DESKTOP, "Desktop");
    }

    public static Desktop getNew() {
        return new Desktop(null, "D005", "Intel", new BigDecimal("1115.00"),
                22, Desktop.FormFactor.MONOBLOCK, "Desktop");
    }

    public static final Laptop laptop1 = new Laptop(LAPTOP1_ID, "L001", "IBM",
            new BigDecimal("1500.00"), 8, Laptop.Size.SIZE_15, "Laptop");

    public static final Laptop laptop2 = new Laptop(LAPTOP2_ID, "L002", "LENOVO",
            new BigDecimal("1210.00"), 16, Laptop.Size.SIZE_13, "Laptop");

    public static final Laptop laptop3 = new Laptop(LAPTOP3_ID, "L003", "ASUS",
            new BigDecimal("1720.00"), 2, Laptop.Size.SIZE_17, "Laptop");
}