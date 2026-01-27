package doan.classchinh;

import java.util.Scanner;

public class HangSX {
    private String MaHang;
    private String TenHang;
    private String DiaChi;
    private String Sdt;

    // Constructor không tham số
    public HangSX() {}

    // Constructor đầy đủ tham số
    public HangSX(String MaHang, String TenHang, String DiaChi, String Sdt) {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
    }

    // Constructor sao chép
    public HangSX(HangSX h) {
        this.MaHang = h.MaHang;
        this.TenHang = h.TenHang;
        this.DiaChi = h.DiaChi;
        this.Sdt = h.Sdt;
    }

    // Hàm nhập
    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma hang san xuat: ");
        MaHang = sc.nextLine();

        System.out.print("Nhap ten hang san xuat: ");
        TenHang = sc.nextLine();

        System.out.print("Nhap dia chi hang san xuat: ");
        DiaChi = sc.nextLine();

        System.out.print("Nhap so dien thoai hang san xuat: ");
        Sdt = sc.nextLine();
    }

    // Hàm xuất
    public void xuat() {
        System.out.printf("%-10s %-20s %-25s %-15s\n", MaHang, TenHang, DiaChi, Sdt);
    }

    // Getter và Setter
    public String getMaHang() { return MaHang; }
    public void setMaHang(String MaHang) { this.MaHang = MaHang; }

    public String getTenHang() { return TenHang; }
    public void setTenHang(String TenHang) { this.TenHang = TenHang; }

    public String getDiaChi() { return DiaChi; }
    public void setDiaChi(String DiaChi) { this.DiaChi = DiaChi; }

    public String getSdt() { return Sdt; }
    public void setSdt(String Sdt) { this.Sdt = Sdt; }
}
