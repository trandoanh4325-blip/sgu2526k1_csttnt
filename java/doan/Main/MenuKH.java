package doan.Main;

import doan.classds.DSKhachHang;
import java.util.Scanner;

public class MenuKH {
    public static void main(DSKhachHang ds) {
        Scanner sc = new Scanner(System.in);
        DSKhachHang dsKH = new DSKhachHang();
        String fKH = "html/java/doan/input/khachhang.txt";
        dsKH.docFile(fKH);
        int ch;
        do {
            System.out.println("\n===== MENU KHACH HANG =====");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them");
            System.out.println("3. Tim theo ma");
            System.out.println("4. Tim theo ten");
            System.out.println("5. Sua");
            System.out.println("6. Xoa");
            System.out.println("7. Doc file (nhap ten file)");
            System.out.println("8. Ghi file (nhap ten file)");
            System.out.println("9. Thong ke");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            try { ch = Integer.parseInt(sc.nextLine()); } catch (Exception e) { ch = -1; }
            switch (ch) {
                case 1: dsKH.xuat(); 
                case 2: dsKH.them();
                case 3: dsKH.timTheoMa(); 
                case 4: dsKH.timTheoTen();
                case 5: dsKH.sua(); 
                case 6: dsKH.xoa();
                case 7:
                    dsKH.docFile(fKH );
                case 8:
                   dsKH.ghiFile(fKH ); 
                case 9: dsKH.thongKeKhachHang(); 
                case 0: break;
                default: System.out.println("Lua chon sai.");
            }
        } while (ch != 0);
    }
}