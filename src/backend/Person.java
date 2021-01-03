/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author LENOVO
 */
public abstract class Person {
    public String nama, alamat, jk, noTelp;

    public Person() {
    }

    public Person(String nama, String alamat, String jk, String noTelp) {
        this.nama = nama;
        this.alamat = alamat;
        this.jk = jk;
        this.noTelp = noTelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {        
        if (jk.equals("L"))
            return "Laki-Laki";
        else if (jk.equals("P"))
            return "Perempuan";
        else 
            return "";
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    @Override
    public abstract String toString();
}
