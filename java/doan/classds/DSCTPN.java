
package doan.classds;

import doan.classchinh.CTPN;
import doan.QuanLy.IChucNang;
import java.io.*;
import java.util.*;

public class DSCTPN implements IChucNang {
    private CTPN[] ds = new CTPN[0];
    private final Scanner sc = new Scanner(System.in);

    // Phương thức docFile
    public void docFile(String File) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(File));
            String line;
            CTPN[] temp = new CTPN[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] arr = line.split(";");
                if (arr.length != 5) {
                    System.out.println(""+ line);
                    continue;
                }
                String maCTPN = arr[0].trim();
                String maPhieu = arr[1].trim();
                String tenHang = arr[2].trim();
                Integer soLuong = Integer.parseInt(arr[3].trim());
                Double donGia = Double.parseDouble(arr[4].trim());
                CTPN ctpn = new CTPN(maCTPN, maPhieu, tenHang, soLuong, donGia);
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = ctpn;
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
            for (CTPN ctpn : ds)
                if (ctpn != null)
                    pw.println(ctpn.getMaCTPN() + ";" +
                            ctpn.getMaPhieu() + ";" +
                            ctpn.getTenHang() + ";" +
                            ctpn.getSoLuong() + ";" +
                            ctpn.getDonGia());
            System.out.println("Ghi file " + File + " thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Kiểm tra trùng mã CTPN
    public boolean kiemTraTrungMa(String ma) {
        for (CTPN ctpn : ds) {
            if (ctpn.getMaCTPN().equals(ma)) {
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
                ds = new CTPN[0];
                System.out.println("Danh sach cu da bi xoa. Bat dau nhap danh sach moi.");
            } else {
                System.out.println("Lua chon khong hop le. Huy nhap.");
                return;
            }
        }
        System.out.print("Nhap so luong chi tiet phieu nhap: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi nhap so luong. Mac dinh la 0.");
            n = 0;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap chi tiet phieu nhap thu " + (i + 1) + " ---");
            CTPN ctpn;
            do {
                ctpn = new CTPN();
                ctpn.nhap(sc);
                if (kiemTraTrungMa(ctpn.getMaCTPN())) {
                    System.out.println("Ma chi tiet phieu nhap '" + ctpn.getMaCTPN() + "' da ton tai! Vui long nhap lai.\n");
                } else {
                    themCTPN(ctpn);
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
            System.out.println("\nDanh sach chi tiet phieu nhap rong.");
            return;
        }
        System.out.println("\n========= DANH SACH CHI TIET PHIEU NHAP =========");
        System.out.printf("%-10s %-10s %-15s %-8s %-10s %-10s\n",
                "MaCTPN", "MaPN", "TenHang", "SL", "DonGia", "ThanhTien");
        System.out.println("----------------------------------------------------------------------");
        for (CTPN c : ds)
            c.xuat();
        System.out.println("====================================================================");
    }


    // Phương thức them
    @Override
    public void them() {
        CTPN ctpn = new CTPN();
        System.out.println("--- Nhap thong tin chi tiet phieu nhap can them ---");
        boolean maTrung;
        do {
            ctpn.nhap(sc);
            String maMoi = ctpn.getMaCTPN();
            maTrung = kiemTraTrungMa(maMoi);
            if (maTrung) {
                 System.out.println("Loi: Ma chi tiet phieu nhap '" + maMoi + "' da ton tai! Vui long nhap lai Ma CTPN.");
            }
        } while (maTrung);
        themCTPN(ctpn);
        System.out.println("\nDa them chi tiet phieu nhap moi thanh cong.");
    }

    public void themCTPN(CTPN ctpn) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = ctpn;
    }

    // Phương thức xoa
    @Override
    public void xoa() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the xoa.");
            return;
        }
        System.out.print("Nhap ma chi tiet phieu nhap can xoa: ");
        String ma = sc.nextLine();
        xoaTheoMaCTPN(ma);
    }

    public void xoaTheoMaCTPN(String ma) {
        int index = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaCTPN().equals(ma)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("\nKhong tim thay ma chi tiet phieu nhap!");
            return;
        }
        for (int i = index; i < ds.length - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, ds.length - 1);
        System.out.println("\nDa xoa chi tiet phieu nhap co ma " + ma);
    }

    // Phương thức sua
    @Override
    public void sua() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the sua.");
            return;
        }
        System.out.print("Nhap ma chi tiet phieu nhap can sua: ");
        String maCTPN = sc.nextLine();
        suaThongTinCTPN(maCTPN);
    }

    public void suaThongTinCTPN(String maCTPN) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaCTPN().equals(maCTPN)) {
                System.out.println("\n--- Chon thong tin can sua cho CTPN " + maCTPN + " ---");
                System.out.println("1. Sua ma phieu nhap\n2. Sua ten hang\n3. Sua so luong\n4. Sua don gia");
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
                        System.out.print("Nhap ma phieu nhap moi: ");
                        ds[i].setMaPhieu(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Nhap ten hang moi: ");
                        ds[i].setTenHang(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Nhap so luong moi: ");
                        try {
                            ds[i].setSoLuong(Integer.parseInt(sc.nextLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("So luong khong hop le!");
                        }
                    }
                    case 4 -> {
                        System.out.print("Nhap don gia moi: ");
                        try {
                            ds[i].setDonGia(Double.parseDouble(sc.nextLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Don gia khong hop le!");
                        }
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                System.out.println("\nDa sua thong tin chi tiet phieu nhap " + maCTPN);
                return;
            }
        }
        System.out.println("\nKhong tim thay ma chi tiet phieu nhap!");
    }

    // Phương thức tim
    @Override
    public void tim() {
        if (ds.length == 0) {
            System.out.println("\nDanh sach rong. Khong the tim kiem.");
            return;
        }
        System.out.print("Nhap ma chi tiet phieu nhap (Ma CTPN) can tim: ");
        String ma = sc.nextLine();
        timTheoMaCTPN(ma);
    }

    public void timTheoMaCTPN(String ma) {
        System.out.println("\n--- Ket qua tim kiem theo Ma Chi Tiet Phieu Nhap ---");
        boolean found = false;
        System.out.printf("%-10s %-10s %-15s %-8s %-10s %-10s\n",
                "MaCTPN", "MaPhieu", "TenHang", "SoLuong", "DonGia", "ThanhTien");
        System.out.println("----------------------------------------------------------------------");
        for (CTPN c : ds) {
            if (c.getMaCTPN().equals(ma)) {
                c.xuat();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nKhong tim thay chi tiet phieu nhap co ma " + ma);
        }
    }

    // Tìm theo mã phiếu nhập
    public void timTheoMaPhieu(String ma) {
        System.out.println("\n--- Ket qua tim kiem theo Ma Phieu Nhap ---");
        boolean found = false;
        System.out.printf("%-10s %-10s %-15s %-8s %-10s %-10s\n",
                "MaCTPN", "MaPhieu", "TenHang", "SoLuong", "DonGia", "ThanhTien");
        System.out.println("----------------------------------------------------------------------");
        for (CTPN c : ds) {
            if (c.getMaPhieu().equals(ma)) {
                c.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("\nKhong tim thay chi tiet phieu nhap nao cho ma phieu " + ma);
        }
    }

    // Thống kê tổng tiền theo mã phiếu nhập
    public void thongKeTongTienTheoPhieu(String maPhieu) {
        double tong = 0;
        for (CTPN c : ds)
            if (c.getMaPhieu().equals(maPhieu))
                tong += c.getThanhTien();
        System.out.printf("\nTong tien cua phieu nhap %s: %.2f\n", maPhieu, tong);
    }
}