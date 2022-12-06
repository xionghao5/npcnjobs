package com.gua.npcnjobs.multithread.sync;

public class User {

    private Integer i;

    private Integer j;

    public synchronized Integer getAndAdd() {
        Integer oldValue = i;
        i++;
        return oldValue;
    }

    public Integer getI(){
        return i;
    }

    public synchronized Integer getJ(){
        return j;
    }

}
