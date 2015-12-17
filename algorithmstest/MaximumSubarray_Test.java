package algorithmstest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import algorithms.dynamicprog.MaximumSubarray;

public class MaximumSubarray_Test {

	@Test
	public void testMax() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		assertTrue(MaximumSubarray.findMax(list).equals("1 1"));
		list = new ArrayList<Integer>();
		list.add(-1);
		list.add(-2);
		list.add(-3);
		list.add(-4);
		list.add(-5);
		list.add(-6);
		assertTrue(MaximumSubarray.findMax(list).equals("-1 -1"));
	}
}
