package com.example.BookDemo;

import com.example.BookDemo.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookDemoApplicationTests {

	@Autowired
	LibraryService libraryService;
	@Test
	void contextLoads() {
	}

	@Test
	public void checkBuildIdMethorLogic(){
		String id=libraryService.buildId("Zman",24);
		assertEquals(id,"OLDZman24");

	}

}
