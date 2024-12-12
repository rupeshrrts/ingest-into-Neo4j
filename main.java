import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;


public class Main {
    private static final String URI = "bolt://localhost:7687";  // Change if you're using a different host/port
    private static final String USER = "neo4j";                 // Default username
    private static final String PASSWORD = "12345678";


    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("aws","iam","list-users");

        JsonArray user = new JsonArray();

        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line= reader.readLine())!=null){
            sb.append(line);
//            System.out.println(line);
        }
        line = sb.toString();
        JsonObject jsonObject = JsonParser.parseString(line).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("Users");

        String username;

        try (Driver driver = GraphDatabase.driver(URI, AuthTokens.basic(USER, PASSWORD));
             Session session = driver.session()) {

            for(JsonElement jsonElement: jsonArray) {
                JsonObject userObject = jsonElement.getAsJsonObject();
                username = userObject.get("UserName").getAsString();
                String cypherQuery = "CREATE (u:User {name: $username })";
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("username", username);
                session.run(cypherQuery, parameters);
                System.out.println(username);
            }

            System.out.println("Node created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
