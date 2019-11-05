package com.example.instanews.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instanews.views.Interface.RecyclerViewOnClick;
import com.example.instanews.R;
import com.example.instanews.model.pojos.Noticias;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Noticias> listanoticias;
    private RecyclerViewOnClick listener;

    public HomeAdapter(List<Noticias> listanoticias, RecyclerViewOnClick listener) {
        this.listanoticias = listanoticias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_noticias, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        final Noticias noticias = listanoticias.get(position);
        holder.onBind(noticias);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(noticias);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listanoticias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView descricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.tituloviagem_id);
            descricao = itemView.findViewById(R.id.descricao_id);

        }


        public void onBind(Noticias noticias) {
            titulo.setText(noticias.getTitulo());
            descricao.setText(noticias.getDescricao());

        }
    }
}
