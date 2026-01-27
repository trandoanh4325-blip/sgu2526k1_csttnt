package classdanhsach;

import classchinh.*;
import java.io.*;
import java.util.*;

public class DSTTTK implements IChucNang {

    private ThongTinTaiKhoan[] ds = new ThongTinTaiKhoan[0];

    // ================== NHẬP ==================
    @Override
    public void nhap() {
        them();
    }

    // ================== XUẤT ==================
    @Override
    public void xuat() {
        System.out.printf("%-10s %-15s %-15s %-10s %-10s\n",
                "MaTK", "TenDN", "MatKhau", "Loai", "MaNV");

        for (ThongTinTaiKhoan t : ds)
            t.xuat();
    }

    // ================== THÊM ==================
    @Override
    public void them() {
        ThongTinTaiKhoan t = new ThongTinTaiKhoan();
        t.nhap();
        them(t);
    }

    public void them(ThongTinTaiKhoan t) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = new ThongTinTaiKhoan(t);
    }

    // ================== SỬA ==================
    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma TK Can Sua: ");
        String ma = sc.nextLine();

        ThongTinTaiKhoan t = tim(ma);
        if (t == null) {
            System.out.println("Khong Tim Thay!");
            return;
        }

        System.out.println("Nhap Thong Tin Moi:");
        t.nhap();
    }

    // ================== TÌM ==================
    @Override
    public void tim() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma Tai Khoan: ");
        String ma = sc.nextLine();

        ThongTinTaiKhoan t = tim(ma);
        if (t != null) t.xuat();
        else System.out.println("Khong Tim Thay!");
    }

    public ThongTinTaiKhoan tim(String maTK) {
        for (ThongTinTaiKhoan t : ds)
            if (t.getMaTK().equalsIgnoreCase(maTK))
                return t;
        return null;
    }

    // ================== XÓA ==================
    @Override
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap Ma TK Can Xoa: ");
        xoa(sc.nextLine());
    }

    public void xoa(String maTK) {
        int idx = -1;

        for (int i = 0; i < ds.length; i++)
            if (ds[i].getMaTK().equalsIgnoreCase(maTK))
                idx = i;

        if (idx == -1) {
            System.out.println("Khong Tim Thay De xoa!");
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
            ArrayList<ThongTinTaiKhoan> list = new ArrayList<>();

            while (sc.hasNextLine()) {
                String maTK = sc.nextLine().trim();
                if (maTK.equals("")) continue;

                String tenDN = sc.nextLine().trim();
                String mk    = sc.nextLine().trim();
                String loai  = sc.nextLine().trim();
                String maNV  = sc.nextLine().trim();

                list.add(new ThongTinTaiKhoan(maTK, tenDN, mk, loai, maNV));

                if (sc.hasNextLine()) sc.nextLine(); 
            }

            ds = list.toArray(new ThongTinTaiKhoan[0]);
            sc.close();

        } catch (Exception e) {
            System.out.println("Loi doc File TK: " + e.getMessage());
        }
    }

    // ================== GHI FILE ==================
    @Override
    public void ghiFile(String file) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {

            for (ThongTinTaiKhoan t : ds) {
                pw.println(t.getMaTK());
                pw.println(t.getTenDangNhap());
                pw.println(t.getMatKhau());
                pw.println(t.getLoai());
                pw.println(t.getMaNV());
                pw.println();
            }

        } catch (Exception e) {
            System.out.println("Loi ghi File TK: " + e.getMessage());
        }
    }

    // ================== SUPPORT ==================
    public int size() {
        return ds.length;
    }

    public ThongTinTaiKhoan[] toArray() {
        return Arrays.copyOf(ds, ds.length);
    }
}
