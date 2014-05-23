import javax.sql.PooledConnection
import org.grails.plugin.hibernate.filter.HibernateFilterDomainConfiguration

dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    configClass = HibernateFilterDomainConfiguration
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            // dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost/feedback?useUnicode=yes&characterEncoding=UTF-8"
			username = "feedback_db"
			password = "Fm1l0c0mAb"
            logSql = true
            formatSql = true            
        }
    }
    test {
        dataSource {
            // dbCreate = "create"
            url = "jdbc:mysql://localhost/feedback_test?useUnicode=yes&characterEncoding=UTF-8"
            username = "feedback_test"
            password = "Fm1l0c0mAt"
        }
    }
    production {
        dataSource {
			pooled = false
            // dbCreate = "create" // need to change this and use grails' db migration tool when schema is stable
            jndiName = "java:comp/env/jdbc/feedback"
        }
    }
}

