package doan.classds;

import doan.classchinh.SanPham;
import doan.classchinh.But;
import doan.classchinh.Tap;
import doan.Exception.MaTrungException;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DSSanPham {
    private SanPham[] ds;
    private int n;

    public DSSanPham() {
        ds = new SanPham[0];
        n = 0;
    }

    public DSSanPham(SanPham[] ds) {
        this.ds = Arrays.copyOf(ds, ds.length);
        this.n = ds.length;
    }

    private SanPham nhapSanPham() {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("Chon loai san pham: 1. But / 2. Tap");
            System.out.print("Lua chon: ");
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                chon = -1;
            }
            if (chon != 1 && chon != 2) {
                System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 1 && chon != 2);

        SanPham sp;

        while (true) {
            sp = (chon == 1) ? new But() : new Tap();
            sp.nhap();
            try {
                kiemTraMaTrung(sp.getMaSanPham());
                break;
            } catch (MaTrungException e) {
                System.out.println("Loi: " + e.getMessage());
                System.out.println("Vui long nhap lai mot ma san pham khac!\n");
            }
        }
        return sp;
    }

    private void kiemTraMaTrung(String ma) throws MaTrungException {
        if (ma == null || ma.trim().isEmpty())
            return;

        for (int i = 0; i < n; i++) {
            SanPham sp = ds[i];
            if (sp != null && sp.getMaSanPham().equals(ma)) {
                throw new MaTrungException("Ma san pham '" + ma + "' da ton tai!");
            }
        }
    }

    public void them(SanPham sp) {
        try {
            kiemTraMaTrung(sp.getMaSanPham());
            ds = Arrays.copyOf(ds, n + 1);
            ds[n] = sp;
            n++;
            System.out.println("Da them san pham!");
        } catch (MaTrungException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }


    public void them() {
        SanPham sp = nhapSanPham();
        them(sp);
    }

    public void xuatDanhSach() {
        if (n == 0) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("======================================================================");
        System.out.printf("%-10s %-30s %-10s %-10s %-10s\n","MaSP", "TenSP", "MaLoai", "DonGia", "SoLuong");
        System.out.println("---------------------------------------------------------------------");
        for (SanPham sp : ds)
            if (sp != null)
                sp.xuat();
        System.out.println("======================================================================");
    }

    public SanPham timTheoMaSanPham(String ma) {
        for (SanPham sp : ds) {
            if (sp != null && sp.getMaSanPham().equals(ma))
                return sp;
        }
        return null;
    }

    public void timTheoMaSanPham() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham can tim: ");
        String ma = sc.nextLine();
        SanPham sp = timTheoMaSanPham(ma);
        if (sp == null) {
            System.out.println("Khong tim thay san pham!");
        } else {
            sp.xuat();
        }
    }

    public SanPham[] timTheoMaLoai(String maLoai) {
        SanPham[] kq = new SanPham[0];
        for (SanPham sp : ds) {
            if (sp != null && sp.getMaLoai().equals(maLoai)) {
                kq = Arrays.copyOf(kq, kq.length + 1);
                kq[kq.length - 1] = sp;
            }
        }
        return kq;
    }

    public void timTheoMaLoai() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma loai can tim: ");
        String maLoai = sc.nextLine();
        SanPham[] kq = timTheoMaLoai(maLoai);
        if (kq.length == 0)
            System.out.println("Khong tim thay san pham!");
        else
            for (SanPham sp : kq)
                sp.xuat();
    }

    public void sua() {
        if (n == 0) {
            System.out.println("Danh sach rong. Khong the sua.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham can sua: ");
        String ma = sc.nextLine();
        suaThongTinSanPham(ma, sc);
    }

    public void suaThongTinSanPham(String ma, Scanner sc) {
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getMaSanPham().equals(ma)) {
                System.out.println("1. Ten san pham 2. Don gia 3. So luong");
                System.out.print("Chon: ");
                int chon;
                try {
                    chon = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lua chon khong hop le!");
                    return;
                }
                switch (chon) {
                    case 1 -> {
                        System.out.print("Ten moi: ");
                        ds[i].setTenSanPham(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Don gia moi: ");
                        ds[i].setDonGia(Float.parseFloat(sc.nextLine()));
                    }
                    case 3 -> {
                        System.out.print("So luong moi: ");
                        ds[i].setSoLuong(Integer.parseInt(sc.nextLine()));
                    }
                    default -> System.out.println("Lua chon khong hop le!");
                }
                System.out.println("Da sua san pham " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay san pham!");
    }

    public void xoaSanPham(String ma) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getMaSanPham().equals(ma)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Khong tim thay ma san pham!");
            return;
        }
        for (int i = index; i < n - 1; i++)
            ds[i] = ds[i + 1];
        ds = Arrays.copyOf(ds, n - 1);
        n--;
        System.out.println("Da xoa san pham " + ma);
    }

    public void thongKeTongSoLuong() {
        int tong = 0;
        for (SanPham sp : ds)
            if (sp != null)
                tong += sp.getSoLuong();
        System.out.println("Tong so luong san pham: " + tong);
    }

    public void docTuFile(String File) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(File));
            String line;
          line = br.readLine();
            SanPham[] temp = new SanPham[0];

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;

                String[] arr = line.split(",");

                if (arr.length != 5) {
                    System.out.println("loi file"+ line);
                    continue;
                }
                String masanpham = arr[0].trim();
                String tensanpham = arr[1].trim();
                String maloai = arr[2].trim();
                float dongia = Float.parseFloat(arr[3].trim());
                int soluong = Integer.parseInt(arr[4].trim());
                SanPham sp = new SanPham(masanpham, tensanpham, maloai, dongia, soluong);
                temp = Arrays.copyOf(temp, temp.length + 1);
                temp[temp.length - 1] = sp;
            }
            br.close();
            ds = temp;
            n = ds.length;
            System.out.println("Doc File Thanh Cong");
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile(String File) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(File))) {
            for (SanPham sp : ds){
                if (sp != null)
                    pw.println(sp.getMaSanPham() + "," +
                            sp.getTenSanPham() + "," +
                            sp.getMaLoai() + "," +
                            sp.getDonGia() + "," +
                            sp.getSoLuong());
        }
         System.out.println("Ghi file thành công!");
     } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
}
