package practice.interview.alibaba;

import java.util.Scanner;

/**
 * 阿里笔试
 * <p>
 * 小明在双十一晚会上抽奖赢得了一次天猫超市免单的机会，
 * 享受在一个包裹内最大体积V，最大重量M内免单
 * 假设商品i,体积Vi,重量Mi,库存Si,价格Pi
 * 目前天猫超市的商品分为生鲜水产(1)、食品酒水(2),美妆个护(3),居家生活(4)四大类
 * 生鲜水产不与美妆个护同包裹
 * 请你帮助小明在购物车里添置商品使得总价值最大
 */
public class TianMao {

    /**
     * 输入范例:
     * 3,40,30
     * 10,10,10,10,1
     * 13,10,12,11,3
     * 3,4,6,5,3
     * 输出范例:
     * 33
     */
    private static int totalPrice(int categoryCount, int totalVolume, int totalWeight, int[] volume, int[] weight,
                                  int[] stock, int[] price, int[] itemType) {
        return 33;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        // 总共商品种类
        int categoryCount = Integer.parseInt(line[0]);
        // 快递体积
        int totalVolume = Integer.parseInt(line[1]);
        // 快递重量
        int totalWeight = Integer.parseInt(line[2]);

        // 物品体积
        int[] volume = new int[50];
        // 重量
        int[] weight = new int[50];
        // 件数
        int[] stock = new int[50];
        // 价格
        int[] price = new int[50];
        // 类型
        int[] itemType = new int[50];

        for (int i = 1; i <= categoryCount; i++) {
            line = in.nextLine().split(",");
            volume[i] = Integer.parseInt(line[0]);
            weight[i] = Integer.parseInt(line[1]);
            stock[i] = Integer.parseInt(line[2]);
            price[i] = Integer.parseInt(line[3]);
            itemType[i] = Integer.parseInt(line[4]);
        }
        in.close();
        System.out.println(totalPrice(categoryCount, totalVolume, totalWeight, volume, weight, stock, price, itemType));
    }
}
