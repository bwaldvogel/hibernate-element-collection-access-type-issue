package de.bwaldvogel.hibernate;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// with AccessType.PROPERTY Hibernate does not honor the @Column annotation of Tag.value.
	@Access(AccessType.PROPERTY)
	private Long id;

	@ElementCollection
	private Set<Tag> tags = new LinkedHashSet<Tag>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}
}
