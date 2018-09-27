package chall.enge.java;
import chall.enge.java.*;
import lang.java.*;

public class A implements IA {
    private Params params;
    private Expected expected;

    public A() {}
    public A(Params p, Expected e) {
	this.params = p;
	this.expected = e;
    }

    public Params getParams() {
	return this.params;
    }

    public Expected getExpected() {
	return this.expected;
    }

    public String toString() {
	return "A: \n\t" + getParams() + "\n\t" + getExpected();
    }
}
