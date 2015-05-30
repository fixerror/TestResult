package ua.radchenko.mentor.padawan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * Есть счетчик, подсчитывающий количество вызовов.
 * 
 * Почему счетчик показывает разные значения и не считает до конца? Как это
 * можно исправить не используя synchronized?
 * 
 * Попробуйте закомментировать обращение к yield(). Измениться ли значение?
 */
public class AtomicCounterTutor {
	private Lock lock = new ReentrantLock();
	int counter = 0;

	class TestThread implements Runnable {
		String threadName;

		public TestThread(String threadName) {
			this.threadName = threadName;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				/*
				 * lock() получает блокировку экземпляра. Если экземпляр
				 * блокирован другим потоком, то поток отключается и
				 * бездействует до освобождения экземпляра;
				 */
				lock.lock();
				counter++;
				// Thread.yield();

				/*
				 * unlock() освобождает блокировку экземпляра. Если текущий
				 * поток не является обладателем блокировки, генерируется
				 * исключение IllegalMonitorStateException.
				 */
				lock.unlock();

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