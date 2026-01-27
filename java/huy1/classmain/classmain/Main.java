package classmain;

import java.util.*;
import classdanhsach.*;
import classchinh.*;
import classquanli.ThongKe;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DSNhanVien dsNV = new DSNhanVien();
        DSKhachHang dsKH = new DSKhachHang();
        DSTTTK dsTK = new DSTTTK();

        int chon;
        do {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. Quan Ly Nhan Vien");
            System.out.println("2. Quan Ly Khach Hang");
            System.out.println("3. Quan Ly Tai Khoan");
            System.out.println("4. Doc Tat Ca Tu File");
            System.out.println("5. Ghi Tat Ca Ra file");
            System.out.println("6. Thong Ke");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1 -> menuNhanVien(dsNV, sc);
                case 2 -> menuKhachHang(dsKH, sc);
                case 3 -> menuTaiKhoan(dsTK, sc);
                case 4 -> {
                    dsNV.docFile("nhanvien.txt");
                    dsKH.docFile("khachhang.txt");
                    dsTK.docFile("taikhoan.txt");
                    System.out.println("Da Doc Xong.");
                }
                case 5 -> {
                    dsNV.ghiFile("nhanvien.txt");
                    dsKH.ghiFile("khachhang.txt");
                    dsTK.ghiFile("taikhoan.txt");
                    System.out.println("Da Ghi Xong.");
                }
                case 6 -> ThongKe.thongKeTatCa(dsNV, dsKH, dsTK);
                case 0 -> System.out.println("Thoat.");
                default -> System.out.println("Sai Lua Chon.");
            }

        } while (chon != 0);

        sc.close();
    }

    // --- menus ---
    public static void menuNhanVien(DSNhanVien ds, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- NV MENU ---");
            System.out.println("1. Xem");
            System.out.println("2. Them");
            System.out.println("3. Tim");
            System.out.println("4. Sua");
            System.out.println("5. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> ds.xuat();
                case 2 -> ds.them();
                case 3 -> ds.tim();
                case 4 -> ds.sua();
                case 5 -> ds.xoa();
                case 0 -> {}
                default -> System.out.println("Sai.");
            }
        } while (c != 0);
    }

    public static void menuKhachHang(DSKhachHang ds, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- KH MENU ---");
           System.out.println("1. Xem");
            System.out.println("2. Them");
            System.out.println("3. Tim");
            System.out.println("4. Sua");
            System.out.println("5. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> ds.xuat();
                case 2 -> ds.them();
                case 3 -> ds.tim();
                case 4 -> ds.sua();
                case 5 -> ds.xoa();
                case 0 -> {}
                default -> System.out.println("Sai.");
            }
        } while (c != 0);
    }

    public static void menuTaiKhoan(DSTTTK ds, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- TK MENU ---");
            System.out.println("1. Xem");
            System.out.println("2. Them");
            System.out.println("3. Tim");
            System.out.println("4. Sua");
            System.out.println("5. Xoa");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> ds.xuat();
                case 2 -> ds.them();
                case 3 -> ds.tim();
                case 4 -> ds.sua();
                case 5 -> ds.xoa();
                case 0 -> {}
                default -> System.out.println("Sai.");
            }
        } while (c != 0);
    }
}
