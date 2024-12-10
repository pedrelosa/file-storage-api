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

    @PostMapping("/ipserver/{diretorio}")
    public ResponseEntity<String> uploadFileDiretorioEspecifico(
            @PathVariable String diretorio,
            @RequestParam("file")MultipartFile file){
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String caminhoAbsoluto = (fileStorageLocation.toUri().getRawPath() + diretorio).substring(1);

        try {
            Path targetLocation = Path.of(caminhoAbsoluto + fileName);
            file.transferTo(targetLocation);

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/files/download/" + diretorio + "/")
                    .path(fileName)
                    .toUriString();

            System.out.println(fileDownloadUri);

            return ResponseEntity.ok("Upload completed! Download link: " + fileDownloadUri);

        }catch (IOException ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

}
