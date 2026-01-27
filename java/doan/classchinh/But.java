package doan.classchinh;

import java.util.Scanner;

public class But extends SanPham {
    private String loaibut;
    private String mau;

    public But(){}

    public But(String maSanPham, String tenSanPham, String maLoai, float donGia, int soLuong, String loaibut, String mau){
        super(maSanPham, tenSanPham, maLoai, donGia, soLuong);
        this.mau = mau;
        this.loaibut = loaibut;
    }

    public But(But b){
        super(b);
        this.loaibut = b.loaibut;
        this.mau = b.mau;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao loai but: ");
        loaibut = sc.nextLine();
        System.out.print("nhap loai mau but: ");
        mau = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("loai but dung la: " + loaibut);
        System.out.println("loai mau can la: " + mau);
    }
    
    public String getMau() {
        return mau;
    }
    public void setMau(String mau) {
        this.mau = mau;
    }
    public String getLoaibut() {
        return loaibut;
    }
    public void setLoaibut(String loaibut) {
        this.loaibut = loaibut;
    }
}
