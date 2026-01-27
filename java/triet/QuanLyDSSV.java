package triet;

import java.util.Scanner;

public class QuanLyDSSV {
    private DSSV ds = new DSSV();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n========== MENU QUẢN LÝ SINH VIÊN ==========");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Xem danh sách sinh viên");
            System.out.println("3. Thêm sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Sửa thông tin sinh viên");
            System.out.println("6. Tìm kiếm sinh viên theo mã");
            System.out.println("7. Thống kê theo giới tính");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ds.nhap();
                    break;
                case 2:
                    ds.xuat();
                    break;
                case 3:
                    ds.them();
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    ds.xoa(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhập mã sinh viên cần sửa: ");
                    ds.sua(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhập mã sinh viên cần tìm: ");
                    SinhVien kq = ds.timKiem(sc.nextLine());
                    if (kq != null) {
                        System.out.println("Kết quả tìm thấy:");
                        kq.xuat();
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;
                case 7:
                    ds.thongKe();
                    break;
                case 8:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }

        } while (chon != 8);
    }
}
