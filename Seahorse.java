import greenfoot.*;

public class Seahorse extends Actor
{
    private int xDestination;
    private int yDestination;
    private int speed;
    public Seahorse(int xDestination, int yDestination, int speed){
        this.xDestination = xDestination;
        this.yDestination = yDestination;
        this.speed = speed;
    }
    public void act() 
    {
        // Add your action code here.
        World world = getWorld();
        int height = world.getHeight();
        int width = world.getWidth();
        getWorld().showText(this.toString(), width/2, height/2);
        move(this.speed);
        if (this.isAtEdge()){
            turn((int)((Math.random()*91)+45));
        }
    }    
    public double calcTripDistance(){
        double d1 = Math.pow((this.yDestination-this.getY()), 2);
        double d2 = Math.pow((this.xDestination-this.getX()), 2);
        double d = Math.sqrt(d1+d2);
        return d;
    }
    public double calcTripTravelTime(){
        double time = this.calcTripDistance()/this.speed;
        return time;
    }
    public String toString(){
        String string = "distance = "+((int)(this.calcTripDistance()*100)/100.0)+" km\ntime = "+((int)(this.calcTripTravelTime()*100)/100.0)+" hrs";
        return string;
    }
}
