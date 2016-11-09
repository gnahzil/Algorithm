package com.ibm.ram.ary;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
	
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
	
	public DogCatQueue() {
		dogQ = new LinkedList<PetEnterQueue>();
		catQ = new LinkedList<PetEnterQueue>();
	}

}


