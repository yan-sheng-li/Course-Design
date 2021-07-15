package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import frame.Books_panel;
import jdbc.ConnectionManager;

public class Books_panelTest {

	@Test
	public void testGetItems() throws SQLException {
		int n=Books_panel.getItems("select * from book_stack;");
		System.out.println(n);
	
	}

}
