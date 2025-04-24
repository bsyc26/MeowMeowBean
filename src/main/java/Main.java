import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.daos.UserDao;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        config.router.apiBuilder(() -> {
            path("")
        })
        Javalin app = Javalin.create();
    }

}
