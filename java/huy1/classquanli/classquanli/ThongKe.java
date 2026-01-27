package classquanli;

import classdanhsach.*;
import classchinh.*;

public class ThongKe {

    // ================== THỐNG KÊ NHÂN VIÊN ==================
    public static void thongKeNhanVien(DSNhanVien ds) {

        NhanVien[] arr = ds.toArray();
        int n = arr.length;
        double sum = 0;

        for (NhanVien x : arr)
            sum += x.getLuong();

        System.out.println("=== THONG KE NHAN VIEN ===");
        System.out.println("Tong NV: " + n);
        System.out.println("Tong luong: " + sum);
        System.out.println("Luong trung binh: " + (n == 0 ? 0 : sum / n));
    }

    // ================== THỐNG KÊ KHÁCH HÀNG ==================
    public static void thongKeKhachHang(DSKhachHang ds) {
        int n = ds.size();
        System.out.println("=== THONG KE KHACH HANG ===");
        System.out.println("Tong KH: " + n);
    }

    // ================== THỐNG KÊ TÀI KHOẢN ==================
    public static void thongKeTaiKhoan(DSTTTK ds) {

        ThongTinTaiKhoan[] arr = ds.toArray();
        int total = arr.length;

        int admin = 0, nv = 0, kh = 0, other = 0;

        for (ThongTinTaiKhoan t : arr) {
            String loai = t.getLoai().toLowerCase();

            if (loai.equals("admin")) admin++;
            else if (loai.equals("nv")) nv++;
            else if (loai.equals("kh")) kh++;
            else other++;
        }

        System.out.println("=== THONG KE TAI KHOAN ===");
        System.out.println("Tong TK: " + total);
        System.out.println("Admin: " + admin + 
                           " | NV: " + nv + 
                           " | KH: " + kh + 
                           " | Khac: " + other);
    }

    // ================== THỐNG KÊ TẤT CẢ ==================
    public static void thongKeTatCa(DSNhanVien nv, DSKhachHang kh, DSTTTK tk) {
        System.out.println();
        thongKeNhanVien(nv);
        System.out.println();
        thongKeKhachHang(kh);
        System.out.println();
        thongKeTaiKhoan(tk);
        System.out.println();
    }
}
