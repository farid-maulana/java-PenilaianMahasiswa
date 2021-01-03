package com.polinema.pengantarpbo;

public class Speaker {
    private String merk;
    private int volume;

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    public void cetak() {
        System.out.println("Merk : " + merk);
        System.out.println("Max volume : " + volume);
    }
}
