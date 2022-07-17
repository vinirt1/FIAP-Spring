package br.com.fiap.spring.util;

import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.fiap.spring.model.dto.CompraDTO;

public class FaturaUtil {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    private FaturaUtil() {

    }

    public static String montarTextoFatura(final List<CompraDTO> listaCompras) {

        StringBuilder stringBuilder = new StringBuilder();
        final String tituloCartao = String.format("%-16s", "Cartão");
        final String tituloBandeira = String.format("%-15s", "Bandeira");
        final String tituloEstabelecimento = String.format("%-30s", "Estabelecimento");
        final String tituloValor = String.format("%-20s", "Valor");
        final String tituloDataHora = String.format("%-20s", "Data/Hora");

        stringBuilder
                .append(tituloCartao + " " + tituloBandeira + " " + tituloEstabelecimento + " " + tituloValor + " "
                        + tituloDataHora + "\n\n");

        for (CompraDTO compraDTO : listaCompras) {
            final String numeroCartao = String.format("%16s", compraDTO.getNumeroCartao().toString());
            final String bandeiraCartao = String.format("%-15s", compraDTO.getBandeiraCartao());
            final String estabelecimento = String.format("%-30s", compraDTO.getEstabelecimento());
            final String valor = String.format("%-20s", "R$ " + compraDTO.getValor());
            final String dataHora = String.format("%20s", compraDTO.getDataHora().format(formatter));

            stringBuilder.append(numeroCartao + " " + bandeiraCartao + " "
                    + estabelecimento + " " + valor + " "
                    + dataHora
                    + "\n");
        }

        return stringBuilder.toString();
    }
}
