package 第一章_常用类;

public class Point implements Comparable<Point> {
    private double x;
    private double y;



    /**
     * 初始化
     * @param x 横坐标初始值
     * @param y 纵坐标初始值
     */
    public  Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    /**
     * 计算两点之间的距离
     * @param p
     * @return 距离值
     */
    public double distance(Point p){
        return Math.sqrt(Math.pow((this.x - p.x),2)+Math.pow((this.y - p.y),2));
    }

    /**
     * 重写equals函数
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Point point = (Point)obj;
        double d = distance(point);

        return this.distance(point)<1e-6;
    }

    @Override
    public int compareTo(Point point) {
        Point p0 = new Point(0,0);
        double d1 = this.distance(p0);
        double d2 = point.distance(p0);
        return Double.compare(d1,d2);
    }
    @Override
    public String toString() {
        return String.format("{%.2f,%.2f}",x,y);
    }
}
