public class NBody {
    // this file is for dealing with the input info
    public static double readRadius(String args) {
        In in = new In("./data/planets.txt");
        int planet_num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String args) {
        In in = new In("./data/planets.txt");
        int planet_nums = in.readInt();
        double radius = in.readDouble();
        Planet[] readin = new Planet[planet_nums];
        for (int i = 0; i < planet_nums; i++) {
            readin[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readString());
        }
        return readin;
    }

    public static void main(String[] args) {
        // String args[] 接受的就是命令行传给程序的参数
        // 不光是main，其他函数也通过这个来获取参数
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // 读取完所有的参数之后，准备画图
        // draw starfield.jpg
        String backgroundToDraw = "./images/starfield.jpg";
        // formatting the canvas size, now we should set it to the universe radius
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        // drawing at the center
        StdDraw.picture(0, 0, backgroundToDraw);

        // drawing all the planets
        for (var iter : planets) {
            iter.draw();
        }

        StdDraw.enableDoubleBuffering();

        // do the time count loop
        double time_count = 0;
        while (time_count < T) {
            // calc all the xF and yF for all the planets
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            int planet_count = 0; // for specifying the planet in fX and fY
            for (var iter : planets) {
                double forceX = iter.calcNetForceExertedByX(planets);
                double forceY = iter.calcNetForceExertedByY(planets);
                xForces[planet_count] = forceX;
                yForces[planet_count] = forceY;
                planet_count++;
            }

            // update the planets
            planet_count = 0;
            for (var iter : planets) {
                iter.update(dt, xForces[planet_count], yForces[planet_count]);
                planet_count++;
            }
            // draw background
            StdDraw.picture(0, 0, backgroundToDraw);
            // draw updated stars
            for (var iter : planets) {
                iter.draw();
            }
            // show the offscreen buffer
            StdDraw.show();
            StdDraw.pause(100);

            time_count += dt;
        }
        // printing the universe when loop is over
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
