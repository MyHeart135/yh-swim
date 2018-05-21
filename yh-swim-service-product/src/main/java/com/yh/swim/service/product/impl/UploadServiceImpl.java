package com.yh.swim.service.product.impl;

import com.yh.swim.common.fdfs.FastDFSUtils;
import com.yh.swim.service.product.UploadService;
import org.springframework.stereotype.Service;

/**
 * 上传图片服务实现
 *
 * @author yanhuan1
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    /**
     * 上传图片方法
     *
     * @param pic  图片转换后的字节码
     * @param name 图片名称
     * @param size 图片大小
     * @return
     */
    @Override
    public String uploadPic(byte[] pic, String name, long size) {
        return FastDFSUtils.uploadPic(pic, name, size);
    }
}
