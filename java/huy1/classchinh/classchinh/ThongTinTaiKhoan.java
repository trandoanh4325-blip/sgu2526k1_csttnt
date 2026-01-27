package classchinh;

import java.util.Scanner;

public class ThongTinTaiKhoan implements IChucNang {

    private String maTK;
    private String tenDangNhap;
    private String matKhau;
    private String loai;
    private String maNV;   // tài khoản thuộc nhân viên nào

    public ThongTinTaiKhoan() {}

    public ThongTinTaiKhoan(String maTK, String tenDangNhap, String matKhau, String loai, String maNV) {
        this.maTK = maTK;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.loai = loai;
        this.maNV = maNV;
    }

    public ThongTinTaiKhoan(ThongTinTaiKhoan t) {
        this(t.maTK, t.tenDangNhap, t.matKhau, t.loai, t.maNV);
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Mã TK: ");
        maTK = sc.nextLine();

        System.out.print("Tên đăng nhập: ");
        tenDangNhap = sc.nextLine();

        System.out.print("Mật khẩu: ");
        matKhau = sc.nextLine();

        System.out.print("Loại tài khoản (admin/nv/kh): ");
        loai = sc.nextLine();

        System.out.print("Mã nhân viên: ");
        maNV = sc.nextLine();
    }

    @Override
    public void xuat() {
        System.out.printf("%-10s %-15s %-15s %-10s %-10s\n",
                maTK, tenDangNhap, "******", loai, maNV);
    }

    // Không dùng – để trống theo interface
    @Override public void them() {}
    @Override public void xoa() {}
    @Override public void sua() {}
    @Override public void tim() {}
    @Override public void docFile(String file) {}
    @Override public void ghiFile(String file) {}

    // ===== GETTER =====
    public String getMaTK() { return maTK; }
    public String getTenDangNhap() { return tenDangNhap; }
    public String getMatKhau() { return matKhau; }
    public String getLoai() { return loai; }
    public String getMaNV() { return maNV; }

    // ===== SETTER =====
    public void setMaTK(String maTK) { this.maTK = maTK; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }
    public void setLoai(String loai) { this.loai = loai; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
}
