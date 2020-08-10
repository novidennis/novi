package novi.spring.uploadingfiles.storage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

	private final Path rootLocation;

	public FileSystemStorageService() {
		this.rootLocation = Paths.get("upload-dir");
	}

	@Override
	public void store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if (file.isEmpty()) {
			throw new FileSystemException("Failed to store empty file " + filename);
		}
		else if (filename.contains("..")) {
			throw new FileSystemException(
					"Cannot store file with relative path outside current directory " + filename);
		}
		InputStream inputStream = file.getInputStream();
		Files.copy(inputStream, this.rootLocation.resolve(filename),
				StandardCopyOption.REPLACE_EXISTING);
	}

	@Override
	public Stream<Path> loadAll() throws IOException {
		try {
			return Files.walk(this.rootLocation, 1)
				.filter(path -> !path.equals(this.rootLocation))
				.map(this.rootLocation::relativize);
		}
		catch (IOException e) {
			throw new FileSystemException("Failed to read stored files");
		}
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) throws IOException {
		Path file = load(filename);
		Resource resource = new UrlResource(file.toUri());
		if (resource.exists() || resource.isReadable()) {
			return resource;
		} else {
			throw new FileSystemException("Could not read file: " + filename);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() throws IOException {
		try {
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new FileSystemException("Could not initialize storage");
		}
	}
}
