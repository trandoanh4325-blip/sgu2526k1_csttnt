package doan.Main;

import doan.classds.DSLoaiSP;
import java.util.Scanner;

public class MenuLoaiSP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSLoaiSP ds = new DSLoaiSP();
        int choice;
        String fileName = "html/java/doan/input/loaisp.txt";

        do {
            System.out.println("===========================================================");
            System.out.println("|                  MENU LOAI SAN PHAM                     |");
            System.out.println("|=========================================================|");
            System.out.println("|1. Nhap danh sach                                        |");
            System.out.println("|2. Xuat danh sach                                        |");
            System.out.println("|3. Them loai san pham                                    |");
            System.out.println("|4. Xoa loai san pham theo ma                             |");
            System.out.println("|5. Sua loai san pham theo ma                             |");
            System.out.println("|6. Tim loai san pham theo ma                             |");
            System.out.println("|7. Thong ke                                              |");
            System.out.println("|------------------------------------                     |");
            System.out.println("|8. Ghi danh sach tu File                                 |");
            System.out.println("|9. Doc danh sach ra File                                 |");
            System.out.println("|0. Thoat                                                 |");
            System.out.println("===========================================================");
            System.out.print("Chon chuc nang: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1 -> ds.nhapDanhSach();
                case 2 -> ds.xuatDanhSach();
                case 3 -> ds.them();
                case 4 -> ds.xoa();
                case 5 -> ds.sua();
                case 6 -> ds.tim();
                case 7 -> ds.thongKe();
                case 8 -> ds.ghiFile(fileName);
                case 9 -> ds.docFile(fileName);
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le. Vui long chon lai!");
            }

        } while (choice != 0);
    }
}
