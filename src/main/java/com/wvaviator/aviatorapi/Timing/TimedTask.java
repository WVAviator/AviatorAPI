package com.wvaviator.aviatorapi.Timing;

public class TimedTask extends Thread {
	
	private long time;
	
	public TimedTask(long time) {
		this.time = time;
		this.start();
	}

	public void run() {	
		try {
			this.sleep(time);
		} catch (InterruptedException e) {
			onInterrupt();
		}		
		executeAfterTime();	
	}

	protected void executeAfterTime() {
		
	}
	
	protected void onInterrupt() {
		
	}
	
}
