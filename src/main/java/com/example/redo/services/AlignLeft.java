package com.example.redo.services;

import com.example.redo.models.Context;
import com.example.redo.models.Paragraph;

public class AlignLeft implements AlignStrategy {

    public void render(Paragraph paragraph, Context context) {
        int lineWidth = context.getLineWidth();
        int textLength = paragraph.getText().length();
        for (int i = 0; i < textLength; i += lineWidth) {
            int endIndex = Math.min(i + lineWidth, textLength);
            String line = paragraph.getText().substring(i, endIndex);
            System.out.println(line);
        }

    }
}
