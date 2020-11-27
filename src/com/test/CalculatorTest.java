package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.customanotaions.TestOnMac;
import com.java.Calculator;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	Calculator calc;
	
	@BeforeEach
	public void setUp() {
	calc = new 	Calculator();
	}
	
	@Test
	@DisplayName("Addition function")
	@Order(1)
	@EnabledOnOs(OS.MAC)
	public void addTest() {
		int result = calc.add(4, 6);
		assertEquals(10, result);
		System.out.println("Current job 1: " + this);
	}
	
	@Test
	@DisplayName("Subtraction function")
	@Order(2)
	public void subTest() {
		int result = calc.sub(10, 5);
		assertEquals(5, result);
		System.out.println("Current job 2: " + this);
	}
	
	@Test
	@DisplayName("Multiplication function")
	@Order(3)
	public void multiTest() {
		int result = calc.multi(2, 5);
		assertEquals(10, result);
		System.out.println("Current job 3: " + this);
	}
	
	@Test
	@DisplayName("Divison function")
	@Order(4)
	public void divTest() {
		int result = calc.div(10, 5);
		assertEquals(2, result);
		System.out.println("Current job 4: " + this);
	}
	
	@Test
	@DisplayName("Divison throws error function")
	@Order(5)
	public void divthrowTest() {
		assertThrows(ArithmeticException.class, ()-> calc.div(5, 0));
		System.out.println("Current job 5: " + this);
	}

	
	@Test
	@DisplayName("Mod function")
	@Order(6)
	public void modTest() {
		int result = calc.mod(10, 5);
		assertEquals(0, result);
		System.out.println("Current job 6: " + this);
	}
	
	
	

	@Nested
	class NestedClasss{
		
		@Test
		@DisplayName("Nested class function")
		@Order(7)
		public void empty_method() {
			
		}
		
		@ParameterizedTest(name ="Parameterised Test cases {0}")
		@ValueSource(strings = {"apple","orange","grapes"})
		public void readData(String input) {
			System.out.println("Input read from value sources is " + input);
		}
	}
	
	
	static class  NestedStaticClasss{
		
		@Test
		@DisplayName("Nested static class function")
		@Order(8)
		public void empty_method() {
			
		}
	}
	
	
	@DisplayName("Addition function")
	@Order(9)
	@TestOnMac
	public void addTestc() {
		int result = calc.add(4, 6);
		assertEquals(10, result);
		System.out.println("Current job 1: " + this);
	}
}
