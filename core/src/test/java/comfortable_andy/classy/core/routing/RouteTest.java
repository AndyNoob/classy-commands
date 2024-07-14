package comfortable_andy.classy.core.routing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteTest {

    @Test
    public void testGenerateRoute() {
        final List<Route> expected = Arrays.asList(
                new Route(Command.class),
                new Route(Command.class, Command.SubCommandB.class),
                new Route(Command.class, Command.SubCommandA.class),
                new Route(Command.class, Command.SubCommandB.class, Command.SubCommandB.SubCommandBB.class),
                new Route(Command.class, Command.SubCommandB.class, Command.SubCommandB.SubCommandBA.class),
                new Route(Command.class, Command.SubCommandA.class, Command.SubCommandA.SubCommandAA.class),
                new Route(Command.class, Command.SubCommandB.class, Command.SubCommandB.SubCommandBB.class, Command.SubCommandB.SubCommandBB.SubCommandBBA.class)
        );
        assertEquals(expected, Route.generateRoutes(Command.class));
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private static class Command {

        public class SubCommandA {
            public class SubCommandAA {
            }
        }

        public class SubCommandB {
            public class SubCommandBA {

            }

            public class SubCommandBB {
                public class SubCommandBBA {

                }
            }
        }

    }

}