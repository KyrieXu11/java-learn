package com.realques.真题01;

import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/9 19:03
 * <p>
 * <p>
 * 有一个很经典的问题是，当前时间是aa:bb,请问若干分钟后是什么时间？我们今天的问题是一个相反的问题。
 * <p>
 * 已知现在的时刻是星期x的yy:zz时刻，请问n分钟前是周几，时间是多少。
 * <p>
 * 例如现在是周三，02:10,则200分钟之前，应该是周二，22:50。
 * <p>
 * <p>
 * 输入包含三行
 * <p>
 * 第一行一个正整数x，表示今天是周x。(1<=x<=7)
 * <p>
 * 第二行是一个24小时制的时间表示，时和分均含前导0，例如，1时1分表示为01:01。保证时间格式是合法的。
 * <p>
 * 第三行是一个正整数n，表示要求的是n分钟之前的时间。(1<=n<=10^9)
 * <p>
 * 输出同样包含两行，第一行仅包含一个正整数，表示n分钟之前是周几。
 * <p>
 * 一个24小时制的时间表示，时和分均含前导0，例如，1时1分表示为01:01。表示n分钟之前的时刻。
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String time = scanner.next();
        String[] timeStr = time.split(":");
        long n = scanner.nextLong();
        int hourInt = Integer.parseInt(timeStr[0]);
        int minInt = Integer.parseInt(timeStr[1]);
        //LocalDateTime dateTime = LocalDateTime.of(2020, 4, 8, hourInt, minInt).minusMinutes(n);
        //System.out.println(dateTime.getDayOfWeek().getValue());
        //System.out.println(dateTime.getHour()+":"+dateTime.getMinute());
        Solution(x, n, hourInt, minInt);
    }

    public static void Solution(int x, long n, int hour, int min) {
        long minusHour = n / 60, minusMin = n % 60;
        //System.out.println(minusHour + " " + minusMin);

        if (minusMin > min) {
            min = (int) (60 + min - minusMin);
            minusMin = 0;
            hour--;
        }
        else {
            min -= minusMin;
            minusMin = 0;
        }
        if (minusHour % 24 > hour) {
            x -= minusHour / 24 + 1;
            if (x < 0)
                x = 7 + x;
            hour = (int) (hour + 24 * (minusHour / 24 + 1) - minusHour);
            minusHour = 0;
        }
        else {
            hour -= minusHour;
            minusHour = 0;
        }
        System.out.println(x);
        if (hour/10>0&&min/10==0)
            System.out.println(hour+":0"+min);
        if (hour/10==0&&min/10==0)
            System.out.println(0+""+hour+":0"+min);
        if (hour/10>0&&min/10>0)
            System.out.println(hour+":"+min);
        if (hour/10==0&&min/10>0)
            System.out.println("0"+hour+":"+min);
    }
}
