
### Set up for testing:
*   Declare dependency on org.springframework.boot:spring-boot-starter-test
*   Declare dependency on org.neo4j:neo4j-ogm-test
*   Annotate a test class with @SpringBootTest and @RunWith(SpringRunner.class)

### References
https://github.com/neo4j-examples/neo4j-sdn-ogm-issue-report-template/blob/master/ogm-3.0/src/test/java/org/neo4j/ogm/test/OgmTestCase.java
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
https://docs.spring.io/spring-data/neo4j/docs/current/reference/html/#reference:testing

### Notes
When configuring session factory, be sure to specify the package(s) to scan for domain classes. What happen if you 
don't do this? Essentially, neo4j ogm wil try to scan for everything and you will get a lot of ClassNotFoundException
 when some of the libraries declare packages that you don't have on the class paths. 
 ```java
 @Bean
    public SessionFactory sessionFactory()
    {
        // with domain entity base package(s)
        return new SessionFactory( configuration);  // don't do this, it will cause unexpected packages to be scanned
                                                    // you will likely get a lot of ClassNotFoundException 
    }
    
 // instead specify the base package to scan
  @Bean
     public SessionFactory sessionFactory()
     {
         // with domain entity base package(s)
         return new SessionFactory( configuration, "com.tbo.sn");
     }
```
