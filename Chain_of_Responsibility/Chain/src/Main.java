interface IHandler {
    void setNextHandler(IHandler nextHandler);
    void dispense(int amount);
}

class ThousandHandler implements IHandler {
    private int numNotes;
    private IHandler nextHandler;

    public ThousandHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void setNextHandler(IHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void dispense(int amount) {
        int needNotes = amount / 1000;

        if (needNotes > numNotes) {
            needNotes = numNotes;
            numNotes = 0;
        } else {
            numNotes -= needNotes;
        }

        if (needNotes > 0) {
            System.out.println("Dispense " + needNotes + " x 1000 Tk");
        }

        int remainingAmt = amount - (needNotes * 1000);

        if (remainingAmt > 0) {
            if (nextHandler != null) {
                nextHandler.dispense(remainingAmt);
            } else {
                System.out.println("Remaining amount " + remainingAmt + " cannot withdraw!");
            }
        }
    }
}

class FiveHundredHandler implements IHandler {
    private int numNotes;
    private IHandler nextHandler;

    public FiveHundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void setNextHandler(IHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void dispense(int amount) {
        int needNotes = amount / 500;

        if (needNotes > numNotes) {
            needNotes = numNotes;
            numNotes = 0;
        } else {
            numNotes -= needNotes;
        }

        if (needNotes > 0) {
            System.out.println("Dispense " + needNotes + " x 500 Tk");
        }

        int remainingAmt = amount - (needNotes * 500);

        if (remainingAmt > 0) {
            if (nextHandler != null) {
                nextHandler.dispense(remainingAmt);
            } else {
                System.out.println("Remaining amount " + remainingAmt + " cannot withdraw!");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        IHandler thousandHandler = new ThousandHandler(10);  // 10 notes of 1000
        IHandler fiveHundredHandler = new FiveHundredHandler(20);  // 20 notes of 500

        thousandHandler.setNextHandler(fiveHundredHandler);

        int amt = 23000;

        System.out.println("Dispensing amount " + amt);
        thousandHandler.dispense(amt);
    }
}
