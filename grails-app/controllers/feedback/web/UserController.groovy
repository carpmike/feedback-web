package feedback.web

import static org.springframework.http.HttpStatus.*

import grails.converters.JSON
import org.hibernate.FetchMode as FM
import grails.rest.RestfulController
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.servlet.HttpHeaders
import org.springframework.http.HttpStatus

class UserController extends RestfulController<User> {

    static responseFormats = ['json', 'xml']
	
    UserController() {
        super(User)
    }
	
    /**
     * Saves a resource
     */
    @Transactional
    def save() {
        if(handleReadOnly()) {
            return
        }
        def user = createResource()

        user.validate()
        if (user.hasErrors()) {
            respond user.errors, view:'create' // STATUS CODE 422
            return
        }

        user.save flush:true
		
		// now add the user role
		def userRole = Role.findByAuthority('ROLE_USER')
		UserRole.create user, userRole, true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: "${resourceName}.label".toString(), default: resourceClassName), user.id])
                redirect user
            }
            '*' {
                response.addHeader(HttpHeaders.LOCATION,
                        g.createLink(
                                resource: this.controllerName, action: 'show',id: user.id, absolute: true,
                                namespace: hasProperty('namespace') ? this.namespace : null ))
                respond user, [status: CREATED]
            }
        }
    }
}
