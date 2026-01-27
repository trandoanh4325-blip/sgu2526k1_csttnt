package classdanhsach;

import classchinh.*;
import java.io.*;
import java.util.*;

public class DSKhachHang implements IChucNang {

    private KhachHang[] ds = new KhachHang[0];

    @Override
    public void nhap() { them(); }

    @Override
    public void xuat() {
        System.out.printf("%-10s %-20s %-12s %-20s\n",
                "MaKH", "Ho Ten", "SDT", "Dia Chi");
        for (KhachHang k : ds) k.xuat();
    }

    @Override
    public void them() {
        KhachHang k = new KhachHang();
        k.nhap();
        them(k);
    }

    public void them(KhachHang k) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new KhachHang(k);
    }

    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma KH Can Sua: ");
        KhachHang k = tim(sc.nextLine());
        if (k == null) System.out.println("Khong Tim Thay!");
        else {
            System.out.println("Nhap Thong Tin Moi:");
            k.nhap();
        }
    }

    @Override
    public void tim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma KH: ");
        KhachHang k = tim(sc.nextLine());
        if (k != null) k.xuat();
        else System.out.println("Khong Tim Thay!");
    }

    public KhachHang tim(String ma) {
        for (KhachHang k : ds)
            if (k.getMaKH().equalsIgnoreCase(ma)) return k;
        return null;
    }

    @Override
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma KH Can Xoa: ");
        xoa(sc.nextLine());
    }

    public void xoa(String ma) {
        int idx = -1;
        for (int i = 0; i < ds.length; i++)
            if (ds[i].getMaKH().equalsIgnoreCase(ma)) idx = i;

        if (idx == -1) return;

        for (int i = idx; i < ds.length - 1; i++)
            ds[i] = ds[i + 1];

        ds = Arrays.copyOf(ds, ds.length - 1);
    }

    @Override
    public void docFile(String file) {
        try {
            Scanner sc = new Scanner(new File(file));
            ArrayList<KhachHang> list = new ArrayList<>();

            while (sc.hasNextLine()) {
                String ma = sc.nextLine().trim();
                if (ma.equals("")) continue;

                String ten = sc.nextLine().trim();
                String sdt = sc.nextLine().trim();
                String dc  = sc.nextLine().trim();

                list.add(new KhachHang(ma, ten, sdt, dc));

                if (sc.hasNextLine()) sc.nextLine(); // dòng trống
            }

            ds = list.toArray(new KhachHang[0]);
            sc.close();

        } catch (Exception e) {
            System.out.println("Loi Doc File KH: " + e.getMessage());
        }
    }

    @Override
    public void ghiFile(String file) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (KhachHang k : ds) {
                pw.println(k.getMaKH());
                pw.println(k.getHoTen());
                pw.println(k.getSdt());
                pw.println(k.getDiaChi());
                pw.println();
            }
        } catch (Exception e) {
            System.out.println("Loi Ghi File KH: " + e.getMessage());
        }
    }

    public int size() { return ds.length; }

    public KhachHang[] toArray() {
        return Arrays.copyOf(ds, ds.length);
    }
}
