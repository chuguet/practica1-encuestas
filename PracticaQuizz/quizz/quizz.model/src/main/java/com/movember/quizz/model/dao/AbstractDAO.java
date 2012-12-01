package com.movember.quizz.model.dao;

import javax.inject.Inject;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.ibatis.sqlmap.client.SqlMapClient;

public abstract class AbstractDAO {

	private static final long serialVersionUID = 1L;

	@Inject
	private DataSourceTransactionManager transactionManager;

	@Inject
	private SqlMapClient sqlMapClient;

	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public SqlMapClient getSqlMapClient() {
		return this.sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
}