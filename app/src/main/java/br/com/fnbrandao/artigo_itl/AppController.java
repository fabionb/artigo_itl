package br.com.fnbrandao.artigo_itl;

import javax.persistence.EntityManager;

import org.hibernate.query.NativeQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private EntityManager entityManager;

	@GetMapping("/flush")
	@Transactional
	public void flush() {
		logger.info("Entering flush method");
		Test1Entity e = new Test1Entity();
		logger.info("Entity created");
		entityManager.persist(e);
		logger.info("Entity persisted");
		entityManager.flush();
		logger.info("Entity Manager flushed");
		// Some slow processing
		slowMethod();
		logger.info("Exiting flush method");
	}

	@GetMapping("/withoutFlush")
	@Transactional
	public void withoutFlush() {
		logger.info("Entering withoutFlush method");
		Test1Entity e = new Test1Entity();
		logger.info("Entity created");
		entityManager.persist(e);
		logger.info("Entity persisted");
		// Some slow processing
		slowMethod();
		logger.info("Exiting withoutFlush method");
	}

	@GetMapping("/nativeQuery")
	@Transactional
	public void nativeQuery() {
		logger.info("Entering nativeQuery method");
		Test1Entity e = new Test1Entity();
		logger.info("Entity created");
		entityManager.persist(e);
		logger.info("Entity persisted");
		entityManager.createNativeQuery("select * from test2entity where id = 1").getResultList();
		logger.info("Native query executed");
		// Some slow processing
		slowMethod();
		logger.info("Exiting nativeQuery method");
	}

	@GetMapping("/nativeQueryWithQuerySpace")
	@Transactional
	public void nativeQueryWithQuerySpace() {
		logger.info("Entering nativeQueryWithQuerySpace method");
		Test1Entity e = new Test1Entity();
		logger.info("Entity created");
		entityManager.persist(e);
		logger.info("Entity persisted");
		NativeQuery<?> query = entityManager.createNativeQuery("select * from test2entity where id = 1").unwrap(NativeQuery.class);
		query.addSynchronizedEntityClass(Test2Entity.class);
		query.getResultList();
		logger.info("Native query executed");
		// Some slow processing
		slowMethod();
		logger.info("Exiting nativeQueryWithQuerySpace method");
	}

	@GetMapping("/nativeQueryWithQuerySpaceFromSameEntity")
	@Transactional
	public void nativeQueryWithQuerySpaceFromSameEntity() {
		logger.info("Entering nativeQueryWithQuerySpaceFromSameEntity method");
		Test1Entity e = new Test1Entity();
		logger.info("Entity created");
		entityManager.persist(e);
		logger.info("Entity persisted");
		NativeQuery<?> query = entityManager.createNativeQuery("select * from test1entity where id = 1").unwrap(NativeQuery.class);
		query.addSynchronizedEntityClass(Test1Entity.class);
		query.getResultList();
		logger.info("Native query executed");
		// Some slow processing
		slowMethod();
		logger.info("Exiting nativeQueryWithQuerySpaceFromSameEntity method");
	}

	@GetMapping("/queryTest2")
	@Transactional
	public void queryTest2() {
		logger.info("Entering queryTest1 method");
		Test1Entity e = new Test1Entity();
		logger.info("Entity created");
		entityManager.persist(e);
		logger.info("Entity persisted");
		entityManager.createQuery("from Test2Entity where id = 1").getResultList();
		logger.info("Query executed");
		// Some slow processing
		slowMethod();
		logger.info("Exiting queryTest2 method");
	}

	@GetMapping("/queryTest1")
	@Transactional
	public void queryTest1() {
		logger.info("Entering queryTest1 method");
		Test1Entity e = new Test1Entity();
		logger.info("Entity created");
		entityManager.persist(e);
		logger.info("Entity persisted");
		entityManager.createQuery("from Test1Entity where id = 1").getResultList();
		logger.info("Query executed");
		// Some slow processing
		slowMethod();
		logger.info("Exiting queryTest1 method");
	}

	private void slowMethod() {
		logger.info("Doing some slow stuff");
	}

}
