package doan.classds;

import java.io.*;
import java.util.*;
import doan.classchinh.NCC;
import doan.QuanLy.IChucNang;

public class DSNCC implements IChucNang {
    private NCC[] ds = new NCC[0];
    private final Scanner sc = new Scanner(System.in);

    // Phương thức docFile
    @Override
    public void docFile(String File) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(File));
            String line;
            NCC[] temp = new NCC[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] arr = line.split(";");
                if (arr.length != 5) {
                    System.out.println(""+ line);
                    continue;
                }
                String maNCC = arr[0].trim();
                String tenNCC = arr[1].trim();
                String diaChi = arr[2].trim();
                String soDienThoai = arr[3].trim();
                String tenSanPham = arr[4].trim();
                NCC ncc = new NCC(maNCC, tenNCC, diaChi, soDienThoai, tenSanPham);
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = ncc;
            }
            br.close();
            ds = temp;
            System.out.println("Doc file " + File + " thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
    // Phương thức ghiFile
    @Override
    public void ghiFile(String File) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(File))) {
            for (NCC ncc : ds)
                if (ncc != null)
                    pw.println(ncc.getMaNCC() + ";" +
                            ncc.getTenNCC() + ";" +
                            ncc.getDiaChi() + ";" +
                            ncc.getSoDienThoai() + ";" +
                            ncc.getTenSanPham());
            System.out.println("Ghi file " + File + " thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
    // Kiểm tra trùng mã NCC
    public boolean kiemTraTrungMa(String ma) {
        for (NCC ncc : ds) {
            if (ncc.getMaNCC().equals(ma)) {
                return true; // Bị trùng mã
            }
        }
        return false; // Không trùng mã
    }
    // Phương thức nhapDanhSach
    @Override
    public void nhapDanhSach() {
        if (ds.length > 0) {
            System.out.println("Danh sach da co du lieu !!!");
            System.out.println("1. Ghi de (Nhap danh sach moi, xoa du lieu cu)");
            System.out.println("2. Huy (Khong nhap, giu lai du lieu cu)");
            System.out.print("Chon 1 hoac 2: ");
            int chon;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Loi: Lua chon khong hop le. Mac dinh huy nhap.");
                chon = 2;
            }
            
            if (chon == 2) {
                System.out.println("Huy nhap danh sach moi. Du lieu cu duoc giu lai.");
                return;
            } else if (chon == 1) {
                ds = new NCC[0];
                System.out.println("Danh sach cu da bi xoa. Bat dau nhap danh sach moi.");
            } else {
                System.out.println("Lua chon khong hop le. Huy nhap.");
                return;
            }
        }
        System.out.print("Nhap so luong nha cung cap: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi nhap so luong. Mac dinh la 0.");
            n = 0;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap nha cung cap thu " + (i + 1) + " ---");
            NCC ncc;
            do {
                ncc = new NCC();
                ncc.nhap(sc);
                if (kiemTraTrungMa(ncc.getMaNCC())) {
                    System.out.println("Ma nha cung cap '" + ncc.getMaNCC() + "' da ton tai! Vui long nhap lai.\n");
                } else {
                    themNCC(ncc);
                    break; 
                }
            } while (true);
        }
        System.out.println("Da nhap danh sach thanh cong!");
    }

    // Phương thức xuatDanhSach
    @Override
    public void xuatDanhSach() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach nha cung cap rong.");
            return;
        }
        System.out.println("\n============= DANH SACH NHA CUNG CAP =============");
        System.out.printf("%-10s %-20s %-20s %-15s %-15s\n",
                "MaNCC", "TenNCC", "DiaChi", "SDT", "TenSP");
        System.out.println(
                "---------------------------------------------------------------------------------------------");
        for (NCC ncc : ds)
            ncc.xuat();
        System.out.println(
                "==============================================================================================");
    }

    // Phương thức them
    @Override
    public void them() {
        NCC ncc = new NCC();
        System.out.println("--- Nhap thong tin nha cung cap can them ---");
        boolean maTrung;
        do {
            ncc.nhap(sc);
            String maMoi = ncc.getMaNCC();
            maTrung = kiemTraTrungMa(maMoi);
            if (maTrung) {
                 System.out.println("Loi: Ma nha cung cap '" + maMoi + "' da ton tai! Vui long nhap lai Ma NCC.");
            }
        } while (maTrung);
        themNCC(ncc);
        System.out.println("\nDa them nha cung cap moi thanh cong.");
    }

    public void themNCC(NCC ncc) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = ncc;
    }


    // Phương thức xoa
    @Override
    public void xoa() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the xoa.");
            return;
        }
        System.out.print("Nhap ma nha cung cap can xoa: ");
        String ma = sc.nextLine();
        xoaTheoMaNCC(ma);
    }

    public void xoaTheoMaNCC(String ma) {
        int index = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaNCC().equals(ma)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("\nKhong tim thay ma nha cung cap!");
            return;
        }
        for (int i = index; i < ds.length - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, ds.length - 1);
        System.out.println("\nDa xoa nha cung cap co ma " + ma);
    }

    // Phương thức sua
    @Override
    public void sua() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the sua.");
            return;
        }
        System.out.print("Nhap ma nha cung cap can sua: ");
        String maNCC = sc.nextLine();
        suaThongTinNCC(maNCC);
    }

    public void suaThongTinNCC(String maNCC) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaNCC().equals(maNCC)) {
                System.out.println("\n--- Chon thong tin can sua cho NCC " + maNCC + " ---");
                System.out
                        .println("1. Sua ten nha cung cap\n2. Sua dia chi\n3. Sua so dien thoai\n4. Sua ten san pham");
                System.out.print("Sua thong tin so: ");
                int chon;
                try {
                    chon = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lua chon khong hop le!");
                    return;
                }

                switch (chon) {
                    case 1 -> {
                        System.out.print("Nhap ten nha cung cap moi: ");
                        ds[i].setTenNCC(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Nhap dia chi moi: ");
                        ds[i].setDiaChi(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Nhap so dien thoai moi: ");
                        ds[i].setSoDienThoai(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Nhap ten san pham moi: ");
                        ds[i].setTenSanPham(sc.nextLine());
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                System.out.println("\nDa sua thong tin nha cung cap " + maNCC);
                return;
            }
        }
        System.out.println("\nKhong tim thay ma nha cung cap!");
    }

    // Phương thức tim
    @Override
    public void tim() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the tim kiem.");
            return;
        }
        System.out.print("Nhap ma nha cung cap can tim: ");
        String ma = sc.nextLine();
        timTheoMaNCC(ma);
    }

    public void timTheoMaNCC(String ma) {
        System.out.println("\n--- Ket qua tim kiem theo Ma NCC ---");
        boolean found = false;
        System.out.printf("%-10s %-20s %-20s %-15s %-15s\n",
                "MaNCC", "TenNCC", "DiaChi", "SDT", "TenSP");
        System.out.println(
                "---------------------------------------------------------------------------------------------");
        for (NCC ncc : ds) {
            if (ncc.getMaNCC().equals(ma)) {
                ncc.xuat();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nKhong tim thay nha cung cap co ma " + ma);
        }
    }

    // Tìm theo sản phẩm
    public void timTheoSanPham(String sp) {
        System.out.println("\n--- Cac nha cung cap co san pham \"" + sp + "\" ---");
        boolean found = false;
        System.out.printf("%-10s %-20s %-20s %-15s %-15s\n",
                "MaNCC", "TenNCC", "DiaChi", "SDT", "TenSP");
        System.out.println(
                "---------------------------------------------------------------------------------------------");
        for (NCC ncc : ds)
            if (ncc.getTenSanPham().equalsIgnoreCase(sp)) {
                ncc.xuat();
                found = true;
            }
        if (!found)
            System.out.println("\nKhong tim thay san pham nao trung khop!");
    }

    // Thống kê số lượng công ty ở địa chỉ ...
    public void thongKeSoLuongTheoDiaChi(String dc) {
        int dem = 0;
        for (NCC ncc : ds)
            if (ncc.getDiaChi().equalsIgnoreCase(dc))
                dem++;
        System.out.println("\nSo luong cong ty o dia chi \"" + dc + "\": " + dem);
    }
}