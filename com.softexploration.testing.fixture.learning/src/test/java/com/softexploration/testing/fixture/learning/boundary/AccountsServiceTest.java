package com.softexploration.testing.fixture.learning.boundary;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.softexploration.testing.fixture.Fixture;
import com.softexploration.testing.fixture.FixtureRule;
import com.softexploration.testing.fixture.learning.boundary.AccountsService;
import com.softexploration.testing.fixture.learning.boundary.DefaultAccountsService;
import com.softexploration.testing.fixture.learning.entity.UsersRepository;
import com.softexploration.testing.fixture.suite.FixtureSuite;

public class AccountsServiceTest {

	static FixtureSuite fixtureSuite = new AccountsServiceFixtureSuite().createFixtureSuite();

	@Rule
	public FixtureRule fixtureRule = new FixtureRule(fixtureSuite);

	@Test
	@Fixture(AccountsServiceFixtureSuite.REMOTE_DATASOURCE)
	public void testServiceWithRemoteDatasource() {
		List<String> accounts = getService().getAccounts();
		Assert.assertEquals("e", accounts.get(4));
	}

	@Test
	@Fixture(AccountsServiceFixtureSuite.LOCAL_DATASOURCE)
	public void testServiceWithLocalDatasource() {
		List<String> accounts = getService().getAccounts();
		Assert.assertEquals("c", accounts.get(2));
	}

	AccountsService getService() {
		DefaultAccountsService simpleService = new DefaultAccountsService();
		simpleService.setUsersRepository(fixtureRule.getBeforeTestFixtureResult(UsersRepository.class));
		return simpleService;
	}

}
