package com.genpect.libraries.integrationtest;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.genpect.libraries.LibrariesApplication;
import com.genpect.libraries.entity.BooksEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibrariesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibraryIntegrationTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void getLibrariesTest() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/library"),
				HttpMethod.GET, entity, String.class);

		String expected = "[\n" + 
				"  {\n" + 
				"    \"libraryName\": \"Library 1\",\n" + 
				"    \"books\": [\n" + 
				"      {\n" + 
				"        \"id\": 1,\n" + 
				"        \"bookName\": \"Maths\",\n" + 
				"        \"libraryName\": \"Library 1\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"        \"id\": 3,\n" + 
				"        \"bookName\": \"Hindi\",\n" + 
				"        \"libraryName\": \"Library 1\"\n" + 
				"      }\n" + 
				"    ]\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"libraryName\": \"Library 2\",\n" + 
				"    \"books\": [\n" + 
				"      {\n" + 
				"        \"id\": 2,\n" + 
				"        \"bookName\": \"English\",\n" + 
				"        \"libraryName\": \"Library 2\"\n" + 
				"      }\n" + 
				"    ]\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"libraryName\": \"Library 3\",\n" + 
				"    \"books\": [\n" + 
				"      \n" + 
				"    ]\n" + 
				"  }\n" + 
				"]";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void getLibrariesByIdTest() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/library/Library 1"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\n" + 
				"  \"libraryName\": \"Library 1\",\n" + 
				"  \"books\": [\n" + 
				"    {\n" + 
				"      \"id\": 1,\n" + 
				"      \"bookName\": \"Maths\",\n" + 
				"      \"libraryName\": \"Library 1\"\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"id\": 3,\n" + 
				"      \"bookName\": \"Hindi\",\n" + 
				"      \"libraryName\": \"Library 1\"\n" + 
				"    }\n" + 
				"  ]\n" + 
				"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void getAllBooksTest() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/books"),
				HttpMethod.GET, entity, String.class);

		String expected = "[\n" + 
				"  {\n" + 
				"    \"id\": 1,\n" + 
				"    \"bookName\": \"Maths\",\n" + 
				"    \"libraryName\": \"Library 1\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 2,\n" + 
				"    \"bookName\": \"English\",\n" + 
				"    \"libraryName\": \"Library 2\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 3,\n" + 
				"    \"bookName\": \"Hindi\",\n" + 
				"    \"libraryName\": \"Library 1\"\n" + 
				"  }\n" + 
				"]";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void getAllBooksByIdTest() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/books/1"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\n" + 
				"  \"id\": 1,\n" + 
				"  \"bookName\": \"Maths\",\n" + 
				"  \"libraryName\": \"Library 1\"\n" + 
				"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void saveBookTest() throws JSONException {

		BooksEntity be = new BooksEntity();
		be.setId(1);
		be.setBookName("testBook");
		be.setLibraryName("Library 2");
		HttpEntity<BooksEntity> entity = new HttpEntity<BooksEntity>(be, headers);

		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/books"),
				HttpMethod.POST, entity, String.class);
		
		String expected = "{\n" + 
				"  \"id\": 1,\n" + 
				"  \"bookName\": \"testBook\",\n" + 
				"  \"libraryName\": \"Library 2\"\n" + 
				"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void updateBookTest() throws JSONException {

		BooksEntity be = new BooksEntity();
		be.setId(20);
		be.setBookName("testBook");
		be.setLibraryName("Library 2");
		HttpEntity<BooksEntity> entity = new HttpEntity<BooksEntity>(be, headers);

		
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/books"),
				HttpMethod.PUT, entity, String.class);
		
		String expected = "{\"description\":\"book ID is invalid\"}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	}
	