/**
 * File Name: PropProject.java<br>
 * LastName, FirstName<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Oct 10, 2015
 */
package com.sqa.ao.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropProject //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 */
public class PropProject {

	private String address;

	private int age;

	private String city;

	private String job;

	private String name;

	private Properties props;

	/**
	 * Method that changes values of current instance and the Properties object
	 */
	public void changeValues() {
		// Change the value of the current instance's name variable to "Mr.
		// Bananas"
		this.setName("Mr. Bananas");
		// Set the Property of the Properties object for key "name" to
		// <current-name of instance>, "Mr. Bananas"
		this.props.setProperty("name", this.getName());
	}

	/**
	 * Method that loads the Properties object from the text file and set
	 * instance field values based on them
	 */
	public void demoLoad() {
		// Create a new instance of the Properties class
		this.props = new Properties();
		// Surround with try catch for error handling of file not being present
		// and if an IO due to bad connection occur
		try {
			// Use a FileInputStream and set it to the location of the file
			// "my-properties.prop"
			// This may cause a FileNotFoundException
			FileInputStream fis = new FileInputStream("my-properties.prop");
			// Load the properties of the text file into the Properties object
			// This may cause IOException due to connection errors
			this.props.load(fis);
			// Set the name of current instance to the Properties object's value
			this.setName(this.props.getProperty("name"));
			// Set the age of current instance to the Properties object's value,
			// also Parse it to int
			this.setAge(Integer.parseInt(this.props.getProperty("age")));
			// Set the city of current instance to the Properties object's value
			this.setCity(this.props.getProperty("city"));
			// Set the address of current instance to the Properties object's
			// value
			this.setAddress(this.props.getProperty("address"));
			// Set the job of current instance to the Properties object's value
			this.setJob(this.props.getProperty("job"));
		} catch (FileNotFoundException e) {
			// Handle file not found exception scenario
			e.printStackTrace();
		} catch (IOException e) {
			// Handle IO exception scenario
			e.printStackTrace();
		}
	}

	/**
	 * Method that demo the store or save operation of converting the Properties
	 * ojbect to a text file
	 */
	public void demoSave() {
		try {
			// Create a FileOutputStream and set it to location where you want
			// to save the converted Properties object to
			// This may cause a FileNotFoundException
			FileOutputStream fos = new FileOutputStream("saved-properties.prop");
			// Save the properties object to the converted text file specified
			// in FileOutputStream, second param is first line in file text,
			// heading
			// This may cause an IOException
			this.props.store(fos, "My Properties File: " + this.getName());
		} catch (FileNotFoundException e) {
			// Handle file not found exception scenario
			e.printStackTrace();
		} catch (IOException e) {
			// Handle IO exception scenario
			e.printStackTrace();
		}
	}

	/**
	 * Method that displays the current instance variable values by calling the
	 * toString() method of itself to console
	 */
	public void display() {
		System.out.println(this);
	}

	public String getAddress() {
		return this.address;
	}

	public int getAge() {
		return this.age;
	}

	public String getCity() {
		return this.city;
	}

	public String getJob() {
		return this.job;
	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method that overrides the toString using the StringBuilder class
	 * Generated using the Source > Generate to toString() option and selecting
	 * a different template
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropProject [address=");
		builder.append(this.address);
		builder.append(", age=");
		builder.append(this.age);
		builder.append(", city=");
		builder.append(this.city);
		builder.append(", job=");
		builder.append(this.job);
		builder.append(", name=");
		builder.append(this.name);
		builder.append("]");
		return builder.toString();
	}
}
