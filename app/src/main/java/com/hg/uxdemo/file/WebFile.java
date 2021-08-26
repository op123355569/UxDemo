package com.hg.uxdemo.file;

import com.hg.zero.file.ZWebFile;

/**
 * 网络文件
 * <p>
 * Created by Hollow Goods on 2021-08-26.
 */
public class WebFile implements ZWebFile<WebFile> {

    /**** 文件id ****/
    private String fileId;
    /**** 生成的文件名 ****/
    private String generateName;
    /**** 原始文件名 ****/
    private String originalName;
    /**** 文件后缀 ****/
    private String fileSuffix;
    /**** 文件大小 单位：KB ****/
    private Long fileSizeKb;
    /**** 文件大小 格式化格式 ****/
    private String fileSizeFormat;

    @Override
    public String getFileId() {
        return fileId;
    }

    @Override
    public String getFileOriginalName() {
        return originalName;
    }

    @Override
    public String getFileGenerateName() {
        return generateName;
    }

    @Override
    public String getFileSuffix() {
        return fileSuffix;
    }

    @Override
    public Long getFileSizeKb() {
        return fileSizeKb;
    }

    @Override
    public String getFileSizeFormat() {
        return fileSizeFormat;
    }

    @Override
    public WebFile setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    @Override
    public WebFile setFileOriginalName(String fileOriginalName) {
        this.originalName = fileOriginalName;
        return this;
    }

    @Override
    public WebFile setFileGenerateName(String fileGenerateName) {
        this.generateName = fileGenerateName;
        return this;
    }

    @Override
    public WebFile setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
        return this;
    }

    @Override
    public WebFile setFileSizeKb(Long fileSizeKb) {
        this.fileSizeKb = fileSizeKb;
        return this;
    }

    @Override
    public WebFile setFileSizeFormat(String fileSizeFormat) {
        this.fileSizeFormat = fileSizeFormat;
        return this;
    }
}
