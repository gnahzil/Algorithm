package com.ibm.ram.ary;

import java.util.LinkedList;
import java.util.Queue;

public class Issue4 {
	
	public class Pet {
		private String type;
		public Pet(String type) {
			this.type = type;
		}
		public String getPetType() {
			return this.type;
		}
	}

	public class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}

	public class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}

	public class PetEnterQueue {
		private Pet pet;
		private int count;
		
		public PetEnterQueue(Pet pet, int count) {
			this.pet = pet;
			this.count = count;
		}
		
		public Pet getPet() {
			return this.pet;
		}
		
		public int getCount() {
			return this.count;
		}
		
		public String getEnterPetType() {
			return this.pet.getPetType();
		}
	}
	
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private int count;
	
	public Issue4() {
		this.dogQ = new LinkedList<PetEnterQueue>();
		this.catQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}
	
	public void add(Pet pet) {
		if ("dog".equals(pet.getPetType())) {
			dogQ.add(new PetEnterQueue(pet, count++));
		} else if ("cat".equals(pet.getPetType())) {
			catQ.add(new PetEnterQueue(pet, count++));
		} else {
			throw new RuntimeException("Your object is not dog or cat");
		}
	}
	
	public Pet pollAll() {
		if (!dogQ.isEmpty() && !catQ.isEmpty()) {
			if (dogQ.peek().getCount() < catQ.peek().getCount()) {
				return dogQ.poll().getPet();
			} else {
				return catQ.poll().getPet();
			}
		} else if (!dogQ.isEmpty()) {
			return dogQ.poll().getPet();
		} else if (!catQ.isEmpty()) {
			return catQ.poll().getPet();
		} else {
			throw new RuntimeException("queue is empty");
		}
	}
	
	public Dog pollDog() {
		if (!dogQ.isEmpty()) {
			return (Dog)dogQ.poll().getPet();
		} else {
			throw new RuntimeException("dog queue is empty");
		}
	}
	
	public Cat pollCat() {
		if (!catQ.isEmpty()) {
			return (Cat)catQ.poll().getPet();
		} else {
			throw new RuntimeException("cat queue is empty");
		}
	}
	
	public boolean isEmpty() {
		return dogQ.isEmpty() && catQ.isEmpty();
	}
	
	public boolean isDogQueueEmpty() {
		return dogQ.isEmpty();
	}
	
	public boolean isCatQueueEmpty() {
		return catQ.isEmpty();
	}
}


