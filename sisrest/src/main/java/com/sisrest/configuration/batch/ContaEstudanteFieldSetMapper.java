package com.sisrest.configuration.batch;

import com.sisrest.model.entities.ContaEstudante;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class ContaEstudanteFieldSetMapper implements FieldSetMapper<ContaEstudante> {

    @Override
    public ContaEstudante mapFieldSet(FieldSet fieldSet) throws BindException {
        ContaEstudante contaEstudante = new ContaEstudante();
        contaEstudante.setNome(fieldSet.readString("nome"));
        contaEstudante.setMatricula(Long.parseLong(fieldSet.readString("matricula")));
        contaEstudante.setEmail(fieldSet.readString("email"));
        contaEstudante.setCampus(fieldSet.readString("campus"));
        contaEstudante.setCurso(fieldSet.readString("curso"));
        return contaEstudante;
    }
}
