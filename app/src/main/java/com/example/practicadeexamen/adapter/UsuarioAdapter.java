package com.example.practicadeexamen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicadeexamen.R;
import com.example.practicadeexamen.gestion.UsuarioGestion;
import com.example.practicadeexamen.model.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> implements View.OnClickListener{

    private List<Usuario> lista;
    private View.OnClickListener listener;

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public UsuarioAdapter(List<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }
    public UsuarioAdapter() {
        this.lista = UsuarioGestion.getUsuario();
    }
    public List<Usuario> getLista() {
        return lista;
    }
    public void refresh(){
        lista = UsuarioGestion.getUsuario();
    }
    @NonNull
    @Override
    public UsuarioAdapter.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_usuario, parent, false);
        vista.setOnClickListener(this);
        return new UsuarioViewHolder(vista);
    }
    @Override
    public void onBindViewHolder(@NonNull UsuarioAdapter.UsuarioViewHolder holder, int position) {
        holder.tvId.setText(""+lista.get(position).getId());
        holder.tvNombre.setText(lista.get(position).getNombre());
        holder.tvEdad.setText(""+lista.get(position).getEdad());
        holder.tvRol.setText(""+lista.get(position).getRol());
        holder.tvCantLogin.setText(""+lista.get(position).getCantidadLogin());
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
    private class UsuarioViewHolder extends RecyclerView.ViewHolder {
        public TextView tvId;
        public TextView tvNombre;
        public TextView tvEdad;
        public TextView tvRol;
        public TextView tvCantLogin;
        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvId = itemView.findViewById(R.id.tvId);
            this.tvNombre = itemView.findViewById(R.id.tvNombre);
            this.tvEdad = itemView.findViewById(R.id.tvEdad);
            this.tvRol = itemView.findViewById(R.id.tvRol);
            this.tvCantLogin = itemView.findViewById(R.id.tvCantLogin);
        }
    }
}
