/*
 * Copyright 2017 Quang Vinh (quangvinh.gulang@gmail.com)
 */
package Model;

/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class ThongKe {
    String thongKe;
    int maDoiTuong;
    int soLuong;

    public ThongKe() {
    }

    public ThongKe(String thongKe,int maDoiTuong, int soLuong) {
        this.thongKe = thongKe;
        this.maDoiTuong = maDoiTuong;
        this.soLuong = soLuong;
    }

    public String getThongKe() {
        return thongKe;
    }

    public void setThongKe(String thongKe) {
        this.thongKe = thongKe;
    }

    public int getMaDoiTuong() {
        return maDoiTuong;
    }

    public void setMaDoiTuong(int maDoiTuong) {
        this.maDoiTuong = maDoiTuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
