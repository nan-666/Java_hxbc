package 第七章_贪吃蛇;

public class Point{
    public int row;
    public int col;



    /**
     * 初始化
     * @param x 横坐标初始值
     * @param y 纵坐标初始值
     */
    public Point(int x, int y){
        this.row = x;
        this.col = y;
    }

    /**
     * 拷贝构造函数
     * @param head
     */
    public Point(Point head) {
        this.row = head.row;
        this.col = head.col;
    }
    /**
     * 重写equals函数
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return this.row==p.row&&this.col==p.col;
    }

    @Override
    public String toString() {
        return String.format("{%d,%d}",row,col);
    }
}
