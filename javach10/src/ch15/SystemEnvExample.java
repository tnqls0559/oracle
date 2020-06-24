package ch15;

public class SystemEnvExample {

	public static void main(String[] args) {
		//환경변수 읽어오기 메소드 getenv(키);
		String javaHome = System.getenv("JAVA_HOME");
		System.out.println("JAVA_HOME="+javaHome);
	}
}
