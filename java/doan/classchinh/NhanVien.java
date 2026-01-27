package doan.classchinh;

import java.util.Scanner;

public class NhanVien{
    private String maNV;
    private String hoTen;
    private String ngaySinh;
    private String sdt;
    private double luong;

    public NhanVien() {}

    public NhanVien(String maNV, String hoTen, String ngaySinh, String sdt, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.luong = luong;
    }

    public NhanVien(NhanVien n) {
        this(n.maNV, n.hoTen, n.ngaySinh, n.sdt, n.luong);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma NV: "); maNV = sc.nextLine();
        System.out.print("Ho ten: "); hoTen = sc.nextLine();
        System.out.print("Ngay sinh (dd/mm/yyyy): "); ngaySinh = sc.nextLine();
        System.out.print("SDT: "); sdt = sc.nextLine();
        System.out.print("Luong: ");
        try { luong = Double.parseDouble(sc.nextLine()); } catch (Exception e) { luong = 0; }
    }

    public void nhapSua() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ho ten: "); 
    hoTen = sc.nextLine();
    System.out.print("Ngay sinh (dd/mm/yyyy): "); 
    ngaySinh = sc.nextLine();
    System.out.print("SDT: "); 
    sdt = sc.nextLine();
    System.out.print("Luong: "); 
    try { luong = Double.parseDouble(sc.nextLine()); } catch (Exception e) { luong = 0; }
    }


public void xuat(){
  System.out.printf("%-10s %-20s %-12s %-12s %-12s\n", 
        maNV, hoTen, ngaySinh, sdt, luong);
}
    public String getMaNV() { return maNV; }
    public String getHoTen() { return hoTen; }
    public String getNgaySinh() { return ngaySinh; }
    public String getSdt() { return sdt; }
    public double getLuong() { return luong; }

    public void setHoTen(String s) { hoTen = s; }
    public void setNgaySinh(String s) { ngaySinh = s; }
    public void setSdt(String s) { sdt = s; }
    public void setLuong(double l) { luong = l; }
}