package feedback.web

import org.hibernate.Filter

/**
*   Apply the hibernate filter for the UserDomain to limit what data a user can see
*/
class UserTenantFilters {

    def springSecurityService

    def filters = {
        all(uri: '/api/login', invert: true) {
            before = {
                def loggedInUserId = springSecurityService.getCurrentUser().id
				println "got the user id: " + loggedInUserId
                Category.enableHibernateFilter('userFilter').setParameter('userId', loggedInUserId)
            }
        }
    }
}
