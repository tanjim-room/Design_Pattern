
interface IApprover{
    public abstract void setNextHandler(IApprover nextApprover);
    public abstract void approve(int days);
    
}


class TeamLead implements IApprover{

    int powerDays;
     private IApprover nextApprover;

    public TeamLead(int powerDays){
        this.powerDays = powerDays;
    } 

     public void setNextHandler(IApprover nextApprover) {
       this.nextApprover = nextApprover;
    }

   
    
    public void approve(int days){

        if(powerDays >= days){
           if(days > 0){
            powerDays = days;
            System.out.println("Team Lead Approve " + powerDays + " Leave." );
           }
            
        }
        //Want to remove
        else{
            if(nextApprover != null){
                nextApprover.approve(days);
            }
              else{
                System.out.println("NO LEAVE!!!");
            }
        }
        

        // else{
            
        //     System.out.println("Team Lead Approve " + this.powerDays + " leave.");
        //     int remainingDays = days - powerDays;

        //     if(nextApprover != null){
        //         nextApprover.approve(remainingDays);
        //     }
        //     else{
        //         System.out.println(remainingDays + " days leave can not accept.");
               
        //     }
        // }
  

    }
   
}

class Manager implements IApprover{

    int powerDays;
    private IApprover nextApprover;

    public Manager(int powerDays){
        this.powerDays = powerDays;
    } 

    public void setNextHandler(IApprover nextApprover) {
       this.nextApprover = nextApprover;
    }

    
    
   public void approve(int days){

      if(powerDays > days){
           if(days > 0){
            powerDays = days;
            System.out.println("Manager Approve " + powerDays + " Leave." );
           }
            
      
        }
        else{
            if(nextApprover != null){
                nextApprover.approve(days);
            }
            else{
                System.out.println("NO LEAVE!!!");
            }
        }

        // else{
            
        //     System.out.println("Manager Approve " + this.powerDays + " leave.");
        //     int remainingDays = days - powerDays;

        //     if(nextApprover != null){
        //         nextApprover.approve(remainingDays);
        //     }
        //     else{
        //         System.out.println(remainingDays + " days leave can not accept.");
               
        //     }
        // }
  

    }
   
}

class Director  implements IApprover{

    int powerDays;
    private IApprover nextApprover;

    public Director(int powerDays){
        this.powerDays = powerDays;
    } 

    public void setNextHandler(IApprover nextApprover) {
       this.nextApprover = nextApprover;
    }

    
    
    public void approve(int days){

        if(powerDays > days){
           if(days > 0){
            powerDays = days;
            System.out.println("Director Approve " + powerDays + " Leave." );
           }
            
      
        }
        else{
            if(nextApprover != null){
                nextApprover.approve(days);
            }
              else{
                System.out.println("NO LEAVE!!!");
            }
        }

        // else{
            
        //     System.out.println("Director Approve " + this.powerDays + " leave.");
        //     int remainingDays = days - powerDays;

        //     if(nextApprover != null){
        //         nextApprover.approve(remainingDays);
        //     }
        //     else{
        //         System.out.println(remainingDays + " days leave can not accept.");
               
        //     }
        // }
  

    }
   
}



public class App {
     public static void main(String[] args) {
        IApprover tl = new TeamLead(2);
        IApprover mn = new Manager(5);
        IApprover dr = new Director(10);

        tl.setNextHandler(mn);
        mn.setNextHandler(dr);

        System.out.println("Approve Status");
        tl.approve(20);
     }
}
