package com.movember.quizz.model.service;

import java.util.List;
import com.movember.quizz.model.bean.AbstractBean;
import com.movember.quizz.model.exception.AppException;

public interface IService<T extends AbstractBean> {

	void insert(T t) throws AppException;

	void update(T t) throws AppException;

	void delete(T t) throws AppException;

	T retrieve(Integer id) throws AppException;

	List<T> selectAll() throws AppException;
}
