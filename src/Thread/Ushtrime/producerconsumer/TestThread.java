package Thread.Ushtrime.producerconsumer;

public class TestThread {
	public static void main(String [] args) {
		Box box = new Box();
		WriteThread wt = new WriteThread(box);
		ReadThread rt = new ReadThread(box);
		rt.start();
		wt.start();		
	}
}