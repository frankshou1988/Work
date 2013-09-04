package com.tetrapak.action.file;

import java.io.InputStream;

/**
 * Report Save Action interface
 * */
public interface ReportSaveAction {
    public String EXCEL = "excel";
    public String PDF = "pdf";

    public InputStream getExcelStream() throws Exception;

    public InputStream getPdfStream() throws Exception;
}
