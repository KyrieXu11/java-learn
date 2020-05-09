package com.DesignMode.DecorationMode;

/**
 * @author KyrieXu
 * @date 2020/2/16 16:55
 * 应用场景：扩展一个类，并且对这个类添加附加功能的时候
 * 其优点式：
 * 1. 不改变原有对象的情况下给一个对象扩展功能
 * 2. 使用不同的对象组合实现不同的效果
 * 3. 符合开闭原则
 **/
public class DecorationTest {
    public static void main(String[] args) {
        Component component=new ConcretComponent();
        Decrator decrator=new ConcretDecoration1(new ConcretDecration(component));
        decrator.Operation();
    }
}

interface Component{
    void Operation();
}

class ConcretComponent implements Component {
    @Override
    public void Operation() {
        System.out.println("拍照");
    }
}

abstract class Decrator implements Component {
    protected Component component;

    public Decrator(Component component) {
        this.component = component;
    }
}

class ConcretDecration extends Decrator{

    public ConcretDecration(Component component) {
        super(component);
    }

    @Override
    public void Operation() {
        System.out.println("美颜");
        component.Operation();
    }
}

class ConcretDecoration1 extends Decrator{

    public ConcretDecoration1(Component component) {
        super(component);
    }

    @Override
    public void Operation() {
        System.out.println("加特技");
        component.Operation();
    }
}
