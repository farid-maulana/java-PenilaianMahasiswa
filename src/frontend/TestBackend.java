/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

/**
 *
 * @author LENOVO
 */
import backend.*;

public class TestBackend {

  public static void main(String[] args) {
        Kelas kls = new Kelas(1,"TI 2F", 2);
// test insert
        kls.save();
       
// test update
        kls.setNamaKelas("TI 3F");
        kls.save();
// test delete
        kls.delete();
// test select all
        for(Kelas k : new Kelas().getAll())
        {
            System.out.println("Nama Kelas: " + k.getNamaKelas() + ", Tingkat: " + k.getTingkat());
        }
// test search
        for(Kelas k : new Kelas().search("2F"))
        {
            System.out.println("Nama Kelas: " + k.getNamaKelas() + ", Tingkat: " + k.getTingkat());
        }
  }
}