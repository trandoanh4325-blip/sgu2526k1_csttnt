package doan.classchinh;

import java.util.Scanner;

public class Tap extends SanPham {
    private String soTrang;
    private String loaiGiay;

    public Tap() {}

    public Tap(String maSanPham, String tenSanPham, String maLoai, float donGia, int soLuong,
               String soTrang, String loaiGiay) {
        super(maSanPham, tenSanPham, maLoai, donGia, soLuong);
        this.soTrang = soTrang;
        this.loaiGiay = loaiGiay;
    }

    public Tap(Tap t) {
        super(t);
        this.soTrang = t.soTrang;
        this.loaiGiay = t.loaiGiay;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so trang: ");
        soTrang = sc.nextLine();
        System.out.print("Nhap loai giay: ");
        loaiGiay = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("So trang: " + soTrang);
        System.out.println("Loai giay: " + loaiGiay);
    }

    public String getSoTrang() { return soTrang; }
    public void setSoTrang(String soTrang) { this.soTrang = soTrang; }

    public String getLoaiGiay() { return loaiGiay; }
    public void setLoaiGiay(String loaiGiay) { this.loaiGiay = loaiGiay; }
}

