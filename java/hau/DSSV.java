import java.util.ArrayList;
public class DSSV {
    private ArrayList<SinhVien> dssv;
    public DSSV(){
        dssv=new ArrayList<>();
    }
    public void nhapN(int N){
        for (int i=0; i<N;i++){
            System.out.println("Nhap sinh vien thu "+(i+1)+": ");
            SinhVien sv= new SinhVien();
            sv.nhap();
            dssv.add(0,sv);
        }
    }
    public void xuat(){
        System.out.printf("%-10s %-15s %-10s %-12s %-5s\n","Ma", "Ho", "Ten", "Ngay sinh", "Gioi tinh");
        for(SinhVien sv:dssv){
            sv.xuat();
        }
    }
    public void them(){
        SinhVien sv =new SinhVien();
        sv.nhap();
        dssv.add(sv);
    }
    public void them(SinhVien sv){
        dssv.add(sv);
    }
    public void xoaSinhVien(String ma) {
        boolean found = false;
        for (int i =0; i< dssv.size(); i++) {
            if (dssv.get(i).getMa().equalsIgnoreCase(ma)) {
                dssv.remove(i);
                System.out.println("Da xoa sinh vien co ma: "+ma);
                found =true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien co ma: " +ma);
        }
    }
    public SinhVien timKiem(String ma){
        for (SinhVien sv: dssv){
            if (sv.getMa().equalsIgnoreCase(ma))
                return sv;
        }
        return null;
    }
    public void timTheoHo(String ho) {
        boolean found = false;
        for (SinhVien sv : dssv) {
            if (sv.getHo().equalsIgnoreCase(ho)) {
                sv.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien co ho: " +ho);
        }
    }
    public void tkGioiTinh(){
        int nam=0,nu=0;
        for (SinhVien sv:dssv){
            if (sv.getGioiTinh().equalsIgnoreCase("Nam")) nam++;
            else if (sv.getGioiTinh().equalsIgnoreCase("Nu")) nu++;
        }
        System.out.println("So sinh vien Nam: "+ nam);
        System.out.println("So sinh vien nu: "+nu);
    }
    public void tkTuoi(){
        int duoi18=0, tu18_24=0, tren24=0;
        for (SinhVien sv:dssv){
            try{
                String[] parts=sv.getNgaySinh().split("/");
                int namSinh = Integer.parseInt(parts[2]);
                int tuoi=2025-namSinh;
                if (tuoi <18) duoi18++;
                else if (tuoi <=24) tu18_24++;
                else tren24++;
            } catch(Exception e){
                System.out.println("Loi ngay sinh: "+sv.getMa());
            }
        }
        System.out.println("Duoi 18 tuoi: "+duoi18);
        System.out.println("Tu 18 den 24 tuoi: "+tu18_24);
        System.out.println("Tren 24 tuoi: "+tren24);
    }
}
