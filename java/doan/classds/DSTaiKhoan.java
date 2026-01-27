package doan.classds;

import doan.classchinh.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSTaiKhoan {
    private ThongTinTaiKhoan[] ds = new ThongTinTaiKhoan[0];
    private int n = 0;

    public DSTaiKhoan() {}

    public int size() { return n; }
    public ThongTinTaiKhoan[] toArray() { return Arrays.copyOf(ds, n); }

    public void nhap() { them(); }

    public void them() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Chon loai tai khoan:");
    System.out.println("1. Admin");
    System.out.println("2. Nhan vien");
    System.out.println("3. Khach hang");
    System.out.print("Nhap lua chon: ");

    int loai = 3;
    try { loai = Integer.parseInt(sc.nextLine()); } catch (Exception e) {}
    if (loai < 1 || loai > 3) loai = 3;

 
    ThongTinTaiKhoan t = new ThongTinTaiKhoan();
    t.nhap();   

    t.setLoaiTK(loai); 

        if (timByMa(t.getMaTK()) != null) {
        System.out.println("MaTK da ton tai!");
        return;
    }

    if (timByUser(t.getUsername()) != null) {
        System.out.println("Username da ton tai!");
        return;
    }

    ds = Arrays.copyOf(ds, n + 1);
    ds[n++] = t;

    System.out.println("Da them TK thanh cong!");
}


    public void them(ThongTinTaiKhoan t) {
        if (timByMa(t.getMaTK()) != null) return;
        ds = Arrays.copyOf(ds, n + 1);
        ds[n++] = new ThongTinTaiKhoan(t);
    }
  public void xuat() {
        if (n == 0) { System.out.println("Danh sach TK rong."); return; }
        System.out.printf("%-6s %-15s %-10s %-6s %-8s\n", "MaTK", "Username", "Pass", "Loai", "MaNV");
        for (int i = 0; i < n; i++) ds[i].xuat();
    }

public void sua() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma TK can sua: ");
    String ma = sc.nextLine();

    ThongTinTaiKhoan t = timByMa(ma);
    if (t == null) {
        System.out.println("Khong tim thay TK!");
        return;
    }

    System.out.println("Nhap thong tin moi:");
    t.nhapSua();

    System.out.println("Da cap nhat!");
}


    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap maTK can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }

    public void xoa(String ma) {
        int idx = -1;
        for (int i = 0; i < n; i++) if (ds[i].getMaTK().equalsIgnoreCase(ma)) { idx = i; break; }
        if (idx == -1) { System.out.println("Khong tim thay."); return; }
        for (int i = idx; i < n - 1; i++) ds[i] = ds[i + 1];
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("Da xoa.");
    }

    public ThongTinTaiKhoan timByMa(String ma) {
        for (int i = 0; i < n; i++) if (ds[i].getMaTK().equalsIgnoreCase(ma)) return ds[i];
        return null;
    }

    public ThongTinTaiKhoan timByUser(String user) {
        for (int i = 0; i < n; i++) if (ds[i].getUsername().equalsIgnoreCase(user)) return ds[i];
        return null;
    }

// Tìm theo mã TK
public void timtheomaTK() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma TK: ");
    String ma = sc.nextLine();

    ThongTinTaiKhoan t = timByMa(ma);
    if (t == null) System.out.println("Khong tim thay.");
    else t.xuat();
}

// Tìm theo Username
public void timtheoUsername() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap username: ");
    String user = sc.nextLine();

    ThongTinTaiKhoan t = timByUser(user);
    if (t == null) System.out.println("Khong tim thay.");
    else t.xuat();
}


    public void docFile(String f) {
        ds = new ThongTinTaiKhoan[0];
        n = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                if (p.length < 5) continue;
                String ma = p[0].trim();
                String user = p[1].trim();
                String pass = p[2].trim();
                int lo = 3;
                try { lo = Integer.parseInt(p[3].trim()); } catch (Exception ex) {}
                String maNV = p[4].trim();
                them(new ThongTinTaiKhoan(ma, user, pass, lo, maNV));
            }
            System.out.println("Doc file TK xong " +f );
        } catch (IOException e) {
            System.out.println("Loi doc file TK: " + e.getMessage());
        }
    }

    public void ghiFile(String f) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < n; i++) {
                ThongTinTaiKhoan t = ds[i];
                bw.write(t.getMaTK() + "," + t.getUsername() + "," + t.getPassword() + "," + t.getLoaiTK() + "," + (t.getMaNV()==null?"":t.getMaNV()));
                bw.newLine();
            }
            System.out.println("Da ghi TK ra file: " + f);
        } catch (IOException e) {
            System.out.println("Loi ghi file TK: " + e.getMessage());
        }
    }
    public void thongKeTaiKhoan() {
    System.out.println("===== THONG KE TAI KHOAN =====");
    System.out.println("Tong so TK: " + n);

    int admin = 0, nv = 0, kh = 0;

    for (ThongTinTaiKhoan t : ds) {
        if (t.getLoaiTK() == 1) admin++;
        else if (t.getLoaiTK() == 2) nv++;
        else if (t.getLoaiTK() == 3) kh++;
    }

    System.out.println("So TK admin: " + admin);
    System.out.println("So TK nhan vien: " + nv);
    System.out.println("So TK khach hang: " + kh);
    }

}