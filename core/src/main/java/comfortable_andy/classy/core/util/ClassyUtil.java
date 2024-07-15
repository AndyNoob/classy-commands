package comfortable_andy.classy.core.util;

import comfortable_andy.classy.core.IClassyEndpoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ClassyUtil {

    @Nullable
    public static IClassyEndpoint.CommandInfo getAnnotation(@NotNull final IClassyEndpoint<?> command) {
        return command.getClass().getAnnotation(IClassyEndpoint.CommandInfo.class);
    }

    @NotNull
    public static List<String> getAliases(@NotNull final IClassyEndpoint<?> command) {
        final var annotation = getAnnotation(command);
        if (annotation == null) return new ArrayList<>();
        return Arrays.asList(annotation.aliases());
    }

    /**
     * @param command the command that has the annotation
     * @return the <strong>UNCOLORED</strong> description
     */
    @NotNull
    public static String getDescription(@NotNull final IClassyEndpoint<?> command) {
        final var annotation = getAnnotation(command);
        if (annotation == null || annotation.description() == null) return "";
        return annotation.description();
    }

}
