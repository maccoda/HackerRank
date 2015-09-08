package algorithmstest;

import org.junit.Test;

import algorithms.SherlockAndTheBeast;

public class SherlockAndTheBeast_Test {

    @Test
    public void testSherlockAndBeast() {
        assert (SherlockAndTheBeast.sherlockSolvesIt(1).equalsIgnoreCase("-1"));
        assert (SherlockAndTheBeast.sherlockSolvesIt(3).equalsIgnoreCase("555"));
        assert (SherlockAndTheBeast.sherlockSolvesIt(5).equalsIgnoreCase("333"));
        assert (SherlockAndTheBeast.sherlockSolvesIt(3).equalsIgnoreCase("555"));
        assert (SherlockAndTheBeast.sherlockSolvesIt(11)
                .equalsIgnoreCase("55555533333"));
    }
}
