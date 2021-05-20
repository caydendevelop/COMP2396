public class ThreadOrder {
	static int count = 0;
	public static void main(String[] arg) {
		Counter ct = new Counter();
		Tracker trk1 = new Tracker(ct, "thread one");
		Tracker trk2 = new Tracker(ct, "thread two");
		trk1.start();
		System.out.println(count);
		trk2.start();
		System.out.println(ct.nextCounter());
	}
}

class Tracker extends Thread {
	Counter ct;
	String message;
	Tracker(Counter ct, String msg) {
		this.ct = ct;
		message = msg;
	}
	public void run() {
		System.out.println(message);
	}
}

class Counter {
	private int count = 0;
	public int nextCounter() {
		synchronized(this) {
			count ++;
			return count;
		}
	}
}

/*
It is unpredictable in which order the threads will be executed.

Possible outputs:
0
1
thread one
thread two

0
thread one
thread two
1

0
thread one
1
thread two

thread one
thread two
0
1

...
*/