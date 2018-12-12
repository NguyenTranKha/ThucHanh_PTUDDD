package com.example.techmaster.gridview_spinner;

import java.security.PublicKey;

public class Dish {
        private String tenmon;
        private boolean promotion;
        private CustomSpinner customSpinner;
//        private int img;
//        private String thumb;



    public Dish(){};

    public Dish(String tenmon, boolean promotion, CustomSpinner customSpinner) {
        this.tenmon = tenmon;
        this.promotion = promotion;
        this.customSpinner = customSpinner;
    }

    public CustomSpinner getCustomSpinner() {
        return customSpinner;
    }

    public void setCustomSpinner(CustomSpinner customSpinner) {
        this.customSpinner = customSpinner;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
