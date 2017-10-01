package io.squirrelsociety.robotcureuil.objects;

import java.util.ArrayList;

import net.dv8tion.jda.core.entities.User;

public class Parti {
	
	public String name;
	public String position;
	public User president;
	ArrayList<User> members = new ArrayList<User>();
	
	public Parti(String name, String position, User president) {
		this.name = name;
		this.position = position;
		this.president = president;
	}
	
	public void registerMember(User member) {
		members.add(member);
	}

}
