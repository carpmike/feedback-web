package feedback.web

import org.apache.commons.logging.LogFactory

abstract class UserDomain {

    private static final log = LogFactory.getLog(this)

    def springSecurityService //injected by spring

  	Integer userId
  	Date dateCreated
  	Date lastUpdated
  	
    static constraints = {
		    userId nullable: false 
    }

   	def beforeValidate () {
   	    log.debug("Before the insert/update userId is: " + userId)
        if (!userId) {
            log.debug("Getting the userId from the authenticated user: " + springSecurityService.getCurrentUser())
            userId = springSecurityService.getCurrentUser().id
        }
        if (!userId) {
            log.error("Trying to save data with no user attached.")
        }
   	}	
}