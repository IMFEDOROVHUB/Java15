import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Питер", "Москва", 2000, 16, 18);
    Ticket ticket2 = new Ticket("Сочи", "Москва", 4000, 12, 14);
    Ticket ticket3 = new Ticket("Египет", "Барнаул", 6000, 6, 11);
    Ticket ticket4 = new Ticket("Клин", "Нижний Новгород", 4500, 3, 10);
    Ticket ticket5 = new Ticket("Астрахань", "Барнаул", 7500, 10, 13);
    Ticket ticket6 = new Ticket("Египет", "Барнаул", 6500, 10, 15);
    Ticket ticket7 = new Ticket("Египет", "Барнаул", 4500, 9, 16);
    Ticket ticket8 = new Ticket("Египет", "Барнаул", 1500, 1, 12);


    @Test
    public void testCompareTo() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

        int expectedMore = 1;
        int actualMore = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expectedMore, actualMore);

        int expectedEquals = 0;
        int actualEquals = ticket4.compareTo(ticket7);

        Assertions.assertEquals(expectedEquals, actualEquals);
    }

    @Test
    public void searchSortPrice() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {ticket8, ticket7, ticket3, ticket6};
        Ticket[] actual = aviaSouls.search("Египет", "Барнаул");

        Assertions.assertArrayEquals(expected, actual);

        Ticket[] expectedOne = {ticket4};
        Ticket[] actualOne = aviaSouls.search("Клин", "Нижний Новгород");

        Assertions.assertArrayEquals(expectedOne, actualOne);

        Ticket[] expectedNothing = {};
        Ticket[] actualNothing = aviaSouls.search("Клин", "Владивосток");

        Assertions.assertArrayEquals(expectedNothing, actualNothing);
    }

    @Test
    public void searchFlightTime() {
        AviaSouls aviaSouls = new AviaSouls();

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        int expected = -1;
        int actual = timeComparator.compare(ticket3, ticket4);

        Assertions.assertEquals(expected, actual);

        int expectedMore = 1;
        int actualMore = timeComparator.compare(ticket4, ticket5);

        Assertions.assertEquals(expectedMore, actualMore);

        int expectedEquals = 0;
        int actualEquals = timeComparator.compare(ticket3, ticket6);

        Assertions.assertEquals(expectedEquals, actualEquals);

    }

    @Test
    public void searchAndSortByComparator() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] expected = {ticket3, ticket6, ticket7, ticket8};
        Ticket[] actual = aviaSouls.searchAndSortBy("Египет", "Барнаул", comparator);

        Assertions.assertArrayEquals(expected, actual);

        Ticket[] expectedOne = {ticket4};
        Ticket[] actualOne = aviaSouls.searchAndSortBy("Клин", "Нижний Новгород", comparator);

        Assertions.assertArrayEquals(expectedOne, actualOne);

        Ticket[] expectedNothing = {};
        Ticket[] actualNothing = aviaSouls.searchAndSortBy("Клин", "Владивосток", comparator);

        Assertions.assertArrayEquals(expectedNothing, actualNothing);
    }
}

