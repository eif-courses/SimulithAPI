package eif.viko.lt.simulith.webapp.controller;

import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.Metadata;
import eif.viko.lt.simulith.webapp.service.DropboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
@RestController
@RequestMapping(value = "/api/dropbox", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DropboxApiController {
    final DropboxService dropboxService;

    @Autowired
    public DropboxApiController(DropboxService dropboxService) {
        this.dropboxService = dropboxService;
    }

    @GetMapping("")
    public String getFolderDetails(){
        Metadata metadata = dropboxService.getFolderDetails("/marius");
        return metadata.toStringMultiline();
    }
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("filePath") String filePath) throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes());
        FileMetadata fm = dropboxService.uploadFile(filePath, inputStream);
        inputStream.close();
        return "You successfully uploaded " + filePath + "= "+ fm.getPathLower();
    }
}
