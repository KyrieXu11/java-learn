package com.DesignMode.ProxyMode.StaticProxyMode.Demo02;

/**
 * @author KyrieXu
 * @since 2020/3/11 13:51
 **/
public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;

    public UserServiceProxy() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public void updateUser() {
        System.out.println("更新调用前");
        userService.updateUser();
        System.out.println("更新调用后");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除调用前");
        userService.deleteUser();
        System.out.println("删除调用后");
    }

    @Override
    public void getUserId() {
        System.out.println("查询调用前");
        userService.getUserId();
        System.out.println("查询调用后");
    }
}
