package com.DesignMode.TemplateMode;

/**
 * @author KyrieXu
 * @since 2020/2/27 14:50
 *
 * 意图：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 *
 *
 **/
public class MainGame {
    public static void main(String[] args) {
        Game game=new CarGame();
        game.play();
        game.end();
        game=new SuperMario();
        game.play();
        game.end();
    }
}
