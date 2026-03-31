package com.lpu.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.lpu.entity.Student;

public class demoTest {
	@Test
	public void demo1() {
		Assertions.assertEquals("xyz", "xyz");
	}
	@Test
	public void demo4() {
		Student s1 = new Student();
		//Student s2 = new Student();
		Assertions.assertSame(s1, s1);
	}
	@Test
	public void demo7() {
		int[] arr1 = {10,20};
		int[] arr2 = {10,20};
		Assertions.assertArrayEquals(arr1, arr2);
	}
	@ParameterizedTest
	@CsvSource({"2,3,5","10,20,30", "-1,1,9"})
	public void testAddition(int a, int b, int expected) {
		int res = a+b;
		Assertions.assertEquals(expected, res);
	}
}
