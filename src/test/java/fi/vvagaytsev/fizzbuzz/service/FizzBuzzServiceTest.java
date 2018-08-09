package fi.vvagaytsev.fizzbuzz.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

/**
 * @author Vladimir Vagaytsev
 * Date: 09/08/2018
 */
public class FizzBuzzServiceTest {

    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();
    private final Random random = new Random();

    @Test
    public void testFirst15Numbers() {
        List<Long> numbers = LongStream.rangeClosed(1, 15).boxed().collect(Collectors.toList());
        List<String> expected = Arrays.asList(
                "1", "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz"
        );
        List<String> actual = fizzBuzzService.fizzBuzzify(numbers);

        assertEquals(expected, actual);
    }

    @Test
    public void testRandomFizz() {
        long randomFizz = 3 * nextPositiveRandom();
        while (randomFizz % 5 == 0) {
            randomFizz = randomFizz / 5;
        }

        List<Long> fizzNumbers = Collections.singletonList(randomFizz);
        List<String> actual = fizzBuzzService.fizzBuzzify(fizzNumbers);
        List<String> expected = Collections.singletonList("Fizz");

        assertEquals(expected, actual);
    }

    @Test
    public void testRandomBuzz() {
        long randomBuzz = 5 * nextPositiveRandom();
        while (randomBuzz % 3 == 0) {
            randomBuzz = randomBuzz / 3;
        }

        List<Long> buzzNumbers = Collections.singletonList(randomBuzz);
        List<String> actual = fizzBuzzService.fizzBuzzify(buzzNumbers);
        List<String> expected = Collections.singletonList("Buzz");

        assertEquals(expected, actual);
    }

    @Test
    public void testRandomFizzBuzz() {
        long randomFizzBuzz = 15 * nextPositiveRandom();
        List<Long> fizzBuzzNumbers = Collections.singletonList(randomFizzBuzz);
        List<String> actual = fizzBuzzService.fizzBuzzify(fizzBuzzNumbers);
        List<String> expected = Collections.singletonList("FizzBuzz");

        assertEquals(expected, actual);
    }

    private int nextPositiveRandom() {
        return 1 + random.nextInt(100);
    }
}