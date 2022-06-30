package humanresources;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HumanResources {

    // tạo các list để lưu các bộ phận và các nhân viên
    
    public static ArrayList<Department> departments = new ArrayList<>();
    public static ArrayList<Staff> staffs = new ArrayList<>();

    

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        themMacDinh();

        do {
            showMenu();
            int choice = in.nextInt();

            if (choice == 0) {
                System.out.println("Thoát!");
                break;
            }
            switch (choice) {

                case 1 -> hienThiNhanVien();
                case 2 -> hienThiBoPhan();
                case 3 -> nhanVienTheoBoPhan();
                case 4 -> themNhanVien();
                case 5 -> timKiemNhanVien();
                case 6 -> hienThiLuongTangDan();
                case 7 -> hienThiLuongGiamDan();

            }

        } while (true);

    }

    // menu
    public static void showMenu() {

        System.out.println("==================== HUMAN RESOURCES ====================");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty ");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");

    }

    // thêm danh sách các nhân viên có sẵn và bộ phận làm việc
    public static void themMacDinh() {
        // thêm bộ phận
        departments.add(new Department("KT", "Kế toán", 1));
        departments.add(new Department("NS", "Nhân sự", 1));
        departments.add(new Department("KD", "Kinh doanh", 1));

        // thêm nhân viên thường
        staffs.add(new Employee("NV1", "Do Thi Ha", 22, 3, "23/09/2020", "KT", 15, 36));
        staffs.add(new Employee("NV2", "Do Phuong Anh", 24, 4, "21/08/2020", "NS", 2, 40));
        staffs.add(new Employee("NV3", "Cao Ky Duyen", 24, 3, "18/05/2020", "KD", 4, 28));

        // thêm quản lý
        staffs.add(new Manger("QL1", "Dao Duy Manh", 32, 2, "15/05/2020", "KT", 2, "Kế toán trưởng"));
        staffs.add(new Manger("QL2", "Tran Cong Vinh", 32, 3, "12/05/2020", "NS", 4, "Nhân sự trưởng"));
        staffs.add(new Manger("QL3", "Do Tan Tai", 28, 4, "09/06/2020", "KD", 2, "Kinh doanh trưởng"));

        
    }

    // 1. Hiển thị danh sách nhân viên hiện có trong công ty
    public static void hienThiNhanVien() {

        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "MNV", "Tên", "Tuổi", "HSL",
                "NVL", "BPLV", "SNN", "CD", "SGLT"));

        // vòng lặp chạy qua list nhân viên và hiển thị các nhân viên
        for (Staff staff : staffs) {
            staff.displayInformation();
        }
    }

    // 2. Hiển thị các bộ phận trong công ty
    public static void hienThiBoPhan() {
        int countKT = 0;
        int countNS = 0;
        int countKD = 0;

        System.out.println(String.format("%-10s%-20s%-20s", "Mã BP", "Tên BP", "Số lượng NV"));

        // vòng lặp chạy qua list  nhân viên và kiểm tra xem nếu bộ phận làm việc
        // trùng với "mã bộ phận" thì tăng số lượng nhân viên
        for (Staff staff : staffs) {
            if (staff.getBoPhanLamViec().equalsIgnoreCase("KT")) {
                countKT++;
            } else if (staff.getBoPhanLamViec().equalsIgnoreCase("NS")) {
                countNS++;
            } else {
                countKD++;
            }
        }

        // vòng lặp chạy qua list bộ phận và kiểm tra và tăng số lượng nhân viên
        for (Department department : departments) {
            if (department.getMaBoPhan().equalsIgnoreCase("KT")) {
                department.setSoLuongNhanVienHienTai(countKT);
            } else if (department.getMaBoPhan().equalsIgnoreCase("NS")) {
                department.setSoLuongNhanVienHienTai(countNS);
            } else {
                department.setSoLuongNhanVienHienTai(countKD);
            }
        }

        // vòng lặp chạy qua và hiển thị thông tin bộ phận
        for (Department department : departments) {
            System.out.println(department.toString());
        }
    }

    // 3. Hiển thị các nhân viên theo từng bộ phận
    public static void nhanVienTheoBoPhan() {
        System.out.println("Bộ phận Kế Toán");

        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "MNV", "Tên", "Tuổi", "HSL",
                "NVL", "BPLV", "SNN", "CD", "SGLT"));

        // vòng lặp chạy qua list nhân viên , kiểm tra và hiển thị
        // nhân viên tương ứng với bộ phận đó
        
        for (Staff staff : staffs) {
            if (staff.getBoPhanLamViec().equalsIgnoreCase("KT")) {
                staff.displayInformation();
            }
        }

        System.out.println();

        System.out.println("Bộ phận Nhân sự");

        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "MNV", "Tên", "Tuổi", "HSL",
                "NVL", "BPLV", "SNN", "CD", "SGLT"));

        // vòng lặp chạy qua list nhân viên , kiểm tra và hiển thị
        // nhân viên tương ứng với bộ phận đó
        for (Staff staff : staffs) {
            if (staff.getBoPhanLamViec().equalsIgnoreCase("NS")) {
                staff.displayInformation();
            }
        }

        System.out.println();

        System.out.println("Bộ phận Kinh doanh");

        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "MNV", "Tên", "Tuổi", "HSL",
                "NVL", "BPLV", "SNN", "CD", "SGLT"));

        // vòng lặp chạy qua list nhân viên , kiểm tra và hiển thị
        // nhân viên tương ứng với bộ phận đó
        for (Staff staff : staffs) {
            if (staff.getBoPhanLamViec().equalsIgnoreCase("KD")) {
                staff.displayInformation();
            }
        }
    }

    // 4. Thêm nhân viên mới vào công ty
    public static void themNhanVien() {
        Scanner in = new Scanner(System.in);

        // nhập các thông tin chung
        System.out.println("Tên nhân viên: ");
        String ten = in.nextLine();

        System.out.println("Tuổi nhân viên: ");
        int tuoi = in.nextInt();

        System.out.println("Hệ số lương: ");
        int heSoLuong = in.nextInt();

        System.out.println("Ngày vào làm: ");
        String ngayVaoLam = in.next();

        System.out.println("Bộ phận làm việc: ");
        String boPhan = chonMaBoPhan(in);

        System.out.println("Số ngày nghỉ phép: ");
        int nghiPhep = in.nextInt();

        // chọn thêm quản lý hay thêm nhân viên thường? sau khi thêm xong sẽ add vào
        // list
        System.out.println("Chọn 1: thêm quản lý, Chọn 2: thêm nhân viên thường");
        int choose = in.nextInt();

        if (choose == 1) {
            String id = themMaNhanVien(in);

            String chucDanh = chonChucDanh(in);

            Manger newManager = new Manger(id, ten, tuoi, heSoLuong, ngayVaoLam, boPhan, nghiPhep, chucDanh);
            
            staffs.add(newManager);
        } else if (choose == 2) {
            String id = themMaNhanVien(in);
            System.out.println("Số giờ làm thêm: ");
            int gioLamThem = in.nextInt();

            Employee newEmployee = new Employee(id, ten, tuoi, heSoLuong, ngayVaoLam, boPhan, nghiPhep, gioLamThem);
            
            staffs.add(newEmployee);
        }
    }

    // 4.1 xét điều kiện cho mã nhân viên ko trùng nhau
    public static String themMaNhanVien(Scanner in) {
        String id = "";
        while (true) {
            System.out.println("Mã nhân viên: ");
            id = in.next();

            // check mã
            boolean idExists = false;
            for (Staff staff : staffs) {
                if (staff.getMaNhanVien().equalsIgnoreCase(id)) {
                    idExists = true;
                    break;
                }
            }
            if (!idExists) {
                break;
            } else {
                System.out.println("Mã đã tồn tại, xin nhập lại mã khác! ");

            }
        }
        return id;
    }

    // 4.2 set chức danh cho quản lý
    public static String chonChucDanh(Scanner in) {
        String chucDanh = "";
        System.out.println("Chọn chức danh: 1.Kế toán trưởng/ 2.Nhân sự trưởng/ 3.Kinh doanh trưởng");
        int choose = in.nextInt();
        switch (choose) {
            case 1 -> chucDanh = "Kế toán trưởng";
            case 2 -> chucDanh = "Nhân sự trưởng";
            case 3 -> chucDanh = "Kinh doanh trưởng";
            default -> chonChucDanh(in);

        }
        return chucDanh;
    }

    // 4.3 chọn mã bộ phận cho nhân viên
    public static String chonMaBoPhan(Scanner in) {
        String maBoPhan = "";
        System.out.println("Chọn bộ phận: 1.Kế toán/ 2.Nhân sự/ 3.Kinh doanh");
        int choose = in.nextInt();
        switch (choose) {
            case 1 -> maBoPhan = "KT";
            case 2 -> maBoPhan = "NS";
            case 3 -> maBoPhan = "KD";
            default -> chonMaBoPhan(in);
        }
        return maBoPhan;
    }

    // 5. Tìm kiếm thông tin nhân viên theo mã nhân viên hoặc tên nhân viên
    public static void timKiemNhanVien() {
        Scanner in = new Scanner(System.in);

        // tạo ds lưu kết quả tìm kiếm
        List<Staff> searchStaff = new ArrayList<>();

        // nhập mã nhân viên cần tìm
        System.out.println("Nhập mã nhân viên hoặc tên nhân viên cần tìm: ");
        String search = in.next();

        // vòng lặp chạy qua list, tạo 1 biến lưu mã nhân viên và tên nhân viên,
        // sau đó kiểm tra nếu cái biến đấy trùng với mã nhân viên đang tìm kiếm,
        // thì lưu nó vào danh sách kết quả tìm kiếm
        
        for (Staff staff : staffs) {
            String idStaff = staff.getMaNhanVien();
            String tenStaff = staff.getTenNhanVien();
            if (idStaff.contains(search) || tenStaff.contains(search)) {
                searchStaff.add(staff);
            }
        }

        // nếu list tìm kiếm có thì hiển thị kết quả, còn ko thì sẽ báo ko tìm thấy
        if (!searchStaff.isEmpty()) {
            
            for (Staff sStaff : searchStaff) {
                if (!searchStaff.isEmpty()) {
                    sStaff.displayInformation();
                }
            }
        } else {
            System.out.println("Không tìm thấy nhân viên này!");
        }
    }

    // 6. Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự tăng dần
    public static void hienThiLuongTangDan() {

        // tạo list để lưu lương của nhân viên
        List<Staff> salaryStaff = new ArrayList<>();       

        // sắp xếp lương theo thứ tư tăng dần
        staffs.sort(Comparator.comparing(Staff::getSalary));
        
        // lặp qua list và hiển thị thông tin
        System.out.println(String.format("%-10s%-20s%-20s%-20s", "MNV", "Tên", "HSL", "Lương"));
        for (Staff staff : staffs) {

            System.out.println(String.format("%-10s%-20s%-20s%-20s", staff.getMaNhanVien(), staff.getTenNhanVien(),
                    staff.getHeSoLuong(), ((ICalculator)staff).calculateSalary()));
        }
    } 

    // 7. Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần
    public static void hienThiLuongGiamDan() {
        // tạo list để lưu lương của nhân viên
        List<Staff> salaryStaffs = new ArrayList<>();
        // copy mang staffs to salaryStaffs
        
        // sắp xếp lương theo thứ tư tăng dần
        salaryStaffs.sort(Comparator.comparing(Staff::getSalary).reversed());

        // lặp qua list và hiển thị thông tin
        System.out.println(String.format("%-10s%-20s%-20s%-20s", "MNV", "Tên", "HSL", "Lương"));
        for (Staff staff : salaryStaffs) {
            System.out.println(String.format("%-10s%-20s%-20s%-20s", staff.getMaNhanVien(), staff.getTenNhanVien(),
                    staff.getHeSoLuong(), staff.getSalary()));
        }

    }
}
