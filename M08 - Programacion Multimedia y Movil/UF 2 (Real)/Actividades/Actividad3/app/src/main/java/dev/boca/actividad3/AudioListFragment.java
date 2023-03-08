package dev.boca.actividad3;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.File;
import java.io.IOException;

public class AudioListFragment extends Fragment implements AudioListAdapter.onItemListClick {
    private boolean isPlaying = false; // Para comprobar si el reproductor esta sonando o no
    private AudioListAdapter audioListAdapter; // Objeto para hacer la recycler view de las listas
    private BottomSheetBehavior bottomSheetBehavior; // Este es la pantalla que sirve para desplegar el reproductor
    private ConstraintLayout playerSheet;
    private File fileToPlay, allFiles[]; // Variable del archivo que va a sonar y de todos los archivos
    private Handler seekbarHandler; // Esta variable se utiliza para configurar la seekbar
    private ImageButton playBtn; // Esta es la imagen del boton de play que se visualiza en el reproductpr
    private MediaPlayer mediaPlayer = null; // Es el media player que utilizmos para ahaer sonar los archivos
    private RecyclerView audioList; // Es el recycler view que hace que se muestre todas los audios
    private Runnable updateSeekbar; // Este objeto se utiliza para actualizar la seekbar
    private SeekBar seekbar; // Esta es la variable de la seekbar
    private TextView playerHeader, playerFileName; // Estos son los textos que utilizamos para decir si esta sonando y el nombre del archivo

    public AudioListFragment(){}

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_audio_list, container, false); // Indica que fragment vamos a utilizar
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializamos todas las variables
        playerSheet = view.findViewById(R.id.player_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(playerSheet);
        audioList = view.findViewById(R.id.audio_list_view);
        playBtn = view.findViewById(R.id.player_play);
        playerHeader = view.findViewById(R.id.player_header_name);
        playerFileName = view.findViewById(R.id.player_file_name);
        seekbar = view.findViewById(R.id.seekbar);

        String path = getActivity().getExternalFilesDir("/").getAbsolutePath(); // Obtenemos la carpeta
        allFiles = new File(path).listFiles(); // obtenemos todos los archivos
        audioListAdapter = new AudioListAdapter(allFiles, this); // Inicializamos el adapter
        audioList.setLayoutManager(new LinearLayoutManager(getContext())); // Le damos al context
        audioList.setAdapter(audioListAdapter); // Al recycler view le damos el audio list


        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            // Si desaparece el BottomSheet lo vuelve a mostrara automaticamente
            @Override public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
            @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {}
        });

        // listener para pausar o seguir la musica
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying) pauseAudio(); // Si la grabacion suena la para
                else if(fileToPlay != null) resumeAudio();// Si la grabacion esta parada lo que va a hacer es sonar
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}
            @Override public void onStartTrackingTouch(SeekBar seekBar) {
                pauseAudio(); // Cuando se mueve la seekbar se para el audio
            }
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress(); // obtiene el progreso de la barra
                mediaPlayer.seekTo(progress); // Lo que hace es pasarle la posicion de la seekbar para que la cancion se mueva hasta alli
                resumeAudio(); // Vuelve a iniciar el audio
            }
        });
    }

    @Override
    public void onClickListener(File file, int position) {
        fileToPlay = file; // Le pasa el audio a la cancion que suena
        if (isPlaying) stopAudio(); // si suena el audio para el audio
        else playAudio(fileToPlay); // sino lo inicia
    }

    // Para el audio y cambia las imagenes
    private void pauseAudio(){
        mediaPlayer.pause();
        isPlaying = false;
        playBtn.setImageResource(R.drawable.ic_play);
        seekbarHandler.removeCallbacks(updateSeekbar);
        updateRunnable();
    }

    // Vuele a iniciar el audio
    private void resumeAudio(){
        mediaPlayer.start();
        isPlaying = true;
        playBtn.setImageResource(R.drawable.ic_pause);
    }

    // Para el audio
    private void stopAudio() {
        if(isPlaying){
            isPlaying = false;
            playerHeader.setText("Stopped");
            playBtn.setImageResource(R.drawable.ic_play);
            mediaPlayer.stop();
            fileToPlay = null;
        }
    }

    // ejecuta el audio y cambia los recursos
    private void playAudio(File fileToPlay) {
        mediaPlayer = new MediaPlayer();
        playBtn.setImageResource(R.drawable.ic_pause);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        try {
            mediaPlayer.setDataSource(fileToPlay.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
        }

        playBtn.setImageResource(R.drawable.ic_pause);
        playerFileName.setText(fileToPlay.getName());
        playerHeader.setText("Playing");
        isPlaying = true;
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopAudio();
                playerHeader.setText("Finalizado!");
            }
        });
        seekbar.setMax(mediaPlayer.getDuration());
        seekbarHandler = new Handler();
        updateRunnable();
    }

    private void updateRunnable() {
        updateSeekbar = new Runnable() {
            @Override
            public void run() {
                seekbar.setProgress(mediaPlayer.getCurrentPosition());
                seekbar.postDelayed(this, 10);
            }
        };
        seekbarHandler.postDelayed(updateSeekbar, 0);
    }

    @Override
    public void onStop() {
        super.onStop();
        stopAudio();
    }
}