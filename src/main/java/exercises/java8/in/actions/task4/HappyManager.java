package exercises.java8.in.actions.task4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HappyManager {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(brian, 2012, 1000),
                new Transaction(mario, 2010, 150),
                new Transaction(raoul, 2013, 710),
                new Transaction(brian, 2015, 110),
                new Transaction(alan, 2016, 5000),
                new Transaction(mario, 2012, 300)
        );


        /*Find all transactions in the year 2011 and sort them by value (s->h)*/
        List<Transaction> findAndSortTransactions = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        /*What are the all unique cities where traders work?*/
        List<String> allUniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());

        /*Find all traders from Cambridge and sort them by name*/
        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        /*Return a string of all traders names sorted alphabetically*/
        String tradersSortedNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());

        /*Are any traders based in Milan?*/
        Boolean isAnyoneHasInMilan = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .anyMatch("Milan"::equals);

        /*Print all transactions' values from the traders living in Cambridge*/
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        /*What is highest value of all transactions?*/
        Optional<Integer> highestTransaction = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        /*Find the transaction with the smallest value*/
        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((value1, value2) -> (value1.getValue() < value2.getValue()) ? value1 : value2);

        Optional<Transaction> smallestTransactionModified = transactions.stream()
                .min(comparing(Transaction::getValue));
    }
}
