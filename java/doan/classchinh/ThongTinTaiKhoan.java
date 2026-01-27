package doan.classchinh;

import java.util.Scanner;

public class ThongTinTaiKhoan{
    private String maTK;
    private String username;
    private String password;
    private int loaiTK; 
    private String maNV; 

    public ThongTinTaiKhoan() {}

    public ThongTinTaiKhoan(String maTK, String username, String password, int loaiTK, String maNV) {
        this.maTK = maTK;
        this.username = username;
        this.password = password;
        this.loaiTK = loaiTK;
        this.maNV = maNV;
    }

    public ThongTinTaiKhoan(ThongTinTaiKhoan t) {
        this(t.maTK, t.username, t.password, t.loaiTK, t.maNV);
    }

   public void nhap() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ma TK: "); 
    maTK = sc.nextLine();
    System.out.print("Username: "); 
    username = sc.nextLine();
    System.out.print("Password: "); 
    password = sc.nextLine();
    System.out.print("MaNV lien ket (de trong neu ko co): "); 
    maNV = sc.nextLine();
}
public void nhapSua() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Username: ");
    username = sc.nextLine();
    System.out.print("Password: ");
    password = sc.nextLine();
    System.out.print("Loai TK (1-admin, 2-nhanvien, 3-khachhang): ");
    try { loaiTK = Integer.parseInt(sc.nextLine()); } catch (Exception e) {}
    System.out.print("Ma NV lien ket: ");
    maNV = sc.nextLine();
}


    public void xuat(){
       System.out.printf("%-6s %-15s %-10s %-6s %-8s\n", 
        maTK, username, password, loaiTK, maNV);
}
    public String getMaTK() { return maTK; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getLoaiTK() { return loaiTK; }
    public String getMaNV() { return maNV; }

    public void setMaTK(String s) { maTK = s; }
    public void setUsername(String s) { username = s; }
    public void setPassword(String s) { password = s; }
    public void setLoaiTK(int l) { loaiTK = l; }
    public void setMaNV(String s) { maNV = s; }
}