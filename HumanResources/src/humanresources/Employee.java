package humanresources;

import java.util.Scanner;

public class Employee extends Staff implements ICalculator {

    private int soGioLamThem;

    public Employee() {
        
    }

    public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, int heSoLuong, String ngayVaoLam,
            String boPhanLamViec, int soNgayNghi, int soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghi);
        this.soGioLamThem = soGioLamThem;
        //this.setSalary(calculateSalary());     
    }

    public int getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    void displayInformation() {
        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", getMaNhanVien(),
                getTenNhanVien(), getTuoiNhanVien(), getHeSoLuong(), getNgayVaoLam(),
                getBoPhanLamViec(), getSoNgayNghi(), "Không có", getSoGioLamThem()));

    }

    public int calculateSalary() {
        return getHeSoLuong() * 3000000 + getSoGioLamThem() * 200000;
    }

    @Override
    public int getSalary() {
        return calculateSalary();
    }

}
