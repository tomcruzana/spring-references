package com.dev.springdata.hibernateinheritance.entity;

import javax.persistence.Entity;

@Entity
public class Humanoid extends Person {
	private int hp;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	
}
