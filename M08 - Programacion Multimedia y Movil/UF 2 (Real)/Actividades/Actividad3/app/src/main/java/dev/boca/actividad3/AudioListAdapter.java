package dev.boca.actividad3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.AudioViewHolder>{

    private File[] allFiles; // Este es un array donde se van a guardar todos los archivos
    private TimeAgo timeAgo; // Este es un objeto de la clase TimeAgo, que sirve para obtener el tiempo del archivo
    private onItemListClick onItemListClick;

    public AudioListAdapter(File[] allfiles, onItemListClick onItemListClick){
        this.allFiles = allfiles; // guardamos los datos de los archivos
        this.onItemListClick = onItemListClick;
    }

    @NonNull @Override public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false); // Utilizamos la view para
        timeAgo = new TimeAgo(); // Inicilizamos el objeto TimeAgo
        return new AudioViewHolder(view); // Retornamos la vista
    }

    @Override public void onBindViewHolder(@NonNull AudioViewHolder holder, int position) {
        holder.list_title.setText(allFiles[position].getName());
        holder.list_date.setText(timeAgo.getTimeAgo(allFiles[position].lastModified()));
    }

    // Obtenemos cuanto
    @Override public int getItemCount() {
        return allFiles.length;
    }

    public class AudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView list_title, list_date, list_image; // Creamos las variables de textview
        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);

            // inicializamos las variables
            list_image = itemView.findViewById(R.id.list_image);
            list_title = itemView.findViewById(R.id.list_title);
            list_date = itemView.findViewById(R.id.list_date);

            itemView.setOnClickListener(this);
        }

        @Override public void onClick(View v) { // Depende a la posicion que se haya pulsado se ejecutara un audio u otro
            onItemListClick.onClickListener(allFiles[getAdapterPosition()], getAdapterPosition());
        }
    }

    public interface onItemListClick{ // Creamos una interfaz para que se pueda implementar en otro metodo
        void onClickListener(File file, int position);
    }
}