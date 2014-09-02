package com.softexploration.testing.fixture.learning.boundary;

import org.apache.log4j.Logger;

import com.softexploration.testing.fixture.execution.FixtureExecutionContext;
import com.softexploration.testing.fixture.learning.entity.LocalDataSourceUsersRepository;
import com.softexploration.testing.fixture.learning.entity.RemoteDataSourceUsersRepository;
import com.softexploration.testing.fixture.suite.FixtureSuite;
import com.softexploration.testing.fixture.suite.RegistrantsFixtureSuite;

public class AccountsServiceFixtureSuite {

	public static final String REMOTE_DATASOURCE = "REMOTE_DATASOURCE";
	public static final String LOCAL_DATASOURCE = "LOCAL_DATASOURCE";

	private static final Logger LOG = Logger.getLogger(AccountsServiceFixtureSuite.class);

	public FixtureSuite createFixtureSuite() {
		RegistrantsFixtureSuite fixtureSuite = new RegistrantsFixtureSuite();
		fixtureSuite.registerFixture(REMOTE_DATASOURCE, this::initRemoteDS, this::cleanRemoteDS);
		fixtureSuite.registerFixture(LOCAL_DATASOURCE, this::initLocalDS, this::cleanLocalDS);
		return fixtureSuite;
	}

	void initRemoteDS(final FixtureExecutionContext context) {
		LOG.debug("initRemoteDS");
		context.setBeforeTestFixtureResult(new RemoteDataSourceUsersRepository());
	}

	void cleanRemoteDS(final FixtureExecutionContext context) {
		LOG.debug("cleanRemoteDS");
	}

	void initLocalDS(final FixtureExecutionContext context) {
		LOG.debug("initLocalDS");
		context.setBeforeTestFixtureResult(new LocalDataSourceUsersRepository());
	}

	void cleanLocalDS(final FixtureExecutionContext context) {
		LOG.debug("cleanLocalDS");
	}

}
