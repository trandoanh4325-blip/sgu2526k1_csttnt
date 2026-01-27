package doan.classds;

import doan.classchinh.PN;
import doan.QuanLy.IChucNang;
import java.io.*;
import java.util.*;

public class DSPN implements IChucNang {
    private PN[] ds = new PN[0];
    private final Scanner sc = new Scanner(System.in);

    // Phương thức docFile
    @Override
    public void docFile(String File) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(File));
            String line;
            PN[] temp = new PN[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] arr = line.split(";");
                if (arr.length != 5) {
                    System.out.println(""+ line);
                    continue;
                }
                String maPhieu = arr[0].trim();
                String maNCC = arr[1].trim();
                String ngayNhap = arr[2].trim();
                String loaiSanPhamChung = arr[3].trim();
                String ghiChu = arr[4].trim();
                PN pn = new PN(maPhieu, maNCC, ngayNhap, loaiSanPhamChung, ghiChu);
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = pn;
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
            for (PN pn : ds)
                if (pn != null)
                    pw.println(pn.getMaPhieu() + ";" +
                            pn.getMaNhaCungCap() + ";" +
                            pn.getNgayNhap() + ";" +
                            pn.getLoaiSanPhamChung() + ";" +
                            pn.getGhiChu());
            System.out.println("Ghi file " + File + " thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public boolean kiemTraTrungMa(String ma) {
        for (PN pn : ds) {
            if (pn.getMaPhieu().equals(ma)) {
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
                ds = new PN[0];
                System.out.println("Danh sach cu da bi xoa. Bat dau nhap danh sach moi.");
            } else {
                System.out.println("Lua chon khong hop le. Huy nhap.");
                return;
            }
        }
        System.out.print("Nhap so luong phieu nhap: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi nhap so luong. Mac dinh la 0.");
            n = 0;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap phieu nhap thu " + (i + 1) + " ---");
            PN p;
            do {
                p = new PN();
                p.nhap(sc);
                if (kiemTraTrungMa(p.getMaPhieu())) {
                    System.out.println("Ma phieu '" + p.getMaPhieu() + "' da ton tai! Vui long nhap lai.\n");
                } else {
                    themPN(p);
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
            System.out.println("\nDanh sach phieu nhap rong.");
            return;
        }
        System.out.println("\n================ DANH SACH PHIEU NHAP ================");
        System.out.printf("%-10s %-10s %-12s %-25s %-15s\n",
                "MaPN", "MaNCC", "NgayNhap", "LoaiSPChung", "GhiChu");
        System.out.println("--------------------------------------------------------------------");
        for (PN p : ds) {
            p.xuat();
        }
        System.out.println("====================================================================");
    }

    // Phương thức them
    @Override
    public void them() {
        PN p = new PN();
        System.out.println("--- Nhap thong tin phieu nhap can them ---");

        boolean maTrung;
        do {
            p.nhap(sc);
            String maMoi = p.getMaPhieu();
            maTrung = kiemTraTrungMa(maMoi);
            if (maTrung) {
                System.out.println("Loi: Ma phieu nhap '" + maMoi + "' da ton tai! Vui long nhap lai Ma Phieu.");
            }
        } while (maTrung);
        themPN(p);
        System.out.println("\nDa them phieu nhap moi thanh cong.");
    }

    public void themPN(PN p) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = p;
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
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaPhieu().equals(ma)) {
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
            if (ds[i].getMaPhieu().equals(maPhieu)) {
                System.out.println("\n--- Chon thong tin can sua cho phieu " + maPhieu + " ---");
                System.out.println(
                        "1. Sua ma nha cung cap\n2. Sua ngay nhap\n3. Sua loai san pham chung\n4. Sua Ghi chu");
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
                        System.out.print("Nhap ma NCC moi: ");
                        ds[i].setMaNhaCungCap(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Nhap ngay nhap moi: ");
                        ds[i].setNgayNhap(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Nhap loai san pham chung moi: ");
                        ds[i].setLoaiSanPhamChung(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Nhap Ghi chu moi (Da tra/Con no): ");
                        ds[i].setGhiChu(sc.nextLine());
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

    // Tìm phiếu nhập theo mã
    public void timTheoMa(String ma) {
        System.out.println("\n--- Ket qua tim kiem theo Ma Phieu ---");
        boolean found = false;
        System.out.printf("%-10s %-10s %-12s %-25s %-15s\n",
                "MaPN", "MaNCC", "NgayNhap", "LoaiSPChung", "GhiChu");
        System.out.println("--------------------------------------------------------------------");
        for (PN p : ds) {
            if (p.getMaPhieu().equals(ma)) {
                p.xuat();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nKhong tim thay phieu nhap co ma " + ma);
        }
    }

    // Tìm phiếu nhập theo ngày
    public void timTheoNgay(String ngay) {
        System.out.println("\n--- Ket qua tim kiem theo Ngay Nhap ---");
        boolean found = false;
        System.out.printf("%-10s %-10s %-12s %-25s %-15s\n",
                "MaPN", "MaNCC", "NgayNhap", "LoaiSPChung", "GhiChu");
        System.out.println("--------------------------------------------------------------------");
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

    // Thống kê số phiếu nhập còn nợ trong ngày
    public void thongKePhieuNhapConNo(String ngay) {
        int soLuongConNo = 0;
        int tongSoPhieuTrongNgay = 0;
        final String TRANG_THAI_NO = "con no";
        for (PN p : ds) {
            if (p.getNgayNhap().equals(ngay)) {
                tongSoPhieuTrongNgay++;
                if (p.getGhiChu().trim().toLowerCase().equals(TRANG_THAI_NO)) {
                    soLuongConNo++;
                }
            }
        }
        System.out.println("\n=== Thong ke phieu nhap con no ngay " + ngay + " ===");
        if (tongSoPhieuTrongNgay == 0) {
            System.out.println("Khong co phieu nhap nao trong ngay " + ngay + ".");
        } else {
            System.out.println("- Tong so Phieu Nhap trong ngay: " + tongSoPhieuTrongNgay);
            System.out.println("- So luong Phieu Nhap CON NO: " + soLuongConNo);
        }
    }
}