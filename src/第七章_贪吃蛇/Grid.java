package 第七章_贪吃蛇;

import java.awt.*;

public class Grid {
    private int rows;//行数
    private int cols;//列数
    private int size;//格子大小
    private int margin;//边距

    public Grid(int rows, int cols, int size, int margin) {
        this.rows = rows;
        this.cols = cols;
        this.size = size;
        this.margin = margin;
    }

    /**
     * 行大小
     * @return 行
     */
    public int getRows() {
        return rows;
    }

    /**
     * 列大小
     * @return 列
     */
    public int getCols() {
        return cols;
    }

//    /**
//     * 格子大小
//     * @return
//     */
//    public int getSize() {
//        return size;
//    }
//
//    /**
//     * 边距
//     * @return
//     */
//    public int getMargin() {
//        return margin;
//    }

    /**
     * 判断越界
     * @param p 带判断的位置
     * @return
     */
    public boolean transboundary(Point p){
        //行号越界
        if (p.row<0 || p.row>=rows){
            return true;
        }
        //列号越界
        if (p.col<0 || p.col>=cols){
            return true;
        }
        return false;
    }

    /**
     * 获取指定位置的矩形面积
     * @param p
     * @return
     */
    public Rectangle getRect(Point p){
        Rectangle r = new Rectangle();
        r.x = size*p.col + margin;
        r.y = size*p.row + margin;
        r.width = size;
        r.height = size;
        return r;
    }
    /**
     * 获取网格的矩形面积(不包括边距)
     *
     * @return
     */
    public Rectangle getRectWithOutMargin() {
        Rectangle r = new Rectangle();
        r.x = margin;
        r.y = margin;
        r.width = size*cols;
        r.height = size*rows;
        return r;
    }
    /**
     * 获取网格的矩形面积(包括边距)
     *
     * @return
     */
    public Rectangle getRectWithMargin() {
        Rectangle r = new Rectangle();
        r.x = 0;
        r.y = 0;
        r.width = size*cols+2*margin;
        r.height = size*rows+2*margin;
        return r;
    }

}
