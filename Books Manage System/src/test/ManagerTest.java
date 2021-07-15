package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Manager;

public class ManagerTest {

	@Test
	public void test() {
		Manager manager=new Manager("323", "dfdf");
		System.out.println(manager.toString());
	}
	@Test
	public void t1() {
		String s1="root";
		String s2="root";
		System.out.println(s1.equals(s2));
	}

}
