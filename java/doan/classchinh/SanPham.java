package doan.classchinh;

import java.util.Scanner;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String maLoai;
    private float donGia;
    private int soLuong;

    public SanPham() {
        maSanPham = "";
        tenSanPham = "";
        maLoai = "";
        donGia = 0;
        soLuong = 0;
    }

    public SanPham(String maSanPham, String tenSanPham, String maLoai, float donGia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.maLoai = maLoai;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public SanPham(SanPham sp) {
        this.maSanPham = sp.maSanPham;
        this.tenSanPham = sp.tenSanPham;
        this.maLoai = sp.maLoai;
        this.donGia = sp.donGia;
        this.soLuong = sp.soLuong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham: ");
        maSanPham = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        tenSanPham = sc.nextLine();
        System.out.print("Nhap ma loai: ");
        maLoai = sc.nextLine();
        System.out.print("Nhap don gia: ");
        donGia = sc.nextFloat();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-30s %-10s %-10.2f %-10d\n", maSanPham, tenSanPham, maLoai, donGia, soLuong);
    }

    public float tinhThanhTien() {
        return donGia * soLuong;
    }

    public SanPham clone() {
        return new SanPham(this);
    }

    // Getter - Setter chuẩn camelCase
    public String getMaSanPham() { return maSanPham; }
    public void setMaSanPham(String maSanPham) { this.maSanPham = maSanPham; }

    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }

    public String getMaLoai() { return maLoai; }
    public void setMaLoai(String maLoai) { this.maLoai = maLoai; }

    public float getDonGia() { return donGia; }
    public void setDonGia(float donGia) { this.donGia = donGia; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
}
