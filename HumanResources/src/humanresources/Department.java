package humanresources;
public class Department {
    
    private String maBoPhan;
    private String tenBoPhan;
    private int soLuongNhanVienHienTai;

    public Department(String maBoPhan, String tenBoPhan, int soLuongNhanVienHienTai) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai;
    }

    public String getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getSoLuongNhanVienHienTai() {
        return soLuongNhanVienHienTai;
    }

    public void setSoLuongNhanVienHienTai(int soLuongNhanVienHienTai) {
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai;
    }

    public String toString() {
      return  String.format("%-10s%-20s%-20s",  getMaBoPhan(),  getTenBoPhan(), getSoLuongNhanVienHienTai());
    }

    
}
