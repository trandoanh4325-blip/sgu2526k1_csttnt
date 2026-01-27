package doan.Main;

import doan.classds.DSHoaDon;

import java.util.Scanner;

public class MenuHoaDon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tenFile = "html/java/doan/input/hoadon.txt"; 
        DSHoaDon dsHD = new DSHoaDon();
     
        int chon;
        do {
            System.out.println("=============================================================");
            System.out.println("|                    MENU QUAN LY HOA DON                   |");
            System.out.println("|===========================================================|");
            System.out.println("|1. Xuat danh sach hoa don                                  |");
            System.out.println("|2. Them hoa don moi                                        |");
            System.out.println("|3. Tim theo ma hoa don                                     |");
            System.out.println("|4. Tim theo ngay lap                                       |");
            System.out.println("|5. Xoa hoa don theo ma                                     |");
            System.out.println("|6. Thong ke tong tien                                      |");
            System.out.println("|7. Sua hoa don                                             |");
            System.out.println("|-----------------------------------------------------------|");
            System.out.println("|8. Doc file tu file                                        |");
            System.out.println("|9. Ghi file vao file                                       |");
            System.out.println("|0. Quay ve MENU CHINH                                      |");
            System.out.println("=============================================================");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsHD.xuatDanhSach();
                case 2 -> dsHD.them();
                case 3 -> dsHD.timHoaDon();
                case 4 -> dsHD.timNgayLap();
                case 5 -> {
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String ma = sc.nextLine();
                    dsHD.xoaHoaDon(ma);
                }
                case 6 -> dsHD.thongkeTongTien();
                case 7 -> dsHD.sua();
                case 8 -> {
                    dsHD.docTuFile(tenFile);
                    System.out.println("Da doc du lieu tu file.");
                }
                case 9 -> {
                    dsHD.ghiFile(tenFile);
                    System.out.println("Da ghi du lieu vao file.");
                }
                case 0 -> System.out.println("Tro ve MENU CHINH.");
                default -> System.out.println("Lua chon khong dung");
            }
        } while (chon != 0);
    }
}
