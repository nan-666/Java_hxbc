package 第七章_贪吃蛇;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;//蛇身
    private Direction direction;//方向
    private boolean grown;//生长标记

    /**
     * 初始化
     * @param col 列号
     * @param length 长度
     */
    public Snake(int col,int length){
        body = new LinkedList<>();
        for (int row = 0; row < length; row++) {
            Point p = new Point(row,col);
            body.addFirst(p);

        }
        direction = Direction.DOWN;
        grown = false;
    }

    /**
     * 移动
     */
    public void move(){
        //加头
        Point newHead = new Point(getHead());
        switch (direction){
            case UP:
                newHead.row--;
                break;
            case DOWN:
                newHead.row++;
                break;
            case LEFT:
                newHead.col--;
                break;
            case RIGHT:
                newHead.col++;
                break;
        }
        body.addFirst(newHead);
        //去尾
        if (grown) {
            grown = false;
        }else {
            body.removeLast();
        }
    }

    /**
     * 生长
     */
    public void grow(){
        grown = true;
    }

    /**
     * 改变方向
     * @param d 新的方向
     */
    public void turn(Direction d){
        this.direction = d;
    }

    /**
     * 是否吃到自己
     * @return true 吃到了 false 没吃到
     */
    public Boolean eatSelf(){
        Point head = getHead();
        return body.indexOf(head) != body.lastIndexOf(head);
    }

    /**
     * 获取蛇头位置
     * @return  蛇头位置
     */
    public Point getHead(){
        return body.getFirst();
    }

    /**
     * 获取蛇身(包括蛇头)
     * @return 蛇身
     */
    public LinkedList<Point> getBody(){
        return body;
    }
}
