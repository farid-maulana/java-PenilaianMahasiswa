package com.polinema.pengantarpbo;

public class Main {
    public static void main(String[] args) {  
        Sepatu sepatu1 = new Sepatu();
        Sepatu sepatu2 = new Sepatu();
        SepatuSnikers sepatu3 = new SepatuSnikers();

        sepatu1.setMerk("New Era");
        sepatu1.setWarna("Hitam");
        sepatu1.setUkuran(40);
        sepatu1.cetak();
        
        sepatu2.setMerk("Nike");
        sepatu2.setWarna("Coklat");
        sepatu2.setUkuran(38);
        sepatu2.cetak();
        
        sepatu3.setMerk("Adidas");
        sepatu3.setWarna("Abu-abu");
        sepatu3.setUkuran(41);
        sepatu3.setModel("Classic");
        sepatu3.tambahUkuranSol(3);
        sepatu3.cetak();
    }
}
