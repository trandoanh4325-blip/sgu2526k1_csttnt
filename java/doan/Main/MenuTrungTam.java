package doan.Main;

import doan.classds.DSSanPham;
import java.util.Scanner;

public class MenuTrungTam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tenFile = "html/java/doan/input/sanpham.txt"; 
        DSSanPham dsSP = new DSSanPham();  
      
        int chon;
        do {
            System.out.println("============================================================");
            System.out.println("|                  MENU QUAN LY SAN PHAM                   |");
            System.out.println("|==========================================================|");
            System.out.println("|1. Xuat danh sach san pham                                |");
            System.out.println("|2. Them san pham moi                                      |");
            System.out.println("|3. Tim san pham theo ma                                   |");
            System.out.println("|4. Tim san pham theo ma loai                              |");
            System.out.println("|5. Xoa san pham theo ma                                   |");
            System.out.println("|6. Thong ke tong so luong san pham                        |");
            System.out.println("|7. Sua san pham                                           |");
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|8. Doc du lieu tu file                                    |");
            System.out.println("|9. Ghi du lieu ra file                                    |");
            System.out.println("|0. Quay ve MENU CHINH                                     |");
            System.out.println("============================================================");
            System.out.print("Chon chuc nang: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> dsSP.xuatDanhSach();
                case 2 -> dsSP.them();
                case 3 -> dsSP.timTheoMaSanPham();
                case 4 -> dsSP.timTheoMaLoai();
                case 5 -> {
                    System.out.print("Nhap ma can xoa: ");
                    String ma = sc.nextLine();
                    dsSP.xoaSanPham(ma);
                }
                case 6 -> dsSP.thongKeTongSoLuong();
                case 7 -> dsSP.sua(); // goi sua() trong DSSanPham
                case 8 -> {
                    dsSP.docTuFile(tenFile);
                    System.out.println("Da doc du lieu tu file!");
                }
                case 9 -> {
                    dsSP.ghiFile(tenFile);
                    System.out.println("Da ghi du lieu ra file!");
                }
                case 0 -> System.out.println("Tro ve MENU CHINH...");
                default -> System.out.println("Lua chon sai.");
            }
        } while (chon != 0);
    }
}
