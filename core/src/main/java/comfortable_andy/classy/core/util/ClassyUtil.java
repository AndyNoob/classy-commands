package comfortable_andy.classy.core.util;

import comfortable_andy.classy.core.ClassyEndpoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ClassyUtil {

    @Nullable
    public static ClassyEndpoint.CommandInfo getAnnotation(@NotNull final ClassyEndpoint<?> command) {
        return command.getClass().getAnnotation(ClassyEndpoint.CommandInfo.class);
    }

    @NotNull
    public static List<String> getAliases(@NotNull final ClassyEndpoint<?> command) {
        final var annotation = getAnnotation(command);
        if (annotation == null) return new ArrayList<>();
        return Arrays.asList(annotation.aliases());
    }

    /**
     * @param command the command that has the annotation
     * @return the <strong>UNCOLORED</strong> description
     */
    @NotNull
    public static String getDescription(@NotNull final ClassyEndpoint<?> command) {
        final var annotation = getAnnotation(command);
        if (annotation == null || annotation.description() == null) return "";
        return annotation.description();
    }

}
