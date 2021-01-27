package stringmethods.url;

public class UrlManager {
    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public UrlManager(String url) {
        /*String[] temp = url.split(":");
        protocol = temp[0];
        if (temp.length < 3) {
            String[] other = temp[1].split("/");
            host = other[0];
            query = other[other.length - 1].split("\\?")[i];

            for (int i = 1; i < other.length - 1; i++) {
                path += other[i] + "/";
            }
        } else {

        }*/
        protocol = url.substring(0, url.indexOf("://"));
        int protocolLength = protocol.length();
        host = url.substring(url.charAt(protocolLength) + 3, url.indexOf("/", protocolLength + 3));
        if (host.contains(":")) {
            host = host.split(":")[0];
            port = Integer.parseInt(host.split(":")[1]);
        }
        if (url.contains("\\?")) {
            path = url.substring(protocolLength + 3 + host.length() + port.toString().length() + 1, url.indexOf("?"));
            query = url.substring(url.indexOf("\\"));
        } else {
            path = url.substring(protocolLength + 3 + host.length() + port.toString().length() + 1);
        }
    }
}
