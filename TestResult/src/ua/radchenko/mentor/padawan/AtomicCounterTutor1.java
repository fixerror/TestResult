package ua.radchenko.mentor.padawan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * Есть счетчик, подсчитывающий количество вызовов.
 * 
 * Почему счетчик показывает разные значения и не считает до конца? Как это
 * можно исправить не используя synchronized?
 * 
 * Попробуйте закомментировать обращение к yield(). Измениться ли значение?
 */
public class AtomicCounterTutor1 {
	AtomicInteger counter=new AtomicInteger();

	class TestThread implements Runnable {
		String threadName;

		public TestThread(String threadName) {
			this.threadName = threadName;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				counter.getAndIncrement();
			}
		}
	}

	@Test
	public void testThread() {
		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < 100; i++) {
			threads.add(new Thread(new TestThread("t" + i)));
		}
		System.out.println("Starting threads");
		for (int i = 0; i < 100; i++) {
			threads.get(i).start();

		}
		try {
			for (int i = 0; i < 100; i++) {
				threads.get(i).join();
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Counter=" + counter);

	}

}