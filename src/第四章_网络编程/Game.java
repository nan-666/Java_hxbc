package 第四章_网络编程;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 游戏（总控）
 */
public class Game {


    /**
     * 获得棋盘高度
     * @return 棋盘高度
     */
    public int getHeight() {
        return board.getHeight();
    }

    /**
     * 获得棋盘宽度
     * @return 棋盘宽度
     */
    public int getWidth() {
        return board.getWidth();
    }

    private Board board;//棋盘
    private Composition com;//棋局

    /**
     * 构造函数初始化
     * @param rows 行数
     * @param cols 列数
     * @param size 格子大小
     * @param margin 边距
     */
    public Game(int rows,int cols,int size,int margin) {
        board = new Board(rows,cols,size,margin);
        com = new Composition(rows+1,cols+1);
    }

    /**
     * 绘制棋盘
     * @param g 绘图对象
     */
    public void drawBoard(Graphics g) {
        //画纬线
        int startX = board.getMargin();
        int endX = board.getMargin()+board.getCols()*board.getSize();
        for (int i = 0; i <= board.getRows(); i++) {
            int y = board.getMargin()+board.getSize()*i;
            g.drawLine(startX,y,endX,y);
        }
        //画经线
        int startY = board.getMargin();
        int endY = board.getMargin()+board.getRows()*board.getSize();
        for (int i = 0; i <= board.getCols(); i++) {
            int x = board.getMargin()+board.getSize()*i;
            g.drawLine(x,startY,x,endY);
        }
    }

    /**
     * 绘制棋子
     * @param p 绘制棋子坐标
     * @param turn 棋子颜色
     * @param g 绘图对象
     */
    public void drawChess(Logic p, Status turn, Graphics g){
        int r = 10;//半径

        //计算棋子外切矩形的左上角坐标
        Physical t = board.convert1(p);
        t.x -= r;
        t.y -= r;
        //设置棋子颜色并绘制棋子(实心圆)
        g.setColor(turn == Status.BLACK?Color.BLACK:Color.WHITE);
        g.fillArc(t.x,t.y,2*r,2*r,0,360);
    }

    /**
     * 落子
     * @param logic 逻辑坐标
     * @return 落子产生的输赢结果 NONE平局，WHITE白方胜，BLACK黑方胜
     */
    public Status addChess(Logic logic){

        //如果该点有子则不作处理
        if (!com.exist(logic)){
            return Status.NONE;
        }

        Status status = com.add(logic);
        return Status.BLACK;

    }
    public Logic convert(Physical p) {
        return board.convert(p);
    }

    public Status win() {
        return Status.NONE;
    }
}
