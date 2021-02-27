package com.example.practicadeexamen.gestion;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.practicadeexamen.datos.AdminDB;
import com.example.practicadeexamen.model.Usuario;

import java.util.ArrayList;

public class UsuarioGestion {
    private static AdminDB data=null; //La base de datos física
    private static SQLiteDatabase conexion = null; //La conexión a la base de datos

    //Se inicializa la referencia a la base de datos para usar estiantes
    public static void init(AdminDB data) {
        UsuarioGestion.data=data;
    }

    public static boolean inserta(Usuario usuario) {
        long registro=-1;
        if (usuario!=null) {
            ContentValues info = new ContentValues();
            info.put("id",usuario.getId());
            info.put("nombre",usuario.getNombre());
            info.put("edad",usuario.getEdad());
            info.put("rol",usuario.getRol());
            info.put("cantidadLogin",usuario.getCantidadLogin());
            //ContentValues --> info --> Map --> {{"id",1},{"nombre",'Juan'},{"edad",18}}
            conexion=data.getWritableDatabase();
            registro=conexion.insert("usuarios",
                    null,
                    info);
            conexion.close();
        }
        return registro!=-1;  //Retorna true si es un numero de registro válido, false si no lo es...
    }

    public static Usuario busca(int id) {
        Usuario usuario=null;
        conexion = data.getReadableDatabase();
        Cursor datos=conexion.rawQuery("select * from usuarios where id=?",
                new String[]{""+id+""});
        //Cursor datos2=conexion.rawQuery("select * from estudiante where id="+id,null);

        if (datos.moveToFirst()) {  //Si logra ubicarse en el primer registro... lo encontró
            usuario = new Usuario(
                    datos.getInt(0),  //id del estudiante
                    datos.getString(1),  //nombre del estudiante
                    datos.getInt(2),   //Edad del estudiante
                    datos.getString(3), //Edad del estudiante
                    datos.getInt(4)   //Edad del estudiante
            );
        }
        conexion.close();
        return usuario;  //Si estudiante es null no lo encontró.. sino entonces si lo encontró
    }

    public static boolean actualiza(Usuario usuario) {
        long registro=-1;
        if (usuario!=null) {
            ContentValues info = new ContentValues();
            info.put("id",usuario.getId());
            info.put("nombre",usuario.getNombre());
            info.put("edad",usuario.getEdad());
            info.put("rol",usuario.getEdad());
            info.put("cantidadUsuario",usuario.getEdad());
            //ContentValues --> info --> Map --> {{"id",1},{"nombre",'Juan'},{"edad",18}}
            conexion=data.getWritableDatabase();
            registro=conexion.update("usuario",
                    info,
                    "id=?",
                    new String[]{""+usuario.getId()+""});
            conexion.close();
        }
        return registro==1;  //Retorna true si actualizó un registro, false si no...
    }

    public static boolean elimina(int id) {
        conexion=data.getWritableDatabase();
        long valor = conexion.delete("usuarios",
                "id=?",
                new String[]{""+id+""});
        conexion.close();
        return valor==1;
    }

    public static ArrayList<Usuario> getUsuario() {
        ArrayList<Usuario> lista=new ArrayList<>();
        conexion=data.getReadableDatabase();
        Cursor datos = conexion.rawQuery("select * from usuarios",null);
        while (datos.moveToNext()) {
            lista.add(new Usuario(
                    datos.getInt(0),  //id del estudiante
                    datos.getString(1),  //nombre del estudiante
                    datos.getInt(2),   //Edad del estudiante
                    datos.getString(3), //Rol del estudiante
                    datos.getInt(4)   //Cantidad Login del estudiante
            ));
        }
        conexion.close();
        return lista;
    }
}
