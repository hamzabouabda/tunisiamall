package delegate;

import java.util.List;

import entities.Client;
import services.ClientManagementRemote;
import locator.ServiceLocator;

public class ClientManagementDelegate {

	public static final String jndiName = "/tunisiamall-ear/tunisiamall-ejb/ClientManagement!services.ClientManagementRemote";
	
	public static ClientManagementRemote getProxy(){
		return (ClientManagementRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	
	public static Boolean doAddCar(Client c){
		return getProxy().addClient(c);
	}
	
	
	
	
	
}
