package br.com.pedrelosa.filestorageapi;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/files")
public class FileStorageController {
    private final Path fileStorageLocation;

    public FileStorageController(FileStorageProperties fileStorageProperties){
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
    }

    @PostMapping("/upload")
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
    @PostMapping("/upload/{diretorio}")
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


    @PostMapping("/mkdir")
    public ResponseEntity<String> makeDirectory(@RequestParam("diretorio") String diretorio){

        //Configuração para windows .substring
        String caminhoAbsoluto = (fileStorageLocation.toUri().getRawPath() + diretorio).substring(1);

        System.out.println(caminhoAbsoluto);

        try {
            Files.createDirectories(Path.of(caminhoAbsoluto));
            return ResponseEntity.ok(caminhoAbsoluto + " Foi cadastrado!");
        } catch (IOException e) {
            return ResponseEntity.ok("Caminho já cadastrado");
        }

    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Path filePath = fileStorageLocation.resolve(fileName);

        try {
            Resource resource = new UrlResource(filePath.toUri());
            String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping("/download/{diretorio}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFileDiretorioEspecifico(
            @PathVariable String diretorio,
            @PathVariable String fileName,
            HttpServletRequest request){

        String caminhoAbsoluto = (fileStorageLocation.toUri().getRawPath() + diretorio).substring(1) + fileName;
        Path filePath = fileStorageLocation.resolve(caminhoAbsoluto);

        try {
            Resource resource = new UrlResource(filePath.toUri());
            String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> listFiles() throws IOException {
        List<String> fileNames = Files.list(fileStorageLocation)
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());

        return ResponseEntity.ok(fileNames);
    }

    @GetMapping("/lista-diretorio-especifico")
    public ResponseEntity<List<String>> listFiles(@RequestParam("diretorio") String diretorio) throws IOException {

        //Configuração para windows .substring
        String caminhoAbsoluto = (fileStorageLocation.toUri().getRawPath() + diretorio).substring(1);

        Path pathCaminhoAbsoluto = Path.of(caminhoAbsoluto);

        if (Files.exists(pathCaminhoAbsoluto, LinkOption.NOFOLLOW_LINKS)) {
            List<String> fileNames = Files.list(pathCaminhoAbsoluto)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(fileNames);
        }else {
            return ResponseEntity.badRequest().body(Collections.singletonList("O diretório pesquisado não existe"));
        }
    }

}
