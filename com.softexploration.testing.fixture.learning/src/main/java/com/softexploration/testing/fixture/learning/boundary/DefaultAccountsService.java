package com.softexploration.testing.fixture.learning.boundary;

import java.util.List;

import com.softexploration.testing.fixture.learning.entity.UsersRepository;

public class DefaultAccountsService implements AccountsService {

	private UsersRepository usersRepository;

	public void setUsersRepository(final UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public List<String> getAccounts() {
		return usersRepository.getAccounts();
	}

}
