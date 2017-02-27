package com.webhoseio.sdk.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entities {

	@SerializedName("persons")
	@Expose
	private List<Person> persons = null;
	@SerializedName("organizations")
	@Expose
	private List<Organization> organizations = null;
	@SerializedName("locations")
	@Expose
	private List<Location> locations = null;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
}
