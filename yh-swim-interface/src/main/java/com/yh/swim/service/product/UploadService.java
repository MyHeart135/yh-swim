package com.yh.swim.service.product;

/**
 * 上传图片方法
 */
public interface UploadService {

    /**
     * 上传图片方法
     *
     * @param pic  图片转换后的字节码
     * @param name 图片名称
     * @param size 图片大小
     * @return 图片地址
     */
    String uploadPic(byte[] pic, String name, long size);
}
