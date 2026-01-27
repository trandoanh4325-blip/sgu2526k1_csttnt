package doan.classchinh;

import java.util.Scanner;

public abstract class SanPham{
    protected String MaSanPham;
    protected String TenSanPham;
    protected String MaLoai;
    protected float DonGia;
    protected int SoLuong;

    public SanPham() {
        MaSanPham = "";
        TenSanPham = "";
        MaLoai = "";
        DonGia = 0;
        SoLuong = 0;
    }

    public SanPham(String MaSanPham, String TenSanPham, String MaLoai, float DonGia, int SoLuong) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.MaLoai = MaLoai;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
    }
     // thiết lập sao chép
     public SanPham(SanPham sp) {
        this.MaSanPham = sp.MaSanPham;
        this.TenSanPham = sp.TenSanPham;
        this.MaLoai = sp.MaLoai;
        this.DonGia = sp.DonGia;
        this.SoLuong = sp.SoLuong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        MaSanPham = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        TenSanPham = sc.nextLine();
        System.out.print("Nhap ma loai: ");
        MaLoai = sc.nextLine();
        System.out.print("Nhap don gia: ");
        DonGia = sc.nextFloat();
        System.out.print("Nhap so luong: ");
        SoLuong = sc.nextInt();
        sc.nextLine();
    }

   
    public void xuat() {
        System.out.printf("%-10s %-15s %-10s %-10.2f %-10d\n",
                MaSanPham, TenSanPham, MaLoai, DonGia, SoLuong);
    }

    public String getMaSanPham() { return MaSanPham; }
    public void setMaSanPham(String MaSanPham) { this.MaSanPham = MaSanPham; }

    public String getTenSanPham() { return TenSanPham; }
    public void setTenSanPham(String TenSanPham) { this.TenSanPham = TenSanPham; }

    public String getMaLoai() { return MaLoai; }
    public void setMaLoai(String MaLoai) { this.MaLoai = MaLoai; }

    public float getDonGia() { return DonGia; }
    public void setDonGia(float DonGia) { this.DonGia = DonGia; }

    public int getSoLuong() { return SoLuong; }
    public void setSoLuong(int SoLuong) { this.SoLuong = SoLuong; }

     public float tinhThanhTien() {
        return DonGia * SoLuong;
    }

    public SanPham clone() {
        return new SanPham(this){};
    }
}
