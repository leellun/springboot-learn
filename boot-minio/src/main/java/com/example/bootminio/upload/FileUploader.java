package com.example.bootminio.upload;

import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import io.minio.messages.Tags;
import okhttp3.OkHttpClient;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class FileUploader {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .httpClient(getUnsafeOkHttpsClient())
                    .credentials("jGtLBvw6HhnW9Nsc", "BzDmbL3ZCPERFHPxB5jOnf0w7l48DqOu")
                    .endpoint("192.168.100.100", 31582, false)
                    .build();

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket("test").build());
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("test").build());
            }
            FileInputStream fis = new FileInputStream("./pom.xml");
            Map<String, String> headers = new HashMap<>();
            headers.put("name", "pomtest.xml");
            // 使用putObject上传一个文件到存储桶中。
            ObjectWriteResponse response = minioClient.putObject(PutObjectArgs.builder()
                    .bucket("test")
                    .object("pom.xml")
                    .extraQueryParams(headers)
                    .headers(headers)
                    .tags(headers)
                    .stream(fis, fis.available(), -1)
                    .build());
            System.out.println("pom.xml is successfully uploaded as pom.xml to `test` bucket." + response.versionId());
            Tags tags = minioClient.getObjectTags(GetObjectTagsArgs.builder().bucket("test").object("pom.xml").build());
            System.out.println(tags.get().get("name"));
            System.out.println(minioClient.getObject(GetPresignedObjectUrlArgs.builder().bucket("test").method(Method.GET).object("pom.xml").build()));
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }

    public static OkHttpClient getUnsafeOkHttpsClient() throws KeyManagementException {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };


            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[]{};
                }
            });


            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            return builder.build();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
