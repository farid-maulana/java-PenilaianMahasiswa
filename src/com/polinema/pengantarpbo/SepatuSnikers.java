package com.polinema.pengantarpbo;

public class SepatuSnikers extends Sepatu {
    private String model;
    private int ukuranSol;

    public void setModel(String model) {
        this.model = model;
    }

    public void setUkuranSol(int ukuranSol) {
        this.ukuranSol = ukuranSol;
    }
    
    public void tambahUkuranSol(int ukuranSol) {
        this.ukuranSol += ukuranSol;
    }
    
    public void cetak() {
        super.cetak();
        System.out.println("Model Snikers : " + model);
        System.out.println("Ukuran Sol : " + ukuranSol + " cm");
    }
}
