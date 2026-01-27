package doan.Main;

import java.util.Scanner;
import java.io.*;

public class mf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== MENU CHINH =====");
            System.out.println("1. Xuat du lieu tu H.txt");
            System.out.println("2. Xuat du lieu tu hoc.txt");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> xuatDuLieu("html/java/doan/input/h.txt");
                case 2 -> xuatDuLieu("html/java/doan/input/hoc.txt");
                case 0 -> System.out.println("Thoat chuong trinh.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    /**
     * Hàm xuất toàn bộ dữ liệu từ file ra màn hình
     * @param fileName: tên file cần xuất (H.txt hoặc hoc.txt)
     */
    public static void xuatDuLieu(String fileName) {
        File f = new File(fileName);
        
        // Kiểm tra file có tồn tại không
        if (!f.exists()) {
            System.out.println("File '" + fileName + "' khong ton tai!");
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            System.out.println("\n================ DU LIEU TU FILE: " + fileName + " ================");
            String line;
            int lineNumber = 1;
            
            // Đọc từng dòng và in ra
            while ((line = br.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            
            System.out.println("====================================================================\n");
        } 
        catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}