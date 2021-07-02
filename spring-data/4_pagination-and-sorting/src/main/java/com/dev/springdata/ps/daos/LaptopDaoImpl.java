package com.dev.springdata.ps.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dev.springdata.ps.entities.Laptop;
import com.dev.springdata.ps.repositories.LaptopRepository;

@Repository
public class LaptopDaoImpl implements LaptopDao {

	@Autowired
	LaptopRepository laptopRepo;

	@Override
	public boolean addLaptop(Laptop laptop) {
		laptopRepo.save(laptop);
		return true;
	}

	@Override
	public boolean getLaptop(int id) {
		List<Laptop> laptop = laptopRepo.findById(id);
		laptop.forEach((l) -> System.out.println(l));
		return true;
	}

	@Override
	public boolean updateLaptop(int id, String brand, String name, String model, String serial, int quantity,
			double price) {
		List<Laptop> laptopList = laptopRepo.findById(id);
		Laptop laptop = laptopList.get(0); // crap code
		laptop.setName(name);
		laptop.setBrand(brand);
		laptop.setSerial(serial);
		laptop.setQuantity(quantity);
		laptop.setPrice(price);
		laptopRepo.save(laptop);
		return true;
	}

	@Override
	public boolean deleteLaptop(int id) {
		laptopRepo.deleteById(id);
		return true;
	}

}
