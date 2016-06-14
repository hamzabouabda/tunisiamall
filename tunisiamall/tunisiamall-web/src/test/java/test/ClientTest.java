package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import delegate.ClientManagementDelegate;
import entities.Client;

public class ClientTest {

	private ClientManagementDelegate clientDelegate;
	
	
	@Before
	public void setUp() throws Exception {
		
		clientDelegate=new ClientManagementDelegate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testdoAddClient() {
		Client c =new Client();
		c.setNom("boukchim");
		c.setPrenom("amine");
		c.setSexe("M");
		c.setLogin("aaa");
		c.setMdp("zaza");
		clientDelegate.doAddCar(c);
	}

}
