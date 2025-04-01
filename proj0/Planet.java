public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    /*
     * Begin by creating a basic version of the Planet class with the following 6
     * instance variables:
     * 
     * double xxPos: Its current x position
     * double yyPos: Its current y position
     * double xxVel: Its current velocity in the x direction
     * double yyVel: Its current velocity in the y direction
     * double mass: Its mass
     * String imgFileName: The name of the file that corresponds to the image that
     * depicts the planet (for example, jupiter.gif)
     */
    static final double G = 6.67e-11;
    // constructor function
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.imgFileName = p.imgFileName;
        this.mass = p.mass;
        this.xxPos = p.xxPos;
        this.xxVel = p.xxVel;
        this.yyPos = p.yyPos;
        this.yyVel = p.yyVel;
    }

   

    public double calcDistance(Planet p){
        double delta_x = p.xxPos - this.xxPos;
        double delta_y = p.yyPos - this.yyPos;
        double dis =  delta_x * delta_x + delta_y * delta_y;
        return Math.sqrt(dis);
    }

    public double calcForceExertedBy(Planet p){
        double force = G * this.mass * p.mass / (this.calcDistance(p)*this.calcDistance(p));
        return force;
    }

    double calcForceExertedByX(Planet p){
        double theta = (p.xxPos - this.xxPos)/(this.calcDistance(p));
        double forceX = this.calcForceExertedBy(p) * theta;
        return forceX;
    }

    double calcForceExertedByY(Planet p){
        double theta = (p.yyPos - this.yyPos)/(this.calcDistance(p));
        double forceY = this.calcForceExertedBy(p) * theta;
        return forceY;
    }

    double calcNetForceExertedByX(Planet[] p){
        double sumForceX = 0;
        for(var iter:p){
            if (this.calcDistance(iter) != 0){
            sumForceX += this.calcForceExertedByX(iter);
            }
        }
        return sumForceX;
    }

    double calcNetForceExertedByY(Planet[] p){
        double sumForceY = 0;
        for(var iter:p){
            if (this.calcDistance(iter) != 0){
            sumForceY += this.calcForceExertedByY(iter);
            }
        }
        return sumForceY;
    }

    void update(double dt, double fx, double fy){
        double ax = fx/this.mass;
        double ay = fy/this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    void draw(){
        // draw a planet itself at its position
        StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
        //为了能够成功读取到images里面的图片文件，加上如上的路径
    }
}
