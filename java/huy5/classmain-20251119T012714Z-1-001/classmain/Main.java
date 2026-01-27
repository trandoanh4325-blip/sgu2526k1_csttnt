package classmain;

import java.util.Scanner;
import classdanhsach.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        DSTaiKhoan dsTK = new DSTaiKhoan();
        String fTK = "taikhoan.txt";
        dsTK.docFile(fTK);

        int ch;
        do {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. Quan ly Nhan Vien");
            System.out.println("2. Quan ly Khach Hang");
            System.out.println("3. Quan ly Tai Khoan");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            try { ch = Integer.parseInt(sc.nextLine()); } catch (Exception e) { ch = -1; }

            switch (ch) {
                case 1: MenuNV.mainMenu(dsNV); break;
                case 2: MenuKH.mainMenu(dsKH); break;
                case 3: MenuTK.mainMenu(dsTK); break;
                case 0: System.out.println("Thoat."); break;
                default: System.out.println("Lua chon sai.");
            }
        } while (ch != 0);

        sc.close();
    }
}