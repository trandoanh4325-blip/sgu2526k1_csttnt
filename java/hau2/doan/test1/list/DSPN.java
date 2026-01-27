package test1.list;

import doan.single.PN;
import doan.chucnang.IChucNang;
import java.io.*;
import java.util.*;

public class DSPN implements IChucNang {
    private PN[] ds = new PN[0];
    private final Scanner sc = new Scanner(System.in);

    // Phương thức docFile
    @Override
    public void docFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            List<PN> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    PN p = new PN(
                        parts[0], // maPhieu
                        parts[1], // maNhaCungCap
                        parts[2], // ngayNhap
                        parts[3], // tenHang
                        Integer.parseInt(parts[4]), // soLuong
                        Double.parseDouble(parts[5]) // donGia
                    );
                    list.add(p);
                }
            }
            ds = list.toArray(new PN[0]);
            System.out.println("\nDoc file thanh cong tu: " + file);
        } catch (FileNotFoundException e) {
            System.out.println("\nLoi: Khong tim thay file " + file);
        } catch (IOException | NumberFormatException e) {
            System.out.println("\nLoi doc/ghi file hoac dinh dang du lieu bi sai: " + e.getMessage());
        }
    }

    // Phương thức ghiFile
    @Override
    public void ghiFile(String file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (PN p : ds) {
                String line = p.getMaPhieu() + ";" + 
                              p.getMaNhaCungCap() + ";" + 
                              p.getNgayNhap() + ";" + 
                              p.getTenHang() + ";" + 
                              p.getSoLuong() + ";" + 
                              p.getDonGia();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("\nGhi file thanh cong vao: " + file);
        } catch (IOException e) {
            System.out.println("\nLoi khi ghi file: " + e.getMessage());
        }
    }
    
    // Phương thức nhapDanhSach
    @Override
    public void nhapDanhSach() {
        System.out.print("Nhap so luong phieu nhap: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi nhap so luong. Mac dinh la 0.");
            n = 0;
        }
        if (ds.length > 0) {
            System.out.print("Danh sach da co du lieu. Ban co muon ghi de (Y/N)? ");
            String confirm = sc.nextLine();
            if (!confirm.equalsIgnoreCase("Y")) {
                System.out.println("Huy nhap danh sach moi.");
                return;
            }
        }
        ds = new PN[n];
        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap phieu nhap thu " + (i+1) + " ---");
            ds[i] = new PN();
            ds[i].nhap();
        }
    }

    // Phương thức xuatDanhSach
    @Override
    public void xuatDanhSach() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach phieu nhap rong.");
            return;
        }
        System.out.println("\n================ DANH SACH PHIEU NHAP ================");
        System.out.printf("%-10s %-10s %-12s %-15s %-10s %-12s %-12s\n",
                "MaPN", "MaNCC", "NgayNhap", "TenHang", "SoLuong", "DonGia", "ThanhTien");
        System.out.println("--------------------------------------------------------------------------------------");
        for (PN p : ds) {
            p.xuat();
        }
        System.out.println("======================================================");
    }
    
    // Phương thức them
    @Override
    public void them() {
        PN p = new PN();
        System.out.println("--- Nhap thong tin phieu nhap can them ---");
        p.nhap();
        themPN(p);
        System.out.println("\nDa them phieu nhap moi.");
    }
    public void themPN(PN p) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new PN(p);
    }

    // Phương thức xoa
    @Override
public void xoa() {
    if (ds.length == 0) {
        System.out.println("\nDanh sach rong. Khong the xoa.");
        return;
    }
    System.out.print("Nhap ma phieu nhap can xoa: ");
    String ma = sc.nextLine();
    xoaTheoMaPN(ma);
}
public void xoaTheoMaPN(String ma) {
    int index = -1;
    for (int i = 0; i < ds.length; i++){
        if (ds[i].getMaPhieu().equalsIgnoreCase(ma)){ 
            index = i; 
            break;
        }
    }
    if (index == -1) {
        System.out.println("\nKhong tim thay ma phieu!");
        return;
    }
    for (int i = index; i < ds.length - 1; i++) {
        ds[i] = ds[i + 1];
    }
    ds = Arrays.copyOf(ds, ds.length - 1);
    System.out.println("\nDa xoa phieu nhap co ma " + ma);
}

    // Phương thức sua
    @Override
    public void sua() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the sua.");
            return;
        }
        System.out.print("Nhap ma phieu nhap can sua: ");
        String maPhieu = sc.nextLine();
        suaPhieuNhap(maPhieu);
    }
    public void suaPhieuNhap(String maPhieu) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaPhieu().equalsIgnoreCase(maPhieu)) {
                System.out.println("\n--- Chon thong tin can sua cho phieu " + maPhieu + " ---");
                System.out.println("1. Sua ma nha cung cap\n2. Sua ngay nhap\n3. Sua ten hang\n4. Sua so luong\n5. Sua don gia");
                System.out.print("Sua thong tin so: ");
                int chon;
                try {
                     chon = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lua chon khong hop le!");
                    return;
                }
               
                switch (chon) {
                    case 1 -> { System.out.print("Nhap ma NCC moi: "); ds[i].setMaNhaCungCap(sc.nextLine()); }
                    case 2 -> { System.out.print("Nhap ngay nhap moi: "); ds[i].setNgayNhap(sc.nextLine()); }
                    case 3 -> { System.out.print("Nhap ten hang moi: "); ds[i].setTenHang(sc.nextLine()); }
                    case 4 -> { 
                        System.out.print("Nhap so luong moi: "); 
                        try {
                            ds[i].setSoLuong(Integer.parseInt(sc.nextLine()));
                        } catch (NumberFormatException e) { System.out.println("So luong khong hop le!"); }
                    }
                    case 5 -> { 
                        System.out.print("Nhap don gia moi: "); 
                        try {
                            ds[i].setDonGia(Double.parseDouble(sc.nextLine()));
                        } catch (NumberFormatException e) { System.out.println("Don gia khong hop le!"); }
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                System.out.println("\nDa sua thong tin phieu nhap " + maPhieu);
                return;
            }
        }
        System.out.println("\nKhong tim thay phieu nhap can sua!");
    }
    // Phương thức tim
    @Override
    public void tim() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the tim kiem.");
            return;
        }
        System.out.print("Nhap ma phieu can tim: ");
        String ma = sc.nextLine();
        timTheoMa(ma);
    }
    public void timTheoMa(String ma) {
        System.out.println("\n--- Ket qua tim kiem theo Ma Phieu ---");
        boolean found = false;
        System.out.printf("%-10s %-10s %-12s %-15s %-10s %-12s %-12s\n",
                "MaPN", "MaNCC", "NgayNhap", "TenHang", "SoLuong", "DonGia", "ThanhTien");
        System.out.println("--------------------------------------------------------------------------------------");
        for (PN p : ds) {
            if (p.getMaPhieu().equalsIgnoreCase(ma)) {
                p.xuat();
                found = true;
                break; 
            }
        }
        if (!found) {
             System.out.println("\nKhong tim thay phieu nhap co ma " + ma);
        }
    }

    // Tìm kiếm theo ngày
    public void timTheoNgay(String ngay) {
        System.out.println("\n--- Ket qua tim kiem theo Ngay Nhap ---");
        boolean found = false;
        System.out.printf("%-10s %-10s %-12s %-15s %-10s %-12s %-12s\n",
                "MaPN", "MaNCC", "NgayNhap", "TenHang", "SoLuong", "DonGia", "ThanhTien");
        System.out.println("--------------------------------------------------------------------------------------");
        for (PN p : ds) {
            if (p.getNgayNhap().equals(ngay)) {
                p.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nKhong tim thay phieu nhap nao trong ngay " + ngay);
        }
    }
    // Thống kê tổng số lượng theo ngày
    public void thongKeTheoNgay(String ngay) {
        int tong = 0;
        for (PN p : ds) {
            if (p.getNgayNhap().equals(ngay)) {
                tong += p.getSoLuong();
            }
        }
        System.out.println("\nTong so luong ngay " + ngay + ": " + tong);
    }
}