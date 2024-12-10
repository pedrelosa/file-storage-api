package br.com.pedrelosa.filestorageapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Controller
@RequestMapping("/api/anotaai")
public class ApiAnotaAiController {
    private final Path fileStorageLocation;

    public ApiAnotaAiController(FileStorageProperties fileStorageProperties){
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
    }

    @PostMapping("/ipserver")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        System.out.println(fileName);

        try {
            Path targetLocation = fileStorageLocation.resolve(fileName);
            System.out.println(targetLocation.getFileName());
            file.transferTo(targetLocation);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/files/download/")
                    .path(fileName)
                    .toUriString();

            return ResponseEntity.ok("Upload completed! Download link: " + fileDownloadUri);

        }catch (IOException ex){
            return ResponseEntity.badRequest().build();
        }

    }

}
