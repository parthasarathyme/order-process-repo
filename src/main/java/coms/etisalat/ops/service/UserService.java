package coms.etisalat.ops.service;

import java.util.List;

import coms.etisalat.ops.domain.User;
import coms.etisalat.ops.exception.UserException;

public interface UserService {
	public abstract Integer addNewUser(User user) throws UserException;
	public abstract User getUserDetails(Integer userId) throws UserException;
	public abstract User getUserDetails(String userName, String password) throws UserException;
	public abstract List<User> getAllUsers() throws UserException;
}
