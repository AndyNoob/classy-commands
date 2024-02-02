package io.github.andynoob.classy.core.routing;

import io.github.andynoob.classy.core.util.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;
import java.util.stream.Collectors;

public record Route(@Unmodifiable List<Class<?>> argumentsInOrder) {

    public Route(@NotNull final Class<?>... classes) {
        this(Arrays.asList(classes));
    }

    public Route(@Unmodifiable List<Class<?>> argumentsInOrder) {
        this.argumentsInOrder = Collections.unmodifiableList(argumentsInOrder);
    }

    @Contract("_ -> !null")
    public @NotNull Route createExtended(@NotNull final Class<?> aClass) {
        final var list = new ArrayList<>(argumentsInOrder);
        list.add(aClass);
        return new Route(list);
    }

    @Nullable
    public Class<?> latest() {
        return this.argumentsInOrder.isEmpty() ? null : this.argumentsInOrder.get(this.argumentsInOrder.size() - 1);
    }

    @Override
    public String toString() {
        return argumentsInOrder.stream().map(Class::getSimpleName).collect(Collectors.joining(" -> "));
    }

    @NotNull
    public static List<Route> generateRoutes(@NotNull final Class<?> aClass) {
        final List<Route> routes = new ArrayList<>();

        final List<Pair<Route, Class<?>[]>> routeMap = new ArrayList<>();
        final Route route = new Route(aClass);

        routeMap.add(new Pair<>(route, aClass.getDeclaredClasses()));

        for (int i = 0; i < routeMap.size(); i++) {
            final Pair<Route, Class<?>[]> pair = routeMap.get(i);
            final Route key = pair.a();
            routes.add(key);
            final Class<?>[] arr = pair.b();
            for (Class<?> clazz : arr) {
                if (!clazz.isMemberClass()) continue;
                routeMap.add(new Pair<>(key.createExtended(clazz), clazz.getDeclaredClasses()));
            }
        }

        return routes;
    }

}
