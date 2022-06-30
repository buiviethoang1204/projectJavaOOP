package humanresources;

import java.util.Scanner;

public class Manger extends Staff implements ICalculator {

    private String chucDanh;

    public Manger(String maNhanVien, String tenNhanVien, int tuoiNhanVien, int heSoLuong, String ngayVaoLam,
            String boPhanLamViec, int soNgayNghi, String chucDanh) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghi);
        this.chucDanh = chucDanh;
        //this.setSalary(calculateSalary());        
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    void displayInformation() {
        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", getMaNhanVien(),
                tenNhanVien, getTuoiNhanVien(), getHeSoLuong(), getNgayVaoLam(), getBoPhanLamViec(),
                getSoNgayNghi(), getChucDanh(), "Không có"));
    }

    public int calculateSalary() {
        int luong = 0;
        if (this.chucDanh == "Kế toán trưởng") {
            luong = getHeSoLuong()*5000000 + 6000000;
        } else if (this.chucDanh == "Nhân sự trưởng") {
            luong = getHeSoLuong()*5000000 + 5000000;
        } else if (this.chucDanh == "Kinh doanh trưởng") {
            luong = getHeSoLuong()*5000000 + 8000000;
        }
        return luong;
    }

    @Override
    public int getSalary()
    {
        return calculateSalary();
    }
}
