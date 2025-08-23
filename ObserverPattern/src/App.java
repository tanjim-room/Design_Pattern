import java.util.ArrayList;

interface IChannel{

    public abstract void subscribe(ISubscriber subscriber);
    public abstract void unsubscribe(ISubscriber subscriber);
    public abstract void notifySubscriber();
    
    
}


interface ISubscriber{
    public abstract void update();
}


class Channel implements IChannel{
    ArrayList<ISubscriber> subscribers;
    String name;
    String latestVideo;

    public Channel(String name){
        this.name=name;
        this.subscribers= new ArrayList<ISubscriber>();
    }

    public void subscribe(ISubscriber subscriber){
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }

    }

    public void unsubscribe(ISubscriber subscriber){
        if(subscribers.contains(subscriber)){
            subscribers.remove(subscriber);
        }
        else{
            System.out.println("He is not a Subscriber!!!");
        }
    }
    public void notifySubscriber(){
        for(ISubscriber sub : subscribers){
            sub.update();
        }
    }

    public void uploadVideo(String title){
        latestVideo =  title;
        System.out.println(name +" upload a video " + title);
        notifySubscriber();
    }
    
    public String getUpdateVideo(){
        return "\nCheckout your latest video " + latestVideo;
    }
}


class Subscriber implements ISubscriber{
    String name;
    Channel channel;

    public Subscriber(String name, Channel channel){
        this.name = name;
        this.channel = channel;
    }
    public void update(){
        System.out.println("Hey " + name + " your latest " + channel.getUpdateVideo());
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Channel c1 = new Channel("Coder");
        Channel c2 = new Channel("Travel");

        Subscriber s1 = new Subscriber("Rakib", c1);
        Subscriber s2 = new Subscriber("Sakib", c1);

        c1.subscribe(s1);
        c1.uploadVideo("CP guideline!!!");

        c1.subscribe(s2);
        c1.uploadVideo("Design Pattern Rules!!!");

    }
}
