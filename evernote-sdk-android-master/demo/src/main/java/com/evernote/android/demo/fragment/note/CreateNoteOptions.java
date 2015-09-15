package com.evernote.android.demo.fragment.note;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.evernote.android.demo.R;
import com.evernote.android.demo.task.CreateNewNoteTask;
import com.evernote.client.android.helper.Cat;

import net.vrallev.android.task.Task;
import net.vrallev.android.task.TaskExecutor;
import net.vrallev.android.task.TaskResult;

/**
 * @author rwondratschek
 */
public class CreateNoteOptions extends DialogFragment {


    private Button usingKeyboard;
    private Button usingOCR;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
/*
This Dialogue is opened when the user clicks the fabButton.
It offers two options
 - To create a note using keyboard
 - To create a note using OCR
 */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_create_note_options, null);

        usingKeyboard = (Button) view.findViewById(R.id.usingKeyboardButton);

        usingOCR = (Button) view.findViewById(R.id.usingOCRButton);

        usingKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CreateNoteDialogFragment().show(getChildFragmentManager(), CreateNoteDialogFragment.TAG);

            }
        });

        usingOCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.create_new_note)
                .setView(view)
                .create();
    }

    public void createNewNote(String title, String content, CreateNewNoteTask.ImageData imageData) {
        ((NoteContainerFragment) getParentFragment()).createNewNote(title,
               content, imageData);
    }



}