/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package novi.spring.uploadingfiles.storage;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dave Syer
 *
 */
public class FileSystemStorageServiceTests {

	private FileSystemStorageService service;

	@BeforeEach
	public void init() {
		try {
			//properties.setLocation("target/files/" + Math.abs(new Random().nextLong()));
			service = new FileSystemStorageService();
			service.init();
		} catch (IOException e) {

		}
	}

	@Test
	public void loadNonExistent() {
		assertThat(service.load("foo.txt")).doesNotExist();
	}

	@Test
	public void saveAndLoad() {
		try {
			service.store(new MockMultipartFile("foo", "foo.txt", MediaType.TEXT_PLAIN_VALUE,
					"Hello, World".getBytes()));
			assertThat(service.load("foo.txt")).exists();
		} catch (IOException e) {

		}
	}

	@Test
	public void saveNotPermitted() {
		assertThrows(IOException.class, () -> {
			service.store(new MockMultipartFile("foo", "../foo.txt",
			MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));
		});
	}

	@Test
	public void savePermitted() {
		try {
			service.store(new MockMultipartFile("foo", "bar/../foo.txt",
					MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));
		} catch (IOException e) {

		}
	}

}
