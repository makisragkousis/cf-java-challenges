package gr.aueb.cf.ch12;

public class Main {

    public static void main(String[] args) {

        PointXYZ point = new PointXYZ(2.0, 3.0, 5.0);

        System.out.println(point.getXYDistance());
        System.out.println(point.getYZDistance());
        System.out.println(point.getXZDistance());
        System.out.println(point.getXYZDistance());
    }
}
