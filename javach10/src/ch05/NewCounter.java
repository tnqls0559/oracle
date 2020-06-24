package ch05;

public class NewCounter {
	int no;

	public NewCounter(int no) {
		this.no = no;
	}
	//
@Override
	protected void finalize() throws Throwable {
	   System.out.println(no+"삭제");
	}
}
