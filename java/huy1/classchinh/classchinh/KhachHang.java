package classchinh;

import java.util.Scanner;

public class KhachHang implements IChucNang {

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

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma KH: "); maKH = sc.nextLine();
        System.out.print("Ho ten: "); hoTen = sc.nextLine();
        System.out.print("SDT: "); sdt = sc.nextLine();
        System.out.print("Đia chi: "); diaChi = sc.nextLine();
    }

    @Override
    public void xuat() {
        System.out.printf("%-10s %-20s %-12s %-20s\n",
                maKH, hoTen, sdt, diaChi);
    }

    @Override public void them() {}
    @Override public void xoa() {}
    @Override public void sua() {}
    @Override public void tim() {}
    @Override public void docFile(String file) {}
    @Override public void ghiFile(String file) {}

    public String getMaKH() { return maKH; }
    public String getHoTen() { return hoTen; }
    public String getSdt() { return sdt; }
    public String getDiaChi() { return diaChi; }
}
