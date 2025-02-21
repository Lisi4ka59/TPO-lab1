package com.lisi4ka.part3;

public class Door {
    private boolean isOpen;

    public Door() {
        this.isOpen = false;
    }

    public void open() {
        this.isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
