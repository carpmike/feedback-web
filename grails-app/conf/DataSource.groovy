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
            username = "feedbockdb"
            password = "Fm1l0c0mAb"
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://aa1lqclsgwjugkf.crujaacepihh.us-east-1.rds.amazonaws.com:3306/cm_feedback?user=feedbockdb&password=Fm1l0c0mAb"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect
            properties {
                validationQuery = "SELECT 1"
                testOnBorrow = true
                testOnReturn = true
                testWhileIdle = true
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                minEvictableIdleTimeMillis = 1800000
            }
        }
    }
}

