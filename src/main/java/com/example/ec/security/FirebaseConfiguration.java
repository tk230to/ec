package com.example.ec.security;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import lombok.Data;

/**
 * Firebase設定クラス。
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "firebase")
@Data
public class FirebaseConfiguration {

    /** FirebaseのURL */
    private String databaseURL;

    /** Firebaseの秘密鍵ファイルパス */
    private String serviceAccount;

    /**
     * Firebaseデータベース参照クラスをBeanに登録。
     *
     * @return Firebaseデータベース参照クラス
     */
    @Bean
    public DatabaseReference firebaseDatabse() {
        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
        return firebase;
    }

    /**
     * 「Firebase Admin SDK」の初期処理。
     * @throws IOException
     */
    @PostConstruct
    public void init() throws IOException {

        FileInputStream inputStream = new FileInputStream(serviceAccount);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl(databaseURL)
                .build();

        if (FirebaseApp.getApps().size() == 0) {
            FirebaseApp.initializeApp(options);
        }
    }
}