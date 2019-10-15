package 第七章_贪吃蛇;

import java.util.LinkedList;
import java.util.Map;

public class Food {
    private Point point;//位置

    /**
     * 初始化
     * @param Rows 最大行号
     * @param Cols 最大列号
     * @param points 蛇身
     */
    public void init(int Rows, int Cols, LinkedList points){
        point = new Point(0,0);
        while (true) {
            point.row = (int) (Math.random()*Rows);
            point.col= (int) (Math.random()*Cols);
            if (!points.contains(point)){
                break;
            }
        }
    }

    /**
     * 获取食物
     * @return 食物
     */
    public Point getPoint(){
        return point;
    }
}
