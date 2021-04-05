package com.magang.tokoelektronik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magang.tokoelektronik.domain.Toko;
import com.magang.tokoelektronik.repository.TokoRepository;

@Service
public class TokoService {
	
	@Autowired
	private TokoRepository repo;
	
	public List<Toko> listAll(){
		return repo.findAll();
	}
	public void save (Toko tk) {
		repo.save(tk);
	}
	public Toko get(long id) {
		return repo.findById(id).get();
	}
	public void delete(long id) {
		repo.deleteById(id);
	}

}
