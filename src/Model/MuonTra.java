/*
 * Copyright 2017 Quang Vinh (quangvinh.gulang@gmail.com)
 */
package Model;

import java.sql.Date;

/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class MuonTra {
    private int maMuonTra;
    private int maDocGia;
    private String tenDocGia;    
    private int maSach;
    private String tenSach;
    private String theLoai;
    private String tenTacGia;
    private int maNhanVien;
    private Date ngayMuon;
    private Date ngayTra;
    private int maPhieu;
    
    
    public MuonTra() {
        
    }

    public MuonTra(int maMuonTra, int maDocGia, String tenDocGia, int maSach, String tenSach, String theLoai, String tenTacGia, int maNhanVien, Date ngayMuon, Date ngayTra, int maPhieu) {
        this.maMuonTra = maMuonTra;
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tenTacGia = tenTacGia;
        this.maNhanVien = maNhanVien;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.maPhieu = maPhieu;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }
    

    public int getMaMuonTra() {
        return maMuonTra;
    }

    public void setMaMuonTra(int maMuonTra) {
        this.maMuonTra = maMuonTra;
    }

    public int getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(int maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    
}
