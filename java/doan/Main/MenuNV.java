package doan.Main;

import doan.classds.DSNhanVien;
import java.util.Scanner;

public class MenuNV {
    public static void main(DSNhanVien ds) {
        Scanner sc = new Scanner(System.in);
        DSNhanVien dsNV = new DSNhanVien();
        String fNV = "html/java/doan/input/nhanvien.txt";
        dsNV.docFile(fNV);
        int ch;
        do {
            System.out.println("\n===== MENU NHAN VIEN =====");
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
                case 1: dsNV.xuat(); 
                case 2: dsNV.them(); 
                case 3: dsNV.timTheoMa(); 
                case 4: dsNV.timTheoTen();
                case 5: dsNV.sua(); 
                case 6: dsNV.xoa();
                case 7:
                    dsNV.docFile(fNV); 
                case 8:
                    dsNV.ghiFile(fNV);
                case 9: dsNV.thongKeNhanVien();
                case 0: break;
                default: System.out.println("Lua chon sai.");
            }
        } while (ch != 0);
    }
}