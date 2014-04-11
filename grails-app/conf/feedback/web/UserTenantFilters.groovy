package feedback.web

import org.hibernate.Filter

/**
*   Apply the hibernate filter for the UserDomain to limit what data a user can see
*/
class UserTenantFilters {

    def springSecurityService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                def loggedInUserId = springSecurityService.getCurrentUser().id
                Category.enableHibernateFilter('userFilter').setParameter('userId', loggedInUserId)
            }
        }
    }
}
