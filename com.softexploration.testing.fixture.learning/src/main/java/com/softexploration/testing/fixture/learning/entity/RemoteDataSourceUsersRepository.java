package com.softexploration.testing.fixture.learning.entity;

import java.util.Arrays;
import java.util.List;

public class RemoteDataSourceUsersRepository implements UsersRepository {

	@Override
	public List<String> getAccounts() {
		return Arrays.asList(new String[] { "a", "b", "c", "d", "e" });
	}

}
