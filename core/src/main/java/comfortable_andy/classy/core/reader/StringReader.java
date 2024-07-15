package comfortable_andy.classy.core.reader;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringReader {

    private int cursor = 0;
    private final String reading;

    public boolean hasNext() {
        return cursor < reading.length();
    }

    public char next() {
        return reading.charAt(cursor++);
    }

    public void jumpToContent() {
        while (hasNext() && Character.isWhitespace(peek())) next();
    }

    public char peek() {
        return reading.charAt(cursor);
    }

    public String readStringUntil(char ch) {
        jumpToContent();
        final int start = cursor;
        Character last = null;
        while (hasNext()) {
            if (!(last != null && last == '\\') && peek() == ch) break;
            last = next();
        }
        return reading.substring(start, cursor);
    }

    public String readStringToken() {
        return readStringUntil(' ');
    }

    public String readQuotedString() {
        if (!hasNext()) return "";
        if (peek() != '"') return readStringUntil(' ');
        else return readStringUntil('"');
    }

    public String readAll() {
        int start = cursor;
        cursor = reading.length();
        return reading.substring(start);
    }

}
