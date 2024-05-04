package JavaQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RemoveDuplicates {
  public static void main(String[] args) {

    // create an arraylist from the array
    // using asList() method of the Arrays class
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 3));
    System.out.println("ArrayList with duplicate elements: " + numbers);

    // create a stream from arraylist
    Stream<Integer> stream = numbers.stream();

    // call the distinct() of Stream
    // to remove duplicate elements
    stream = stream.distinct();

    // convert the stream to arraylist
    numbers = (ArrayList<Integer>)stream.collect(Collectors.toList());
    System.out.println("ArrayList without duplicate elements: " + numbers);

  }
}
