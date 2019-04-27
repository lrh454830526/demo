/**
 * 题 1:
 * 编程实现功能:
 功能是求出字符 s 与字符串t的第二公共单词(这里，假设两个
 字符串均由英字母和空格字符组成);若找到这样的公共单词，
 函数返回该单词，否则，函数返回NULL，如果有多个满足要
 求，则返回第一个单词。
 例如:若 s=“This is C programming text”，t=“This is a text for C
 programming”，则函数返回“this”。
 *
 *
 *- 题 2:
 某些整数能分解成若干个连续整数的和的形式，例如
 15 = 1 + 2+3+4+5
 15 = 4 + 5 + 6
 15 = 7 + 8
 某些整数不能分解为连续整数的和，例如:16
 输入: 一个整数N(N <= 10000)
 输出:整数N对应的所有分解组合，按照每个分解中的最小整数
 从小到大输出，每个分解占一行 ，每个数字之间有一个空格(每
 行最后保留一个空格);如果没有任何分解组合，则输出NONE。

 题 3:
 开发一个个主页 ，至少包含如下功能部分:
 1. 个人简历，把投递到我们这里的简历，在个人网站上还
 原;
 2. “旅行日志”。使用地图API，把你旅行到过的省份使用某种交
 互标注出来; 鼠标标放到相关省份后可以看到相关的时间和备
 注;对于没有去过的地方，可以在地图上直接“做计划”，比如，
 你之前没有去过浙江旅行，那直接可以地图上给浙江省做一个
 旅行计划，比如，写上 “计划2018五一期间旅行 ”。对于已经
 去过的省份，不可以再做计划;
   交材料:
 1. 所有源代码，包括CSS/JS/HTML;如果ᨀ交到GitHub，加分;
 2. 如果有在线Demo，加分;
 */

/**
 * @author  liurenhua
 */
public class Main {

    public static void main(String a[]){
        String s = "This is C programming text";
        String t = "This is a text for C\n" +
                " programming";
        System.out.println(question1(s,t));
        question2(15);
    }

    /**
     * 以下为对题目1的解答,思路如下  把s按照空格拆分成字符串数组
     * 一层循环比较s中的单词 有没有在t这个句子中出现
     */

    /**
     *
     * @param s  第一个句子
     * @param t  第二个句子
     * @return
     */
    public static String question1(String s,String t){
        if (s == null || t == null || s.length() == 0 || t.length() == 0){
            return  null;
        }

        String[] sArray = s.split(" ");
        for (int i = 0;i < sArray.length;i++){
            if(t.contains(sArray[i])){
                return sArray[i];
            }
        }
        return null;
    }




    /**
     * 以下为对题2的解答
     * 思路如下：
     * 某数N被写成x,x+1,x+2,x+3...x+m-1相加,则有x + (x + 1) + (x + 2) + (x + 3) + ....(x + m - 1) = N
     * 由数列的性质可化简上等式为 (2 * x + m - 1) * m / 2  = N
     * 解这个式子为  x =  1/2 * （2*N / m + 1 - m）
     * 如果能写成连续的几个整数相加 则只要保证 存在正整数x 即可
     * 即在上式中  2 * N % M  = 0  且 （2*N / m + 1 - m） % 2 = 0 x > 0
     */

    /**
     *
     * @param N  N为输入的整数
     */
    public static void question2(int N){
        //result用来拼凑输出结果
        StringBuffer result = new StringBuffer();
        //m表示拆分成m个连续的整数相加
        int m = 1;
        //x表示这m个数中最小的一个为x
        int x;
        while( m ++ < N - 1){
            //按照上述分析 如果2 * N / m 或者 (2*N / m + 1 - m) / 2 有小数位 表示不存在正整数x
            if(2 * N % m != 0 || (2 * N / m + 1 - m)% 2 != 0){
                continue;
            }else {
                x = (2 * N / m + 1 - m) / 2;
                //x小于0肯定也是不满足的
                if(x <= 0){
                    continue;
                }
                //否则的话就是满足要求 用result来拼接输出结果
                result.append(N).append(" = ");
                for (int i = 0;i < m;i++){
                    if (i == 0){
                        result.append(x).append(" + ");
                    }else if(i == m - 1){
                        result.append(x + i);
                    }else{
                        result.append(x + i).append(" + ");
                    }
                }
                result.append("\n");
            }
        }

        //如果输出的语句长度为0  表示该数不能被写成m个整数相加的形式
        if (result.length() == 0){
            System.out.println("NONE");
        }else {
            System.out.println(result);
        }

    }

}
