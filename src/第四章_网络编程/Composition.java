package 第四章_网络编程;

/**
 * 棋局
 */
public class Composition {
    public static void main(String[] args) {
        Composition chess = new Composition(5,5);
        System.out.println(chess);
        Logic p = new Logic(2,3);

        if (chess.exist(p)) {
            chess.add(p);
            System.out.println(chess);
        }
    }
    private Status [][]chesses;//每个落点的状态
    private Status turn;//轮到哪方落子，只能取值白黑

    /**
     * 构造函数初始化
     * @param rows 行数
     * @param cols 列数
     */
    public Composition(int rows,int cols) {
        //创建落点的二维数组，并初始化每个点为“无子”
        chesses = new Status[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chesses[i][j] = Status.NONE;
            }
        }
        //黑方先手
        turn = Status.BLACK;
    }

    /**
     * 判断指定位置是否有子
     * @param p 位置
     * @return 是否有子
     */
    public boolean exist(Logic p){
        if (chesses[p.row][p.col] == Status.NONE) {
            return true;
        }
        return false;
    }

    /**
     * 在指定位置落子
     * @param p 指定位置
     * @return 落子颜色
     */
    public Status add(Logic p){
        //修改落点状态
        chesses[p.row][p.col] = turn;
        //切换
        if (turn == Status.BLACK){
            turn = Status.WHITE;
        } else if (turn == Status.WHITE) {
            turn = Status.BLACK;
        }
        return chesses[p.row][p.col];
    }

    /**
     * 判断输赢结果
     * @return NONE平局，WHITE白方胜，BLACK黑方胜
     */
    public Status  win(){
        return Status.NONE;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < chesses.length; i++) {
            for (int j = 0; j < chesses[0].length; j++) {
                s += chesses[i][j];
            }
            s += "\n";
        }
        return s;
    }
}
