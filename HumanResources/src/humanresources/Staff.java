package humanresources;

import java.util.Scanner;

public abstract class Staff {
    String maNhanVien;
    protected String tenNhanVien;
    private int tuoiNhanVien;
    private int heSoLuong;
    private String ngayVaoLam;
    private String boPhanLamViec;
    private int soNgayNghi;
    //private int luong;

    public Staff() {
        
    }

    public Staff(String maNhanVien, String tenNhanVien, int tuoiNhanVien, int heSoLuong, String ngayVaoLam, String boPhanLamViec,
            int soNgayNghi) {
        
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanLamViec = boPhanLamViec;
        this.soNgayNghi = soNgayNghi;
        
    }

    
    /*public int getSalary() {
        return luong;
    }

    public void setSalary(int luong) {
        this.luong = luong;
    }*/

    public abstract int getSalary();

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getTuoiNhanVien() {
        return tuoiNhanVien;
    }

    public void setTuoiNhanVien(int tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getBoPhanLamViec() {
        return boPhanLamViec;
    }

    public void setBoPhanLamViec(String boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }

    public int getSoNgayNghi() {
        return soNgayNghi;
    }

    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    abstract void displayInformation();

    public String toString() {
        return "Ma nhan vien: " + this.maNhanVien + ", Ten nhan vien: " + this.tenNhanVien + ", Tuoi nhan vien: "
                + this.tuoiNhanVien + ", He so luong: " + this.heSoLuong + ", Ngay vao lam: " + this.ngayVaoLam
                + ", Bo phan lam viec: " + this.boPhanLamViec + ", So ngay nghi: " + this.soNgayNghi;
    }
}
