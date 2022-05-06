package algorithms.other;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yangyuan on 2021/3/21.
 * 731. 我的日程安排表 II
 *
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。

 MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。

 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。

 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。

 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

 */
public class MyCalendarTwo {
    Map<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap();
    }
    //差分
    //当我们预定一个新的日程安排 [start, end)，则执行 delta[start]++ 和 delta[end]--。
    //其中 delta 是按照 key 值从小到大排序的结构，我们用 active 来记录当前正在进行的日程安排数，当 active>=3 时，说明产生了三重预定。
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int sum = 0;
        for (Map.Entry<Integer, Integer> en:map.entrySet()){
            sum += en.getValue();
            if (sum >= 3){
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(1,10);
        System.out.println(myCalendarTwo.book(2,11));
        System.out.println(myCalendarTwo.book(3, 12));
    }
}
