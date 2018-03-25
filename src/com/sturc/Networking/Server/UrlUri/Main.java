package com.sturc.Networking.Server.UrlUri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");

            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.connect();


            BufferedReader input = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println("Key: " + key);
                for (String string : value) {
                    System.out.println("Value: " + value);
                }
            }

/*
            String line = "";
            while (line != null) {
                line = input.readLine();
                System.out.println(line);
            }
            input.close();
*/


//            URI uri = url.toURI();



/*            System.out.println("Scheme = " + uri.getScheme());
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