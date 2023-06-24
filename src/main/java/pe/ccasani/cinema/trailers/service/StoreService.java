package pe.ccasani.cinema.trailers.service;

import java.nio.file.Path;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StoreService {

  void startFilesStore();
  String storeFile(MultipartFile file);
  Path loadFile(String fileName);
  Resource loadAsResource(String fileName);
  void deleteFile(String fileName);
}
