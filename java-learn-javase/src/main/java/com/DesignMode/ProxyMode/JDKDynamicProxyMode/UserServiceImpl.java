package com.DesignMode.ProxyMode.JDKDynamicProxyMode;

/**
 * @author KyrieXu
 * @date 2020/2/8 15:22
 * 要加日志的类
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        info("添加");
    }

    @Override
    public void delete() {
        info("删除");
    }

    @Override
    public void update() {
        info("更新");
    }

    @Override
    public void query() {
        info("查询");
    }

    private void info(String msg){
        System.out.println(msg+"了一条信息");
    }
}
