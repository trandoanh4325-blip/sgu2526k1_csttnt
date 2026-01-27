package doan.classchinh;

import java.util.Scanner;

public class LoaiSP {
    private String MaLoai;
    private String TenLoai;
    private String Mota;
    private String NgayTao;

    // Constructor không tham số
    public LoaiSP() {}

    // Constructor tham số
    public LoaiSP(String MaLoai, String TenLoai, String Mota, String NgayTao) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
        this.Mota = Mota;
        this.NgayTao = NgayTao;
    }

    // Constructor sao chép
    public LoaiSP(LoaiSP l) {
        this.MaLoai = l.MaLoai;
        this.TenLoai = l.TenLoai;
        this.Mota = l.Mota;
        this.NgayTao = l.NgayTao;
    }
    // Hàm nhập
    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma loai: ");
        MaLoai = sc.nextLine();

        System.out.print("Nhap ten loai san pham: ");
        TenLoai = sc.nextLine();

        System.out.print("Nhap mo ta: ");
        Mota = sc.nextLine();

        System.out.print("Nhap ngay tao (dd/mm/yyyy): ");
        NgayTao = sc.nextLine();
    }

    // Hàm xuất
    public void xuat() {
        System.out.printf("%-10s %-20s %-25s %-15s\n",
                MaLoai, TenLoai, Mota, NgayTao);
    }

    // Getter và Setter
    public String getMaLoai() { return MaLoai; }
    public void setMaLoai(String MaLoai) { this.MaLoai = MaLoai; }

    public String getTenLoai() { return TenLoai; }
    public void setTenLoai(String TenLoai) { this.TenLoai = TenLoai; }

    public String getMota() { return Mota; }
    public void setMota(String Mota) { this.Mota = Mota; }

    public String getNgayTao() { return NgayTao; }
    public void setNgayTao(String NgayTao) { this.NgayTao = NgayTao; }
}
