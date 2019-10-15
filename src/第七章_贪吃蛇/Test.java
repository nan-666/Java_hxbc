package 第七章_贪吃蛇;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test {
    static Frame frame;//窗体对象
    static Canvas canvas;//画布
    static Graphics g;//绘图对象
    static Button btn;
    static Game game;
    public static void main(String[] args) {
        game = new Game();
        frame = new Frame();
        frame.setTitle("贪吃蛇");
        Rectangle r = game.getRect();
        frame.setSize(r.width,r.height+40);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        btn = new Button("start");
        btn.setSize(100,40);
        frame.add(btn);

        canvas = new Canvas();
        canvas.setBackground(Color.GRAY);
        canvas.setSize(r.width,r.height);
        frame.add(canvas);


        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                g = canvas.getGraphics();
                game.drawGrid(g);
                game.drawSnake(g);
                game.drawFood(g);
                game.start(g);
            }
        });
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int code = e.getKeyCode();
                switch (code){
                    case KeyEvent.VK_LEFT:
                        game.turn(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.turn(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_UP:
                        game.turn(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.turn(Direction.DOWN);
                        break;
                }
            }
        });


    }
}
