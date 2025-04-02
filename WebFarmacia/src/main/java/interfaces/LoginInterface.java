package interfaces;

import entidades.User;

public interface LoginInterface {
	
	void registerUser(User user) throws Exception;
	    
	User loginUser(String email, String password) throws Exception;
}
