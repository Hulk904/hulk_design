package algorithms.top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2019/12/29.
 */
public class MeetingRoom {
    public static void main(String[] args) {
        int[][] times = new int[][]{{0,30},{15,20},{5,10}};
        System.out.println(minMeetingRooms(times));

    }

    private static int minMeetingRooms(int[][] intervals){
        //先按开始时间排序
        Arrays.sort(intervals, Comparator.comparing(t -> t[0]));
        PriorityQueue<Integer> roomWithEndTime = new PriorityQueue<>();
        for (int[] meeting : intervals){
            if (roomWithEndTime.isEmpty()){
                roomWithEndTime.add(meeting[1]);
                continue;
            }
            if (roomWithEndTime.peek() > meeting[0]){
                roomWithEndTime.add(meeting[1]);
            } else {
                roomWithEndTime.poll();
                roomWithEndTime.add(meeting[1]);
            }
        }
        return roomWithEndTime.size();
    }


}
