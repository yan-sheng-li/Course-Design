package test;

import static org.junit.Assert.*;

import org.junit.Test;

import jdbc.ConnectionManager;

public class ConnectionManagerTest {

	@Test
	public void testTimeString() {
		
		String string=ConnectionManager.getday();
		System.out.println(string);
		
	}

}
