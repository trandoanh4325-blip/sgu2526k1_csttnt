package doan.classchinh;

import java.util.Scanner;

public class HoaDon {
    private String maHoaDon;
    private String ngayLap;
    private String maKhachHang;
    private String maNhanVien;

    public HoaDon() {
        maHoaDon = "";
        ngayLap = "";
        maKhachHang = "";
        maNhanVien = "";
    }

    public HoaDon(String maHoaDon, String ngayLap, String maKhachHang, String maNhanVien) {
        this.maHoaDon = maHoaDon;
        this.ngayLap = ngayLap;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
    }

    public HoaDon(HoaDon hd) {
        this.maHoaDon = hd.maHoaDon;
        this.ngayLap = hd.ngayLap;
        this.maKhachHang = hd.maKhachHang;
        this.maNhanVien = hd.maNhanVien;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        maHoaDon = sc.nextLine();
        System.out.print("Nhap ngay lap: ");
        ngayLap = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        maKhachHang = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = sc.nextLine();
    }

   public void xuat() {
    System.out.printf("%-10s %-15s %-10s %-15s %-15s\n", maHoaDon, ngayLap, maKhachHang, maNhanVien);
    }

 
    // Getter Setter
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getNgayLap() { return ngayLap; }
    public void setNgayLap(String ngayLap) { this.ngayLap = ngayLap; }

    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }

    public String getMaNhanVien() { return maNhanVien; }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien = maNhanVien; }


}
