package doan.classds;

import doan.QuanLy.IChucNang;
import doan.classchinh.HangSX;


import java.io.*;
import java.util.*;

public class DSHangSX implements IChucNang {

    private HangSX[] ds = new HangSX[0];
    private final Scanner sc = new Scanner(System.in);

    // Kiểm tra mã trùng (không tham số)
    private boolean maTrung(String ma) {
        for (HangSX h : ds) {
            if (h.getMaHang().equals(ma)) return true;
        }
        return false;
    }

    // Nhập danh sách nhiều nhà sản xuất (đa hình: override từ IChucNang)
    @Override
    public void nhapDanhSach() {
        System.out.print("Nhap so luong hang san xuat: ");
        int n;
        try { n = Integer.parseInt(sc.nextLine()); } 
        catch (NumberFormatException e) { System.out.println("Loi nhap so luong."); n = 0; }

        if (ds.length > 0) {
            System.out.println("Danh sach da co du lieu. Chon:");
            System.out.println("1. Ghi de danh sach moi");
            System.out.println("2. Huy nhap danh sach moi");
            int choice;
            try { choice = Integer.parseInt(sc.nextLine()); } 
            catch (NumberFormatException e) { choice = 2; }

            if (choice != 1) { System.out.println("Huy nhap danh sach moi."); return; }
            else ds = new HangSX[0];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap hang san xuat thu " + (i+1) + " ---");
            HangSX h;
            do {
                h = new HangSX();
                h.nhap(); // Gọi hàm nhập từ class HangSX
                if (maTrung(h.getMaHang())) {
                    System.out.println("Ma hang da ton tai! Vui long nhap lai.\n");
                } else {
                    break; // mã không trùng, thoát vòng lặp
                }
            } while(true);

            themHang(h);
        }
    }

    // Xuất danh sách (đa hình: override)
    @Override
    public void xuatDanhSach() {
        if (ds.length == 0) { System.out.println("\nDanh sach rong."); return; }
        System.out.println("\n================ DANH SACH HANG SAN XUAT ================");
        System.out.printf("%-10s %-20s %-25s %-15s\n","MaHang","TenHang","DiaChi","Sdt");
        System.out.println("--------------------------------------------------------");
        for (HangSX h : ds) {
            System.out.printf("%-10s %-20s %-25s %-15s\n",
                    h.getMaHang(), h.getTenHang(), h.getDiaChi(), h.getSdt());
        }
        System.out.println("========================================================");
    }

    // Thêm (đa hình: override)
    @Override
    public void them() {
        HangSX h;
        System.out.println("--- Nhap thong tin hang san xuat ---");
        do {
            h = new HangSX();
            h.nhap(); // Nhập toàn bộ
            if (maTrung(h.getMaHang())) {
                System.out.println("Ma hang da ton tai! Vui long nhap lai.\n");
            } else {
                break; // mã không trùng, thoát
            }
        } while(true);
        themHang(h);
        System.out.println("Da them hang san xuat moi.");
    }

public void themHang(HangSX l){
    ds = Arrays.copyOf(ds, ds.length + 1);
    ds[ds.length - 1] = new HangSX(l); // copy constructor
}

    // Xóa (đa hình: override)
    @Override
    public void xoa() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.print("Nhap ma hang can xoa: ");
        String ma = sc.nextLine();
        xoaTheoMa(ma);
    }

    // Xóa theo mã (có tham số)
    public void xoaTheoMa(String ma){
        int index=-1;
        for(int i=0;i<ds.length;i++){
            if(ds[i].getMaHang().equals(ma)){ index=i; break; }
        }
        if(index==-1){ System.out.println("Khong tim thay hang!"); return; }
        for(int i=index;i<ds.length-1;i++) ds[i]=ds[i+1];
        ds=Arrays.copyOf(ds, ds.length-1);
        System.out.println("Da xoa hang co ma "+ma);
    }

    // Sửa (đa hình: override)
    @Override
    public void sua() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.print("Nhap ma hang can sua: ");
        String ma = sc.nextLine();
        suaHang(ma);
    }

    // Sửa theo mã (có tham số)
    public void suaHang(String ma){
        for(int i=0;i<ds.length;i++){
            if(ds[i].getMaHang().equals(ma)){
                int choice;
                do {
                    System.out.println("\n--- Chon thong tin can sua ---");
                    System.out.println("1. TenHang");
                    System.out.println("2. DiaChi");
                    System.out.println("3. Sdt");
                    System.out.println("0. Thoat sua");
                    System.out.print("Lua chon: ");
                    try { choice = Integer.parseInt(sc.nextLine()); } catch(Exception e){ choice=-1; }
                    switch(choice){
                        case 1 -> { System.out.print("Nhap ten moi: "); ds[i].setTenHang(sc.nextLine()); }
                        case 2 -> { System.out.print("Nhap dia chi moi: "); ds[i].setDiaChi(sc.nextLine()); }
                        case 3 -> { System.out.print("Nhap so dien thoai moi: "); ds[i].setSdt(sc.nextLine()); }
                        case 0 -> System.out.println("Thoat sua");
                        default -> System.out.println("Lua chon khong hop le!");
                    }
                } while(choice!=0);
                System.out.println("Da sua thong tin hang san xuat "+ma);
                return;
            }
        }
        System.out.println("Khong tim thay hang can sua!");
    }

    // Tìm (đa hình: override)
    @Override
    public void tim() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the tim kiem.");
            return;
        }

        System.out.println("\n===== MENU TIM KIEM HANG SAN XUAT =====");
        System.out.println("1. Tim theo ma hang (khong tham so)");
        System.out.println("2. Tim theo ten hang (co tham so)");
        System.out.print("Lua chon: ");

        int choice;
        try { choice = Integer.parseInt(sc.nextLine()); } catch(Exception e) { 
            System.out.println("Lua chon khong hop le!"); 
            return; 
        }

        switch(choice) {
            // Tìm theo mã - không tham số
            case 1 -> {
                HangSX h = timTheoMa(); // Hàm không tham số
                if(h != null) System.out.println("Tim thay hang: " + h.getTenHang());
                else System.out.println("Khong tim thay hang san xuat.");
            }
            // Tìm theo tên - có tham số
            case 2 -> {
                System.out.print("Nhap ten hang can tim: ");
                String ten = sc.nextLine();
                HangSX[] kq = timTheoTen(ten);
                if(kq.length == 0) System.out.println("Khong tim thay hang san xuat nao.");
                else {
                    System.out.println("\nDanh sach hang tim theo ten: " + ten);
                    System.out.printf("%-10s %-20s %-25s %-15s\n","MaHang","TenHang","DiaChi","Sdt");
                    for(HangSX h : kq)
                        if (h != null) h.xuat();
                }
            }
            default -> System.out.println("Lua chon khong hop le!");
        }
    }

    // Tìm theo mã - KHÔNG tham số
    public HangSX timTheoMa() {
        System.out.print("Nhap ma hang can tim: ");
        String ma = sc.nextLine();
        for(HangSX h : ds) {
        if(h.getMaHang().equals(ma)) return h;
        }
        return null;
    }

    // Tìm theo tên - CÓ tham số
    public HangSX[] timTheoTen(String ten) {
        return Arrays.stream(ds)
                 .filter(h -> h.getTenHang().equalsIgnoreCase(ten))
                 .toArray(HangSX[]::new);
    }

    // Ghi file
    @Override
    public void ghiFile(String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for(HangSX h : ds) {
                bw.write(h.getMaHang() + ";" + h.getTenHang() + ";" + h.getDiaChi() + ";" + h.getSdt());
                bw.newLine();
            }
            System.out.println("Ghi file thanh cong: " + file);
        } catch(IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Đọc file
    @Override
    public void docFile(String file) {
        File f = new File(file);
        if (!f.exists()) {
            System.out.println("File khong ton tai!");
            return;
        }
        try (Scanner fileScanner = new Scanner(f)) {
            ds = new HangSX[0]; // reset mảng
            while(fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(";");
                if(parts.length == 4) {
                    themHang(new HangSX(parts[0], parts[1], parts[2], parts[3])); // Constructor có tham số
                }
            }
            System.out.println("Doc file thanh cong tu: " + file);
        } catch(Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Thống kê
    public void thongKe() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the thong ke.");
            return;
        }

        System.out.print("Nhap ma hang can thong ke: ");
        String ma = sc.nextLine();

        long count = Arrays.stream(ds)
                .filter(h -> h.getMaHang().equals(ma))
                .count();

        System.out.println("So hang san xuat co ma '" + ma + "': " + count);
    }
}
