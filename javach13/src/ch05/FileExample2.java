package ch05;

import java.io.File;
import java.io.IOException;

public class FileExample2 {

	public static void main(String[] args) throws IOException {
		File dir = new File(".");//현재 디렉토리,...상위 디렉토리
		System.out.println("Read:"+dir.canRead());//속성 읽기여부
		System.out.println("Write:"+dir.canWrite());//속성 쓰기여부
		System.out.println("절대경로:"+dir.getAbsolutePath());
		System.out.println("표준경로:"+dir.getCanonicalPath());
		System.out.println("최종수정:"+dir.lastModified());
		System.out.println("사이즈:"+dir.length());
		System.out.println("parent:"+dir.getParent());
		System.out.println("parent:"+dir.getParentFile());
		System.out.println("Path:"+dir.getPath());
		System.out.println("hidden:"+dir.isHidden());
	}
}
