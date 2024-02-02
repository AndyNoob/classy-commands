package io.github.andynoob.classy.core;

import io.github.andynoob.classy.core.routing.Route;
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
public abstract class ClassyCommand {

    @NotNull
    protected final String name;
    @NotNull
    @Getter(AccessLevel.PACKAGE)
    List<Route> routes = new ArrayList<>();

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface CommandInfo {
        String[] aliases() default {};
        String description();
    }

}
