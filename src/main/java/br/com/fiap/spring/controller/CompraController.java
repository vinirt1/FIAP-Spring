package br.com.fiap.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.spring.model.dto.CompraCreateDTO;
import br.com.fiap.spring.model.dto.CompraDTO;
import br.com.fiap.spring.model.dto.CompraValorDTO;
import br.com.fiap.spring.service.CompraService;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping()
    public ResponseEntity<List<CompraDTO>> listar() {
        return new ResponseEntity<List<CompraDTO>>(compraService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> consultar(@PathVariable("id") final Long id) {
        return new ResponseEntity<CompraDTO>(compraService.consultar(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CompraDTO> salvar(@RequestBody final CompraCreateDTO compraCreateDTO) {
        return new ResponseEntity<CompraDTO>(compraService.salvar(compraCreateDTO), HttpStatus.CREATED);
    }

    // https://stackoverflow.com/questions/25287734/rest-actions-and-url-api-design-considerations
    @DeleteMapping("/{id}/estorno")
    public ResponseEntity<CompraDTO> estornar(@PathVariable("id") final Long id) {
        return new ResponseEntity<CompraDTO>(compraService.estornar(id), HttpStatus.OK);
    }

    // https://stackoverflow.com/questions/25287734/rest-actions-and-url-api-design-considerations
    @PatchMapping("/{id}/valor")
    public ResponseEntity<CompraDTO> alterarValor(@PathVariable("id") final Long id,
            @RequestBody final CompraValorDTO compraValorDTO) {
        return new ResponseEntity<CompraDTO>(compraService.alterarValor(id, compraValorDTO), HttpStatus.OK);
    }

}
