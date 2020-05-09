package com.kyriexu.FunctionApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author KyrieXu
 * @date 2020/2/21 13:55
 **/
public class TestFunctionInterFace {

    @Test
    public void Test01() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User(UUID.randomUUID().toString().substring(0, 10), UUID.randomUUID().toString().substring(0, 5), (new Random().nextInt(90) + 2));
            list.add(user);
        }
        list.stream().filter((u1) -> u1.getName().charAt(0) != 'A')
                .filter((u1) -> u1.getAge() < 23)
                .forEach(System.out::println);
    }

}

@Data
@AllArgsConstructor
@ToString
class User {
    private String id;
    private String name;
    private int age;
}
