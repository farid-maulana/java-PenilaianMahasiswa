/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Kelas {
    public int idKelas,tingkat;
    public String namaKelas;
    
    public Kelas(){
    }

    public Kelas(int idKelas, String namaKelas,int tingkat) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.tingkat = tingkat;
    }
    
    public void setidKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public int getidKelas() {
        return idKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setTingkat(int tingkat) {
        this.tingkat = tingkat;
    }

    public int getTingkat() {
        return tingkat;
    }
    
    public Kelas getById(int idKelas) {
        Kelas kelas = new Kelas();
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM kelas "
                + "WHERE id_kelas = '" + idKelas + "'");

        try {
            while (resultSet.next()) {
                kelas = new Kelas();
                kelas.setidKelas(resultSet.getInt("id_kelas"));
                kelas.setNamaKelas(resultSet.getString("nama_kelas"));
                kelas.setTingkat(resultSet.getInt("tingkat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kelas;
    }

    public ArrayList<Kelas> getAll() {
        ArrayList<Kelas> ListKelas = new ArrayList();

        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM kelas");

        try {
            while (resultSet.next()) {
                Kelas kelas = new Kelas();
                kelas.setidKelas(resultSet.getInt("id_kelas"));
                kelas.setNamaKelas(resultSet.getString("nama_kelas"));
                kelas.setTingkat(resultSet.getInt("tingkat"));

                ListKelas.add(kelas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListKelas;
    }

    public ArrayList<Kelas> search(String keyword) {
        ArrayList<Kelas> ListKelas = new ArrayList();

        String sql = "SELECT * FROM kelas WHERE "
                + "nama_kelas LIKE '%" + keyword + "%' OR "
                + "tingkat LIKE '%" + keyword + "%'";

               
        ResultSet resultSet = DBHelper.selectQuery(sql);

        try {
            while (resultSet.next()) {
                Kelas kelas = new Kelas();
                kelas.setidKelas(resultSet.getInt("id_kelas"));
                kelas.setNamaKelas(resultSet.getString("nama_kelas"));
                kelas.setTingkat(resultSet.getInt("tingkat"));


                ListKelas.add(kelas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListKelas;
    }

    public void save() {
        if (getById(idKelas).getidKelas() == 0) {
            String SQL = "INSERT INTO kelas(nama_kelas,tingkat) VALUES ("
                    + "'" + this.namaKelas + "', "
                    + "'" + this.tingkat + "' "
                    + ")";
            this.idKelas = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE kelas SET "
                    + "nama_kelas = '" + this.namaKelas + "', "
                    + "tingkat = '" + this.tingkat + "' "
                    + "WHERE id_kelas = '" + this.idKelas + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM kelas WHERE id_kelas = '" + this.idKelas + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String jumlahKelas() {
        String total = "";
        ResultSet rs = DBHelper.selectQuery("SELECT count(*) AS total FROM kelas");
        try {
            while (rs.next()) {
                total = rs.getString("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    
    public String toString() {
        return namaKelas;
    }
}

    
    

