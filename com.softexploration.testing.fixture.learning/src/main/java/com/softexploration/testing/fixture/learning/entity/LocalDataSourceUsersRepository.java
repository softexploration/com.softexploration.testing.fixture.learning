package com.softexploration.testing.fixture.learning.entity;

import java.util.Arrays;
import java.util.List;

public class LocalDataSourceUsersRepository implements UsersRepository {

	@Override
	public List<String> getAccounts() {
		return Arrays.asList(new String[] { "a", "b", "c" });
	}

}
