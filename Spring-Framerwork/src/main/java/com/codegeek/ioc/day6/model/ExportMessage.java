package com.codegeek.ioc.day6.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ExportMessage extends BaseRowModel {

    @ExcelProperty(value = "报文内容",index = 0)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExportMessage(String message) {
        this.message = message;
    }

    public ExportMessage() {
    }
}