package com.example.servingwebcontent.provider;

import com.example.servingwebcontent.exception.CustomizeErrorCode;
import com.example.servingwebcontent.exception.CustomizeException;
import com.google.gson.Gson;
import com.qingstor.sdk.config.*;
import com.qingstor.sdk.service.Bucket;
import com.qingstor.sdk.service.QingStor;
import com.qingstor.sdk.exception.QSException;
import com.qingstor.sdk.service.Types;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.Date;


@Service
public class UCloudProvider {
    @Value("${ucloud.ufile.public-key}")
    private String publicKey;
    @Value("${ucloud.ufile.private-key}")
    private String privateKey;
    @Value("${ucloud.ufile.expires}")
    private Integer expires;

    private QingStor stor;
    private Bucket bucket;


    private void getBucket() {
        EnvContext env = new EnvContext(publicKey, privateKey);
        QingStor stor = new QingStor(env);
        try {
            QingStor.ListBucketsOutput output = stor.listBuckets(null);
            if (output.getStatueCode() == 200) {
                System.out.println("Count = " + output.getCount());

                List<Types.BucketModel> buckets = output.getBuckets();
                System.out.println("buckets = " + new Gson().toJson(buckets));
                bucket = stor.getBucket(buckets.get(0).getName(), buckets.get(0).getLocation());

            } else {
                handleError(output);
            }
        } catch (QSException e) {
            e.printStackTrace();
        }
    }

    private void handleError(QingStor.ListBucketsOutput output) {
        String logMessage = String.format("QingStor list buckets error, status code: %s, error code: %s, message: %s",
                output.getStatueCode(), output.getCode(), output.getMessage());
        System.out.println(logMessage);
    }

    private void handleOutput(Bucket.PutObjectOutput output) {
        int statusCode = output.getStatueCode();
        if (statusCode == 201) {
            System.out.println(output.getETag());
        } else {
            System.out.println(output.getCode());
            System.out.println(output.getMessage());
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }
        System.out.println(output.getRequestId());
    }


    public String upload(InputStream fileStream, String mimeType, String fileName)  throws QSException {
        getBucket();
        String filekey = generateFileName(fileName);
        filekey = filePathWithFileName(filekey);

        String fileUrl = "";
        try {
            Bucket.PutObjectInput input = new Bucket.PutObjectInput();
            input.setBodyInputStream(fileStream);
            input.setContentLength((long) fileStream.available());

            Bucket.PutObjectOutput output = bucket.putObject(filekey, input);
            handleOutput(output);

            long expiresTime = new Date().getTime() / 1000 + expires;
            fileUrl = bucket.GetObjectSignatureUrl(filekey, expiresTime);

        } catch (Exception e) {
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }
        return fileUrl;
    }

    public  String generateFileName(String filePath) {
        // 创建随机UUID
        String uuid = UUID.randomUUID().toString();

        // 提取文件名
        String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);

        // 剔除文件名中的不可见字符
        fileName = fileName.replaceAll("\\s+", "");

        // 拼接UUID和处理后的文件名
        fileName = uuid + fileName;

        return fileName;
    }

    String filePathWithFileName(String fileName) {
        return QingYunConstants.QingYunPath + "/" +  QingYunConstants.QingYunImgPath + "/" + fileName;
    }
}
