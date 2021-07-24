package com.spiderfrog.gadgets.utils;

public class TimeHelper
{
    private long lastMS;
    
    public TimeHelper() {
        this.lastMS = 0L;
    }
    
    public boolean isDelayComplete(final long delay) {
        return System.currentTimeMillis() - this.lastMS >= delay;
    }
    
    public void setLastMS(final long lastMS) {
        this.lastMS = lastMS;
    }
    
    public void setLastMS() {
        this.lastMS = System.currentTimeMillis();
    }
    
    public int convertToMS(final int perSecond) {
        return 1000 / perSecond;
    }
    
    public void reset() {
        this.lastMS = this.getCurrentMS();
    }
    
    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    public long getLastMS() {
        return this.lastMS;
    }
}
