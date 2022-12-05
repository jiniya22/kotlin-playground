package xyz.applebox.kotlin.solid

abstract class Datasource(val dbName: String) {
    abstract fun getJdbcUrl(): String
}

class MariadbDatasource(dbName: String): Datasource(dbName) {
    override fun getJdbcUrl(): String {
        return "jdbc:mariadb://localhost:3306/${dbName}"
    }
}
class H2Datasource(dbName: String): Datasource(dbName) {
    override fun getJdbcUrl(): String {
        return "jdbc:h2:mem:${dbName}"
    }
}

class ConnectDatabase {
    fun connect(datasource: Datasource) {
        println("database 연결 ... ${datasource.getJdbcUrl()}")
    }
}