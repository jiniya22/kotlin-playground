package xyz.applebox.kotlin.solid

interface Connection {
    fun connect();
}

class HttpConnection: Connection {
    override fun connect() {
        println("HttpConnection 연결")
    }

    fun http() {
        println("HTTP 연결")
    }
}

class SocketConnection: Connection {
    override fun connect() {
        println("SocketConnection 연결")
    }
    fun socket() {
        println("소켓 연결")
    }
}