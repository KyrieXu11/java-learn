package com.DesignMode.TemplateMode;

/**
 * @author KyrieXu
 * @since 2020/6/12 11:38
 **/
// 游戏，有他自己的声明周期
abstract class Game{
    // 负责整个声明周期的方法
    // 在调用的时候只需要调用此类的这个方法就可以调用子类实现的各个时期的方法
    public void game(){
        start();
        running();
        end();
    }

    // 游戏开始
    protected abstract void start();

    // 游戏进行中
    protected abstract void running();

    // 游戏结束
    protected abstract void end();
}

class CarGame extends Game{

    @Override
    public void start() {
        System.out.println("赛车游戏开始");
    }

    @Override
    public void running() {
        System.out.println("赛车游戏进行");
    }

    @Override
    public void end() {
        System.out.println("赛车游戏结束");
    }
}

class MarioGame extends Game{

    @Override
    public void start() {
        System.out.println("马里奥游戏开始");
    }

    @Override
    public void running() {
        System.out.println("马里奥游戏进行");
    }

    @Override
    public void end() {
        System.out.println("马里奥游戏结束");
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new MarioGame();
        game.game();
        game = new CarGame();
        game.game();
    }
}
