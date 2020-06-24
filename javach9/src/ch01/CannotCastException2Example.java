package ch01;

public class CannotCastException2Example {
	public static void main(String[] args) {
		RemoteController remoteController = new Television();
		Audio audio = (Audio)remoteController;
	}
}
