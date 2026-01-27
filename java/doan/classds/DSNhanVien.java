package doan.classds;

import doan.classchinh.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSNhanVien{
    private NhanVien[] ds = new NhanVien[0];
    private int n = 0;

    public DSNhanVien() {}
    public int size() { return n; }
    public NhanVien[] toArray() { return Arrays.copyOf(ds, n); }

    public void nhap() { them(); }

public void them() {
    NhanVien t = new NhanVien();
    t.nhap();
    if (tim(t.getMaNV()) != null) {
        System.out.println("Ma NV da ton tai, khong them.");
        return;
    }
    ds = Arrays.copyOf(ds, n + 1);
    ds[n++] = t;

    System.out.println("Da them NV.");
}

  public void them(NhanVien t) {
    if (tim(t.getMaNV()) != null) return;
    ds = Arrays.copyOf(ds, n + 1);
    ds[n++] = new NhanVien(t);
}

    public void xuat() {
        if (n == 0) { System.out.println("Danh sach NV rong."); return; }
        System.out.printf("%-8s %-20s %-12s %-12s %-12s\n", "MaNV", "Ho Ten", "NgaySinh", "SDT", "Luong");
        for (int i = 0; i < n; i++) ds[i].xuat();
    }
    
    public NhanVien tim(String ma) {
    for (int i = 0; i < n; i++) {
        if (ds[i].getMaNV().equalsIgnoreCase(ma)) {
            return ds[i];
        }
    }
    return null;
}

  public void sua() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma NV can sua: ");
    String ma = sc.nextLine();

    NhanVien k = timTheoMa(ma);

    if (k == null) {
        System.out.println("Khong tim thay.");
        return;
    }

    System.out.println("Nhap thong tin moi:");
    k.nhapSua();
    System.out.println("Cap nhat xong!");
}

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma NV can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }

    public void xoa(String ma) {
        int idx = -1;
        for (int i = 0; i < n; i++) if (ds[i].getMaNV().equalsIgnoreCase(ma)) { idx = i; break; }
        if (idx == -1) { System.out.println("Khong tim thay de xoa."); return; }
        for (int i = idx; i < n - 1; i++) ds[i] = ds[i + 1];
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("Da xoa.");
    }

    public NhanVien timTheoMa(String ma) {
    for (NhanVien nv : ds) {
        if (nv != null && nv.getMaNV().equalsIgnoreCase(ma)) return nv;
    }
    return null;
}

public void timTheoMa() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma NV can tim: ");
    String ma = sc.nextLine();
    NhanVien nv = timTheoMa(ma);
    if (nv == null) System.out.println("Khong tim thay NV!");
    else nv.xuat();
}

public NhanVien[] timTheoTen(String ten) {
    NhanVien[] kq = new NhanVien[0];
    for (NhanVien nv : ds) {
        if (nv != null && nv.getHoTen().equalsIgnoreCase(ten)) {
            kq = Arrays.copyOf(kq, kq.length + 1);
            kq[kq.length - 1] = nv;
        }
    }
    return kq;
}

public void timTheoTen() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ten NV can tim: ");
    String ten = sc.nextLine();
    NhanVien[] kq = timTheoTen(ten);
    if (kq.length == 0) System.out.println("Khong tim thay NV!");
    else for (NhanVien nv : kq) nv.xuat();
}


    public void docFile(String f) {
        ds = new NhanVien[0];
        n = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                if (p.length < 5) continue;
                String ma = p[0].trim();
                String ten = p[1].trim();
                String ngay = p[2].trim();
                String sdt = p[3].trim();
                double lu = 0;
                try { lu = Double.parseDouble(p[4].trim()); } catch (Exception ex) {}
                them(new NhanVien(ma, ten, ngay, sdt, lu));
            }
            System.out.println("Doc file NV xong " + f);
        } catch (IOException e) {
            System.out.println("Loi doc file NV: " + e.getMessage());
        }
    }

    public void ghiFile(String f) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < n; i++) {
                NhanVien t = ds[i];
                bw.write(t.getMaNV() + "," + t.getHoTen() + "," + t.getNgaySinh() + "," + t.getSdt() + "," + t.getLuong());
                bw.newLine();
            }
            System.out.println("Da ghi NV ra file: " + f);
        } catch (IOException e) {
            System.out.println("Loi ghi file NV: " + e.getMessage());
        }
    }

    public void thongKeNhanVien() {
    System.out.println("===== THONG KE NHAN VIEN =====");
    System.out.println("Tong NV: " + n);

    if (n == 0) return;

    double sum = 0;
    double max = ds[0].getLuong();
    double min = ds[0].getLuong();

    for (NhanVien a : ds) {
        double l = a.getLuong();
        sum += l;
        if (l > max) max = l;
        if (l < min) min = l;
    }

    System.out.println("Luong cao nhat: " + max);
    System.out.println("Luong thap nhat: " + min);
    System.out.println("Luong trung binh: " + (sum / n));
    }

}