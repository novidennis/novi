package novi.spring.uploadingfiles.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void init() throws IOException;

	void store(MultipartFile file) throws IOException;

	Stream<Path> loadAll() throws IOException;

	Path load(String filename);

	Resource loadAsResource(String filename) throws IOException;

	void deleteAll();

}
