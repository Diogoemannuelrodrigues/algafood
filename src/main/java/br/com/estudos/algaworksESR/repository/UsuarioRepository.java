package br.com.estudos.algaworksESR.repository;

import br.com.estudos.algaworksESR.entidade.Usuario;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UsuarioRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Usuario save(Usuario usuario){
        dynamoDBMapper.save(usuario);
        return usuario;
    }

    public Usuario getUsuario(String usuarioId){
        return dynamoDBMapper.load(Usuario.class, usuarioId);
    }
    public String delete(String usuarioId){
        Usuario usuario = getUsuario(usuarioId);
        dynamoDBMapper.delete(usuario);
        return "Usuario: "+ usuario + " Deletado.";
    }


    public String update(String usuarioId, Usuario usuario){
        dynamoDBMapper.save(usuario,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("usuarioId",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(usuarioId)
                        )));
        return usuarioId;
    }
}
