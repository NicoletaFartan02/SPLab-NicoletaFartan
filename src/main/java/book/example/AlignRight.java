package book.example;

public class AlignRight implements AlignStrategy{

    @Override
    public void render(Paragraph paragraph, Context context) {
        int lineWidth = context.getLineWidth();
        int textLength = paragraph.getText().length();
        for (int i = 0; i < textLength; i += lineWidth) {
            int endIndex = Math.min(i + lineWidth, textLength);
            String line = paragraph.getText().substring(i, endIndex);
            int paddingLength = lineWidth - line.length();
            String padding = " ".repeat(paddingLength);
            String formattedLine = padding + line;
            System.out.println(formattedLine);
        }
    }
}
