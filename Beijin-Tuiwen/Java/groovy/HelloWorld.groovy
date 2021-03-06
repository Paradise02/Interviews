import com.sun.net.httpserver.HttpServer

HttpServer.create(new InetSocketAddress(8080), 0).with {
    createContext("/") { http ->
        http.responseHeaders.add("Content-type", "text/plain")
        http.sendResponseHeaders(200, 0)
        http.responseBody.withWriter { out ->
            out << "Hello World"
        }
    }
    start()
}