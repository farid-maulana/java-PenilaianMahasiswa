/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Penilaian {

    private int idPenilaian, nilai;
    private Mahasiswa mahasiswa = new Mahasiswa();
    private MataKuliah matakuliah = new MataKuliah();
    private String tipeNilai;

    public Penilaian() {
    }

    public Penilaian(int idPenilaian, Mahasiswa mahasiswa, MataKuliah matakuliah, int nilai, String tipeNilai) {
        this.idPenilaian = idPenilaian;
        this.mahasiswa = mahasiswa;
        this.matakuliah = matakuliah;
        this.nilai = nilai;
        this.tipeNilai = tipeNilai;
    }

    public void setIdPenilaian(int idPenilaian) {
        this.idPenilaian = idPenilaian;
    }

    public int getIdPenilaian() {
        return idPenilaian;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMatakuliah(MataKuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    public MataKuliah getMatakuliah() {
        return matakuliah;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getNilai() {
        return nilai;
    }

    public void setTipeNilai(String tipeNilai) {
        this.tipeNilai = tipeNilai;
    }

    public String getTipeNilai() {
        return tipeNilai;
    }

    public Penilaian getById(int id) {
        Penilaian penilaian = new Penilaian();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penilaian p "
                + "LEFT JOIN mahasiswa m "
                + "ON p.nim = m.nim "
                + "LEFT JOIN matakuliah mk "
                + "ON p.id_matkul = mk.id_matkul "
                + "WHERE id_penilaian = '" + id + "'");

        try {
            while (rs.next()) {
                penilaian.setIdPenilaian(rs.getInt("id_penilaian"));
                penilaian.getMahasiswa().setNim(rs.getString("nim"));
                penilaian.getMahasiswa().setNama(rs.getString("nama"));
                penilaian.getMahasiswa().setAlamat(rs.getString("alamat"));
                penilaian.getMahasiswa().setNoTelp(rs.getString("no_telp"));
                penilaian.getMatakuliah().setIdMatkul(rs.getInt("id_matkul"));
                penilaian.getMatakuliah().setNamaMatkul(rs.getString("nama_matkul"));
                penilaian.getMatakuliah().setSks(rs.getInt("sks"));
                penilaian.setTipeNilai(rs.getString("tipe_nilai"));
                penilaian.setNilai(rs.getInt("nilai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return penilaian;
    }

    public ArrayList<Penilaian> getAll() {
        ArrayList<Penilaian> ListPenilaian = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM penilaian p "
                + "LEFT JOIN mahasiswa m "
                + "ON p.nim = m.nim "
                + "LEFT JOIN matakuliah mk "
                + "ON p.id_matkul = mk.id_matkul");

        try {
            while (rs.next()) {
                Penilaian penilaian = new Penilaian();
                penilaian.setIdPenilaian(rs.getInt("id_penilaian"));
                penilaian.getMahasiswa().setNim(rs.getString("nim"));
                penilaian.getMahasiswa().setNama(rs.getString("nama"));
                penilaian.getMahasiswa().setAlamat(rs.getString("alamat"));
                penilaian.getMahasiswa().setNoTelp(rs.getString("no_telp"));
                penilaian.getMatakuliah().setIdMatkul(rs.getInt("id_matkul"));
                penilaian.getMatakuliah().setNamaMatkul(rs.getString("nama_matkul"));
                penilaian.getMatakuliah().setSks(rs.getInt("sks"));
                penilaian.setTipeNilai(rs.getString("tipe_nilai"));
                penilaian.setNilai(rs.getInt("nilai"));

                ListPenilaian.add(penilaian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ListPenilaian;
    }
    
    public ArrayList<Penilaian> search(String keyword) {
        ArrayList<Penilaian> ListPenilaian = new ArrayList();

        String sql = "SELECT * FROM penilaian p "
                + "LEFT JOIN mahasiswa m "
                + "ON p.nim = m.nim "
                + "LEFT JOIN matakuliah mk "
                + "ON p.id_matkul = mk.id_matkul "
                + "WHERE nama_matkul LIKE '%" + keyword + "%' OR "
                    + "nama LIKE '%" + keyword + "%' OR "
                    + "tipe_nilai LIKE '%" + keyword + "%' OR "
                    + "nilai LIKE '%" + keyword + "%'";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Penilaian penilaian = new Penilaian();
                penilaian.setIdPenilaian(rs.getInt("id_penilaian"));
                penilaian.getMahasiswa().setNim(rs.getString("nim"));
                penilaian.getMahasiswa().setNama(rs.getString("nama"));
                penilaian.getMahasiswa().setAlamat(rs.getString("alamat"));
                penilaian.getMahasiswa().setNoTelp(rs.getString("no_telp"));
                penilaian.getMatakuliah().setIdMatkul(rs.getInt("id_matkul"));
                penilaian.getMatakuliah().setNamaMatkul(rs.getString("nama_matkul"));
                penilaian.getMatakuliah().setSks(rs.getInt("sks"));
                penilaian.setTipeNilai(rs.getString("tipe_nilai"));
                penilaian.setNilai(rs.getInt("nilai"));

                ListPenilaian.add(penilaian);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPenilaian;
    }

    public boolean save() {
        if (getById(idPenilaian).getIdPenilaian() == 0) {
            String sql = "INSERT INTO penilaian (id_matkul, nim, tipe_nilai, nilai) "
                    + "VALUES ("
                    + "'" + this.getMatakuliah().getIdMatkul() + "', "
                    + "'" + this.getMahasiswa().getNim() + "', "
                    + "'" + this.tipeNilai + "', "
                    + "'" + this.nilai + "'"
                    + ")";
            this.idPenilaian = DBHelper.insertQueryGetId(sql);
        } else {
            String sql = "UPDATE penilaian SET "
                    + "id_matkul = '" + this.getMatakuliah().getIdMatkul() + "', "
                    + "nim = '" + this.getMahasiswa().getNim() + "', "
                    + "tipe_nilai = '" + this.tipeNilai + "',"
                    + "nilai = '" + this.nilai + "'";

            DBHelper.executeQuery(sql);
        }
        return true;
    }

    public void delete() {
        DBHelper.executeQuery("DELETE FROM penilaian WHERE id_penilaian = "
                + "'" + this.idPenilaian + "'");
    }
}
