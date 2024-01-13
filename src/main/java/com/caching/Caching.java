package com.caching;

public class Caching {
	
	
	//1)Caching is a mechanism to enhance the performance of the application
	//2) Caching is used to reduce the number of database queries
	//how caching works in hibernate--> Supose we have database and Java Application and Hibernate in b/w(with Cache memory in hibernate)
	// suppose application need object it will ask hibernate first, hibernate checks in cache memory if object is present it is returned
	//to application, otherwise hibernate will fire query to get object and first put it into cache memory and the return it back
	//to the application, if application again needs same object, it will be checked in hibernate's cache memory and if present 
	//returned from here to application or new query will be fired.
	
	//In hibernate we have two types of caching 1) First Level 2)Second level
	//first level associated with session object, provided by default
	//second level associated with sessionFactory object, have to enable manually(do configuration)

}
