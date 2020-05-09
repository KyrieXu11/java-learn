package com.DesignMode.TemplateMode;

/**
 * @author KyrieXu
 * @since 2020/2/27 14:49
 **/
public class CarGame implements Game {
    @Override
    public void play() {
        System.out.println("车玩");
    }

    @Override
    public void start() {
        System.out.println("车开");
    }

    @Override
    public void dead() {
        System.out.println("车撞");
    }

    @Override
    public void end() {
        System.out.println("车完");
    }
}
