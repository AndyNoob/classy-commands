package io.github.andynoob.classy.core.util;

import io.github.andynoob.classy.core.ClassyCommand;
import io.github.andynoob.classy.core.routing.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ClassyUtil {

    @Nullable
    public static ClassyCommand.CommandInfo getAnnotation(@NotNull final ClassyCommand command) {
        return command.getClass().getAnnotation(ClassyCommand.CommandInfo.class);
    }

    @NotNull
    public static List<String> getAliases(@NotNull final ClassyCommand command) {
        final var annotation = getAnnotation(command);
        if (annotation == null) return new ArrayList<>();
        return Arrays.asList(annotation.aliases());
    }

    /**
     * @param command the command that has the annotation
     * @return the <strong>UNCOLORED</strong> description
     */
    @NotNull
    public static String getDescription(@NotNull final ClassyCommand command) {
        final var annotation = getAnnotation(command);
        if (annotation == null || annotation.description() == null) return "";
        return annotation.description();
    }

}
