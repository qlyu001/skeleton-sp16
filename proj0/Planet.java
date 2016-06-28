import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.abs;


public class Planet{
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
 
    public double calcDistance(Planet b){
        double x = xxPos - b.xxPos;
        double y = yyPos - b.yyPos;
        double z = sqrt(x*x + y*y);
        
        return z;
    }
    
    public double calcForceExertedBy(Planet b){
        double distance = calcDistance(b);
        return mass*b.mass*6.67e-11/(distance * distance);
    }
    
    public double calcForceExertedByX(Planet b){
        double totalForce = calcForceExertedBy(b);
        double dx = xxPos - b.xxPos;
        double r = calcDistance(b);
        return totalForce*dx/r;
    }
    
    public double calcForceExertedByY(Planet b){
        double totalForce = calcForceExertedBy(b);
        double dy = yyPos - b.yyPos;
        double r = calcDistance(b);
        return totalForce*dy/r;
    }
    
    public double calcNetForceExertedByX(Planet[] b){
        double temp = 0.0;
        for(Planet element : b){
            if(!equals(element)){
                temp += calcForceExertedByX(element);
            }
            
        }
        return temp;
    }

    public double calcNetForceExertedByY(Planet[] b){
        double temp = 0.0;
        for(Planet element : b){
            if(!equals(element)){
                temp += calcForceExertedByY(element);
            }
        }
        return temp;
    }
    
    public void update(double dt, double fX, double fY){
        double aX = fX/mass;
        double aY = fY/mass;
        xxVel = xxVel + dt*aX;
        yyVel = yyVel + dt*aY;
        xxPos = xxPos + dt*xxVel;
        yyPos = yyPos + dt*yyVel;
    }
    public void draw(){
        String image = "./images/"+imgFileName;
        StdDraw.picture(xxPos,yyPos,image);
    }

  



    
}