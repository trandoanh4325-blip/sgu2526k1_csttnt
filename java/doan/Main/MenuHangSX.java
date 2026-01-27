package doan.Main;

import doan.classds.DSHangSX;
import java.util.Scanner;

public class MenuHangSX {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSHangSX dsHang = new DSHangSX();
        int choice;
        String fileName = "html/java/doan/input/HangSX.txt";
        
        do {
            System.out.println("===========================================================");
            System.out.println("|                  MENU HANG SAN XUAT                     |");
            System.out.println("|=========================================================|");
            System.out.println("|1. Nhap danh sach hang san xuat                          |");
            System.out.println("|2. Xuat danh sach hang san xuat                          |");
            System.out.println("|3. Them hang san xuat moi                                |");
            System.out.println("|4. Xoa hang san xuat                                     |");
            System.out.println("|5. Sua thong tin hang san xuat                           |");
            System.out.println("|6. Tim hang san xuat                                     |");
            System.out.println("|7. Thong ke                                              |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("|8. Ghi danh sach ra file                                 |");
            System.out.println("|9. Doc danh sach tu file                                 |");
            System.out.println("|0. Thoat                                                 |");
            System.out.println("===========================================================");
            System.out.print("Lua chon cua ban: ");

            try { choice = Integer.parseInt(sc.nextLine()); }
            catch (Exception e) { choice = -1; }

            switch (choice) {
                case 1 -> dsHang.nhapDanhSach();
                case 2 -> dsHang.xuatDanhSach();
                case 3 -> dsHang.them();
                case 4 -> dsHang.xoa();
                case 5 -> dsHang.sua();
                case 6 -> dsHang.tim();
                case 7 -> dsHang.thongKe();
                case 8 -> dsHang.ghiFile(fileName);
                case 9 -> dsHang.docFile(fileName);
                case 0 -> System.out.println("Thoat chuong trinh!");
                default -> System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }
        } while (choice != 0);
    }
}
