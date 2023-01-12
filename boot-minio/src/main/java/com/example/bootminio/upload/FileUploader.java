package com.example.bootminio.upload;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
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
            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket("test")
                    .object("pom.xml")
                    .stream(fis, fis.available(), -1)
                    .build());
            System.out.println("pom.xml is successfully uploaded as pom.xml to `test` bucket.");
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
            builder.sslSocketFactory(sslSocketFactory,new X509TrustManager() {
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
