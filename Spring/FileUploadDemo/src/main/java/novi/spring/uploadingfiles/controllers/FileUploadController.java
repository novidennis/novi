package novi.spring.uploadingfiles.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemException;
import java.util.stream.Collectors;

import novi.spring.uploadingfiles.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

	private final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<?> serveFile(@PathVariable String filename) {
		try {
			Resource file = storageService.loadAsResource(filename);
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
					.body(file);
		} catch (IOException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file)  {
		try {
			storageService.store(file);
			return ResponseEntity.ok("You successfully uploaded " + file.getOriginalFilename() + "!");
		} catch (IOException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@ExceptionHandler(FileSystemException.class)
	public ResponseEntity<?> handleStorageFileNotFound(FileSystemException exc) {
		return ResponseEntity.notFound().build();
	}
}
