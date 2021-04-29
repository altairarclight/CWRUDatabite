
@SpringBootApplication
@RestController
public class DataBiteBE {
    public static void main(String[] args) {
        System.setProperty("server.port", 8081);
        System.setProperty("http.maxConnections", "10");

        SpringApplication.run(DataBiteBE.class, args);
    }
}
