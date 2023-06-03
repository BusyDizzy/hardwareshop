package com.antontkach.hardwareshop;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.model.HardDrive;
import com.antontkach.hardwareshop.model.Laptop;
import com.antontkach.hardwareshop.model.Monitor;

import java.math.BigDecimal;

public class ProductTestData {

    public static final MatcherFactory.Matcher<Desktop> DESKTOP_MATCHER = MatcherFactory.usingEqualsComparator(Desktop.class);

    public static final MatcherFactory.Matcher<Laptop> LAPTOP_MATCHER = MatcherFactory.usingEqualsComparator(Laptop.class);

    public static final MatcherFactory.Matcher<Monitor> MONITOR_MATCHER = MatcherFactory.usingEqualsComparator(Monitor.class);

    public static final MatcherFactory.Matcher<HardDrive> HARD_DRIVE_MATCHER = MatcherFactory.usingEqualsComparator(HardDrive.class);


    public static final int NOT_FOUND = 100;

    public static final int DESKTOP1_ID = 1;

    public static final int DESKTOP2_ID = 2;

    public static final int DESKTOP3_ID = 3;

    public static final int LAPTOP1_ID = 4;

    public static final int LAPTOP2_ID = 5;

    public static final int LAPTOP3_ID = 6;

    public static final int MONITOR1_ID = 7;

    public static final int MONITOR2_ID = 8;

    public static final int MONITOR3_ID = 9;

    public static final int HARD_DRIVE1_ID = 10;

    public static final int HARD_DRIVE2_ID = 11;

    public static final int HARD_DRIVE3_ID = 12;


    public static final Desktop desktop1 = new Desktop(DESKTOP1_ID, "D001", "ASUS",
            new BigDecimal("789.00"), 17, Desktop.FormFactor.DESKTOP, "Desktop");

    public static final Desktop desktop2 = new Desktop(DESKTOP2_ID, "D002", "KINGDEL",
            new BigDecimal("567.00"), 5, Desktop.FormFactor.NETTOP, "Desktop");

    public static final Desktop desktop3 = new Desktop(DESKTOP3_ID, "D003", "MICRO-STAR",
            new BigDecimal("912.00"), 26, Desktop.FormFactor.MONOBLOCK, "Desktop");


    public static ProductTo getUpdatedDesktop() {
        return new ProductTo(DESKTOP3_ID, "D004", "AMD", new BigDecimal("1333.00"),
                9, "Desktop", "DESKTOP", null, null, null);
    }

    public static ProductTo getNewDesktop() {
        return new ProductTo(null, "D005", "Intel", new BigDecimal("1115.00"),
                22, "Desktop", "MONOBLOCK", null, null, null);
    }

    public static final Laptop laptop1 = new Laptop(LAPTOP1_ID, "L001", "IBM",
            new BigDecimal("1500.00"), 8, Laptop.Size.SIZE_15, "Laptop");

    public static final Laptop laptop2 = new Laptop(LAPTOP2_ID, "L002", "LENOVO",
            new BigDecimal("1210.00"), 16, Laptop.Size.SIZE_13, "Laptop");

    public static final Laptop laptop3 = new Laptop(LAPTOP3_ID, "L003", "ASUS",
            new BigDecimal("1720.00"), 2, Laptop.Size.SIZE_17, "Laptop");

    public static ProductTo getUpdatedLaptop() {
        return new ProductTo(LAPTOP3_ID, "L007", "Apple", new BigDecimal("1833.00"),
                5, "Laptop", null, 13, null, null);
    }

    public static ProductTo getNewLaptop() {
        return new ProductTo(null, "L008", "Samsung", new BigDecimal("115.00"),
                222, "Laptop", null, 15, null, null);
    }

    public static final Monitor monitor1 = new Monitor(MONITOR1_ID, "M001", "DELL",
            new BigDecimal("500.00"), 41, 24L, "Monitor");

    public static final Monitor monitor2 = new Monitor(MONITOR2_ID, "M002", "Apple",
            new BigDecimal("810.00"), 6, 25L, "Monitor");

    public static final Monitor monitor3 = new Monitor(MONITOR3_ID, "M003", "ASUS",
            new BigDecimal("520.00"), 22, 27L, "Monitor");

    public static ProductTo getUpdatedMonitor() {
        return new ProductTo(MONITOR3_ID, "M006", "ViewSonic", new BigDecimal("654.00"),
                3, "Monitor", null, null, 31L, null);
    }

    public static ProductTo getNewMonitor() {
        return new ProductTo(null, "M011", "Samsung", new BigDecimal("615.00"),
                12, "Monitor", null, null, 21L, null);
    }

    public static final HardDrive hardDrive1 = new HardDrive(HARD_DRIVE1_ID, "H001",
            "Western Digital", new BigDecimal("370.00"), 8,
            "1000 GB", "Hard Drive");

    public static final HardDrive hardDrive2 = new HardDrive(HARD_DRIVE2_ID, "H002",
            "IBM", new BigDecimal("710.00"), 5,
            "1500 GB", "Hard Drive");

    public static final HardDrive hardDrive3 = new HardDrive(HARD_DRIVE3_ID, "H003",
            "DELL", new BigDecimal("420.00"), 4,
            "2000 GB", "Hard Drive");

    public static ProductTo getUpdatedHardDrive() {
        return new ProductTo(HARD_DRIVE3_ID, "H005", "Hitachi", new BigDecimal("576.00"),
                11, "Hard Drive", null, null, null, "500 GB");
    }

    public static ProductTo getNewHardDrive() {
        return new ProductTo(null, "H007", "Samsung", new BigDecimal("785.00"),
                22, "Hard Drive", null, null, null, "1500 GB");
    }
}