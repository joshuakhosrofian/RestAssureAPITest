package commons;

public class Printer {

    private String objectID = "";

    public Printer(String owner){
        objectID = owner;
    }

    public Printer printGreeting(){
        System.out.println("printGreeting: Namaste!");
        return this;
    }

    public Printer printFavoriteNum() {
        System.out.println("printFavoriteNum: My favorite Number is 10");
        return this;
    }

    public Printer printColor() {
        System.out.println("printColor: Blue");
        return this;
    }
}
