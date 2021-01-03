package com.polinema.pengantarpbo;

public class Sepatu {
    private String merk, warna;
    private int ukuran;

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setUkuran(int ukuran) {
        this.ukuran = ukuran;
    }
    
    public void tambahUkuran(int ukuran) {
        this.ukuran += ukuran;
    }
    
    public void cetak() {
        System.out.println("------------------------");
        System.out.println("Merk Sepatu : " + merk);
        System.out.println("Warna Sepatu : " + warna);
        System.out.println("Ukuran : " + ukuran);
    }
}
