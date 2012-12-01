package com.movember.quizz.model.dao;

import java.sql.SQLException;
import java.util.List;
import com.movember.quizz.model.bean.AbstractBean;

public interface IRepositoryDAO<T extends AbstractBean> {

	void insert(T t) throws SQLException;

	void update(T t) throws SQLException;

	void delete(Integer id) throws SQLException;

	T retrieve(Integer id) throws SQLException;

	List<T> selectAll() throws SQLException;

	List<T> selectByCriterios() throws SQLException;
}
