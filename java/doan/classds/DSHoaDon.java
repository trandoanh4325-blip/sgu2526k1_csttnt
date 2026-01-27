package doan.classds;

import doan.classchinh.HoaDon;
import doan.Exception.MaTrungException;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSHoaDon {
    private HoaDon[] ds;
    private int n;
    private final Scanner sc = new Scanner(System.in);

    public DSHoaDon() {
        ds = new HoaDon[0];
        n = 0;
    }

    public DSHoaDon(HoaDon[] ds) {
        this.ds = Arrays.copyOf(ds, ds.length);
        this.n = ds.length;
    }

    private HoaDon nhapHoaDon() {
        HoaDon hd = new HoaDon();
        hd.nhap();
        return hd;
    }

    private void kiemTraMaTrung(String ma) throws MaTrungException {
    if (ma == null || ma.trim().isEmpty()) return;
    for (int i = 0; i < n; i++) {
        HoaDon hd = ds[i];
        if (hd != null && hd.getMaHoaDon().equals(ma)) {
            throw new MaTrungException("Ma hoa don '" + ma + "' da ton tai!");
        }
    }
}

    public void them(HoaDon hd) {
        try {
            kiemTraMaTrung(hd.getMaHoaDon());
            ds = Arrays.copyOf(ds, n + 1);
            ds[n] = hd;
            n++;
            System.out.println("Da them hoa don!");
        } catch (MaTrungException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void them() {
        HoaDon hd = nhapHoaDon();
        them(hd);
    }

    public void xuatDanhSach() {
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("===========================================================================");
        System.out.printf("%-10s %-15s %-10s %-15s %-15s\n", "MaHD", "NgayLap", "TongTien", "makhachhang","manhanvien");
        System.out.println("----------------------------------------------------------------------------");
        for (HoaDon hd : ds) 
        if (hd != null)  hd.xuat();
        System.out.println("===========================================================================");
    }

    public HoaDon timHoaDon(String ma) {
        for (HoaDon hd : ds) {
            if (hd != null && hd.getMaHoaDon().equals(ma)) return hd;
        }
        return null;
    }

    public void timHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don can tim: ");
        String ma = sc.nextLine();
        HoaDon hd = timHoaDon(ma);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don!");
        }
            System.out.println("\n===HOA DON CAN TIM===");
            hd.xuat();
    }

    public HoaDon[] timNgayLap(String ngay) {
        HoaDon[] kq = new HoaDon[0];
        for (HoaDon hd : ds) {
            if (hd != null && hd.getNgayLap().equals(ngay)) {
                kq = Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length - 1] = hd;
            }
        }
        return kq;
    }

    public void timNgayLap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay lap can tim: ");
        String ngay = sc.nextLine();
        HoaDon[] kq = timNgayLap(ngay);
        if (kq.length == 0)
         System.out.println("Khong tim thay hoa don!");
        else {
            System.out.println("=== KET QUA TIM NGAY LAP " + ngay + " ===");
            for (HoaDon hd : kq) hd.xuat();
        }
    }

    public void sua() {
        if (n == 0) {
            System.out.println("\nDanh sach rong. Khong the sua.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don can sua: ");
        String maHD = sc.nextLine();
        suaThongTinHoaDon(maHD);
    }

    public void suaThongTinHoaDon(String maHD) {
        
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getMaHoaDon().equals(maHD)) {
                System.out.println("\n--- Chon thong tin can sua cho Hoa Don " + maHD + " ---");
                System.out.println("1. Sua ngay lap \n 2. Sua tong tien");
                System.out.print("Chon so: ");
                int chon;
                try {
                    chon = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lua chon khong hop le!");
                    return;
                }

                switch (chon) {
                    case 1 -> {
                        System.out.print("Nhap ngay lap moi: ");
                        ds[i].setNgayLap(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Nhap tong tien moi: ");
                        try {
                            ds[i].setTongTien(Float.parseFloat(sc.nextLine()));
                        } catch (NumberFormatException e) {
                            System.out.println("Tong tien khong hop le!");
                        }
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                System.out.println("Da sua hoa don " + maHD);
                return;
            }
        }
        System.out.println("\nKhong tim thay ma hoa don!");
    }

    public void xoaHoaDon(String maHD) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getMaHoaDon().equals(maHD)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Khong tim thay ma hoa don!");
            return;
        }
        for (int i = index; i < n - 1; i++) {
            ds[i] = ds[i + 1];
         }
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("Da xoa hoa don " + maHD);
    }

    public void thongkeTongTien() {
        double tong = 0;
        for (HoaDon hd : ds) if (hd != null) tong += hd.getTongTien();
        System.out.println("Tong tien tat ca hoa don: " + tong);
    }

   public void docTuFile(String File) {
    try {
        BufferedReader br = new BufferedReader(new FileReader(File));
        String line;
        HoaDon[] temp = new HoaDon[0];
        line = br.readLine();
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",");
            if (arr.length != 5) {
                System.out.println("loi file" + line);
                continue;
            }
            String ma = arr[0].trim();
            String ngay = arr[1].trim();
            float tong = Float.parseFloat(arr[2].trim());
            String makh = arr[3].trim();
            String manv = arr[4].trim();
            HoaDon hd = new HoaDon(ma, ngay, tong, makh, manv);
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = hd;
        }
        br.close();
        ds = temp;
        n = ds.length;
        System.out.println("Doc File Thanh Cong");
    } catch (Exception e) {
        System.out.println("Loi doc file:  " + e.getMessage());
    }
}

public void ghiFile(String File) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(File))) {
        pw.println("ma,ngaylap,tongtien,makhachhang,manhanvien");
        for (HoaDon hd : ds) {
            if (hd != null)
                pw.println(hd.getMaHoaDon() + "," +
                        hd.getNgayLap() + "," +
                        hd.getTongTien() + "," +
                        hd.getMaKhachHang() + "," +
                        hd.getMaNhanVien());
        }
        System.out.println("Ghi file thành công!");
    } catch (Exception e) {
        System.out.println("Lỗi ghi file: " + e.getMessage());
    }
}

}
