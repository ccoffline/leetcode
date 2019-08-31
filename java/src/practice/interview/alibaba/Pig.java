package practice.interview.alibaba;

/**
 * 阿里笔试
 * <p>
 * 小明是一个数学家，他喜欢用数字给事物命名编号，他给自己编号为1，
 * 同时在2019年小明开办了一个农场，准备开始养母猪，他专门给农场的母猪用以下数列
 * 2，3，4，5，7，9，12，16，21，28，37，49，65，86，114，151...进行命名。
 * 假设农场的母猪永远不会死，小母猪出生后3年后成熟，成熟后从第三年开始每年只会生一只小母猪。
 * 第一年农场，有一只刚刚出生的小母猪和一只成熟的母猪(本年不再生小猪，下一年开始生小猪)，并给他们编号为2和3。
 * 请问，第m只母猪编号为多少？其是哪一年出生的？
 * 小明还准备了1份礼物，专门颁给农场第1到m只的母猪颁奖，颁奖规则如下:
 * 选出第1到m只的母猪翻转编号(114编号翻转为411)为第k大的母猪进行颁奖，请问是第几只猪获奖？
 * 提示: f(n)=f(n-2)+f(n-3)
 */
public class Pig {
    /**
     * 输入:
     * m,k
     * 输出:
     * 第m只母猪编号,哪一年出生,第几只小猪获奖
     * <p>
     * 输入范例:
     * 20,3
     * 输出范例:
     * 465,2024,15
     **/
    static String calculate(int m, int k) {
        int[] pigs = new int[m + 1];
        pigs[1] = 2;
        pigs[2] = 3;
        pigs[3] = 4;
        for (int i = 4; i <= m; i++) pigs[i] = pigs[i - 2] + pigs[i - 3];
        int mc = pigs[m];
        for (int i = 1; i <= m; i++) pigs[i] = reverse(pigs[i]);
        int kp = 0, temp = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            kp = 0;
            for (int i = 1; i <= m; i++)
                if (pigs[i] < temp && pigs[i] > pigs[kp])
                    kp = i;
            temp = pigs[kp];
        }
        pigs[0] = pigs[1] = 1;
        int my = 2017;
        for (int i = 2; ; i++) {
            pigs[i] = pigs[i - 1] + pigs[i - 2];
            if (pigs[i] >= m) {
                my += i;
                break;
            }
        }
        return "" + mc + "," + my + "," + kp;
    }

    static int reverse(int v) {
        int result = 0;
        while (v > 0) {
            result = result * 10 + v % 10;
            v /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String[] line = in.nextLine().split(",");
//        int m = Integer.valueOf(line[0]);
//        int k = Integer.valueOf(line[1]);
        int m = 20, k = 3;
        System.out.println(calculate(m, k));
    }
}