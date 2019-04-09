package hard;

import java.util.*;

public class Solution218 {

    public static void main(String[] args) {
        Solution218 s = new Solution218();
        int[][][] cases = new int[][][]{
                {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}},
                {{0, 1, 3}}
        };
        for (int[][] c : cases) {
            for (int[] i : s.getSkyline(c)) System.out.println(Arrays.toString(i));
            System.out.println();
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        LinkedList<int[]> result = new LinkedList<>();
        int[] last = new int[]{0, 0};
        TreeMap<Integer, Integer> end = new TreeMap<>();
        Map.Entry<Integer, Integer> entry;
        for (int[] building : buildings) {
            while ((entry = end.firstEntry()) != null && entry.getKey() < building[0]) {
                // 遍历建筑左边的结束点
                last[1] = entry.getValue();
                result.add(last);
                last = new int[]{entry.getKey(), 0};
                end.remove(entry.getKey());
            }
            if (building[0] == last[0]) {
                // 如果位置重叠，刷新高度
                if (building[2] > last[1])
                    last[1] = building[2];
            } else {
                // 位置向右，计入拐点，新建拐点
                last[1] = entry == null ? 0 : entry.getValue();
                if (building[2] > last[1]) {
                    result.add(last);
                    last = new int[]{building[0], building[2]};
                }
            }
            // 将结束点比这个建筑短，还比这个建筑矮的统统删掉（完全覆盖）
            while ((entry = end.floorEntry(building[1])) != null && entry.getValue() <= building[2])
                end.remove(entry.getKey());
            // 如果存在比这个建筑又高，结束点还在他右边的，就不把这个建筑放进去（完全覆盖）
            if ((entry = end.ceilingEntry(building[1])) == null || entry.getValue() < building[2])
                end.put(building[1], building[2]);
        }
        // 遍历完所有建筑后把结束点全部放入拐点
        while ((entry = end.firstEntry()) != null) {
            last[1] = entry.getValue();
            result.add(last);
            last = new int[]{entry.getKey(), 0};
            end.remove(entry.getKey());
        }
        result.add(last);
        // 去除首拐点为0，0的
        if (Arrays.equals(result.getFirst(), new int[]{0, 0}))
            result.removeFirst();
        return result;
    }
}
