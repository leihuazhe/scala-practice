package com.maple.implic.two

import java.sql.Connection

import scala.language.implicitConversions

class RichConnection(conn: Connection) {

  def executeUpdate(sql: String): Int = {
    conn.prepareStatement(sql).executeUpdate()
  }

}

object RichConnection {

  implicit def executeUpdate(connection: Connection): RichConnection = new RichConnection(connection)
}
