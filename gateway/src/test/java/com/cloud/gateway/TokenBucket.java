package com.cloud.gateway;

public class TokenBucket {

    /**
     * 时间
     */
    private long time = System.currentTimeMillis()-1000;
    /**
     * 总量
     */
    private Double total=10.0;
    /**
     * token 放入速度
     */
    private Double rate=1.0;
    /**
     * 当前总量
     */
    private Double nowSize=8.0;


    public boolean limit() {
        long now = System.currentTimeMillis();
        nowSize = Math.min(total, nowSize + (now - time) * rate);
        time = now;
        if (nowSize < 1) {
            // 桶里没有token
            return false;
        } else {
            // 存在token
            nowSize -= 1;
            return true;
        }
    }



}
