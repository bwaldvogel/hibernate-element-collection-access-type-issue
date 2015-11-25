package de.bwaldvogel.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Tag {

	@Column(nullable = false)
	private String value;

	public Tag() {}

	public Tag(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Tag tag = (Tag) o;

		return !(value != null ? !value.equals(tag.value) : tag.value != null);

	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}
