package org.example.service.storage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Post;
import org.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageService {

    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;

    @Value("${spring.cloud.gcp.storage.project-id}")
    private String projectId;

    private final PostRepository PostRepository;

    public String imageUpload(MultipartFile img_Post) throws IOException {
        InputStream keyFile = ResourceUtils.getURL("classpath:darakbang-422004-c04b80b50e78.json" ).openStream();
        String Post_origin_name =img_Post.getOriginalFilename();
        String Post_file_name=changedImageName(Post_origin_name);
        String Post_ext = img_Post.getContentType();
        Storage storage = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(keyFile))
                .build()
                .getService();
        // 이미지 GCP bucket에 저장
        BlobInfo blobInfo_Post = storage.create(
                BlobInfo.newBuilder(bucketName, Post_file_name)
                        .setContentType(Post_ext)
                        .build(),
                img_Post.getInputStream()
        );
        return Post_file_name;
    }

    public void PostImageDelete(Long PostId) throws IOException {
        Post Post = PostRepository.findByPostId(PostId);

        String imgPost = Post.getImagePost().substring(45);
        log.info(imgPost);

        InputStream keyFile = ResourceUtils.getURL("classpath:darakbang-422004-c04b80b50e78.json" ).openStream();
            Storage storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(keyFile))
                    .build()
                    .getService();

            Blob blobReal = storage.get(bucketName, imgPost);

            Storage.BlobSourceOption precondition =
                    Storage.BlobSourceOption.generationMatch(blobReal.getGeneration());
            storage.delete(bucketName, imgPost, precondition);

    }

    private static String changedImageName(String originName) {
        String random = UUID.randomUUID().toString();
        return random+originName;
    }

}
