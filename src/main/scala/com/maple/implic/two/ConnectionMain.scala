package com.maple.implic.two

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import javax.sql.DataSource


object ConnectionMain {
  //引入隐式转换 func
  import com.maple.implic.two.RichConnection._

  def main(args: Array[String]): Unit = {
    //定义 dataSource
    val ds: DataSource = {
      val ds = new MysqlDataSource
      ds.setURL("jdbc:mysql://115.159.41.97:3306/maple?useUnicode=true&characterEncoding=utf8")
      ds.setUser("root")
      ds.setPassword("123456")
      ds
    }
    //获取 conn
    val connection = ds.getConnection
    //执行查询
    connection.executeUpdate("UPDATE  t_user SET  name = 'maple' WHERE id = 1")
  }
}