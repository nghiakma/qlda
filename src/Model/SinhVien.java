/*
 * Copyright 2017 Quang Vinh (quangvinh.gulang@gmail.com)
 */
package Model;

/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class SinhVien {
    int maDocGia;
    String tenDocGia;
    String ngaySinh;
    String gioiTinh;
    String diaChi;
    String email;    
    String dienThoai;
    String ngaylapthe;
    
    public SinhVien(){
        
    }
    public SinhVien(int maDocGia, String tenDocGia, String ngaySinh, String gioiTinh, String diaChi, String email, String dienThoai, String ngayLapThe) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.dienThoai = dienThoai;
        this.ngaylapthe = ngayLapThe;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getNgayLapThe() {
        return ngaylapthe;
    }

    public void setNgayLapThe(String ngaylapthe) {
        this.ngaylapthe = ngaylapthe;
    }

}
