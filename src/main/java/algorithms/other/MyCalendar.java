package algorithms.other;

import java.util.TreeSet;

/**
 * Created by yangyuan on 2021/3/21.
 * 729. 我的日程安排表 I
 *
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。

 MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
 注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。

 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。

 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，
 返回 false 并且不要将该日程安排添加到日历中。

 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)

 */
public class MyCalendar {

    TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] - b[0]);

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        int[] floor = set.floor(new int[]{start});
        int[] ceil = set.ceiling(new int[]{start});
        if (floor == null || ceil == null || (floor[1] <= start && ceil[1] >= end)) {
            set.add(new int[]{start, end});
            return true;
        }
        return false;
    }



}
