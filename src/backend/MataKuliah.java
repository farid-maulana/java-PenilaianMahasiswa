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
public class MataKuliah {
    public int idMatkul,sks;
    public String namaMatkul;

    public MataKuliah() {
    }

    public MataKuliah(int idMatkul,String namaMatkul,int sks){
        this.idMatkul=idMatkul;
        this.namaMatkul=namaMatkul;
        this.sks=sks;
    }

    public void setIdMatkul(int idMatkul) {
        this.idMatkul = idMatkul;
    }

    public int getIdMatkul() {
        return idMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public int getSks() {
        return sks;
    }

   public MataKuliah getById(int idMatkul) {
        MataKuliah mk  = new MataKuliah();
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM matakuliah "
                + "WHERE id_matkul = '" + idMatkul + "'");

        try {
            while (resultSet.next()) {
                mk = new MataKuliah();
                mk.setIdMatkul(resultSet.getInt("id_matkul"));
                mk.setNamaMatkul(resultSet.getString("nama_matkul"));
                mk.setSks(resultSet.getInt("sks"));
        
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mk;
    }

    public ArrayList<MataKuliah> getAll() {
        ArrayList<MataKuliah> ListMataKuliah = new ArrayList();

        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM matakuliah");

        try {
            while (resultSet.next()) {
                MataKuliah mk = new MataKuliah();
                mk.setIdMatkul(resultSet.getInt("id_matkul"));
                mk.setNamaMatkul(resultSet.getString("nama_matkul"));
                mk.setSks(resultSet.getInt("sks"));

                ListMataKuliah.add(mk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListMataKuliah;
    }

    public ArrayList<MataKuliah> search(String keyword) {
        ArrayList<MataKuliah> ListMataKuliah = new ArrayList();

        String sql = "SELECT * FROM matakuliah WHERE "
                + "id_matkul LIKE '%" + keyword + "%' OR "
                + "nama_matkul LIKE '%" + keyword + "%' OR "
                + "sks LIKE '%" + keyword + "%'";
           
        ResultSet resultSet = DBHelper.selectQuery(sql);

        try {
            while (resultSet.next()) {
               MataKuliah mk = new MataKuliah();
                mk.setIdMatkul(resultSet.getInt("id_matkul"));
                mk.setNamaMatkul(resultSet.getString("nama_matkul"));
                mk.setSks(resultSet.getInt("sks"));

                ListMataKuliah.add(mk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListMataKuliah;
    }

    public void save() {
        if (getById(idMatkul).getIdMatkul() == 0) {
            String SQL = "INSERT INTO matakuliah(nama_matkul, sks) VALUES ("
                    + "'" + this.namaMatkul + "', "
                    + "'" + this.sks + "'"
                    + ")";
            this.idMatkul = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE matakuliah SET "
                    + "nama_matkul = '" + this.namaMatkul + "', "
                    + "sks = '" + this.sks + "'"
                    + "WHERE id_matkul = '" + this.idMatkul+ "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM matakuliah WHERE id_matkul = '" + this.idMatkul + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String jumlahMataKuliah() {
        String total = "";
        ResultSet rs = DBHelper.selectQuery("SELECT count(*) AS total FROM matakuliah");
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
        return namaMatkul;
    }
}
