package de.bwaldvogel.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EventTest {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceUnit");

	private EntityManager entityManager;

	@Before
	public void setUp() {
		entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
	}

	@Test
	public void testPersistValidTag() {
		entityManager.getTransaction().begin();

		Event event = new Event();
		Tag tag = new Tag("some-value");
		event.addTag(tag);

		entityManager.persist(event);
		entityManager.getTransaction().commit();
	}

	@Test
	public void testPersistInvalidTag() {
		entityManager.getTransaction().begin();

		Event event = new Event();
		Tag tag = new Tag(null);
		event.addTag(tag);

		try {
			entityManager.persist(event);
			Assert.fail("PersistenceException expected");
		} catch (PersistenceException e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.containsString("not-null property"));
		}
	}

}