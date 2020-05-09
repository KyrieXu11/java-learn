package com.DesignMode.BuilderMode.pattern02;

/**
 * @author KyrieXu
 * @since 2020/3/11 13:29
 **/
public class Demo {
    public static void main(String[] args) {
        User user = User.builder().setId("123").setName("234").build();
        // User{name='234', id='123'}
        System.out.println(user);
    }
}

class User{
    private String name;

    private String id;

    private User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // 给外界建造的入口
    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String name;

        private String id;

        private UserBuilder() {
        }

        // 链式编程要每个都返回this对象
        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setId(String id) {
            this.id = id;
            return this;
        }

        // 将建造好的属性放进user中
        public User build(){
            if (name==null||id==null)
                throw new RuntimeException("id，姓名不能为空");
            return new User(name,id);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
