package com.transport.TransportCompany.business.services;

import java.math.BigInteger;
import java.util.List;

public interface IService<T> {
	List<T> GetAll();
	T GetById(BigInteger id);
}
