package com.polinema.pengantarpbo;

public class wirelessSpeaker extends Speaker {
    private String koneksi;
    private int treble;

    public void setKoneksi(String koneksi) {
        this.koneksi = koneksi;
    }

    public void setTreble(int treble) {
        this.treble = treble;
    }
    
    public void cetak() {
        System.out.println("Wireless Speaker");
        super.cetak();
        System.out.println("Koneksi : " + koneksi);
        System.out.println("Bass : " + treble);
    }
}
