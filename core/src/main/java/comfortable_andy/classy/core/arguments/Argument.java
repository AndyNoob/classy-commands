package comfortable_andy.classy.core.arguments;


import comfortable_andy.classy.core.reader.StringReader;

public abstract class Argument<T> {

    protected final T t;

    protected Argument(StringReader str) {
        this.t = parse(str);
    }

    protected abstract T parse(StringReader str);

}
