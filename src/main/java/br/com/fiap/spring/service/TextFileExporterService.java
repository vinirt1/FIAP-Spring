package br.com.fiap.spring.service;

import java.nio.file.Path;

public interface TextFileExporterService {
    Path export(String fileContent, String fileName);
}
