package test1.single;

import java.util.*;

public class PN {
    private String maPhieu;
    private String maNhaCungCap;
    private String ngayNhap;
    private String tenHang;
    private int soLuong;
    private double donGia;

    // Hàm thiết lập 0 tham số 
    public PN(){}

    // Hàm thiết lập có tham số
    public PN(String maPhieu, String maNhaCungCap, String ngayNhap, String tenHang, int soLuong, double donGia) {
        this.maPhieu = maPhieu;
        this.maNhaCungCap = maNhaCungCap;
        this.ngayNhap = ngayNhap;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    // Hàm thiết lập sao chép
    public PN(PN p) {
        this.maPhieu = p.maPhieu;
        this.maNhaCungCap = p.maNhaCungCap;
        this.ngayNhap = p.ngayNhap;
        this.tenHang = p.tenHang;
        this.soLuong = p.soLuong;
        this.donGia = p.donGia;
    }

    // Get/set
    public String getMaPhieu() { return maPhieu; }
    public void setMaPhieu(String maPhieu) { this.maPhieu = maPhieu; }

    public String getMaNhaCungCap() { return maNhaCungCap; }
    public void setMaNhaCungCap(String maNhaCungCap) { this.maNhaCungCap = maNhaCungCap; }

    public String getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(String ngayNhap) { this.ngayNhap = ngayNhap; }

    public String getTenHang() { return tenHang; }
    public void setTenHang(String tenHang) { this.tenHang = tenHang; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }

    public double getThanhTien() {
        return soLuong * donGia;
    }

    // Hàm nhập
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu: ");
        maPhieu = sc.nextLine();
        System.out.print("Nhap ma nha cung cap: ");
        maNhaCungCap = sc.nextLine();
        System.out.print("Nhap ngay nhap (dd/mm/yyyy): ");
        ngayNhap = sc.nextLine();
        System.out.print("Nhap ten hang: ");
        tenHang = sc.nextLine();
        System.out.print("Nhap so luong: ");
        try {
            soLuong = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi: So luong khong hop le, dat mac dinh la 0.");
            soLuong = 0;
        }
        System.out.print("Nhap don gia: ");
        try {
            donGia = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Loi: Don gia khong hop le, dat mac dinh la 0.0.");
            donGia = 0.0;
        }
    }
    // Hàm xuất
    public void xuat() {
        System.out.printf("%-10s %-10s %-12s %-15s %-10d %-12.2f %-12.2f\n",
                maPhieu, maNhaCungCap, ngayNhap, tenHang, soLuong, donGia, getThanhTien());
    }
}