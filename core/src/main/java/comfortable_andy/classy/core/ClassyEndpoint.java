package comfortable_andy.classy.core;

import comfortable_andy.classy.core.routing.Route;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class ClassyEndpoint<S> {

    @NotNull
    @Getter(AccessLevel.PACKAGE)
    List<Route> routes = new ArrayList<>();

    protected abstract boolean execute(S sender);

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface CommandInfo {
        String value();
        String[] aliases() default {};
        String description();
    }

}
