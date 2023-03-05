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
    private boolean isPlaying = false;
    private AudioListAdapter audioListAdapter;
    private BottomSheetBehavior bottomSheetBehavior;
    private ConstraintLayout playerSheet;
    private File fileToPlay, allFiles[];
    private Handler seekbarHandler;
    private ImageButton playBtn;
    private MediaPlayer mediaPlayer = null;
    private RecyclerView audioList;
    private Runnable updateSeekbar;
    private SeekBar seekbar;
    private TextView playerHeader, playerFileName;

    public AudioListFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_audio_list, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        playerSheet = view.findViewById(R.id.player_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(playerSheet);
        audioList = view.findViewById(R.id.audio_list_view);

        playBtn = view.findViewById(R.id.player_play);
        playerHeader = view.findViewById(R.id.player_header_name);
        playerFileName = view.findViewById(R.id.player_file_name);

        String path = getActivity().getExternalFilesDir("/").getAbsolutePath();
        allFiles = new File(path).listFiles();
        audioListAdapter = new AudioListAdapter(allFiles, this);
        audioList.setLayoutManager(new LinearLayoutManager(getContext()));
        audioList.setAdapter(audioListAdapter);

        seekbar = view.findViewById(R.id.seekbar);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
            @Override public void onSlide(@NonNull View bottomSheet, float slideOffset) {}
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying) pauseAudio();
                else {
                    if(fileToPlay != null) resumeAudio();
                }
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}
            @Override public void onStartTrackingTouch(SeekBar seekBar) {
                pauseAudio();
            }
            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                mediaPlayer.seekTo(progress);
                resumeAudio();
            }
        });
    }

    @Override
    public void onClickListener(File file, int position) {
        fileToPlay = file;
        if (isPlaying) stopAudio();
        else playAudio(fileToPlay);
    }

    private void pauseAudio(){
        mediaPlayer.pause();
        isPlaying = false;
        playBtn.setImageResource(R.drawable.ic_play);
        seekbarHandler.removeCallbacks(updateSeekbar);
        updateRunnable();
    }

    private void resumeAudio(){
        mediaPlayer.start();
        isPlaying = true;
        playBtn.setImageResource(R.drawable.ic_pause);
    }

    private void stopAudio() {
        if(isPlaying){
            isPlaying = false;
            playerHeader.setText("Stopped");
            playBtn.setImageResource(R.drawable.ic_play);
            mediaPlayer.stop();
            fileToPlay = null;
        }
    }

    private void playAudio(File fileToPlay) {
        mediaPlayer = new MediaPlayer();
        playBtn.setImageResource(R.drawable.ic_pause);
        Toast.makeText(getContext(), fileToPlay.getAbsolutePath(), Toast.LENGTH_LONG).show();
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