package comfortable_andy.classy.core.arguments;

import comfortable_andy.classy.core.reader.StringReader;

public class GreedyStringArgument extends Argument<String> {

    public GreedyStringArgument(StringReader str) {
        super(str);
    }

    @Override
    protected String parse(StringReader str) {
        return str.readAll();
    }

}
