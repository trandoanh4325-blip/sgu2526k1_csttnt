package thu;
import java.util.Scanner;

 public class hai {
     private String maso;
     private String hoten;
     private String lop;
     private float diem1, diem2, diem3;
  //ham không có tham số
   public  hai(){
    maso = "";
    hoten = "";
    lop = "";
    diem1 =diem2= diem3=0;
     }
  // hàm có tham số
    public hai(String maso, String hoten, String lop, float diem1, float diem2, float diem3){
      this.maso = maso;
      this.hoten = hoten;
       this.lop = lop;
       this.diem1 = diem1;
        this.diem2 = diem2;
         this.diem3 = diem3;
     }
  //void nhập
  public void nhap(){
     Scanner sc=new Scanner(System.in);
     System.out.print("nhap ma so sv");
     maso=sc.nextLine();
     System.out.print("nhap ho va ten");
     hoten=sc.nextLine();
     System.out.print("nhap ten lop");
     lop=sc.nextLine();
     System.out.print("diem mon 1");
     diem1 =sc.nextFloat();
     System.out.print("diem mon 2");
     diem2 =sc.nextFloat();
    System.out.print("diem mon 3");
     diem3=sc.nextFloat();
  }
  //void xuất
  public void xuat(){
    System.out.print("ma so: "+maso);
    System.out.print("ho va ten: "+ hoten);
    System.out.print("lop"+lop);
    System.out.print("diem 1: "+diem1);
    System.out.print("diem 2: "+diem2);
    System.out.print("diem 3: "+diem3);
  }
  public float diemtrungbinh(){
    return (diem1+diem2+diem3)/3f;
  }
  public String xeploai() {
    Float dtb=diemtrungbinh();
    if(dtb>=8.0 && dtb<9.0){
      return "hoc sinh gioi";
    }
    if(dtb>=6.5 && dtb<8.0){
      return "hoc sinh kha";
    }
    if(dtb<6.5 && dtb>=3.0){
      return "hoc sinh trung binh";
    }
    if(dtb<3 && dtb >= 0){
      return "hoc sinh yeu";
    }
    return "hoc sinh xuat sac";
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    //hàm có tham số
    hai hs1 = new hai(" 1, "," tran dinh bao quoc, "," 12a1, ",8.3f,8.6f,7.9f);
    hs1.xuat();
    System.out.println("diem trung binh: "+hs1.diemtrungbinh());
    System.out.println("xep loai hoc luc: "+hs1.xeploai());
    //hàm có ko tham só
    hai hs2 = new hai();
    hs2.nhap();
    hs2.xuat();
    System.out.println("diem trung binh:"+hs2.diemtrungbinh());
    System.out.println("xep loai hoc luc:"+hs2.xeploai());
    sc.close();
  }
}