package chuong2;
import java.util.Scanner;

import doan.classchinh.SanPham;

class QLYSANPHAM{
    private SanPham[] ds;
    private int n;
public QLYSANPHAM(){
    ds= new SANPHAM[0];
    n=0;
}
public qlysanpham(Sanpham[]ds ){
    this.ds= ArrayscopyOf(ds, ds.length);
    this n = ds.length;
}
public void nhap(){
   scanner sc
   System.out.print();
   n = sc.nextLine();
   ds = new sanpham[n];
   for(int i=0 ; i<n; i++){
    System.out.println(",..."+(n+1)+":");
    ds[i]= new sanpham();
    ds[i].nhap();
   }
}
public void xuat(){
    if( n==0){
        system.out.println(rong);
        return;
    }
    System.out.println();
    for(sanpham sp : ds){
        if(sp !=null){
        sp.xuat();
        }
    }
}
public void them(sanpham sp){
    ds = arraycopyof(ds, n+1);
    ds[n]= sanpham;
    n++;
}
public void them(){
    sanpham sp = nhapsanpham();
    themsanpham();
}
public void timsanpham(){
    scanner sc 
    system.out.print(nhap);
    ma = sc.nextLine();
    sanpham sp = timmasanpham(ma);
    if(sp == null){
        system.out.println("ko thay");
    }
    else{
        sp.xuat();
    }
}

public void timmasanpham(String ma){
    for( san pham sp:ds){
        if(sp != null && sp.getmasanpham().equals(ma)){
            return sp;
        }
    }
}

public void xoa(String ma){
    int index=1;
    for(int i=0; i<n;i++){
        if(ds[i]!=null && ds[i].getmasanpham().equals(ma)){
            index=i;
            break;
        }
    }
    if(index ==-1){
        system.out.println("ko thay");
        return;
    }
    for (int i= index; i<n-1; i++){
        ds[i]= ds[i+1];
        ds= ArrayscopyOf(ds, n-1);
        n--;
        System.out.println("da xoa");
    }
}

 public void xoa(){
    if(n==0){
        System.out.print("rong");
    }
    sc
    System.out.print("nhap ma can xoa:");
    ma = sc.nextLine();
    xoa(ma);
}