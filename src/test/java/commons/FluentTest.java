package commons;

import org.testng.annotations.Test;

public class FluentTest {

    @Test
    public void practice_fluent() {

        Printer nijat = new Printer("nijat");
        Printer fawad = new Printer("fawad");

        nijat.printGreeting()
                .printFavoriteNum()
                .printColor();

        fawad.printGreeting()
                .printFavoriteNum()
                .printColor();
    }
}
