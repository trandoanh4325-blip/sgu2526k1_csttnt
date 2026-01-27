package triet;

import java.util.Arrays;
import java.util.Scanner;

public class DSSV {
   private SinhVien[] dssv;
    private int n;

    public DSSV() {
        dssv = new SinhVien[0];
        n = 0;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        n = sc.nextInt();
        sc.nextLine();
        dssv = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\n-- Nhập sinh viên thứ " + (i + 1) + " --");
            dssv[i] = new SinhVien();
            dssv[i].nhap();
        }
    }

    public void xuat() {
        System.out.printf("%-10s %-15s %-10s %-12s %-8s %6s\n", "MãSV", "Họ", "Tên", "Ngày sinh", "GT", "ĐTB");
        for (int i = 0; i < n; i++) {
            dssv[i].xuat();
        }
    }

    public void them() {
        n=dssv.length;
        dssv = Arrays.copyOf(dssv, n + 1);
        dssv[n] = new SinhVien();
        dssv[n].nhap();
        n++;
    }

    public void them(SinhVien x) {
        n=dssv.length;
        dssv = Arrays.copyOf(dssv, n + 1);
        dssv[n] = new SinhVien(x);
        n++;
    }

    public SinhVien timKiem(String ma) {
        for (int i = 0; i < n; i++) {
            if (dssv[i].getMaSV().equalsIgnoreCase(ma))
                return dssv[i];
        }
        return null;
    }

    public void xoa(String ma) {
        int vt = -1;
        for (int i = 0; i < n; i++) {
            if (dssv[i].getMaSV().equalsIgnoreCase(ma)) {
                vt = i; break;
            }
        }
        if (vt == -1) {
            System.out.println("Không tìm thấy sinh viên có mã: " + ma);
            return;
        }
        for (int i = vt; i < n - 1; i++) {
            dssv[i] = dssv[i + 1];
        }
        n--;
        dssv = Arrays.copyOf(dssv, n);
        System.out.println("Đã xóa sinh viên có mã " + ma);
    }

    public void sua(String ma) {
        SinhVien sv = timKiem(ma);
        if (sv == null) {
            System.out.println("Không tìm thấy sinh viên có mã: " + ma);
            return;
        }
        System.out.println("Nhập lại thông tin cho sinh viên " + ma + ":");
        sv.nhap();
    }

    // Thống kê điểm trung bình
    public void thongKe() {
        double tong = 0;
        for (int i = 0; i < n; i++) tong += dssv[i].getDiemTB();
        double tb = (n > 0) ? tong / n : 0;
        System.out.printf("Điểm trung bình của toàn lớp: %.2f\n", tb);
    }
}