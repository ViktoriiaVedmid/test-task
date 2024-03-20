package tasks;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TaskLongestString {

    public ArrayList<String> createListOfStrings(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Volvo");
        list.add("BMW");
        list.add("Mazda");
        list.add("Ford");
        return list;
    }

    public ArrayList<String> getLongestWord(){
        ArrayList<String> sortedCollection = (ArrayList<String>) createListOfStrings().stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        Collections.reverse(sortedCollection);

        ArrayList<String> longestNames = new ArrayList<>();
        int longestLength = sortedCollection.get(0).length();

        for (String name : sortedCollection) {
            if(name.length() == longestLength) {
                longestNames.add(name);
            }
        }
        return longestNames;
    }

    @Test
    public void testSolution() {
        System.out.println("Longest strings from list:");
        getLongestWord().forEach(name -> System.out.println(name));
    }
}
