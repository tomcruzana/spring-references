package com.dev.springdata.ps.daos;

import com.dev.springdata.ps.entities.Laptop;

public interface LaptopDao {
	public boolean addLaptop(Laptop laptop);

	public boolean getLaptop(int id);

	public boolean updateLaptop(int id, String brand, String name, String model, String serial, int quantity, double price);

	public boolean deleteLaptop(int id);

}
