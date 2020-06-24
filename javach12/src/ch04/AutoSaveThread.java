package ch04;

import java.io.FileWriter;
import java.io.IOException;

public class AutoSaveThread extends Thread{
    public void save() {
    	System.out.println("작업 내용을 저장함");
    	try(FileWriter writer = new FileWriter("c:\\tmp\\save.txt",true);){
			writer.write("자동저장\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);//1초 간격으로 멈춤
			}catch(Exception e) {
				break;
			}
			save();
		}//while()끝.
	}
}
