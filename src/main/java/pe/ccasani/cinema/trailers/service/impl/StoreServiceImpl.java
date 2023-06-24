package pe.ccasani.cinema.trailers.service.impl;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import pe.ccasani.cinema.trailers.exceptions.FileNotFoundException;
import pe.ccasani.cinema.trailers.exceptions.StoreException;
import pe.ccasani.cinema.trailers.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

  @Value("${storage.location}")
  private String storageLocation;

  @PostConstruct
  @Override
  public void startFilesStore() {
    try {
      Files.createDirectories(Paths.get(storageLocation));
    } catch (IOException ioException) {
      throw new StoreException("Error al inicializar la ubicacion del archivo.");
    }
  }

  @Override
  public String storeFile(MultipartFile file) {
    var fileName = file.getOriginalFilename();

    if (file.isEmpty()) {
      throw new StoreException("No se puede almacenar un archivo vacio");
    }

    try {
      var inputStream = file.getInputStream();
      Files.copy(inputStream, Paths.get(storageLocation).resolve(fileName), REPLACE_EXISTING);
    } catch (IOException ioException) {
      throw new StoreException("Error al almacenar el archivo ".concat(fileName));
    }

    return fileName;
  }

  @Override
  public Path loadFile(String fileName) {
    return Paths.get(storageLocation).resolve(fileName);
  }

  @Override
  public Resource loadAsResource(String fileName) {

    try {
      var file = loadFile(fileName);
      var resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new FileNotFoundException("No se pudo encontrar el archivo".concat(fileName));
      }
    } catch (IOException e) {
      throw new FileNotFoundException("No se pudo encontrar el archivo".concat(fileName), e);
    }
  }

  @Override
  public void deleteFile(String fileName) {
    var file = loadFile(fileName);

    try {
      FileSystemUtils.deleteRecursively(file);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
