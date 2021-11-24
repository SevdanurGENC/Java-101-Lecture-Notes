package dosyalamaIslemleri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class dosyalamaislemleri { 
	
	public static void DosyaOlustur(String URL){
		File dosya = new File(URL);
		try {
			if(!dosya.exists()){  //dosya yoksa
				dosya.createNewFile();   //dosyayý olustur
				System.out.println("Dosya olusturuldu");
			}else {
				System.out.println("Dosya var oldugundan olusturma islemi yapilmayacaktir.");				
			} 
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
	
	public static void dosyaYazma(String URL){
		File dosya = new File(URL);
		try {
			FileOutputStream yaz = new FileOutputStream(dosya);
			String icerik = "Taskopru MYO. \nBilgisayar Programciligi";
			yaz.write(icerik.getBytes());
			yaz.flush();
			yaz.close();			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("Yazma islemi tamamlandi");
		}
		
		
	}
	
	
	public static void dosyaOkuma(String URL){
		File dosya = new File(URL);
		try {
			FileInputStream oku = new FileInputStream(dosya);
			int dosyaBoyutu = (int) dosya.length();
			System.out.println("\nDosyanýn boyutu : " + dosyaBoyutu);
			for (int i = 0; i < dosyaBoyutu; i++) {
				System.out.print((char) oku.read());
			}
			oku.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("\nOkuma islemi tamamlandi");
		}
		
		
	}
	
	
	
	public static void dosyayaVeriEkleme(String URL){
		BufferedWriter yazdir = null;
		File dosya = new File(URL);
		try {
			FileWriter dosyayaYaz = new FileWriter(dosya,true);
			yazdir = new BufferedWriter(dosyayaYaz);
			String icerik = "\nProgramlama Temelleri";
			yazdir.write(icerik);
			yazdir.flush();
			yazdir.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("Veri ekleme islemi tamamlanmistir.");
		} 
	}
	
	
	
	public static void dosyaSil(String URL){
		File dosya = new File(URL);
		if(!dosya.exists()){
			System.out.println("Dosya bulunamadigindan silinemedi.");
		}else{
			dosya.delete();
			System.out.println( dosya.getName() + " isimli Dosya silinmistir");
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DosyaOlustur("deneme.txt");
		dosyaYazma("deneme.txt");
		dosyaOkuma("deneme.txt");
		
		dosyayaVeriEkleme("deneme.txt");
		dosyaOkuma("deneme.txt");
		
		// dosyaSil("deneme.txt");
	}

}
