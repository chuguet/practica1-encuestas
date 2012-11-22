package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.IModelTable;

public interface IModelService<T extends IModelTable> {

	void save(T t);

	void update(T t);

	void delete(T t);

	T findOne(Long pId);

	List<T> findAll();
}
