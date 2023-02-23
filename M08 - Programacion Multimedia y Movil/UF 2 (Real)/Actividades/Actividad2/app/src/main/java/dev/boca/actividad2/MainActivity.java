package dev.boca.actividad2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import android.graphics.*;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // componentes que estamos utilizando
    ImageView img_song; // Es la imagen de la cancion
    TextView titleSong, artistSong, secondsNow, secondsSong;
    // Estas variables son:
    //      el titulo de la cancion
    //      el artista de la cancion
    //      el tiempo transucrrido de la cancion
    //      el tiempo de la cancion

    ImageButton buttonPlay, buttonPrevious, buttonNext, buttonRepeat, buttonRandom;
    SeekBar seekBar;

    View view; // Este variable para mirar si es la vista principal
    int repeat = 2, position = 0; // Estas variables, es para obtener si se va a repetir y la posicion de la cancion.

    MediaPlayer mpVector [] = new MediaPlayer[3]; // Este vector sirve para almacenar las canciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aqui estamos declarando los componentes de la aplicacion
        buttonPlay = (ImageButton) findViewById(R.id.button_play); // Boton de play
        buttonPrevious= (ImageButton) findViewById(R.id.button_previous_song); // Boton de la cancion previa
        buttonNext = (ImageButton) findViewById(R.id.button_next_song); // Boton de la sigueinte cancion
        buttonRandom = (ImageButton) findViewById(R.id.button_random); // Boton que salta a una cancion aleatoria
        titleSong = findViewById(R.id.title_song); // El texto del titulo de la cancion
        artistSong = findViewById(R.id.artist_song); // El texto del artista de la cancion
        secondsNow = findViewById(R.id.seconds_now); // El tiempo actual de la cancion
        secondsSong = findViewById(R.id.seconds_song); // El tiempo de la cancion
        buttonRepeat = (ImageButton) findViewById(R.id.button_repeat); // El boton que hace repetir la misma cancion
        img_song = (ImageView) findViewById(R.id.imageview); // La imagen de la cancion
        seekBar = (SeekBar) findViewById(R.id.seekbar); // La seekbar que va avanzando

        // Aqui almacenamos las canciones
        mpVector[0] = MediaPlayer.create(this, R.raw.el_credo);
        mpVector[1] = MediaPlayer.create(this, R.raw.igualdad_no_te_vayas_todavia);
        mpVector[2] = MediaPlayer.create(this, R.raw.presentacion_jarabe_de_palo);

        ImageBorderRadius(); // Llamamos a este metodo para redondear la imagen
        controlSound();
    }

    private void controlSound() {
        // Llamamos al metodo para la cancion anterior y almacenamos la vista actual
        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreviousSong(v);
                view = v;
            }
        });

        // Llamamos al metodo para la siguiente cancion y almacenamos la vista actual
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextSong(v);
                view = v;
            }
        });

        // Llamamos al metodo para pausar la cancion y almacenamos la vista actual
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayPause(v);
                view = v;
            }
        });

        // LLamamos al metodo para repetir la cancion y almacenamos la vista actual
        buttonRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RepeatSong(v);
                view = v;
            }
        });

        // Llamamos al metodo para hacer sonar una cancion aleatoria y almacenamos la vista actual
        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomSong();
                view = v;
            }
        });

        // Llamamos al metodo para que automaticamente saltea la siguiente cancion cuando esta se termine
        automaticNextSong();

        // Este metodo sirve para cuando queremos avanzar la cancion por la seekbar, pues para que avance
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mpVector[position].seekTo(progress);
                }
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    // Metodo playPause
    public void PlayPause(View view){
        if(mpVector[position].isPlaying()){ // Si la cancion esta sonando se pausara y cambiara el icono
            mpVector[position].pause();
            buttonPlay.setImageResource(R.drawable.ic_play);
        }else{ // Si la cancion no esta sonando se volvera a reproducir y cambiara el icono
            mpVector[position].start();
            buttonPlay.setImageResource(R.drawable.ic_pause);
            initializeSeekBar();
        }
    }

    // Este metodo sirve para saltar la cancion anterior
    public void PreviousSong(View view){
        if(position == 0){ // Comprobamos la posicion actual
            if(mpVector[position].isPlaying()){ // Comprobamos si la cancion esta sonando
                if(mpVector[position].isLooping()) { // Comprobamos si la cancion se la ha indicado se repita
                    RepeatSong(view); // Llamamos al metodo para que repita la cancion, para desactivar el modo repeticion
                }
                mpVector[position].stop(); // Paramos completamente la cancion
                mpVector[position] = MediaPlayer.create(this, R.raw.el_credo); // Como la cancion se elimina al hacer stop, la volvemos a llamar en la posicion que esta
            }
            position = 2; // Cambiamos la posicion, ya que se cambia de cancion
            img_song.setImageResource(R.drawable.jarabe_de_palo); // Cambiamos la imagen de la cancion
            mpVector[position].start(); // Iniciamos la cancion
            buttonPlay.setImageResource(R.drawable.ic_pause); // Cambiamos el recurso del boton de play
            titleSong.setText("Presentacion de la banda"); // Cambiamos el texto de la cancion
            artistSong.setText("Jarabe de Palo (Chirigota)"); // Cambiamos el artista de la cancion
            ImageBorderRadius(); // Hacemos la imagen que tenga los bordes redondeados
        } else if(position == 2){
            if(mpVector[position].isPlaying()){
                if(mpVector[position].isLooping()) {
                    RepeatSong(view);
                }
                mpVector[position].stop();
                mpVector[position] = MediaPlayer.create(this, R.raw.el_credo);
            }
            position = 1;
            img_song.setImageResource(R.drawable.no_te_vayas_todavia);
            mpVector[position].start();
            buttonPlay.setImageResource(R.drawable.ic_pause);
            titleSong.setText("Pasodoble de la Igualdad");
            artistSong.setText("No te vayas todavia");
            ImageBorderRadius();
        }else if(position == 1){
            if(mpVector[position].isPlaying()){
                if(mpVector[position].isLooping()) {
                    RepeatSong(view);
                }
                mpVector[position].stop();
                mpVector[position] = MediaPlayer.create(this, R.raw.el_credo);
            }
            position = 0;
            img_song.setImageResource(R.drawable.juan_carlos_aragon);
            mpVector[position].start();
            buttonPlay.setImageResource(R.drawable.ic_pause);
            titleSong.setText("El credo");
            artistSong.setText("Juan Carlos Aragon");
            ImageBorderRadius();
        }
        initializeSeekBar(); // Inicializamos la seekbar
        automaticNextSong(); // Cuando se acabe la cancion saltara a la siguiente cancion
    }

    // Este es el metodo para la siguiente cancion
    public void NextSong(View view){
        if(position == 0){ // Comprobamos la posicion
            if(mpVector[position].isPlaying()){ // Comrobamos si la cancion esta sonando
                if(mpVector[position].isLooping()) { // Comprobamos si la cancion esta en bucle-
                    RepeatSong(view); // Llamamos al metodo para que repita la cancion, para desactivar el modo repeticion
                }
                mpVector[position].stop(); // Hacemos que se pare la cancion
                mpVector[position] = MediaPlayer.create(this, R.raw.el_credo); // Al hacer parar la cancion, se destruye y lo que tenemos que hacer es volver a instanciar la cancion
            }
            position = 1; // Cambiamos la posicion, ya que se cambia de cancion
            img_song.setImageResource(R.drawable.no_te_vayas_todavia); // Cambiamos el recurso de la imagen
            mpVector[position].start(); // Iniciamos la cancion
            buttonPlay.setImageResource(R.drawable.ic_pause); // Cambiamos el icono del boton de Play
            titleSong.setText("Pasodoble de la Igualdad"); // Cambiamos el titulo de la cancion
            artistSong.setText("No te vayas todavia"); // Cabiamos el artista de la cancion
            ImageBorderRadius(); // Llamamos al metodo para que se redondeen las imagenes
        } else if(position == 1){
            if(mpVector[position].isPlaying()) {
                if(mpVector[position].isLooping()) {
                    RepeatSong(view);
                }
                mpVector[position].stop();
                mpVector[position] = MediaPlayer.create(this, R.raw.igualdad_no_te_vayas_todavia);
            }
            position = 2;
            img_song.setImageResource(R.drawable.jarabe_de_palo);
            mpVector[position].start();
            buttonPlay.setImageResource(R.drawable.ic_pause);
            titleSong.setText("Presentacion de la banda");
            artistSong.setText("Jarabe de Palo (Chirigota)");
            ImageBorderRadius();
        }else if(position == 2){
            if(mpVector[position].isPlaying()) {
                if(mpVector[position].isLooping()) {
                    RepeatSong(view);
                }
                mpVector[position].stop();
                mpVector[position] = MediaPlayer.create(this, R.raw.presentacion_jarabe_de_palo);
            }
            position = 0;
            img_song.setImageResource(R.drawable.juan_carlos_aragon);
            mpVector[position].start();
            buttonPlay.setImageResource(R.drawable. ic_pause);
            titleSong.setText("El credo");
            artistSong.setText("Juan Carlos Aragon");
            ImageBorderRadius();
        }
        initializeSeekBar(); // Incializamos la seekbar
        automaticNextSong(); // Cuando se acabe la cancion va a saltar la siguiente
    }

    public void initializeSeekBar(){
        int milis = mpVector[position].getDuration(); // Obtenemos los milisegundos de la cancion
        // Obtenemos los segundos y milisegundos
        int totalseconds = milis/1000;
        int totalMinutes = totalseconds/60;
        int seconds = totalseconds % 60;
        int minutes = totalMinutes % 60;

        // Indicamos el maximo de la barra y ponemos el tiempo de l cancion
        secondsSong.setText("0" + minutes  + ":" + seconds);
        seekBar.setMax(milis);

        // Creamos un objeto handler que va a ser el que vaya avanzando el puntero de la seekbar
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    seekBar.setProgress(mpVector[position].getCurrentPosition());
                    handler.postDelayed(this, 1000);
                }catch (Exception e){
                    seekBar.setProgress(0);
                }
            }
        }, 0);

        // Creamos otro handler para que el texto de la textview vaya avanzando
        Handler handlerSeconds = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int totalseconds = mpVector[position].getCurrentPosition()/1000;
                int totalMinutes = totalseconds/60;

                int seconds = totalseconds % 60;
                int minutes = totalMinutes % 60;
                String sSeconds = (seconds < 10 ? "0" + seconds : "" + seconds);
                String sMinutes = (minutes < 10 ? "0" + minutes : "" + minutes);
                secondsNow.setText(sMinutes + ":" + sSeconds);
                handlerSeconds.postDelayed(this, 1000);
            }
        };
        handlerSeconds.post(runnable);
    }

    // este es el metodo que hace repetir la cancion
    public void RepeatSong(View view){
        Drawable drawable = buttonRepeat.getDrawable(); // Obtenemos el recurso del boton de repetir cancion
        if(repeat == 1){ // Comprobamos si es para desactivar la repeticion
            drawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN); // Cambiamos el
            mpVector[position].setLooping(false); // Indicamos que no queremos que se repita
            repeat = 2; // cambiamos el valor de repeticion
        }else{ // Si es para activar la repeticion
            drawable.setColorFilter(Color.parseColor("#11BB11"), PorterDuff.Mode.SRC_IN); // Ponemos el color de repeticion en verde, indicando que esta activo
            mpVector[position].setLooping(true); // Hacemos que la cancion se repita todo el rato
            repeat = 1; // Cambiamos el valor de repeticion
        }
        buttonRepeat.setImageDrawable(drawable); // Cambiamos la imagen del boton de repeat
    }

    // Este es el metodo que hace saltar a la siguiente cancion
    public void automaticNextSong(){
        if(!mpVector[position].isLooping()){ // Comprobamos si la cancion no esta en bucle
            mpVector[position].setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp){
                    NextSong(view); // Y si no esta saltamos a la siguiente cancion
                }
            });
        }
    }

    // Este es el metodo que hace sonar una cancion aleatoria
    public void randomSong(){
        if(!mpVector[position].isLooping()){ // Comprobamos si la cancion no esta en bucle
            Random random = new Random(); // Instanciamos el objeto random
            position = random.nextInt(3); // Indicamos hasta cuanto queremos, hacer un random
            NextSong(view); // Llamamos al metodo para la siguiente que suene la siguiente cancion
        }
    }

    // Este metodo sirve para poder redondear la imagen
    public void ImageBorderRadius(){
        Drawable originalDrawable = img_song.getDrawable();
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();
        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);
        roundedDrawable.setCornerRadius(25);
        img_song.setImageDrawable(roundedDrawable);
    }
}