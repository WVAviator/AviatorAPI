package com.wvaviator.aviatorapi.Timing;

public class RecurringTask extends Thread {
	
	private long time;
	private boolean canceled;
	
	public RecurringTask(long time) {
		this.time = time;
	}
	
	public void run() {
		while(!canceled) {
			
			try {
				this.sleep(time);
			} catch (InterruptedException e) {
				canceled = true;
				onInterrupt();
				break;
			}
			executeAfterDelay();
			
		}
	}

	protected void executeAfterDelay() {
		
	}
	
	protected void onInterrupt() {
		
	}

}
