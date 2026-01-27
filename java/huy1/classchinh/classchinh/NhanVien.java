package classchinh;

import java.util.Scanner;

public class NhanVien implements IChucNang {

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

    // ================= NHẬP =================
    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ma NV: ");
        maNV = sc.nextLine();

        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();

        System.out.print("Ngay sinh: ");
        ngaySinh = sc.nextLine();

        System.out.print("SDT: ");
        sdt = sc.nextLine();

        System.out.print("Luong: ");
        luong = sc.nextDouble();
        sc.nextLine();
    }

    // ================= XUẤT =================
    @Override
    public void xuat() {
        System.out.printf("%-10s %-20s %-12s %-12s %-10.2f\n",
                maNV, hoTen, ngaySinh, sdt, luong);
    }

    // ====== Interface yêu cầu nhưng không dùng trong class đối tượng ======
    @Override public void them() {}
    @Override public void xoa() {}
    @Override public void sua() {}
    @Override public void tim() {}
    @Override public void docFile(String file) {}
    @Override public void ghiFile(String file) {}

    // ================= GETTER =================
    public String getMaNV() { return maNV; }
    public String getHoTen() { return hoTen; }
    public String getNgaySinh() { return ngaySinh; }
    public String getSdt() { return sdt; }
    public double getLuong() { return luong; }

    // ================= SETTER =================
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public void setLuong(double luong) { this.luong = luong; }
}
