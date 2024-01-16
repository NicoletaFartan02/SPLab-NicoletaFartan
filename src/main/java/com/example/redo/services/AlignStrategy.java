package com.example.redo.services;

import com.example.redo.models.Context;
import com.example.redo.models.Paragraph;

public interface AlignStrategy {

    void render(Paragraph paragraph, Context context);
}
