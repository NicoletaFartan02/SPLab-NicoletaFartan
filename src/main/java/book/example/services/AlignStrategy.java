package book.example.services;

import book.example.models.Context;
import book.example.models.Paragraph;

public interface AlignStrategy {
     void render(Paragraph paragraph, Context context);

}
