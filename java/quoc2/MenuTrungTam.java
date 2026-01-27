package doan.Main;

import doan.classds.*;
import java.util.Scanner;

public class MenuTrungTam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSSanPham ds = new DSSanPham();
        String fileName = "sanpham.txt";

        System.out.println("Dang doc du lieu. !!! waitting for love !!!");
        ds.docFile(fileName);

        int choice;
        do {
            System.out.println("\n========= MENU QUAN LY SAN PHAM =========");
            System.out.println("1. Nhap danh sach san pham");
            System.out.println("2. Xuat danh sach san pham");
            System.out.println("3. Them san pham moi");
            System.out.println("4. Xoa san pham theo ma");
            System.out.println("5. Sua san pham theo ma");
            System.out.println("6. Tim san pham theo ma");
            System.out.println("7. Thong ke tong so luong san pham");
            System.out.println("8. Ghi danh sach ra File");
            System.out.println("9. Doc danh sach tu File");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> ds.nhapDanhSach();
                case 2 -> ds.xuatDanhSach();
                case 3 -> ds.them();
                case 4 -> ds.xoa();
                case 5 -> ds.sua();
                case 6 -> ds.tim();
                case 7 -> ds.thongKeTongSoLuong();
                case 8 -> ds.ghiFile(fileName);
                case 9 -> ds.docFile(fileName);
                case 0 -> System.out.println("Thoat chuong trinh. Hen gap lai!");
                default -> System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }

        } while (choice != 0);

        sc.close();
    }
}
