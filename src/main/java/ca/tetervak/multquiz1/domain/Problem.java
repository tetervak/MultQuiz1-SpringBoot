package ca.tetervak.multquiz1.domain;

import java.io.Serializable;

public class Problem implements Serializable {

    final private int a;
    final private int b;
    final private int answer;

    public Problem() {
        a = (int) (1 + 9 * Math.random());
        b = (int) (1 + 9 * Math.random());
        answer = a * b;
    }

    public Problem(int a, int b) {
        this.a = a;
        this.b = b;
        answer = a * b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getAnswer() {
        return answer;
    }

}

