package doan.text;

import doan.Exception.MaTrungException;
import doan.classchinh.SanPham;

public class thu {
    private void kiemTraMaTrung(String ma) throws MaTrungException {
        for (SanPham sp : ds) {
            if (sp != null && sp.getMaSanPham().equals(ma)) {
                throw new MaTrungException("Ma san pham '" + ma + "' da ton tai!");
            }
        }
    }
}
    HoaDon hd = new HoaDon(ma,ngay,  tong, manhanvien, makhachhang);
     ChiTietHoaDon cthd = new ChiTietHoaDon(machitiethoadon, mahoadon, masanpham, soluong); 