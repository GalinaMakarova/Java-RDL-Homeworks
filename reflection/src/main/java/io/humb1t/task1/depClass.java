package io.humb1t.task1;

@Deprecated
public class depClass {
    private int num;

    public depClass() {
        this.num = 0;
    }

    public depClass(int num) {
        this.num = num + 1;
    }

    private int getNextNum(int num) {
        return num * 5 + 1;
    }
}
