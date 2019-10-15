package 第四章_网络编程;

/**
 * 棋盘
 */
public class Board {
    public static void main(String[] args) {
        //单元测试
        Board b = new Board(10,10,30,20);
        Physical p = new Physical(100,70);
        Logic p1 = b.convert(p);
        if (p1 == null) {
            System.out.println("转换失败");
        } else {
            System.out.printf("行号%d,列号%d", p1.row, p1.col);
        }
    }
    private int rows;//行数
    private int cols;//列数
    private int size;//格子大小
    private int margin;//边距

    /**
     * 构造函数初始化
     * @param rows
     * @param cols
     * @param size
     * @param margin
     */
    public Board(int rows, int cols, int size, int margin) {
        this.rows = rows;
        this.cols = cols;
        this.size = size;
        this.margin = margin;
    }

    public int getMargin(){
        return margin;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public int getSize(){
        return size;
    }

    /**
     * 获得棋盘宽度
     * @return 棋盘宽度
     */
    public int getWidth(){
        return 2*margin+cols*size;
    }

    /**
     * 获得棋盘高度
     * @return 棋盘高度
     */
    public int getHeight(){
        return 2*margin+rows*size;
    }
    /**
     * 将物理坐标转换为逻辑坐标
     * @param p 物理坐标
     * @return 逻辑坐标，null表示不存在
     */
    public Logic convert(Physical p){
        if (p.x < margin-size/2 || p.x > margin+cols*size+size/2){
            return  null;
        }
        if (p.y < margin-size/2 || p.y > margin+rows*size+size/2){
            return  null;
        }
        Logic p1 = new Logic((p.y-margin+size/2)/size,(p.x-margin+size/2)/size);
        return p1;
    }

    /**
     * 将逻辑坐标转换为物理坐标
     * @param p 逻辑坐标
     * @return 物理坐标
     */
    public Physical convert1(Logic p){
        Physical t = new Physical(0,0);
        t.x = margin+size*p.col;
        t.y = margin+size*p.row;
        return t;
    }
}
