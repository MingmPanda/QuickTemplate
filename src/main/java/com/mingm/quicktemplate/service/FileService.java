package com.mingm.quicktemplate.service;

import java.io.File;
import java.io.InputStream;

/**
 * @author: panmm
 * @date: 2020/6/29 01:46
 * @description:
 */
public interface FileService {

    /**
     * 文件上传
     * @param inputStream
     * @param filename
     */
    void upload(InputStream inputStream, String filename);

    /**
     * 文件上传
     * @param file
     */
    void upload(File file);
}
