package doan.Main;

import doan.classds.DSTaiKhoan;
import java.util.Scanner;

public class MenuTK {
    public static void main(DSTaiKhoan ds) {
        Scanner sc = new Scanner(System.in);
         DSTaiKhoan dsTK = new DSTaiKhoan();
        String fTK = "html/java/doan/input/taikhoan.txt";
        dsTK.docFile(fTK);

        int ch;
        do {
            System.out.println("\n===== MENU TAI KHOAN =====");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them");
            System.out.println("3. Tim theo ma TK");
            System.out.println("4. Tim theo username");
            System.out.println("5. Sua");
            System.out.println("6. Xoa");
            System.out.println("7. Doc file (nhap ten file)");
            System.out.println("8. Ghi file (nhap ten file)");
            System.out.println("9. Thong ke");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            try { ch = Integer.parseInt(sc.nextLine()); } catch (Exception e) { ch = -1; }
            switch (ch) {
                case 1: dsTK.xuat(); 
                case 2: dsTK.them(); 
                case 3: dsTK.timtheomaTK(); 
                case 4: dsTK.timtheoUsername(); 
                case 5: dsTK.sua(); 
                case 6: dsTK.xoa(); 
                case 7:
                   dsTK.docFile( fTK); 
                case 8:
                 dsTK.ghiFile( fTK); 
                case 9: dsTK.thongKeTaiKhoan();
                case 0: break;
                default: System.out.println("Lua chon sai.");
            }
        } while (ch != 0);
    }
}