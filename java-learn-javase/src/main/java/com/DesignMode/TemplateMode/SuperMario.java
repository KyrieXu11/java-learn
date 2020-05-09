package com.DesignMode.TemplateMode;

import java.lang.reflect.Method;

/**
 * @author KyrieXu
 * @since 2020/2/27 14:40
 **/
public class SuperMario implements Game {
    @Override
    public void play() {
        System.out.println("玩马里奥游戏");
    }

    @Override
    public void start() {
        System.out.println("开始马里奥游戏");
    }

    @Override
    public void dead() {
        System.out.println("马里奥游戏人物死亡");
    }

    @Override
    public void end() {
        System.out.println("马里奥游戏结束");
    }
}
