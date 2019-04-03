# Spring JPA Demo

A Sample project using Spring 5, Hibernate 5, JPA 2.1 and JUnit 4.12 for Building & Testing DAO tier.
    
**This project DOES NOT include Oracle JDBC Driver. You must add ojdbc6.jar manually in this project, otherwise
you would get ClassNotFoundException !!**

## The Steps

1.  Create new "Spring Legacy Project"

    Choose Template "Simple Spring Web Maven"

2.  Open "pom.xml" file

    2.1 Add new dependency:

        <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-orm</artifactId>
                <version>${spring-framework.version}</version>
        </dependency>		
    
    2.2 Change spring version from 3.1.1 to 5.0.9

    		<spring-framework.version>5.0.9.RELEASE</spring-framework.version>
    
    2.3 Change Hibernate version to 5

    		<hibernate.version>5.0.12.Final</hibernate.version>
    
    2.4 Change JUnit version to 4.12

    		<junit.version>4.12</junit.version>

3.  Goto **src/main/resources/spring/application-config.xml**

    Switch to "namespaces" TAB
    
    Select "tx" namespace and switch to "source" TAB

        <context:component-scan base-package="com.mahendra"/>

        <bean id="dataSource"
            class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
            <property name="username" value="hr" />
            <property name="password" value="hr" />
            <property name="url" value="jdbc:oracle:thin:@localhost:1521:xe" />
        </bean> 
        
        <bean id="emFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
            <property name="dataSource" ref="dataSource"/>
            <property name="packagesToScan" value="com.mahendra"/>
            <property name="persistenceProviderClass" value="org.hibernate.ejb.HibernatePersistence"/>
            <property name="jpaPropertyMap">
                <map>
                    <entry key="hibernate.dialect" value="org.hibernate.dialect.Oracle10gDialect" />
                    <entry key="hibernate.hbm2ddl.auto" value="update"/>
                </map>
            </property>
        </bean>

4.  Create New ENTITY class "Country"
    
        @Entity
        @Table(name="countries")
        public class Country {

        @Id
        @Column(name="country_id")
        private String code;
        
        @Column(name="country_name",length=40)
        private String name;
        
        @Column(name="region_id")
        private Integer region;

        //Generate Setters, Getters and Constructor

5.  Create a DAO Interface
    
        public interface CountryDAO {

            Country findById(String code);
            List<Country> findByRegion(int regionId);
        }

6.  Create Implementation class
    
        import java.util.List;

        import javax.persistence.*;
        
        import org.springframework.stereotype.Repository;

        import com.mahendra.entities.Country;

        @Repository
        public class CountryDAOImpl implements CountryDAO {

            @PersistenceContext 
            private EntityManager em;
            
            
            @Override
            public Country findById(String code) {
                return em.find(Country.class, code);
            }

            @Override
            public List<Country> findByRegion(int regionId) {
                Query q = em.createQuery("select x from Country x where x.region=?");
                q.setParameter(1, regionId);
                
                return q.getResultList();
            }

        }

7.  Create JUnit Test case for DAOImpl class
    
    Right click on "CountryDAOImpl" ->New ->Other -> JUnit Test Case
    
    choose source folder "src/main/test"
    
    Click Next
    
    Select both "findById" and "findByRegio" method and finish

8.  Modify the Test case class like this:

    8.1 Add following TWO annotations on CLASS Level
    
        // PRE_REQUISITE: Must include "spring-test" in pom.xml
        @RunWith(SpringJUnit4ClassRunner.class) //Inform JUnit about Spring TEST
        @ContextConfiguration("classpath:/spring/application-config.xml")

    8.2 Inject "DAO" object
        	
        @Autowired
        private CountryDAO dao;

    8.3 Write Test Cases

        @Test
        public void testFindById() {
            Country c = dao.findById("IN");
            assertEquals("India", c.getName());
        }

        @Test
        public void testFindByRegion() {
            List<Country> countries = dao.findByRegion(3);
            assertEquals(6, countries.size());
        }

    8.4 The Final Test case class should be like this:

        import static org.junit.Assert.*;

        import java.util.List;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

        import com.mahendra.entities.Country;

        // PRE_REQUISITE: Must include "spring-test" in pom.xml
        @RunWith(SpringJUnit4ClassRunner.class) //Inform JUnit about Spring TEST
        @ContextConfiguration("classpath:/spring/application-config.xml")
        public class CountryDAOImplTest {
            
            @Autowired
            private CountryDAO dao;

            @Test
            public void testFindById() {
                Country c = dao.findById("IN");
                assertEquals("India", c.getName());
            }

            @Test
            public void testFindByRegion() {
                List<Country> countries = dao.findByRegion(3);
                assertEquals(6, countries.size());
            }
        }

9.  Add OJDBC6.jar or OJDBC14.jar to project classpath

10. Right click on "CountryDAOImplTest" and Choose Run As -> JUnit Test 

11. You should get ALL tests PASSED!