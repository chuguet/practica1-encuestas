package com.movember.quizz.model.repository;

import java.util.List;
import com.movember.quizz.model.bean.IModelTable;

public interface IRepositoryDAO<T extends IModelTable> {

	void save(T t);

	void update(T t);

	void delete(T t);

	T findOne(Long pId);

	List<T> findAll();
}
