package doan.Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===========================================================");
            System.out.println("|                     MENU CHINH                          |");
            System.out.println("|=========================================================|");
            System.out.println("|1. Quan ly San Pham                                      |");
            System.out.println("|2. Quan ly Chi Tiet Hoa Don                              |");
            System.out.println("|3. Quan ly Hoa Don                                       |");
            System.out.println("|4. Quan ly Chi Tiet Phieu Nhap                           |");
            System.out.println("|5. Quan ly Phieu Nhap                                    |");
            System.out.println("|6. Quan ly Nha Cung Cap                                  |");
            System.out.println("|7. Quan ly Hang San Xuat                                 |");
            System.out.println("|8. Quan ly Loai San Pham                                 |");
            System.out.println("|9. Quan ly Khach Hang                                    |");
            System.out.println("|10.Quan ly Nhan Vien                                     |");
            System.out.println("|11.Quan ly Thong Tin Tai Khoan                           |");
            System.out.println("|0. Thoat                                                 |");
            System.out.println("===========================================================");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> MenuTrungTam.main(null);
                case 2 -> MenuChiTietHoaDon.main(null);
                case 3 -> MenuHoaDon.main(null);
                case 4 -> MenuCTPN.main(null);
                case 5 -> MenuPN.main(null);
                case 6 -> MenuNCC.main(null);
                case 7 -> MenuHangSX.main(null);
                case 8 -> MenuLoaiSP.main(null);
                case 9 -> MenuKH.main(null);
                case 10 ->MenuNV.main(null);
                case 11 ->MenuTK.main(null);
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }
}
