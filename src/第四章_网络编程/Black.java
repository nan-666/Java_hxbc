package 第四章_网络编程;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 游戏（总控）
 */
public class Black {
    static Frame frame;//图形对象
    static Canvas canvas;//画布
    static Graphics2D g;//绘图对象
    static Button btn;//按钮
    static Game game;
    static TCP client;
    public static void main(String[] args) {

        game = new Game(10,10,30,20);
        frame = new Frame();
        frame.setTitle("黑方");
        frame.setSize(game.getWidth(),game.getHeight()+70);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);//显示

        btn = new Button("start");
        btn.setSize(100,40);
        frame.add(btn);

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                g = (Graphics2D) canvas.getGraphics();
                g.setColor(Color.black);
                //g.setStroke(new BasicStroke(2));

                game.drawBoard(g);
                client = new TCP("192.168.1.119",2000);

            }
        });

        canvas = new Canvas();
        canvas.setBackground(Color.LIGHT_GRAY);
        canvas.setSize(game.getWidth(),game.getHeight());
        frame.add(canvas);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Physical p = new Physical(e.getX(),e.getY());
                Logic logic = game.convert(p);
                if(logic == null){
                    return ;
                }

                //通知对方同步更新
                byte []bytes = {(byte) logic.row,(byte) logic.col};
                client.send(bytes);
                //等待对方落子
                client.receive(bytes);
                Logic l = new Logic(bytes[0],bytes[1]);
                addChess(l);
            }
        });

    }
    private static void addChess(Logic logic) {
        Status status = game.addChess(logic);
        game.drawChess(logic,status,g);
        status = game.win();

        if(status == Status.BLACK){
            System.out.println("黑方胜");
        }else if(status == Status.WHITE){
            System.out.println("白方胜");
        }
    }


}
