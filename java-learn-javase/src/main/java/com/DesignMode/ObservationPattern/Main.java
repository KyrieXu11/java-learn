package com.DesignMode.ObservationPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KyrieXu
 * @since 2020/6/12 11:16
 *
 * 首先要有一个观察者(fans)和一个订阅者(up主)
 * 当订阅者更新信息的时候，订阅者要通知所有订阅自己的观察者，我已经更新了
 **/
class Subject {
    private List<Observer> list = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    // 更新状态
    public void setState(int state) {
        this.state = state;
        // 通知观察者
        notifyAllObserver();
    }

    // 通知所有订阅自己的观察者
    private void notifyAllObserver() {
        for (Observer observer : list) {
            // 遍历通知我已经更新了
            observer.update();
        }
    }

    // 订阅方法
    protected void attach(Observer observer) {
        this.list.add(observer);
    }
}

abstract class Observer {
    // 每一个观察者要订阅一个订阅者
    protected Subject subject;

    protected abstract void update();
}

class BinObserver extends Observer {

    public BinObserver(Subject subject) {
        // 由于初始是null，所以要赋初值
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    protected void update() {
        int state = subject.getState();
        System.out.println("2进制观察者："+state);
        System.out.println("2进制:" + Integer.toBinaryString(state));
    }
}

class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        // 由于初始是null，所以要赋初值
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    protected void update() {
        int state = subject.getState();
        System.out.println("16进制观察者："+state);
        System.out.println("16进制："+Integer.toHexString(state));
    }
}


public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        // 这个粉丝要订阅up主
        new BinObserver(subject);
        // 这个粉丝也要订阅up主
        new HexObserver(subject);
        subject.setState(123);
    }
}
