package com.cor.code;

interface IHandler {
    public IHandler nextHandler = null;

    default void setNextHandler(IHandler nextHandler){
        nextHandler = nextHandler;
    }

    void dispense(int amount);

}

class ThousandHandler implements IHandler{

    private int numNotes;

    public ThousandHandler (int numNotes){
        this.numNotes=numNotes;
    }
    @Override
    public void dispense(int amount) {
        int needNotes = amount / 1000;

        if(needNotes > numNotes){
            needNotes = numNotes;
            numNotes = 0;
        }
        else{
            numNotes = numNotes - needNotes;
        }
        if (needNotes > 0){
            System.out.println("Dispense " + needNotes + "x 1000 Tk");
        }

        int remainingAmt = amount - (needNotes * 1000);
        if(remainingAmt > 0){
            if ((nextHandler != null)) {
                nextHandler.dispense(remainingAmt);
                
            }
            else{
                System.out.println("Remaining amount" + remainingAmt + "cannot withdarw!");
            }
        }
    }
    
} 

class FiveHundredHandler implements IHandler{

    private int numNotes;

    public FiveHundredHandler (int numNotes){
        this.numNotes=numNotes;
    }
    @Override
    public void dispense(int amount) {
        int needNotes = amount / 1000;

        if(needNotes > numNotes){
            needNotes = numNotes;
            numNotes = 0;
        }
        else{
            numNotes = numNotes - needNotes;
        }
        if (needNotes > 0){
            System.out.println("Dispense " + needNotes + "x 500 Tk");
        }

        int remainingAmt = amount - (needNotes * 500);
        if(remainingAmt > 0){
            if ((nextHandler != null)) {
                nextHandler.dispense(remainingAmt);
                
            }
            else{
                System.out.println("Remaining amount" + remainingAmt + "cannot withdarw!");
            }
        }
    }
    
} 
