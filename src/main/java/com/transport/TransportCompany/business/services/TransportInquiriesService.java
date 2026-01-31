package com.transport.TransportCompany.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transport.TransportCompany.persistence.entities.TransportInquiry;
import com.transport.TransportCompany.persistence.repositiories.TransportInquiriesRepository;

@Service
public class TransportInquiriesService implements IService<TransportInquiry>{

	@Autowired
	private TransportInquiriesRepository transportInquiriesRepo;

	@Override
	public List<TransportInquiry> GetAll() {
		return transportInquiriesRepo.findAll();
	}

	@Override
	public TransportInquiry GetById(Long id) {
		Optional<TransportInquiry> res = transportInquiriesRepo.findById(id);
		if (res.isPresent())
			return res.get();
		return null;
	}

	public TransportInquiry Create(TransportInquiry transportInquiry) {
		return transportInquiriesRepo.save(transportInquiry);
	}

	public void Delete(TransportInquiry transportInquiry) {
		transportInquiriesRepo.delete(transportInquiry);
	}
}
