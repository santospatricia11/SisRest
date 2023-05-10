package com.sisrest.configuration.batch;

import com.sisrest.model.entities.BeneficiarioRaw;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class BeneficiarioRawFieldSetMapper implements FieldSetMapper<BeneficiarioRaw> {
    @Override
    public BeneficiarioRaw mapFieldSet(FieldSet fieldSet) throws BindException {
        BeneficiarioRaw beneficiarioRaw = new BeneficiarioRaw();
        beneficiarioRaw.setNome(fieldSet.readString("nome"));
        beneficiarioRaw.setMatricula(fieldSet.readString("matricula"));
        beneficiarioRaw.setCpf(fieldSet.readString("cpf"));
        beneficiarioRaw.setCurso(fieldSet.readString("curso"));
        beneficiarioRaw.setPrograma(fieldSet.readString("programa"));
        beneficiarioRaw.setModalidade(fieldSet.readString("modalidade"));
        beneficiarioRaw.setSituacao(fieldSet.readString("situacao"));
        beneficiarioRaw.setClassificacao(fieldSet.readString("classificacao"));
        beneficiarioRaw.setPontuacao(fieldSet.readString("pontuacao"));
        beneficiarioRaw.setRendaBruta(fieldSet.readString("rendaBruta"));
        beneficiarioRaw.setQtdePessoas(fieldSet.readString("qtDePessoas"));
        beneficiarioRaw.setPercapta(fieldSet.readString("percapta"));
        beneficiarioRaw.setCota(fieldSet.readString("cota"));
        beneficiarioRaw.setNascimento(fieldSet.readString("nascimento"));
        beneficiarioRaw.setValor(fieldSet.readString("valor"));
        return beneficiarioRaw;
    }
}
