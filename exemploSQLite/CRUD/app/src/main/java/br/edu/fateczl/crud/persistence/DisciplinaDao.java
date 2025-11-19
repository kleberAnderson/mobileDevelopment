package br.edu.fateczl.crud.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.crud.model.Disciplina;

public class DisciplinaDao implements ICRUDDao<Disciplina>, IDisciplinaDao {
    @Override
    public DisciplinaDao open() throws SQLException {
        return null;
    }

    @Override
    public void close() {

    }
    @Override
    public void insert(Disciplina disciplina) throws SQLException {

    }

    @Override
    public int update(Disciplina disciplina) throws SQLException {
        return 0;
    }

    @Override
    public void delete(Disciplina disciplina) throws SQLException {

    }

    @Override
    public Disciplina findOne(Disciplina disciplina) throws SQLException {
        return null;
    }

    @Override
    public List<Disciplina> findAll() throws SQLException {
        return null;
    }
}
