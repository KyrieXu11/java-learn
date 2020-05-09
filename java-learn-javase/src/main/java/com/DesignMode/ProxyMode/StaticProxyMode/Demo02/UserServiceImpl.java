package com.DesignMode.ProxyMode.StaticProxyMode.Demo02;

/**
 * @author KyrieXu
 * @since 2020/3/11 13:50
 **/
public class UserServiceImpl implements UserService {
    @Override
    public void updateUser() {
        System.out.println("更新");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除");
    }

    @Override
    public void getUserId() {
        System.out.println("获取id");
    }
}
