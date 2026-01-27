package doan.classds;

import doan.classchinh.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSKhachHang{
    private KhachHang[] ds = new KhachHang[0];
    private int n = 0;

    public DSKhachHang() {}

    public int size() { return n; }
    public KhachHang[] toArray() { return Arrays.copyOf(ds, n); }

    public void nhap() { them(); }

    public void xuat() {
        if (n == 0) { System.out.println("Danh sach KH rong."); return; }
        System.out.printf("%-8s %-20s %-12s %-25s\n", "MaKH", "Ho Ten", "SDT", "Dia Chi");
        for (int i = 0; i < n; i++) ds[i].xuat();
    }

    public void them() {
        KhachHang k = new KhachHang();
        k.nhap();

        if (timTheoMa(k.getMaKH()) != null) {
            System.out.println("Ma KH da ton tai.");
            return;
        }

        ds = Arrays.copyOf(ds, n + 1);
        ds[n++] = k;
        System.out.println("Da them KH.");
    }

    public void them(KhachHang k) {
        if (timTheoMa(k.getMaKH()) != null) return;
        ds = Arrays.copyOf(ds, n + 1);
        ds[n++] = new KhachHang(k);
    }

    public void sua() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma KH can sua: ");
    String ma = sc.nextLine();

    KhachHang k = timTheoMa(ma);
    if (k == null) {
        System.out.println("Khong tim thay KH.");
        return;
    }

    System.out.println("Nhap thong tin moi :");
    k.nhapSua();

    System.out.println("Da cap nhat.");
}


    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma KH can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }

    public void xoa(String ma) {
        int idx = -1;
        for (int i = 0; i < n; i++) if (ds[i].getMaKH().equalsIgnoreCase(ma)) { idx = i; break; }
        if (idx == -1) { System.out.println("Khong tim thay."); return; }
        for (int i = idx; i < n - 1; i++) ds[i] = ds[i + 1];
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("Da xoa.");
    }
     
   public KhachHang timTheoMa(String ma) {
    for (KhachHang k : ds) {
        if (k != null && k.getMaKH().equalsIgnoreCase(ma)) return k;
    }
    return null;
}

public void timTheoMa() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ma KH can tim: ");
    String ma = sc.nextLine();
    KhachHang k = timTheoMa(ma);
    if (k == null) System.out.println("Khong tim thay KH!");
    else k.xuat();
}

public KhachHang[] timTheoTen(String ten) {
    KhachHang[] kq = new KhachHang[0];
    for (KhachHang k : ds) {
        if (k != null && k.getHoTen().equalsIgnoreCase(ten)) {
            kq = Arrays.copyOf(kq, kq.length + 1);
            kq[kq.length - 1] = k;
        }
    }
    return kq;
}

public void timTheoTen() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Nhap ten KH can tim: ");
    String ten = sc.nextLine();
    KhachHang[] kq = timTheoTen(ten);
    if (kq.length == 0) System.out.println("Khong tim thay KH!");
    else for (KhachHang k : kq) k.xuat();
}

    public void docFile(String f) {
        ds = new KhachHang[0];
        n = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                if (p.length < 4) continue;
                them(new KhachHang(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim()));
            }
            System.out.println("Doc file KH xong " + f);
        } catch (IOException e) {
            System.out.println("Loi doc file KH: " + e.getMessage());
        }
    }

    public void ghiFile(String f) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (int i = 0; i < n; i++) {
                KhachHang k = ds[i];
                bw.write(k.getMaKH() + "," + k.getHoTen() + "," + k.getSdt() + "," + k.getDiaChi());
                bw.newLine();
            }
            System.out.println("Da ghi KH ra file: " + f);
        } catch (IOException e) {
            System.out.println("Loi ghi file KH: " + e.getMessage());
        }
    }

    public void thongKeKhachHang() {
    System.out.println("===== THONG KE KHACH HANG =====");
    System.out.println("Tong so KH: " + n);
    }

}