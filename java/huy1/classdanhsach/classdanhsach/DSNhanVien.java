package classdanhsach;

import classchinh.*;
import java.io.*;
import java.util.*;

public class DSNhanVien implements IChucNang {

    private NhanVien[] ds = new NhanVien[0];

    // ================== NHẬP ==================
    @Override
    public void nhap() {
        them();
    }

    // ================== XUẤT ==================
    @Override
    public void xuat() {
        System.out.printf("%-10s %-20s %-12s %-12s %-10s\n",
                "MaNV", "Ho Ten", "Ngay Sinh", "SDT", "Luong");

        for (NhanVien n : ds)
            n.xuat();
    }

    // ================== THÊM ==================
    @Override
    public void them() {
        NhanVien n = new NhanVien();
        n.nhap();
        them(n);
    }

    public void them(NhanVien n) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new NhanVien(n);
    }

    // ================== SỬA ==================
    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap Ma NV Can Sua: ");
        String ma = sc.nextLine();

        NhanVien n = tim(ma);
        if (n == null) {
            System.out.println("Không tìm thấy!");
            return;
        }

        System.out.println("Nhap Thong Tin Moi:");
        n.nhap();
    }

    // ================== TÌM ==================
    @Override
    public void tim() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap Ma NV: ");
        String ma = sc.nextLine();

        NhanVien n = tim(ma);
        if (n != null) n.xuat();
        else System.out.println("Khong Tim Thay!");
    }

    public NhanVien tim(String ma) {
        for (NhanVien n : ds)
            if (n.getMaNV().equalsIgnoreCase(ma))
                return n;
        return null;
    }

    // ================== XÓA ==================
    @Override
    public void xoa() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap Ma NV Can Xoa: ");
        xoa(sc.nextLine());
    }

    public void xoa(String ma) {
        int idx = -1;

        for (int i = 0; i < ds.length; i++)
            if (ds[i].getMaNV().equalsIgnoreCase(ma))
                idx = i;

        if (idx == -1) {
            System.out.println("Khong Tim Thay Ma De Xoa!");
            return;
        }

        for (int i = idx; i < ds.length - 1; i++)
            ds[i] = ds[i + 1];

        ds = Arrays.copyOf(ds, ds.length - 1);
    }

    // ================== ĐỌC FILE ==================
    @Override
    public void docFile(String file) {
        try {
            Scanner sc = new Scanner(new File(file));
            ArrayList<NhanVien> list = new ArrayList<>();

            while (sc.hasNextLine()) {

                String ma = sc.nextLine().trim();
                if (ma.equals("")) continue;

                String ten = sc.nextLine().trim();
                String ngaySinh = sc.nextLine().trim();
                String sdt = sc.nextLine().trim();
                double luong = Double.parseDouble(sc.nextLine().trim());

                list.add(new NhanVien(ma, ten, ngaySinh, sdt, luong));

                if (sc.hasNextLine()) sc.nextLine(); // bỏ dòng trống
            }

            ds = list.toArray(new NhanVien[0]);
            sc.close();

        } catch (Exception e) {
            System.out.println("Loi Doc File NV: " + e.getMessage());
        }
    }

    // ================== GHI FILE ==================
    @Override
    public void ghiFile(String file) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {

            for (NhanVien n : ds) {
                pw.println(n.getMaNV());
                pw.println(n.getHoTen());
                pw.println(n.getNgaySinh());
                pw.println(n.getSdt());
                pw.println(n.getLuong());
                pw.println();
            }

        } catch (Exception e) {
            System.out.println("Lỗi ghi file NV: " + e.getMessage());
        }
    }

    // ================== THỐNG KÊ ==================
    public int size() { return ds.length; }

    public NhanVien[] toArray() {
        return Arrays.copyOf(ds, ds.length);
    }
}
