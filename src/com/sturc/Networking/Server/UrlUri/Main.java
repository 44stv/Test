package com.sturc.Networking.Server.UrlUri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(10000);


            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page.");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }
            inputReader.close();


/*            urlConnection.setDoOutput(true);
            urlConnection.connect();

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("Key: " + key);
                for (String string : value) {
                    System.out.println("Value: " + value);
                }
            }*/

/*            URI uri = url.toURI();
            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());*/

/*            // usually constant
            URI baseURI = new URI("http://username:password@myserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tv?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedURI1 = baseURI.resolve(uri1);
            URI resolvedURI2 = baseURI.resolve(uri2);
            URI resolvedURI3 = baseURI.resolve(uri3);

            URL url1 = resolvedURI1.toURL();
            System.out.println("URL1 = " + url1);
            URL url2 = resolvedURI2.toURL();
            System.out.println("URL2 = " + url2);
            URL url3 = resolvedURI3.toURL();
            System.out.println("URL3 = " + url3);

            URI relativizedURI = baseURI.relativize(resolvedURI2);
            System.out.println("Relative URI = " + relativizedURI);
*/
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}