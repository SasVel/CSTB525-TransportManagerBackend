package com.transport.TransportCompany.business.services;

import java.util.List;

public interface IService<T> {
	List<T> GetAll();
	T GetById(Long id);

}
