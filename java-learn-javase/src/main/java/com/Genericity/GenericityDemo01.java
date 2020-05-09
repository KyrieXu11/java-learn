package com.Genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KyrieXu
 * @date 2020/1/29 17:18
 **/
public class GenericityDemo01 {

    @Test
    public void GenericityTest(){

        Object obj=null;
        String str=null;
//        子类对象可以赋值给父类对象
        obj=str;

//        同理，子类对象数组也可以赋值给父类对象数组
        Object[] objects=null;
        String[] strings=null;
        objects=strings;

//       但是泛型就不能这样了
        List<Object> objectList=null;
        List<String> stringList=null;

//        objectList=stringList;
//        不过可以使用通配符，即下面这个形式,编译都通过
        List<?> l=null;
        l=objectList;
        l=stringList;

        List<?> list=new ArrayList<>();
//        下面的这个语句报错，不能识别类型；无法向list里面添加任何数据，不过可以添加空值(null)
//        list.add("abc");
    }


}

class Order<T>{
    private String id;

//    这里和类名后面跟着的通配符一致
//    如果一个类有多个泛型，则书写成<E1,E2,E3...>类似的形式
    private T orderT;

//  构造方法是没有泛型的
    public Order() {
    }

    public Order(String id, T orderT) {
        this.id = id;
        this.orderT = orderT;
    }

//    下面的编译报错，因为静态是比创建实例快的，不确定泛型的类型
//    public static void testG(T a){
//
//    }

//    下面的方法是不报错的，因为这个是在调用这个静态方法的时候就知道泛型的类型了
    public static <T> T TestT(T a){
        return a;
    }

}

//  指明泛型类型
class SubOrder extends Order<Integer>{

}

//  不指明泛型类型
class SubOrder1<T> extends Order<T>{

}

//  接口也可以使用泛型
interface OrderGenericity<T>{
    T getInf();

    List<T> getAllInfo();

}