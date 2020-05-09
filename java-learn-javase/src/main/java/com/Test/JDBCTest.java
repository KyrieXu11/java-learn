package com.Test;

import org.junit.Test;

import java.sql.*;

/**
 * @author KyrieXu
 * @date 2020/2/21 15:33
 **/
public class JDBCTest {
    @Test
    public void Test01() throws SQLException {
        Driver driver=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage?serverTimezone=UTC&useUnicode=true", "root", "qq18717128499");
//        PrepareStatement是在这里写sql语句的，然后Statement是在获取了statement之后写sql语句的
        PreparedStatement statement = connection.prepareStatement("select * from user");
        ResultSet resultSet = statement.executeQuery();
        resultSet.close();
        connection.close();
    }

    @Test
    public void Test02(){
        char s='\u0639';
        System.out.println(s);
        Object o='f';
        System.out.println(o);
    }


}
