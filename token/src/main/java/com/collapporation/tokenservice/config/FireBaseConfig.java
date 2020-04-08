package com.collapporation.tokenservice.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireBaseConfig {
    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("token/src/main/resources/collapporation-firebase-adminsdk-k3rsq-d5f46f4ba4.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://dataeditor.firebaseio.com")
                .build();

        FirebaseApp app = FirebaseApp.initializeApp(options);

        return FirebaseAuth.getInstance(app);
    }
}
