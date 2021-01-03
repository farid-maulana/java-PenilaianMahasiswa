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
public class Mahasiswa extends Person {
    private Kelas kelas = new Kelas();
    private String nim;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, Kelas kelas, String nama, String alamat, String jk, String noTelp) {
        super(nama, alamat, jk, noTelp);
        this.nim = nim;
        this.kelas = kelas;
    } 

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public Mahasiswa getByNim(String nim) {
        Mahasiswa mhs = new Mahasiswa();
        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM mahasiswa m "
                + "LEFT JOIN kelas k "
                + "ON m.id_kelas = k.id_kelas "
                + "WHERE nim = '" + nim + "'");

        try {
            while (resultSet.next()) {
                mhs = new Mahasiswa();
                mhs.setNim(resultSet.getString("nim"));
                mhs.getKelas().setidKelas(resultSet.getInt("id_kelas"));
                mhs.getKelas().setNamaKelas(resultSet.getString("nama_kelas"));
                mhs.getKelas().setTingkat(resultSet.getInt("tingkat"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setJk(resultSet.getString("jk"));
                mhs.setAlamat(resultSet.getString("alamat"));
                mhs.setNoTelp(resultSet.getString("no_telp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mhs;
    }

    public ArrayList<Mahasiswa> getAll() {
        ArrayList<Mahasiswa> ListMahasiswa = new ArrayList();

        ResultSet resultSet = DBHelper.selectQuery("SELECT * FROM mahasiswa m "
                + "LEFT JOIN kelas k "
                + "ON m.id_kelas = k.id_kelas");

        try {
            while (resultSet.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(resultSet.getString("nim"));
                mhs.getKelas().setidKelas(resultSet.getInt("id_kelas"));
                mhs.getKelas().setNamaKelas(resultSet.getString("nama_kelas"));
                mhs.getKelas().setTingkat(resultSet.getInt("tingkat"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setJk(resultSet.getString("jk"));
                mhs.setAlamat(resultSet.getString("alamat"));
                mhs.setNoTelp(resultSet.getString("no_telp"));

                ListMahasiswa.add(mhs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListMahasiswa;
    }

    public ArrayList<Mahasiswa> search(String keyword) {
        ArrayList<Mahasiswa> ListMahasiswa = new ArrayList();

        String sql = "SELECT * FROM mahasiswa m "
                + "LEFT JOIN kelas k "
                + "ON m.id_kelas = k.id_kelas "
                + "WHERE nim LIKE '%" + keyword + "%' OR "
                    + "nama_kelas LIKE '%" + keyword + "%' OR "
                    + "nama LIKE '%" + keyword + "%' OR "
                    + "alamat LIKE '%" + keyword + "%' OR "
                    + "no_telp LIKE '%" + keyword + "%'";

        ResultSet resultSet = DBHelper.selectQuery(sql);

        try {
            while (resultSet.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNim(resultSet.getString("nim"));
                mhs.getKelas().setidKelas(resultSet.getInt("id_kelas"));
                mhs.getKelas().setNamaKelas(resultSet.getString("nama_kelas"));
                mhs.getKelas().setTingkat(resultSet.getInt("tingkat"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setJk(resultSet.getString("jk"));
                mhs.setAlamat(resultSet.getString("alamat"));
                mhs.setNoTelp(resultSet.getString("no_telp"));

                ListMahasiswa.add(mhs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListMahasiswa;
    }

    public void save() {
        if (getByNim(nim).getNim() == null) {
            String SQL = "INSERT INTO mahasiswa(nim, nama, jk, id_kelas, alamat, no_telp) VALUES ("
                    + "'" + this.nim + "', "
                    + "'" + this.nama + "', "
                    + "'" + this.jk + "', "
                    + "'" + this.getKelas().getidKelas() + "', "
                    + "'" + this.alamat + "', "
                    + "'" + this.noTelp + "' "
                    + ")";
            DBHelper.executeQuery(SQL);
        } else {
            String SQL = "UPDATE mahasiswa SET "
                    + "nama = '" + this.nama + "', "
                    + "jk = '" + this.jk + "', "
                    + "id_kelas = '" + this.getKelas().getidKelas() + "', "
                    + "alamat = '" + this.alamat + "', "
                    + "no_telp = '" + this.noTelp + "' "
                    + "WHERE nim = '" + this.nim + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM mahasiswa WHERE nim = '" + this.nim + "'";
        DBHelper.executeQuery(SQL);
    }
    
    public String jumlahMahasiswa() {
        String total = "";
        ResultSet rs = DBHelper.selectQuery("SELECT count(*) AS total FROM mahasiswa");
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
        return nim;
    }
}
