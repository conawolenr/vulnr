package com.newrelic.restservice;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Greeting {

	private @Id @GeneratedValue Long id;
	private String content;

	Greeting() {}

	Greeting(Long id, String content) {
        this.id = id;
		this.content = content;
	}

	public Long getId() {
		return this.id;
	}

	public String getContent() {
		return this.content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Greeting))
			return false;
		Greeting employee = (Greeting) o;
		return Objects.equals(this.id, employee.id) && Objects.equals(this.content, employee.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.content);
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + this.id + ", name='" + this.content + '\'' + '}';
	}
}
