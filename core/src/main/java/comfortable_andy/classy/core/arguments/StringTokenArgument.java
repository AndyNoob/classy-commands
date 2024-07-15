package comfortable_andy.classy.core.arguments;

import comfortable_andy.classy.core.reader.StringReader;

public class StringTokenArgument extends Argument<String> {

    public StringTokenArgument(StringReader str) {
        super(str);
    }

    @Override
    protected String parse(StringReader str) {
        return str.readStringUntil(' ');
    }

}
