package everyday;

/*
 * leetcode 3222 求硬币玩家
 * 题目解析 两个整数代表 75美分和10美分的硬币的数量，每次拿走115美分 ，拿不走的就输了
 * a b 假如 a先拿 拿不走115美分，就是失败
 * */
public class losingPlayer {


    // x 75美分 的个数 y 为 10美分 的个数
    public static String losingPlayer(int x, int y) {
        //所以每次拿到是 1 个 75 美分 4个10美分，每次拿走是 115 美分 所以 x:y = 1:4
        //如果 x:y = 1:4  那么 4 * x + 1 * y = 115 * n
        //如果 x:y=1:5 < 1:4 那么 删后面的 否则删前面的
        //但是第一次都没有拿不起 那么就是 Bob 赢了
//        if (x==1&&y<4){
//            return "Alice";
//        }
        if (x==0 || y==0){
            return "Bob";
        }

        double xy = (double) x / (double) y;
        if (xy <= 1.0 / 4.0) {
            if (x % 2 == 0) {
                return "Bob";
            } else return "Alice";
        } else {
            if ((y / 4) % 2 == 0) {
                return "Bob";
            } else return "Alice";
        }
    }

    public static void main(String[] args) {
        String result = losingPlayer(1, 1);
        System.out.println(result);
    }
}
