package com.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Override
	public Integer addLaptop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer addLaptops(boolean x) {
		if (x == false) {
			throw new IllegalArgumentException();
		}
		System.out.println("you must set the boolean to false to raise a simulated exception");
		return 0;
	}

	@Override
	public Integer getLaptop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer updateLaptop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer deleteLaptop() {
		// TODO Auto-generated method stub
		return 0;
	}

}
