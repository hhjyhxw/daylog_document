package org.example.proxy.jdkproxy;

/**
 * @author zdh
 */
public class UserImpl implements UserInterface{

    @Override
    public void doSomething() {
        System.err.println("doSomething...");
    }

    @Override
    public void saySomething() {
        System.err.println("saySomething...");
    }

    private void print() {
        System.err.println("print...");
    }
}
