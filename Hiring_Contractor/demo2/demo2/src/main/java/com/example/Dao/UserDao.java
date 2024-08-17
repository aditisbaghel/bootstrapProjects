package com.example.Dao;




import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.model.Login;
import com.example.model.SpecificationDetails;
import com.example.model.User;


@Component
public interface UserDao {
	
	public boolean addUser(User user);
	
	public boolean userExist(Login login);
	
	//public List<User> findAll();
	
	public boolean enterSpecification(SpecificationDetails specificationDetails);
	
	public boolean checkInbox(String user_id);
	
	public List<Map<String,Object>> showDetails();
	
	public User checkQuestionAnswer(String userid,String questionType,String answer);
	
	public void updatePassword(String userid,String password);
	
	public boolean checkPassword(String newpassword,String repassword);
	
	public List<String> getMessages(String userid);
	
}
