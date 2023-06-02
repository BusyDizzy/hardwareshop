package com.antontkach.hardwareshop;

import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.model.Product;

import java.math.BigDecimal;

public class ProductTestData {

    public static final MatcherFactory.Matcher<Product> PRODUCT_MATCHER = MatcherFactory.usingEqualsComparator(Product.class);

    public static final MatcherFactory.Matcher<Desktop> DESKTOP_MATCHER = MatcherFactory.usingEqualsComparator(Desktop.class);

    public static final int NOT_FOUND = 100;

    public static final int DESKTOP1_ID = 1;

    public static final int DESKTOP2_ID = 2;

    public static final int DESKTOP3_ID = 3;

    public static final int LAPTOP1_ID = 4;

    public static final int LAPTOP2_ID = 5;

    public static final int LAPTOP3_ID = 6;

    public static final Desktop desktop1 = new Desktop(DESKTOP1_ID, "D001", "ASUS", new BigDecimal("789.00"), 17, Desktop.FormFactor.DESKTOP);

    public static final Desktop desktop2 = new Desktop(DESKTOP2_ID, "D002", "KINGDEL", new BigDecimal("567.00"), 5, Desktop.FormFactor.NETTOP);

    public static final Desktop desktop3 = new Desktop(DESKTOP3_ID, "D003", "MICRO-STAR", new BigDecimal("912.00"), 26, Desktop.FormFactor.MONOBLOCK);
}