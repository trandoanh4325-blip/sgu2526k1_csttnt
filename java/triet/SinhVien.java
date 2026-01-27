package triet;
import java.util.Scanner;

public class SinhVien {
    private String maSV;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String gioiTinh;
    private double diemTB;

    public SinhVien() {}

    public SinhVien(String maSV, String ho, String ten, String ngaySinh, String gioiTinh) {
        this.maSV = maSV;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diemTB = 0.0;
    }

    public SinhVien(SinhVien x) {
        this.maSV = x.maSV;
        this.ho = x.ho;
        this.ten = x.ten;
        this.ngaySinh = x.ngaySinh;
        this.gioiTinh = x.gioiTinh;
        this.diemTB = x.diemTB;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã SV: ");
        maSV = sc.nextLine();
        System.out.print("Nhập họ: ");
        ho = sc.nextLine();
        System.out.print("Nhập tên: ");
        ten = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        ngaySinh = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        gioiTinh = sc.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        try {
            diemTB = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            diemTB = 0.0;
        }
    }

    public void xuat() {
        System.out.printf("%-10s %-15s %-10s %-12s %-8s %6.2f\n", maSV, ho, ten, ngaySinh, gioiTinh, diemTB);
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }
}

