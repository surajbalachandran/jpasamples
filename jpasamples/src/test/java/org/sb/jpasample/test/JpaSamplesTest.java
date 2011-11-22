package org.sb.jpasample.test;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sb.jpasamples.dao.pojo.Address;
import org.sb.jpasamples.dao.pojo.Customer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:jpasamples-dao-test-context.xml")
public class JpaSamplesTest {

	@Resource(name="entityManagerFactory")
	private EntityManagerFactory entityManagerFactory;

	@Test
	public void addCustomerTest() {
		
		Address address = new Address();
		address.setAddress1("3005 Warren Way, Apt# B");
		address.setCity("Carmel");
		address.setState("IN");
		address.setZip("46033");
		
		Calendar cal = Calendar.getInstance();
		address.setCreateTime(cal.getTime());
		address.setCreateUser("Suraj");
		address.setUpdateTime(cal.getTime());
		address.setUpdateUser("Suraj");
		
		Customer customer = new Customer();
		customer.setName("Paypal");
		customer.setCustomerType("Gold Card Customer");
		customer.setAddress(address);
		customer.setCreateTime(cal.getTime());
		customer.setCreateUser("Suraj");
		customer.setUpdateTime(cal.getTime());
		customer.setUpdateUser("Suraj");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.flush();
		em.getTransaction().commit();
	}
	
	
	public void setEntityManagerFactory(
			EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
}
