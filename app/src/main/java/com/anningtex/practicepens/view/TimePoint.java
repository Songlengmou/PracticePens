package com.anningtex.practicepens.view;

/**
 * @author Administrator
 */
public class TimePoint {
    public float x;
    public float y;
    public long timestamp;

    public TimePoint() {
    }

    public TimePoint(float x, float y) {
        this.x = x;
        this.y = y;
//        this.timestamp = System.currentTimeMillis();
    }

    public TimePoint(float x, float y, long time) {
        this.x = x;
        this.y = y;
        this.timestamp = time;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    /**
     * 获得两个点间的速度
     *
     * @param start
     * @return
     */
    public float velocityFrom(TimePoint start) {
        return distanceTo(start) / (this.timestamp - start.timestamp);
    }

    /**
     * 获得两个点间的距离
     *
     * @param point
     * @return
     */
    public float distanceTo(TimePoint point) {
        return (float) Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
    }
}
