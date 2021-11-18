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


    public Usuario save(Usuario employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }

    public Usuario getEmployeeById(String employeeId) {
        return dynamoDBMapper.load(Usuario.class, employeeId);
    }

    public String delete(String employeeId) {
        Usuario emp = dynamoDBMapper.load(Usuario.class, employeeId);
        dynamoDBMapper.delete(emp);
        return "Employee Deleted!";
    }

    public String update(String usuarioId, Usuario employee) {
        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("employeeId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(usuarioId)
                                )));
        return usuarioId;
    }
}
