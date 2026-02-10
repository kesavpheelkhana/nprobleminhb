package com.example.demo.config;

import com.example.demo.entity.AbstractConfigEntity;
import com.example.demo.entity.enumerator.UploadType;

import java.io.File;

public interface IUploadClient {
    UploadType getUploadType();

    void upload(AbstractConfigEntity.ICredential credential, File file);
}
