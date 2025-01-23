import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Питер", "Москва", 2000, 16, 18);
    Ticket ticket2 = new Ticket("Сочи", "Москва", 4000, 12, 14);
    Ticket ticket3 = new Ticket("Египет", "Барнаул", 6000, 6, 11);

    @Test
    public void compareTo(){
    Ticket ticket = new Ticket();

    ticket1.getPrice();
    ticket2.getPrice();

    Ticket[] tickets = {ticket1, ticket2};

    Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = ticket.compareTo(tickets);


    }

}
