package doan.classds;

import doan.classchinh.ChiTietHoaDon;
import doan.Exception.MaTrungException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DSChiTietHoaDon {
    private ChiTietHoaDon[] ds;
    private int n;

    public DSChiTietHoaDon() {
        ds = new ChiTietHoaDon[0];
        n = 0;
    }

    public DSChiTietHoaDon(ChiTietHoaDon[] ds) {
        this.ds = Arrays.copyOf(ds, ds.length);
        this.n = ds.length;
    }

    private ChiTietHoaDon nhapChiTiet() {
        ChiTietHoaDon c = new ChiTietHoaDon();
        c.nhap();
        return c;
    }

    public void nhapDanhSach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong chi tiet hoa don: ");
        try {
            n = sc.nextInt();
            sc.nextLine(); 
            ds = new ChiTietHoaDon[n];
            for (int i = 0; i < n; i++) {
                System.out.println("Chi tiet hoa don " + (i + 1));
                ds[i] = nhapChiTiet();
            }
        } catch (InputMismatchException e) {
             System.out.println("Loi: So luong khong hop le.");
             n = 0; 
             ds = new ChiTietHoaDon[0];
        }
    }

     private void kiemTraMaTrung(String ma) throws MaTrungException {
    if (ma == null || ma.trim().isEmpty()) return;

    for (int i = 0; i < n; i++) {
        ChiTietHoaDon sp = ds[i];
        if (sp != null && sp.getmachitiethoadon().equals(ma)) {
            throw new MaTrungException("Ma chi tiet hoa don '" + ma + "' da ton tai!");
           }
       }
     }

    public void them(ChiTietHoaDon cthd) {
        try {
            kiemTraMaTrung(cthd.getmachitiethoadon());
            ChiTietHoaDon[] temp = Arrays.copyOf(ds, n + 1);
            temp[n] = cthd;
            ds = temp;
            n++;
            System.out.println("Da them chi tiet hoa don thanh cong!");
        } catch (MaTrungException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
    }

    public void them() {
        ChiTietHoaDon c = nhapChiTiet();
        them(c);
    }

    public void xuatDanhSach() {
        if (n == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("============================================================");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n","ma", "mahoadon", "masanpham", "soluong", "dongiathanhtien");
        System.out.println("--------------------------------------------------------------");
        for (ChiTietHoaDon c : ds) {
        if (c != null) c.xuat();
        System.out.println("=====================================================");
        }
    }

    public ChiTietHoaDon timChiTietHoaDon(String machitiethoadon) {
        for (ChiTietHoaDon c : ds) {
            if (c != null && c.getmachitiethoadon().equals(machitiethoadon)) {
                return c;
            }
        }
        return null;
    }

    public void timChiTietHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma chi tiet can tim: ");
        String ma = sc.nextLine();
        ChiTietHoaDon found = timChiTietHoaDon(ma);
        if (found == null) {
            System.out.println("Khong tim thay chi tiet hoa don co ma: " + ma);
            return;
        }
        System.out.println("\n=== CHI TIET TIM THAY ===");
        found.xuat();
    }

    public ChiTietHoaDon[] timMaHoaDon(String mahoadon) {
        ChiTietHoaDon[] kq = new ChiTietHoaDon[0];
        for (ChiTietHoaDon c : ds) {
            if (c != null && c.getmahoadon().equals(mahoadon)) {
                kq = Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length - 1] = c;
            }
        }
        return kq;
    }

    public void timMaHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don can tim: ");
        String mahoadon = sc.nextLine();
        ChiTietHoaDon[] ketqua = timMaHoaDon(mahoadon);
        if (ketqua.length == 0) {
            System.out.println("Khong ton tai chi tiet thuoc hoa don: " + mahoadon);
            return;
        }
        System.out.println("\n=== CHI TIET HOA DON " + mahoadon + " ===");
        for (int i = 0; i < ketqua.length; i++) {
            System.out.println((i + 1) + ".");
            ketqua[i].xuat();
        }
    }
    
    public void sua() {
        if (n == 0) {
            System.out.println("\nDanh sach rong. Khong the sua.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma chi tiet hoa don can sua: ");
        String maCTHD = sc.nextLine();
        suaThongTinChiTietHoaDon(maCTHD, sc);
    }

    public void suaThongTinChiTietHoaDon(String maCTHD, Scanner sc) {
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getmachitiethoadon().equals(maCTHD)) {
                System.out.println("\n--- Chon thong tin can sua cho Chi Tiet Hoa Don " + maCTHD + " ---");
                System.out.println("1. Sua ma hoa don\n2. Sua ma san pham\n3. Sua so luong\n4. Sua don gia");
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
                        System.out.print("Nhap ma hoa don moi: "); 
                        ds[i].setmahoadon(sc.nextLine()); 
                    }
                    case 2 -> { 
                        System.out.print("Nhap ma san pham moi: "); 
                        ds[i].setmasanpham(sc.nextLine()); 
                    }
                    case 3 -> { 
                        System.out.print("Nhap so luong moi: "); 
                        try {
                            // Giả định phương thức setsoluong1(int) tồn tại và hợp lệ
                            ds[i].setsoluong(Integer.parseInt(sc.nextLine()));
                        } catch (NumberFormatException e) { 
                            System.out.println("So luong khong hop le!"); 
                        } catch (Exception e) { 
                             System.out.println("Loi khi set so luong: " + e.getMessage());
                        }
                    }
                    case 4 -> { 
                        System.out.print("Nhap don gia moi: "); 
                        try {
                            System.out.println("nhap don gia");
                        } catch (NumberFormatException e) { 
                            System.out.println("Don gia khong hop le!"); 
                        } catch (Exception e) { 
                             System.out.println("Loi khi set don gia: " + e.getMessage());
                        }
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                System.out.println("\nĐã sửa thông tin chi tiết hóa đơn " + maCTHD);
                return;
            }
        }
        System.out.println("\nKhong tim thay ma chi tiet hoa don!");
    }
    
    public void xoaChiTietHoaDon(String machitiethoadon) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getmachitiethoadon().equals(machitiethoadon)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Khong tim thay ma chi tiet hoa don can xoa!");
            return;
        }
        for (int i = index; i < n - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("Da xoa ma chi tiet hoa don: " + machitiethoadon);
    }

    public void thongkeTongSoLuong() {
        int tong = 0;
        for (ChiTietHoaDon cthd : ds) {
            if (cthd != null) {
                try {
                    // Giả định getsoluong1() trả về int
                    tong += cthd.getsoluong();
                } catch (Exception e) {
                     System.out.println("Loi khi lay so luong: " + e.getMessage());
                }
            }
        }
        System.out.println("Tong so luong chi tiet hoa don: " + tong);
    }

    public void docTuFile(String File) {
    try {
        BufferedReader br = new BufferedReader(new FileReader(File));
        String line;

        // Bỏ dòng tiêu đề
        line = br.readLine();
        ChiTietHoaDon[] temp = new ChiTietHoaDon[0];
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] arr = line.split(",");
            if (arr.length != 5) {
                System.out.println("Dòng lỗi: " + line);
                continue;
            }
            String ma = arr[0].trim();
            String maHD = arr[1].trim();
            String maSP = arr[2].trim();
            int soLuong = Integer.parseInt(arr[3].trim());
            float donGia = Float.parseFloat(arr[4].trim());
            ChiTietHoaDon cthd = new ChiTietHoaDon(ma, maHD, maSP, soLuong, donGia);
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = cthd;
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
        pw.println("machitiet,mahoadon,masanpham,soluong,dongia");
        for (ChiTietHoaDon cthd : ds) {
            if (cthd != null) {
                pw.println(
                    cthd.getmachitiethoadon() + "," +
                    cthd.getmahoadon() + "," +
                    cthd.getmasanpham() + "," + 
                    cthd.getsoluong() + "," +
                    cthd.getdongia()
                );
            }
        }
        System.out.println("Ghi file thành công!");
    } catch (Exception e) {
        System.out.println("Lỗi ghi file: " + e.getMessage());
    }
}

}






































