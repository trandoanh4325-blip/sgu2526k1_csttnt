package doan.classds;

import doan.QuanLy.IChucNang;
import doan.classchinh.LoaiSP;
import java.io.*;
import java.util.*;

public class DSLoaiSP implements IChucNang {

    private LoaiSP[] ds = new LoaiSP[0];
    private final Scanner sc = new Scanner(System.in);

    // Kiểm tra mã trùng
    private boolean maTrung(String ma) {
        for (LoaiSP l : ds) {
            if (l.getMaLoai().equals(ma)) return true;  //phan biet hoa, thuong (equals)
        }
        return false;
    }

    //Nhập danh sách
    @Override
    public void nhapDanhSach() {
        System.out.print("Nhap so luong loai san pham: ");
        int n;
        try { n = Integer.parseInt(sc.nextLine()); } 
        catch (NumberFormatException e) { System.out.println("Loi nhap so luong."); n = 0; }

        if (ds.length > 0) {
            System.out.println("Danh sach da co du lieu. Chon:");
            System.out.println("1. Ghi de danh sach moi");
            System.out.println("2. Huy (giu lai du lieu cu)");
            int choice;
            try { choice = Integer.parseInt(sc.nextLine()); } 
            catch (NumberFormatException e) { choice = 2; }

            if (choice != 1) { System.out.println("Huy nhap danh sach moi."); return; }
            else ds = new LoaiSP[0];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap loai san pham thu " + (i+1) + " ---");
            LoaiSP l;
            do {
                l = new LoaiSP();
                l.nhap(); // Gọi hàm nhập từ class LoaiSP
                if (maTrung(l.getMaLoai())) {
                    System.out.println("Ma loai da ton tai! Vui long nhap lai.\n");
                } else {
                    break; // mã không trùng, thoát vòng lặp
                }
            } while(true);

            themLoai(l);
        }
    }

    //Xuất danh sách
    @Override
    public void xuatDanhSach() {
        if (ds.length == 0) { System.out.println("\nDanh sach rong."); return; }
        System.out.println("\n================ DANH SACH LOAI SAN PHAM ================");
        System.out.printf("%-10s %-20s %-25s %-15s\n","MaLoai","TenLoai","Mota","NgayTao");
        System.out.println("--------------------------------------------------------");
        for (LoaiSP l : ds) {
            System.out.printf("%-10s %-20s %-25s %-15s\n",
                    l.getMaLoai(), l.getTenLoai(), l.getMota(), l.getNgayTao());
        }
        System.out.println("========================================================");
    }

    //Thêm
    @Override
public void them() {
    LoaiSP l;
    System.out.println("--- Nhap thong tin loai san pham ---");
    while (true) {
        l = new LoaiSP();
        l.nhap(); // Nhập toàn bộ
        if (maTrung(l.getMaLoai())) {
            System.out.println("Ma loai da ton tai! Vui long nhap lai.\n");
        } else {
            break; // mã không trùng, thoát
        }
    }
    themLoai(l);
    System.out.println("Da them loai san pham moi.");
}

public void themLoai(LoaiSP l){
    ds = Arrays.copyOf(ds, ds.length + 1);
    ds[ds.length - 1] = new LoaiSP(l); // copy constructor
}


    //Xóa
    @Override
    public void xoa() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.print("Nhap ma loai can xoa: ");
        String ma = sc.nextLine();
        xoaTheoMa(ma);
    }

        public void xoaTheoMa(String ma){
        int index=-1;
        for(int i=0;i<ds.length;i++){
            if(ds[i].getMaLoai().equals(ma)){ index=i; break; }
        }
        if(index==-1){ System.out.println("Khong tim thay ma loai!"); return; }
        for(int i=index;i<ds.length-1;i++) ds[i]=ds[i+1];
        ds=Arrays.copyOf(ds, ds.length-1);
        System.out.println("Da xoa loai san pham co ma "+ma);
    }

    // Sửa
    @Override
    public void sua() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.print("Nhap ma loai can sua: ");
        String ma = sc.nextLine();
        suaLoai(ma);
    }

    public void suaLoai(String ma){
        for(int i=0;i<ds.length;i++){
            if(ds[i].getMaLoai().equals(ma)){
                int choice;
                do {
                    System.out.println("\n--- Chon thong tin can sua ---");
                    System.out.println("1. TenLoai");
                    System.out.println("2. Mota");
                    System.out.println("3. NgayTao");
                    System.out.println("0. Thoat sua");
                    System.out.print("Lua chon: ");
                    try { choice = Integer.parseInt(sc.nextLine()); } catch(Exception e){ choice=-1; }
                    switch(choice){
                        case 1 -> { System.out.print("Nhap ten moi: "); ds[i].setTenLoai(sc.nextLine()); }
                        case 2 -> { System.out.print("Nhap mo ta moi: "); ds[i].setMota(sc.nextLine()); }
                        case 3 -> { System.out.print("Nhap ngay tao moi: "); ds[i].setNgayTao(sc.nextLine()); }
                        case 0 -> System.out.println("Thoat sua");
                        default -> System.out.println("Lua chon khong hop le!");
                    }
                } while(choice!=0);
                System.out.println("Da sua thong tin loai san pham "+ma);
                return;
            }
        }
        System.out.println("Khong tim thay san pham can sua!");
    }

    //  Tìm
    @Override
    public void tim() {
    if (ds.length == 0) {
        System.out.println("\nDanh sach rong. Khong the tim kiem.");
        return;
    }

    System.out.println("Chon phuong thuc tim kiem:");
    System.out.println("1. Tim theo ma loai");
    System.out.println("2. Tim theo ngay tao");
    System.out.print("Lua chon: ");
    
    int choice;
    try {
        choice = Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Lua chon khong hop le!");
        return;
    }

    switch (choice) {
        case 1 -> {
            LoaiSP l = timTheoMa();
            if (l != null) {
                System.out.println("Tim thay loai san pham: " + l.getTenLoai());
            } else {
                System.out.println("Khong tim thay loai san pham.");
            }
        }
        case 2 -> {
            System.out.print("Nhap ngay can tim (dd/mm/yyyy): ");
            String ngay = sc.nextLine();
            LoaiSP[] dsNgay = timTheoNgay(ngay);
            if (dsNgay.length == 0) {
                System.out.println("Khong tim thay loai san pham nao trong ngay " + ngay);
            } else {
                System.out.println("\nDanh sach loai san pham tim theo ngay " + ngay + ":");
                System.out.printf("%-10s %-20s %-25s %-15s\n","MaLoai","TenLoai","Mota","NgayTao");
                System.out.println("--------------------------------------------------------");
                for (LoaiSP l : dsNgay) {
                    if (l != null) l.xuat(); // xuat() public trong LoaiSP
                }
                System.out.println("========================================================");
            }
        }
        default -> System.out.println("Lua chon khong hop le!");
    }
}

// Tìm theo mã (không tham số, trả về null nếu không tìm thấy)
    public LoaiSP timTheoMa() {
        System.out.print("Nhap ma loai can tim: ");
        String ma = sc.nextLine();
        for (LoaiSP l : ds) {
            if (l.getMaLoai().equals(ma)) return l;
        }
        return null;
    }

    // Tìm theo ngày tạo (có tham số), trả về mảng LoaiSP
    public LoaiSP[] timTheoNgay(String ngay) {
        return Arrays.stream(ds)
                 .filter(l -> l.getNgayTao().equals(ngay))
                 .toArray(LoaiSP[]::new);
    }

    //ghi file
    @Override
    public void ghiFile(String file) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            for(LoaiSP l: ds){
                bw.write(l.getMaLoai()+";"+l.getTenLoai()+";"+l.getMota()+";"+l.getNgayTao());
                bw.newLine();
            }
            System.out.println("Ghi file thanh cong: "+file);
        } catch(IOException e){ System.out.println("Loi ghi file: "+e.getMessage()); }
    }
    //doc file
    @Override
    public void docFile(String file) {
        File f = new File(file);
        if (!f.exists()) { System.out.println("File khong ton tai!"); return; }
        try (Scanner fileScanner = new Scanner(f)) {
            ds = new LoaiSP[0];
            while(fileScanner.hasNextLine()){
                String[] parts = fileScanner.nextLine().split(";");
                if(parts.length==4) themLoai(new LoaiSP(parts[0],parts[1],parts[2],parts[3]));
            }
            System.out.println("Doc file thanh cong tu: "+file);
        } catch(Exception e){ System.out.println("Loi doc file: "+e.getMessage()); }
    }
    
    //thong ke
    public void thongKe() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the thong ke.");
            return;
        }

        System.out.print("Nhap ngay tao can thong ke (dd/mm/yyyy): ");
        String ngay = sc.nextLine();

        long count = Arrays.stream(ds)
                .filter(l -> l.getNgayTao().equals(ngay))
                .count();

        System.out.println("So loai san pham tao trong ngay " + ngay + ": " + count);
    }
}


