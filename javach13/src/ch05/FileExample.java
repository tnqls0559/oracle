package ch05;

import java.io.File;

public class FileExample {
  public static void ListDirectory(File file) {
	  System.out.println("------------------"+file.getPath()+"의 서브 리스트입니다.------------------");
	  File[] subFiles = file.listFiles();//디렉토리내의 서브 디렉토리/파일 리스트
	  for(int i=0;i<subFiles.length;i++) {
		  File f = subFiles[i];
		  long t = f.lastModified();//생성 혹은 수정된 날짜
		  System.out.print(f.getName());//파일명
		  System.out.print("\t파일크기:"+f.length());
		  System.out.printf("\t수정한 시간:%tb %td %ta %tT\n",t,t,t,t);
	  }
  }
	public static void main(String[] args) {
		File f1 = new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath()+","+f1.getParent()+","+f1.getName());
		String res = "";
		if(f1.isFile()) res="파일";
		else if(f1.isDirectory()) res="디렉토리";
		System.out.println(f1.getName()+"은"+res+"입니다.");
		
		File f2 = new File("c:\\tmp\\java_sample");
		if(!f2.exists()) {//파일 존재여부 확인
			f2.mkdir();//존재하지 않으면 디렉토리 생성
		}
		ListDirectory(new File("c:\\tmp"));
		f2.renameTo(new File("c:\\tmp\\javasample"));//디렉토리명 변경
		ListDirectory(new File("c:\\tmp"));
	}
}
