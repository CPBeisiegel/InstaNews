package com.example.instanews.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instanews.model.pojos.Article;
import com.example.instanews.views.Interface.RecyclerViewOnClick;
import com.example.instanews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> listanoticias;
    private RecyclerViewOnClick listener;

    public ArticleAdapter(List<Article> listanoticias, RecyclerViewOnClick listener) {
        this.listanoticias = listanoticias;
        this.listener = listener;
    }

    public ArticleAdapter(List<Article> listanoticias) {
        this.listanoticias = listanoticias;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_noticias, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
        final Article noticias = listanoticias.get(position);
        holder.onBind(noticias);

        holder.itemView.setOnClickListener(v -> listener.onClick(noticias));
    }

    @Override
    public int getItemCount() {
        return listanoticias.size();
    }

    public void atualizaLista(List<Article> novaLista){
        this.listanoticias.clear();
        this.listanoticias = novaLista;
        notifyDataSetChanged();
    }

    public void clear(){
        this.listanoticias.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView descricao;
        private ImageView imgNot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNot = itemView.findViewById(R.id.imgcard);
            titulo = itemView.findViewById(R.id.tituloviagem_id);
            descricao = itemView.findViewById(R.id.descricao_id);
        }


        public void onBind(Article noticias) {
            Picasso.get().load(noticias.getUrlToImage()).into(imgNot);
            titulo.setText(noticias.getTitle());
            descricao.setText(noticias.getDescription());
        }
    }
}
