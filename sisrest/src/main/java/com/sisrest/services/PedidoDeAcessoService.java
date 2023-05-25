package com.sisrest.services;

import com.sisrest.dto.pedidoDeAcesso.PedidoDeAcessoRequest;
import com.sisrest.dto.pedidoDeAcesso.PedidoDeAcessoResponse;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.PedidoDeAcesso;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.repositories.PedidoDeAcessoRepository;
import com.sisrest.services.convertes.AcessoDiaRefeicaoServiceConvert;
import com.sisrest.services.convertes.PedidoDeAcessoServiceConvert;
import com.sisrest.services.convertes.RestricaoAlimentarServiceConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoDeAcessoService {
    @Autowired
    private PedidoDeAcessoRepository pedidoDeAcessoRepository;

    @Autowired
    private PedidoDeAcessoServiceConvert pedidoDeAcessoServiceConvert;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private RestricaoAlimentarServiceConvert restricaoAlimentarServiceConvert;

    @Autowired
    private AcessoDiaRefeicaoServiceConvert acessoDiaRefeicaoServiceConvert;

    public PedidoDeAcessoResponse save(PedidoDeAcessoRequest pedidoDeAcessoDto) {
        PedidoDeAcesso pedidoDeAcesso = pedidoDeAcessoServiceConvert.dtoToPedidoDeAcesso(pedidoDeAcessoDto);
        pedidoDeAcesso.isAprovadoFalse();
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(pedidoDeAcessoDto.getBeneficiario());
        pedidoDeAcesso.setBeneficiario(beneficiario.get());
        pedidoDeAcesso.setRestricoesAlimentares(restricaoAlimentarServiceConvert.restricaoRequestToRestricaoList(pedidoDeAcessoDto.getRestricaoAlimentar(), pedidoDeAcesso));
        pedidoDeAcesso.setAcessosDiaRefeicao(acessoDiaRefeicaoServiceConvert.acessoRequestToAcessoDiaList(pedidoDeAcessoDto.getDiasAcessoRefeicao(), pedidoDeAcesso));
        pedidoDeAcesso = pedidoDeAcessoRepository.save(pedidoDeAcesso);

        PedidoDeAcessoResponse responseDto = pedidoDeAcessoServiceConvert.pedidoDeAcessoToDTO(pedidoDeAcesso);
        return responseDto;
    }

    public PedidoDeAcessoResponse deleteById(long id) {
        Optional<PedidoDeAcesso> pedidoDeAcesso = pedidoDeAcessoRepository.findById(id);
        pedidoDeAcessoRepository.deleteById(id);
        PedidoDeAcessoResponse responseDto = pedidoDeAcessoServiceConvert.pedidoDeAcessoToDTO(pedidoDeAcesso.get());
        return responseDto;
    }

    public PedidoDeAcessoResponse findById(long id) {
        Optional<PedidoDeAcesso> pedidoDeAcesso = pedidoDeAcessoRepository.findById(id);
        PedidoDeAcessoResponse responseDto = pedidoDeAcessoServiceConvert.pedidoDeAcessoToDTO(pedidoDeAcesso.get());
        return responseDto;
    }

    public List<PedidoDeAcessoResponse> findAll() {
        return pedidoDeAcessoServiceConvert.pedidoDeAcessoToResponses(pedidoDeAcessoRepository.findAll());
    }

    public PedidoDeAcessoResponse update(long id, PedidoDeAcessoRequest pedidoDeAcessoDto) {
        Optional<PedidoDeAcesso> pedidoDeAcesso = pedidoDeAcessoRepository.findById(id);
        PedidoDeAcesso original = pedidoDeAcesso.get();
        PedidoDeAcesso atualizar = pedidoDeAcessoServiceConvert.dtoToPedidoDeAcesso(pedidoDeAcessoDto);
        boolean verificado = pedidoDeAcessoRepository.existsById(pedidoDeAcesso.get().getId());

        if (verificado) atualizar.setId(pedidoDeAcesso.get().getId());

        if (atualizar.getSolicitadoEm() == null) {
            atualizar.setSolicitadoEm(original.getSolicitadoEm());
        } else if (atualizar.getAnalisadoEm() == null) {
            atualizar.setAnalisadoEm(original.getAnalisadoEm());
        } else if (atualizar.getJustificativaAnalise() == null) {
            atualizar.setJustificativaAnalise(original.getJustificativaAnalise());
        } else if (atualizar.getBeneficiario() == null) {
            atualizar.setBeneficiario(original.getBeneficiario());
        } else if (atualizar.getRestricoesAlimentares() == null) {
            atualizar.setRestricoesAlimentares(original.getRestricoesAlimentares());
        } else if (atualizar.getAcessosDiaRefeicao() == null) {
            atualizar.setAcessosDiaRefeicao(original.getAcessosDiaRefeicao());
        }

        PedidoDeAcessoResponse responseDto = pedidoDeAcessoServiceConvert.pedidoDeAcessoToDTO(pedidoDeAcessoRepository.save(atualizar));
        return responseDto;
    }

    public PedidoDeAcessoResponse aprovarPedido(Long id) {
        Optional<PedidoDeAcesso> pedidoDeAcesso = pedidoDeAcessoRepository.findById(id);
        PedidoDeAcesso pedido = pedidoDeAcesso.get();
        pedido.isAprovadoTrue();
        PedidoDeAcessoResponse responseDto = pedidoDeAcessoServiceConvert.pedidoDeAcessoToDTO(pedidoDeAcessoRepository.save(pedido));
        return responseDto;
    }
}
