package dev.boca.actividad3;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecordFragment extends Fragment implements View.OnClickListener {

    public static final int REQUEST_AUDIO_PERMISSION_CODE = 21; // Los permisos para obtener el audio
    private TextView filenameText; // El nombre de cada grabacion
    private NavController navController; // obtiene el controlador de navegacion
    private ImageButton listBtn; // Boton que va a la lista de grabaciones
    private ImageButton recordBtn; // Boton de grabacion
    private boolean isRecording = false; // Variable para comprobar si esta grabando
    private MediaRecorder mediaRecorder; // Objeto utilizado para grabar
    private String recordFile; // String para obtener el nombre del archivo
    private Chronometer timer; // Este es el cronometro

    public RecordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializamos las variables
        navController = Navigation.findNavController(view);
        listBtn = view.findViewById(R.id.record_list_button);
        recordBtn = view.findViewById(R.id.record_button);
        timer = view.findViewById(R.id.record_timer);
        filenameText = view.findViewById(R.id.record_filename);
        listBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.record_list_button: // Si se ha pulsado el boton de lista ejecuta lo siguiente
                if(isRecording){ // Si esta grabando salta una alerta indicando que no se puede ya que esta grabando
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setPositiveButton("Ok", null);
                    alertDialog.setTitle("¡¡¡ESTAS GRABANDO!!!");
                    alertDialog.setMessage("Para poder passar de página lo que tienes que hacer es detener la grabacion");
                    alertDialog.create().show();
                }else navController.navigate(R.id.action_recordFragment_to_audioListFragment); // Pasa a la ventana de las listas
                break;

            case R.id.record_button:
                if(isRecording) { // Para la gabracion si esta grabando
                    stopRecording();
                }else{ // Inicia la grabacion si no esta grabando
                    if(checkPermissions()){ // Y si tiene los permisos necesarios empieza a grabar
                        startRecording();
                    }
                }
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startRecording() {

        // Pedimos el nombre y luego el encoder
        final int[] audioEncoder = new int[1];
        AlertDialog.Builder builderName = new AlertDialog.Builder(getContext());
        builderName.setTitle("Introduce el nombre");

        final EditText input = new EditText(getContext());
        input.setText(getDate());
        builderName.setView(input);

        builderName.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 // Una vez introducido obtenemos el nombre e indicamos que esta grabando
                recordFile = input.getText().toString() + ".3gp";
                if(TextUtils.isEmpty(recordFile)) recordFile = getDate() + ".3gp";
                recordBtn.setImageResource(R.drawable.ic_stop);
                recordBtn.setBackgroundResource(R.drawable.circle_recording);
                isRecording = true;

                // EJecutamos el cronometro
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();

                mediaRecorder = new MediaRecorder(); // Iniciamos el media recorder
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC); // Introducimos el recurso
                if(audioEncoder[0] == MediaRecorder.AudioEncoder.AAC) mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                else if(audioEncoder[0] == MediaRecorder.AudioEncoder.AMR_NB) mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
                else if(audioEncoder[0] == MediaRecorder.AudioEncoder.AMR_WB) mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB);
                else mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mediaRecorder.setOutputFile(getPath() + "/" + recordFile);
                mediaRecorder.setAudioEncoder(audioEncoder[0]);

                filenameText.setText("Esta grabando, el nombre del archivo: " + recordFile);
                try {
                    mediaRecorder.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                mediaRecorder.start();
            }
        });


        final String[] opciones = {"AMR_NB", "AMR_WB", "AAC"};
        AlertDialog.Builder builderSetCodec = new AlertDialog.Builder(getContext());
        builderSetCodec.setTitle("Introduce el codec de audio");
        builderSetCodec.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(opciones[which].equals(opciones[0])) audioEncoder[0] = MediaRecorder.AudioEncoder.AMR_NB;
                if(opciones[which].equals(opciones[1])) audioEncoder[0] = MediaRecorder.AudioEncoder.AMR_WB;
                if(opciones[which].equals(opciones[2])) audioEncoder[0] = MediaRecorder.AudioEncoder.AAC;
                builderName.show();
            }
        });
        builderSetCodec.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void stopRecording() {
        timer.stop();
        filenameText.setText("La grabacion se ha detenido, nombre del archivo: " + recordFile);
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

        recordBtn.setImageResource(R.drawable.ic_mic);
        recordBtn.setBackgroundResource(R.drawable.circle_no_recording);
        isRecording = false;
    }

    private boolean checkPermissions() {
        if(ActivityCompat.checkSelfPermission(getContext(), RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getContext(), "Permisos garantizados", Toast.LENGTH_SHORT).show();
            return true;
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{RECORD_AUDIO}, REQUEST_AUDIO_PERMISSION_CODE);
        Toast.makeText(getContext(), "Permisos denegados", Toast.LENGTH_SHORT).show();
        return false;
    }

    public String  getPath(){
        return getActivity().getExternalFilesDir("/").getAbsolutePath();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getDate(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override public void onStop() {
        super.onStop();
        if(isRecording) stopRecording();
    }
}