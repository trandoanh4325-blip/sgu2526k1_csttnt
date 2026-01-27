package doan.classds;

import doan.classchinh.*;
import doan.chucnang.IChucNang;

import java.io.*;
import java.util.*;

public class DSSanPham implements IChucNang {
    private SanPham[] ds = new SanPham[0];
    private final Scanner sc = new Scanner(System.in);

    // Kiểm tra mã trùng (không phân biệt chữ hoa/thường)
    private boolean maTrung(String ma) {
        for (SanPham sp : ds) {
            if (sp.getMaSanPham().equals(ma)) return true;
        }
        return false;
    }

    // Nhập sản phẩm theo loại (0 quay lại menu)
    private SanPham nhapTheoLoai() {
    while (true) {
        System.out.println("Chon loai san pham:");
        System.out.println("1. But");
        System.out.println("2. Tap");
        System.out.println("0. Quay lai menu chinh");
        System.out.print("Lua chon: ");

        int chon;
        try { chon = Integer.parseInt(sc.nextLine()); }
        catch (Exception e){ chon = -1; }

        if (chon == 0) return null;

        SanPham sp = null;
        if (chon == 1) sp = new But();
        else if (chon == 2) sp = new Tap();
        else {
            System.out.println("Lua chon khong hop le! Vui long nhap lai.");
            continue;
        }

        // Nhập mã sản phẩm, kiểm tra trùng
        while (true) {
            System.out.print("Nhap ma san pham: ");
            String ma = sc.nextLine();
            if (maTrung(ma)) System.out.println("Ma san pham da ton tai! Vui long nhap lai.");
            else { sp.setMaSanPham(ma); break; }
        }

        // Nhập tên sản phẩm
        System.out.print("Nhap ten san pham: "); 
        sp.setTenSanPham(sc.nextLine());

        // Nhập mã loại (do người dùng tự nhập)
        while (true) {
            System.out.print("Nhap ma loai: ");
            String maLoai = sc.nextLine();
            if (maLoai.isEmpty()) {
                System.out.println("Ma loai khong duoc de trong! Nhap lai.");
                continue;
            }
            sp.setMaLoai(maLoai);
            break;
        }

        // Nhập đơn giá
        while (true) {
            try {
                System.out.print("Nhap don gia: "); 
                sp.setDonGia(Float.parseFloat(sc.nextLine()));
                break;
            } catch(Exception e){ System.out.println("Nhap sai! Nhap lai."); }
        }

        // Nhập số lượng
        while (true) {
            try {
                System.out.print("Nhap so luong: "); 
                sp.setSoLuong(Integer.parseInt(sc.nextLine()));
                break;
            } catch(Exception e){ System.out.println("Nhap sai! Nhap lai."); }
        }

        // Nhập thông tin riêng
        if (sp instanceof But) {
            System.out.print("Nhap loai but: "); ((But) sp).setloaibut(sc.nextLine());
            System.out.print("Nhap mau: "); ((But) sp).setmau(sc.nextLine());
        } else if (sp instanceof Tap) {
            System.out.print("Nhap so trang: "); ((Tap) sp).setsotrang(sc.nextLine());
            System.out.print("Nhap loai giay: "); ((Tap) sp).setloaigiay(sc.nextLine());
        }

        return sp;
    }
}


    // Thêm sản phẩm vào mảng
    private void themSanPhamVaoDS(SanPham sp) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = sp;
    }

    // Nhập danh sách nhiều sản phẩm
    @Override
    public void nhapDanhSach() {
        int n;
        while (true) {
            System.out.print("Nhap so luong san pham: ");
            try { n = Integer.parseInt(sc.nextLine()); break; }
            catch (Exception e) { System.out.println("Nhap sai! Nhap lai."); }
        }

        if (ds.length > 0) {
            System.out.println("Danh sach da co san pham. Chon:");
            System.out.println("1. Ghi de danh sach moi");
            System.out.println("2. Huy nhap danh sach moi");
            int choice;
            try { choice = Integer.parseInt(sc.nextLine()); } catch(Exception e){ choice=2; }

            if (choice != 1) { System.out.println("Huy nhap danh sach moi."); return; }
            else ds = new SanPham[0];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("--- Nhap san pham thu " + (i+1) + " ---");
            while (true) {
                SanPham sp = nhapTheoLoai();
                if (sp == null) {
                    System.out.println("Quay lai menu chinh...");
                    return;
                }
                if (maTrung(sp.getMaSanPham())) {
                    System.out.println("Ma san pham da ton tai! Nhap lai.");
                    continue;
                }
                themSanPhamVaoDS(sp);
                break;
            }
        }
    }

    @Override
    public void xuatDanhSach() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.printf("%-10s %-15s %-10s %-10s %-10s\n","MaSP","TenSP","MaLoai","DonGia","SoLuong");
        for (SanPham sp : ds) sp.xuat();
    }

    @Override
    public void them() {
        System.out.println("--- Them san pham moi ---");
        while (true) {
            SanPham sp = nhapTheoLoai();
            if (sp == null) {
                System.out.println("Quay lai menu chinh...");
                return;
            }
            if (maTrung(sp.getMaSanPham())) {
                System.out.println("Ma san pham da ton tai! Nhap lai.");
                continue;
            }
            themSanPhamVaoDS(sp);
            System.out.println("Da them san pham moi.");
            break;
        }
    }

    @Override
    public void xoa() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.print("Nhap ma san pham can xoa: ");
        String ma = sc.nextLine();
        int index = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSanPham().equals(ma)) { index=i; break; }
        }
        if (index==-1) { System.out.println("Khong tim thay ma san pham."); return; }
        for (int i = index; i < ds.length-1; i++) ds[i] = ds[i+1];
        ds = Arrays.copyOf(ds, ds.length-1);
        System.out.println("Da xoa san pham co ma: " + ma);
    }

    @Override
    public void sua() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.print("Nhap ma san pham can sua: ");
        String ma = sc.nextLine();
        for (SanPham sp : ds) {
            if (sp.getMaSanPham().equals(ma)) {
                int choice;
                do {
                    System.out.println("\n--- Chon thong tin can sua ---");
                    System.out.println("1. TenSP");
                    System.out.println("2. MaLoai");
                    System.out.println("3. DonGia");
                    System.out.println("4. SoLuong");
                    System.out.println("0. Thoat");
                    System.out.print("Lua chon: ");
                    try { choice = Integer.parseInt(sc.nextLine()); } catch(Exception e){ choice=-1; }
                    switch(choice) {
                        case 1 -> { System.out.print("Nhap ten moi: "); sp.setTenSanPham(sc.nextLine()); }
                        case 2 -> { System.out.print("Nhap ma loai moi: "); sp.setMaLoai(sc.nextLine()); }
                        case 3 -> { 
                            while (true) {
                                System.out.print("Nhap don gia moi: ");
                                try { sp.setDonGia(Float.parseFloat(sc.nextLine())); break; }
                                catch(Exception e){ System.out.println("Nhap sai! Nhap lai."); }
                            }
                        }
                        case 4 -> {
                            while (true) {
                                System.out.print("Nhap so luong moi: ");
                                try { sp.setSoLuong(Integer.parseInt(sc.nextLine())); break; }
                                catch(Exception e){ System.out.println("Nhap sai! Nhap lai."); }
                            }
                        }
                        case 0 -> System.out.println("Thoat sua");
                        default -> System.out.println("Lua chon khong hop le!");
                    }
                } while(choice != 0);
                System.out.println("Da sua san pham " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay san pham de sua.");
    }

    @Override
    public void tim() {
        if (ds.length == 0) { System.out.println("Danh sach rong."); return; }
        System.out.println("Chon phuong thuc tim kiem:");
        System.out.println("1. Tim theo ma san pham");
        System.out.println("2. Tim theo ma loai");
        System.out.print("Lua chon: ");
        int choice;
        try { choice = Integer.parseInt(sc.nextLine()); } catch(Exception e){ choice=-1; }

        switch(choice) {
            case 1 -> {
                System.out.print("Nhap ma san pham: ");
                String ma = sc.nextLine();
                for (SanPham sp : ds) {
                    if (sp.getMaSanPham().equals(ma)) {
                        System.out.println("Tim thay: " + sp.getTenSanPham());
                        return;
                    }
                }
                System.out.println("Khong tim thay san pham.");
            }
            case 2 -> {
                System.out.print("Nhap ma loai: ");
                String maLoai = sc.nextLine();
                SanPham[] kq = Arrays.stream(ds).filter(sp -> sp.getMaLoai().equals(maLoai)).toArray(SanPham[]::new);
                if (kq.length == 0) System.out.println("Khong tim thay san pham nao.");
                else {
                    System.out.println("\nDanh sach san pham tim theo ma loai " + maLoai);
                    System.out.printf("%-10s %-15s %-10s %-10s %-10s\n","MaSP","TenSP","MaLoai","DonGia","SoLuong");
                    for (SanPham sp : kq) sp.xuat();
                }
            }
            default -> System.out.println("Lua chon khong hop le!");
        }
    }

    // Ghi file
    @Override
    public void ghiFile(String file) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (SanPham sp : ds) {
                String line = sp.getMaSanPham()+";"+sp.getTenSanPham()+";"+sp.getMaLoai()+";"+sp.getDonGia()+";"+sp.getSoLuong();
                if (sp instanceof But) line += ";" + ((But) sp).getloaibut() + ";" + ((But) sp).getmau();
                if (sp instanceof Tap) line += ";" + ((Tap) sp).getsotrang() + ";" + ((Tap) sp).getloaigiay();
                bw.write(line); bw.newLine();
            }
            System.out.println("Ghi file thanh cong: " + file);
        } catch(Exception e){ System.out.println("Loi ghi file: " + e.getMessage()); }
    }

    // Doc file tu menu
    public void docFileTuMenu() {
        System.out.print("Nhap ten file can doc: ");
        String file = sc.nextLine();

        System.out.println("Ban muon:");
        System.out.println("1. Ghi de danh sach hien tai");
        System.out.println("2. Chen vao danh sach hien tai");
        System.out.print("Lua chon: ");
        int choice;
        try { choice = Integer.parseInt(sc.nextLine()); } catch(Exception e){ choice = 2; }
        boolean ghiDe = choice == 1;

        docFile(file, ghiDe);
    }

    @Override
public void docFile(String file) {
    System.out.println("Chon thao tac khi doc file:");
    System.out.println("1. Ghi de danh sach hien tai");
    System.out.println("2. Chen them vao danh sach hien tai");
    System.out.print("Lua chon: ");
    
    int choice;
    try { choice = Integer.parseInt(sc.nextLine()); } 
    catch(Exception e) { choice = 1; } // mặc định ghi đè

    if(choice == 1) {
        docFile(file, true);   // ghi đè
    } else {
        docFile(file, false);  // chèn thêm
    }
}
    public void docFile(String file, boolean ghiDe) {
    File f = new File(file);
    if (!f.exists()) {
        System.out.println("File khong ton tai: " + file);
        return;
    }

    if (ghiDe) ds = new SanPham[0]; // reset danh sach khi ghi de

    try (Scanner fileScanner = new Scanner(f)) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] t = line.split(";");
            if (t.length < 5) continue;

            SanPham sp = null;
            if (t[2].equalsIgnoreCase("But")) sp = new But();
            else if (t[2].equalsIgnoreCase("Tap")) sp = new Tap();
            else continue;

            sp.setMaSanPham(t[0]);
            sp.setTenSanPham(t[1]);
            sp.setMaLoai(t[2]);
            sp.setDonGia(Float.parseFloat(t[3]));
            sp.setSoLuong(Integer.parseInt(t[4]));

            if (sp instanceof But && t.length >= 7) {
                ((But) sp).setloaibut(t[5]);
                ((But) sp).setmau(t[6]);
            } else if (sp instanceof Tap && t.length >= 7) {
                ((Tap) sp).setsotrang(t[5]);
                ((Tap) sp).setloaigiay(t[6]);
            }

            themSanPhamVaoDS(sp);
        }
        System.out.println("Doc file thanh cong: " + file + (ghiDe ? " (ghi de)" : " (chen vao)"));
    } catch (Exception e) {
        System.out.println("Loi doc file: " + e.getMessage());
    }
}

    public void thongKeTongSoLuong() {
        int tong = 0;
        for (SanPham sp : ds) tong += sp.getSoLuong();
        System.out.println("Tong so luong tat ca san pham: " + tong);
    }
}
