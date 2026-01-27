package doan.Main;

import doan.classds.DSChiTietHoaDon;
import java.io.File;
import java.util.Scanner;

public class MenuChiTietHoaDon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tenFile = "html/java/doan/input/chitiethoadon.txt";
        DSChiTietHoaDon dsCTHD = new DSChiTietHoaDon();
     
        int chon;
        do {
            System.out.println("==========================================================");
            System.out.println("|            MENU QUAN LY CHI TIET HOA DON               |");
            System.out.println("==========================================================");
            System.out.println("| 1. Xuat danh sach chi tiet hoa don                     |");
            System.out.println("| 2. Them chi tiet hoa don moi                           |");
            System.out.println("| 3. Tim chi tiet theo ma                                |");
            System.out.println("| 4. Tim danh sach theo ma hoa don                       |");
            System.out.println("| 5. Xoa chi tiet hoa don theo ma                        |");
            System.out.println("| 6. Thong ke tong so luong chi tiet hoa don             |");
            System.out.println("| 7. Sua chi tiet hoa don                                |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("| 8. Doc du lieu tu file                                 |");
            System.out.println("| 9. Ghi du lieu vao file                                |");
            System.out.println("| 0. Quay ve MENU CHINH                                  |");
            System.out.println("==========================================================");
            System.out.print("Chon chuc nang: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsCTHD.xuatDanhSach();
                case 2 -> dsCTHD.them();
                case 3 -> dsCTHD.timChiTietHoaDon();
                case 4 -> dsCTHD.timMaHoaDon();
                case 5 -> {
                    System.out.print("Nhap ma chi tiet can xoa: ");
                    String ma = sc.nextLine();
                    dsCTHD.xoaChiTietHoaDon(ma);
                }
                case 6 -> dsCTHD.thongkeTongSoLuong();
                case 7 -> dsCTHD.sua();
                case 8 -> {
                    dsCTHD.docTuFile(tenFile);
                    System.out.println("Da doc du lieu tu file!");
                }
                case 9 -> {
                    dsCTHD.ghiFile(tenFile);
                    System.out.println(" Da ghi du lieu vao file!");
                }
                case 0 -> System.out.println("Tro ve MENU CHINH...");
                default -> System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }
}
