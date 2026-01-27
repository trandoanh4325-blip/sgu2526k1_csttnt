package doan.classchinh;

import java.util.Scanner;

public class KhachHang{
    private String maKH;
    private String hoTen;
    private String sdt;
    private String diaChi;

    public KhachHang() {}

    public KhachHang(String maKH, String hoTen, String sdt, String diaChi) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public KhachHang(KhachHang k) {
        this(k.maKH, k.hoTen, k.sdt, k.diaChi);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma KH: "); maKH = sc.nextLine();
        System.out.print("Ho ten: "); hoTen = sc.nextLine();
        System.out.print("SDT: "); sdt = sc.nextLine();
        System.out.print("Dia chi: "); diaChi = sc.nextLine();
    }
    public void nhapSua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ho ten: "); hoTen = sc.nextLine();
        System.out.print("SDT: "); sdt = sc.nextLine();
        System.out.print("Dia chi: "); diaChi = sc.nextLine();
    }

public void xuat(){
    System.out.printf("%-8s %-20s %-12s %-25s\n", 
        maKH, hoTen, sdt, diaChi);
}
    public String getMaKH() { return maKH; }
    public String getHoTen() { return hoTen; }
    public String getSdt() { return sdt; }
    public String getDiaChi() { return diaChi; }

    public void setHoTen(String s) { hoTen = s; }
    public void setSdt(String s) { sdt = s; }
    public void setDiaChi(String s) { diaChi = s; }
}