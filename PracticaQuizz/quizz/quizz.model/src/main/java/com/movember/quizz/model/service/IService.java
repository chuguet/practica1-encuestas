package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.AbstractBean;

public interface IService<T extends AbstractBean> {

	void insert(T t);

	void update(T t);

	void delete(T t);

	T retrieve(Integer id);

	List<T> selectAll();
}
