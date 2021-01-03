package com.polinema.pengantarpbo;

public class wiredSpeaker extends Speaker {
    private String jenisKabel;
    private int panjangKabel;

    public void setJenisKabel(String jenisKabel) {
        this.jenisKabel = jenisKabel;
    }

    public void setPanjangKabel(int panjangKabel) {
        this.panjangKabel = panjangKabel;
    }
    
    public void cetak() {
        System.out.println("Wired Speaker");
        super.cetak();
        System.out.println("Jenis Kabel : " + jenisKabel);
        System.out.println("Panjang Kabel : " + panjangKabel + " meter");
    }
}
