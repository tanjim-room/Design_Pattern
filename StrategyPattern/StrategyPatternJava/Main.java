
interface Talkable {
    public abstract void talk();
}

class NormalTalk implements Talkable {
    public void talk(){
        System.out.println("Can talk");
    }
}

class NoTalk implements Talkable {
    public void talk(){
        System.out.println("Cannot talk");
    }
}

interface Walkable {
    public abstract void walk();
}

class Walking implements Walkable{
    public void walk(){
        System.out.println("Can walk");
    }
}

class NoWalking implements Walkable{
    public void walk(){
        System.out.println("Cannot walk");
    }
}

interface Flyable{
    public abstract void fly();
}

class Flying implements Flyable{
    public void fly(){
        System.out.println("Can fly");
    }
}

class NoFlying implements Flyable{
    public void fly(){
        System.out.println("Cannot fly");
    }
}


abstract class Robot {
    Talkable talkBehave;
    Walkable walkBehave;
    Flyable  flyBehave;

    public Robot(Talkable t, Walkable w, Flyable f){
        this.talkBehave=t;
        this.walkBehave=w;
        this.flyBehave=f;
    }

    public void walk(){
        walkBehave.walk();
    }

    public void talk(){
        talkBehave.talk();
    }

    public void fly(){
        flyBehave.fly();
    }


    public abstract void projection();
}

class CompanyRobot extends Robot{

    public CompanyRobot(Talkable t, Walkable w, Flyable f) {
        super(t, w, f);
    }

    public void projection(){
        System.out.println("Hello Projection");
    }
    
}


class WorkRobot extends Robot{

    public WorkRobot(Talkable t, Walkable w, Flyable f) {
        super(t, w, f);
    }

    public void projection(){
        System.out.println("Hello Projection working");
    }
    
}

public class Main {
    public static void main(String[] args) throws Exception {
      Robot r1 = new CompanyRobot(new NormalTalk(), new NoWalking(), new Flying());
   
      r1.talk();
         r1.walk();
      r1.fly();
    }
}
