package com.example.Dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.contractor.mapper.UserMapper;
import com.example.Contractor.RegistrationController;
import com.example.model.Login;
import com.example.model.SpecificationDetails;
import com.example.model.User;



@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {
	@Autowired
	 RegistrationController controller;
	@Autowired
	private JdbcTemplate jdbcTemplate;
		String user_id=controller.userid;	
	/*
	 * private final ResultSetExtractor<Tuple2<User, List<Role>>> resultSetExtractor
	 * = JdbcTemplateMapperFactory .newInstance() .addKeys("id") // the column name
	 * you expect the user id to be on .newResultSetExtractor(new
	 * TypeReference<Tuple2<User, List<Role>>> {});
	 */	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addUser(User user) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		int update = jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getDoB(),
				user.getGender(), user.getUserId(), user.getPassword(), user.getQuestionType(), user.getAnswer());
		System.out.println("hello"+update);
		if (update > 0) {
			return true;
		}
		return false;
	}

	
	
	
//	public List<User> findAll() {
//
//        String sql = "SELECT * FROM CUSTOMER";
//
//        List<User> customers = jdbcTemplate.query(
//                sql,
//                new BeanPropertyRowMapper(User.class));
//
//        return customers;
//    }

	/*
	 * @Override public List<User> findAll() { // TODO Auto-generated method stub
	 * String sql =
	 * "select user.user_id,user.first_name,user.last_name,user.dob,user.gender,specification.budget,specification.duration,specification.hours from user,specification where user.user_id=specification.user_id"
	 * ;
	 * 
	 * List<User> user = jdbcTemplate.query( sql,new
	 * BeanPropertyRowMapper(User.class)); //System.out.println(user.get(0)); return
	 * user;
	 * 
	 * }
	 */

@Override
public boolean userExist(Login login) {
	// TODO Auto-generated method stub
	if(login.getUserType().equals("User"))
	{	
	String sql="select * from user where user_id=? and password=?";
	User user=(User)jdbcTemplate.queryForObject(sql,new UserMapper(),login.getUserId(),login.getPassword());
	if(user==null)
		return false;
	return true;
	}
	else
	{
		String sql="select * from admin where user_id=? and password=?";
		User user=(User)jdbcTemplate.queryForObject(sql,new Object[] {login.getUserId(),login.getPassword()},new BeanPropertyRowMapper<User>(User.class));
		System.out.println(user);
		if(user==null)
			return false;
		return true;
	}
		
		
	
}

@Override
public boolean enterSpecification(SpecificationDetails specificationDetails) {
	// TODO Auto-generated method stub
	String sql = "insert into specification values(?,?,?,?)";
	int update = jdbcTemplate.update(sql,specificationDetails.getBudget(),specificationDetails.getDuration(),specificationDetails.getHours(),specificationDetails.getUserid());
	if(update>0)
		return true;
	return false;
}

@Override
public boolean checkInbox(String user_id) {
	// TODO Auto-generated method stub
	
	int count = jdbcTemplate.queryForObject("select count(*) from specification where user_id='"+user_id+"' and budget>0",Integer.class);
	if(count>0)
		return true;
	return false;
}

@Override
public List<Map<String,Object>> showDetails()
{
	List<String> l=new ArrayList<String>();
	String sql="select user.user_id,first_name,last_name,dob,gender,budget,duration,hours from user,specification where user.user_id=specification.user_id";
	

		List<Map<String, Object>> rows=jdbcTemplate.queryForList(sql);
	
	//System.out.println(rows);
	return rows;
}

@Override
public User checkQuestionAnswer(String userid, String questionType, String answer) {
	String sql="select * from user where user_id=? and security_question=? and answer=?";
	User user=new User();
	try{
		 user=(User) jdbcTemplate.queryForObject(sql,new UserMapper(),userid,questionType,answer);
		 System.out.println(user);
		 return user;
	}
	catch (Exception e) {
		System.out.println(e);
		user=null;
		return user;
	}
	
}

@Override
public void updatePassword(String userid,String password) {
	
	String sql="update user set password='"+password+"' where user_id=?";
	User user=new User();
	try {
	user=(User)jdbcTemplate.queryForObject(sql,new UserMapper(),userid);
	}
	catch(Exception e)
	{
	System.out.println(e);
}
}
@Override
public boolean checkPassword(String newpassword, String repassword) {
	if(newpassword.equals(repassword))
	{
		System.out.println(user_id);
		updatePassword(user_id, newpassword);
	return true;
	}
	else
	{
		return false;
	}
}

@Override
public  List<String> getMessages(String userid) {
	List<String> message=new ArrayList<>();
	List<Map<String, Object>> l=new ArrayList<Map<String, Object>>();
	String sql="select message from inbox where user_id='"+userid+"'";
	try {
		l=jdbcTemplate.queryForList(sql);
		for(Map<String,Object> map:l)
		{
			for(String key:map.keySet())
			{
				message.add((String)map.get(key));
			}
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
	return message;
}


}
