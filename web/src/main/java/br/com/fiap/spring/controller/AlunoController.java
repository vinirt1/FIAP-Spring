package br.com.fiap.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.spring.model.dto.AlunoCreateUpdateDTO;
import br.com.fiap.spring.model.dto.AlunoDTO;
import br.com.fiap.spring.model.dto.CompraDTO;
import br.com.fiap.spring.service.AlunoService;
import br.com.fiap.spring.service.TextFileExporterService;
import br.com.fiap.spring.util.FaturaUtil;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private AlunoService alunoService;

    private TextFileExporterService textFileExporterService;

    public AlunoController(AlunoService alunoService, TextFileExporterService textFileExporterService) {
        this.alunoService = alunoService;
        this.textFileExporterService = textFileExporterService;
    }

    @GetMapping()
    public ResponseEntity<List<AlunoDTO>> listar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome) {
        return new ResponseEntity<List<AlunoDTO>>(alunoService.listar(nome), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> consultar(@PathVariable("id") final Long id) {
        return new ResponseEntity<AlunoDTO>(alunoService.consultar(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/compras")
    public ResponseEntity<List<CompraDTO>> compras(@PathVariable("id") final Long id) {
        return new ResponseEntity<List<CompraDTO>>(alunoService.compras(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/fatura")
    public ResponseEntity<InputStreamResource> comprasDownload(@PathVariable("id") final Long id) throws FileNotFoundException {
        final List<CompraDTO> listaCompras = alunoService.compras(id);

        final String fileName = "Fatura.txt";
        final String fileContent = FaturaUtil.montarTextoFatura(listaCompras);
        
        Path exportedPath = textFileExporterService.export(fileContent, fileName);
            
        File exportedFile = exportedPath.toFile();
        FileInputStream fileInputStream = new FileInputStream(exportedFile);
        InputStreamResource inputStreamResource = new InputStreamResource(fileInputStream);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(MediaType.TEXT_PLAIN)
                .contentLength(exportedFile.length())
                .body(inputStreamResource);
    }

    @PostMapping()
    public ResponseEntity<AlunoDTO> salvar(@RequestBody final AlunoCreateUpdateDTO alunoCreateDTO) {
        return new ResponseEntity<AlunoDTO>(alunoService.salvar(alunoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> alterar(@PathVariable("id") final Long id,
            @RequestBody final AlunoCreateUpdateDTO alunoUpdateDTO) {
        return new ResponseEntity<AlunoDTO>(alunoService.alterar(id, alunoUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("id") final Long id) {
        alunoService.deletar(id);
    }
}
