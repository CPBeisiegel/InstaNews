package com.example.instanews.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instanews.Interface.RecyclerSignoOnClick;
import com.example.instanews.Interface.RecyclerViewOnClick;
import com.example.instanews.R;
import com.example.instanews.model.Noticias;
import com.example.instanews.model.Signo;

import java.util.List;

public class SignoAdapter extends RecyclerView.Adapter<SignoAdapter.ViewHolder> {

    private List<Signo> listaSignos;
    private RecyclerSignoOnClick signoListener;

    public SignoAdapter(List<Signo> listaSignos, RecyclerSignoOnClick signoListener) {
        this.listaSignos = listaSignos;
        this.signoListener = signoListener;
    }

    @NonNull
    @Override
    public SignoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SignoAdapter.ViewHolder holder, int position) {
        final Signo signo = listaSignos.get(position);
        holder.onBind(signo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signoListener.onClick(signo);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listaSignos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeSigno;
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iconeSigno);

            nomeSigno = itemView.findViewById(R.id.signoCardNome);

        }


        public void onBind(Signo signo) {
            nomeSigno.setText(signo.getNomeSigno());
            Drawable drawable = itemView.getResources().getDrawable(signo.imagemSigno);
            img.setImageDrawable(drawable);

        }
    }
}
