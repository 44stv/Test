package com.sturc.Networking.Server.UrlUri;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

            // usually constant
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


/*            System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());*/

        } catch (URISyntaxException e) {
            System.out.println("URI bad syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL malformed: " + e.getMessage());
        }

    }
}