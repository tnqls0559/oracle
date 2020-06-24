package ch06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopyEx2 {

	public static void main(String[] args) {
		//문자,이미지,동영상,사운드,...
		File src = new File("c:\\tmp\\srcImg.png");
		File dest = new File("c:\\tmp\\copyImg2.png");
		int c;
		try(FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest)){
			byte[] buf = new byte[1024*10];//10kb
			long start = System.currentTimeMillis();
			while(true) {
				int n=fi.read(buf);//buf에 저장된 길이가 리턴됨.1024*3
				fo.write(buf,0,n);//write(배열,0,길이만큼);
				if(n<buf.length)break;
			}
			System.out.println(src.getPath()+"를"+dest.getPath()+"로 복사완료");
			long end = System.currentTimeMillis();
			System.out.println("작업시간:"+(end-start));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
