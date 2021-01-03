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
public class Dosen extends Person {

    private String nip;
    private MataKuliah mk = new MataKuliah();
    
    public Dosen() {
    }

    public Dosen(String nip, String nama, String alamat, String jk, String noTelp) {
        super(nama, alamat, jk, noTelp);
        this.nip = nip;
    }
    
    public MataKuliah getMataKuliah(){
        return mk;
    }

    public void setMataKuliah(MataKuliah mk) {
        this.mk = mk;
    }

    public String getNip() {
        return nip;
    }
    
    public void setNip(String nip) {
        this.nip = nip;
    }
    
    public Dosen getByNip(String nip) {
        Dosen ds = new Dosen();
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM dosen d "
                + "LEFT JOIN matakuliah m "
                + "ON d.id_matkul = m.id_matkul "
                + "WHERE nip = '" + nip + "'");
        
        try {
            while (resultSet.next()) {
                ds = new Dosen();
                ds.setNip(resultSet.getString("nip"));
                ds.getMataKuliah().setIdMatkul(resultSet.getInt("id_matkul"));
                ds.getMataKuliah().setNamaMatkul(resultSet.getString("nama_matkul"));
                ds.getMataKuliah().setSks(resultSet.getInt("sks"));
                ds.setNama(resultSet.getString("nama_dosen"));
                ds.setAlamat(resultSet.getString("alamat_dosen"));
                ds.setJk(resultSet.getString("jk_dosen"));
                ds.setNoTelp(resultSet.getString("no_telp_dosen"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    
    public ArrayList<Dosen> getAll() {
        ArrayList<Dosen> ListDosen = new ArrayList();
        
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM dosen d "
                + "LEFT JOIN matakuliah m "
                + "ON d.id_matkul = m.id_matkul");
        
        try {
            while (resultSet.next()) {
                Dosen ds = new Dosen();
                ds.setNip(resultSet.getString("nip"));
                ds.getMataKuliah().setIdMatkul(resultSet.getInt("id_matkul"));
                ds.getMataKuliah().setNamaMatkul(resultSet.getString("nama_matkul"));
                ds.getMataKuliah().setSks(resultSet.getInt("sks"));
                ds.setNama(resultSet.getString("nama_dosen"));
                ds.setAlamat(resultSet.getString("alamat_dosen"));
                ds.setJk(resultSet.getString("jk_dosen"));
                ds.setNoTelp(resultSet.getString("no_telp_dosen"));         
                
                ListDosen.add(ds);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ListDosen;
    }
    
    public ArrayList<Dosen> search(String keyword) {
        ArrayList<Dosen> ListDosen = new ArrayList();
        
        String sql = "SELECT * FROM dosen d "
                + "LEFT JOIN matakuliah m "
                + "ON d.id_matkul = m.id_matkul "
                + "WHERE nip LIKE '%" + keyword + "%' OR "
                + "nama_dosen LIKE '%" + keyword + "%' OR "
                + "alamat_dosen LIKE '%" + keyword + "%' OR "
                + "jk_dosen LIKE '%" + keyword + "%' OR "
                + "no_telp_dosen LIKE '%" + keyword + "%'";
        
        ResultSet resultSet = DBHelper.selectQuery(sql);
        
        try {
            while (resultSet.next()) {
                Dosen ds = new Dosen();
                ds.setNip(resultSet.getString("nip"));
                ds.getMataKuliah().setIdMatkul(resultSet.getInt("id_matkul"));
                ds.getMataKuliah().setNamaMatkul(resultSet.getString("nama_matkul"));
                ds.getMataKuliah().setSks(resultSet.getInt("sks"));
                ds.setNama(resultSet.getString("nama_dosen"));
                ds.setAlamat(resultSet.getString("alamat_dosen"));
                ds.setJk(resultSet.getString("jk_dosen"));
                ds.setNoTelp(resultSet.getString("no_telp_dosen"));
                
                ListDosen.add(ds);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ListDosen;
    }
    
    public void save() {
        if (getByNip(nip).getNip() == null) {
            String SQL = "INSERT INTO dosen(nip, id_matkul, nama_dosen, jk_dosen, alamat_dosen, no_telp_dosen) VALUES ("
                    + "'" + this.nip + "', "
                    + "'" + this.getMataKuliah().getIdMatkul() + "', "
                    + "'" + this.nama + "', "
                    + "'" + this.jk + "', "
                    + "'" + this.alamat + "', "
                    + "'" + this.noTelp + "'"
                    + ")";
            DBHelper.executeQuery(SQL);
        } else {
            String SQL = "UPDATE dosen SET "
                    + "id_matkul = '" + this.getMataKuliah().getIdMatkul() + "', "
                    + "nama_dosen = '" + this.nama + "', "
                    + "jk_dosen = '" + this.jk + "', "
                    + "alamat_dosen = '" + this.alamat + "', "
                    + "no_telp_dosen = '" + this.noTelp + "' "
                    + "WHERE nip = '" + this.nip + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM dosen WHERE nip = '" + this.nip + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String jumlahDosen() {
        String total = "";
        ResultSet rs = DBHelper.selectQuery("SELECT count(*) AS total FROM dosen");
        try {
            while (rs.next()) {
                total = rs.getString("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return nip;
    }
}
