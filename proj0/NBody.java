public class NBody{
    
    public static double readRadius(String name){
        In temp = new In(name);
        int number = temp.readInt();
        double radius = temp.readDouble();
        temp.close();
        return radius;
    }
    
    public static Planet[] readPlanets(String name){
        In temp = new In(name);
        int numberPlanet = temp.readInt();
        double raduis = temp.readDouble();
        Planet total[] = new Planet[numberPlanet];
        double xp = 0.0;
        double yp = 0.0;
        double xv = 0.0;
        double yv = 0.0;
        double m;
        String img;
        for(int i = 0; i < numberPlanet; ++i){
            xp = temp.readDouble();
            yp = temp.readDouble();
            xv = temp.readDouble();
            yv = temp.readDouble();
            m = temp.readDouble();
            img = temp.readString();
            total[i] = new Planet(xp,yp,xv,yv,m,img);
        }
        return total;
    }
    
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double uRadius = readRadius(filename);
        Planet total[] = readPlanets(filename);
        StdDraw.setScale(-uRadius,uRadius);
        StdDraw.clear();
        for(double timeV = 0.0;timeV < T; timeV += dt){
            double xForces[] = new double[total.length];
            double yForces[] = new double[total.length];
            for(int i = 0; i < total.length; ++i){
                xForces[i] = total[i].calcNetForceExertedByX(total);
                yForces[i] = total[i].calcNetForceExertedByX(total);
                total[i].update(dt,xForces[i],yForces[i]);
            }
            String background = "./images/starfield.jpg";
            StdDraw.picture(0,0,background);
            for(int i = 0; i < total.length; ++i){
                total[i].draw();
            }
            // copy offscreen buffer to onscreen
            StdDraw.show(3);
            
            // pause for 10 ms
            //StdDraw.pause(10);

        }
        
    
    }

}