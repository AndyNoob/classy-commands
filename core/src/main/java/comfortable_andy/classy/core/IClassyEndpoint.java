package comfortable_andy.classy.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface IClassyEndpoint<S> {

    boolean execute(S sender);

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface CommandInfo {
        String value();
        String[] aliases() default {};
        String description();
    }

}
