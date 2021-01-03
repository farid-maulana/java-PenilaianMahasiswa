package com.polinema.pengantarpbo;

public class Demo {
    public static void main(String[] args) {
        Speaker speaker1 = new Speaker();
        wiredSpeaker speaker2 = new wiredSpeaker();
        wirelessSpeaker speaker3 = new wirelessSpeaker();
        
        System.out.println("Speaker");
        speaker1.setMerk("Advance");
        speaker1.setVolume(60);
        speaker1.cetak();
        
        speaker2.setMerk("JBL");
        speaker2.setVolume(80);
        speaker2.setJenisKabel("MIDI");
        speaker2.setPanjangKabel(3);
        speaker2.cetak();
        
        speaker3.setMerk("JBL");
        speaker3.setVolume(100);
        speaker3.setKoneksi("Bluetooth");
        speaker3.setTreble(70);
        speaker3.cetak();
    }
}
