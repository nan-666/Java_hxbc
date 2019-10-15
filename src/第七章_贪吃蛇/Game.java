package 第七章_贪吃蛇;

import java.awt.*;
import java.util.LinkedList;

public class Game {
    private Food food;
    private Grid grid;
    private Snake snake;



    public Game(){
        grid = new Grid(20,20,30,50);
        snake = new Snake(grid.getCols()/2,5);
        food = new Food();
        food.init(grid.getRows(),grid.getCols(),snake.getBody());
    }

    /**
     * 判断是否吃到食物
     */
    public boolean eatfood(){
        return snake.getHead().equals(food.getPoint());
    }

    /**
     * 判断是否碰墙
     * @return
     */
    public boolean meetGrid(){
        return grid.transboundary(snake.getHead());
    }

    /**
     * 开始
     * @return
     */
    public void start(Graphics g){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    snake.move();
                    drawGrid(g);
                    drawFood(g);
                    drawSnake(g);
                    if(eatfood()){
                        snake.grow();
                        food.init(grid.getRows(),grid.getCols(),snake.getBody());
                    }
                    if (meetGrid()||snake.eatSelf()){
                        System.out.println("游戏结束");
                        Thread.
                    }
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    /**
     * 绘制食物
     */

    public void drawFood(Graphics g){
        drawBlock(food.getPoint(),Color.YELLOW,g);

    }


    /**
     * 绘制网格
     * @return
     */
    public void drawGrid(Graphics g){
        Rectangle r = grid.getRectWithOutMargin();
        g.setColor(Color.WHITE);
        g.fillRect(r.x,r.y,r.width,r.height);
    }
    /**
     * 绘制蛇
     */

    public void drawSnake(Graphics g){
        LinkedList<Point> points = snake.getBody();
        for (int i = 0; i < points.size(); i++) {
            Color color = i==0?Color.RED:Color.green;
            drawBlock(points.get(i),color,g);
        }
    }
    /**
     * 绘制方块
     * @param g 绘图对象
     * @param p 绘图位置
     * @param color 颜色
     */
    private void drawBlock(Point p, Color color,Graphics g){
        Rectangle r = grid.getRect(p);
        g.setColor(color);
        g.fillRect(r.x,r.y,r.width,r.height);
    }


    public Rectangle getRect() {
        Rectangle r = grid.getRectWithMargin();
        return r;
    }
    public void turn(Direction d){
        snake.turn(d);
    }

}
