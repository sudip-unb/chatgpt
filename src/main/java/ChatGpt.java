import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChatGpt
{
    public static void chatGPT(String text) throws Exception
    {
        String url = "https://api.openai.com/v1/completions";

        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer <API Key>");

        Map<String, String > hm = new HashMap<>();
        hm.put("role", "user");
        hm.put("content", text);

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 0.2);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .collect(Collectors.joining());
        String op = new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");
        System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
    }
    public static void main(String[] args) throws Exception {
        while(true) {
            Scanner sc = new Scanner(System.in);
            String inputText = sc.nextLine();
            if("Break".equalsIgnoreCase(inputText) || "Exit".equalsIgnoreCase(inputText)){
                System.exit(0);
            }
            else{
                chatGPT(inputText);
            }
        }
    }
}
