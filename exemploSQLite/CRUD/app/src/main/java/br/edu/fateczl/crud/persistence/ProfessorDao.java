package br.edu.fateczl.crud.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.crud.model.Professor;

public class ProfessorDao implements ICRUDDao<Professor>, IProfessorDao{
    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase dataBase;

    public ProfessorDao(Context context) {
        this.context = context;
    }
    
    @Override
    public ProfessorDao open() throws SQLException {
        gDao = new GenericDao(context);
        dataBase = gDao.getWritableDatabase();
        return this;
    }

    @Override
    public void close() {
        gDao.close();
    }
    @Override
    public void insert(Professor professor) throws SQLException {
        ContentValues contentValues = getContentValues(professor);
        dataBase.insert("professor", null, contentValues);
    }

    @Override
    public int update(Professor professor) throws SQLException {
        ContentValues contentValues = getContentValues(professor);
        return dataBase.update("professor", contentValues,
                "codigo = " + professor.getCodigo(), null);
    }

    @Override
    public void delete(Professor professor) throws SQLException {
       dataBase.delete("professor", "codigo = " + professor.getCodigo(),
               null);
    }

    @SuppressLint("Range")
    @Override
    public Professor findOne(Professor professor) throws SQLException {
        String sql = "SELECT codigo, nome, titulacao FROM professor WHERE codigo = " +
                professor.getCodigo();
        Cursor cursor = dataBase.rawQuery(sql, null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            professor.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
            professor.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            professor.setTitulacao(cursor.getString(cursor.getColumnIndex("titulacao")));
        }
        cursor.close();
        return professor;
    }
    @SuppressLint("Range")
    @Override
    public List<Professor> findAll() throws SQLException {
        List<Professor> professores= new ArrayList<>();
        String sql = "SELECT codigo, nome, titulacao FROM professor";
        Cursor cursor = dataBase.rawQuery(sql, null);
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            Professor professor = new Professor();
            professor.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
            professor.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            professor.setTitulacao(cursor.getString(cursor.getColumnIndex("titulacao")));

            cursor.moveToNext();
            professores.add(professor);
        }
        cursor.close();
        return professores;
    }

    private static ContentValues getContentValues(Professor professor) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", professor.getCodigo());
        contentValues.put("nome", professor.getNome());
        contentValues.put("titulacao", professor.getTitulacao());

        return contentValues;
    }
}
