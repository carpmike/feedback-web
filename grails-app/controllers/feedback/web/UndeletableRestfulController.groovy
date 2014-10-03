package feedback.web

import grails.converters.JSON
import grails.rest.RestfulController
import static org.springframework.http.HttpStatus.*
import grails.artefact.Artefact
import grails.transaction.Transactional
import grails.util.GrailsNameUtils

import org.codehaus.groovy.grails.web.servlet.HttpHeaders
import org.springframework.http.HttpStatus

class UndeletableRestfulController<T> extends RestfulController<T> {

	UndeletableRestfulController(Class<T> domainClass) {
		this(domainClass, false)
	}
	UndeletableRestfulController(Class<T> domainClass, boolean readOnly) {
		super(domainClass, readOnly)
	}

	/**
	 * Lists all resources up to the given maximum
	 *
	 * @param max The maximum
	 * @return A list of resources
	 */
	@Override
	def index(Integer max) {
		// ignoring max for now
		def resources = listAllActiveResources()
		respond listAllActiveResources(), model: [("${resourceName}Count".toString()): resources.size()]
	}
	
	
	/**
	 * Deletes a resource for the given id - but doesn't actually delete them, just sets them inactive
	 * @param id The id
	 */
	@Transactional
	def delete() {
		if(handleReadOnly()) {
			return
		}

		def instance = queryForResource(params.id)
		if (instance == null) {
			notFound()
			return
		}

		instance.isInactive = true
		
		instance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [message(code: "${resourceClassName}.label".toString(), default: resourceClassName), instance.id])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT } // NO CONTENT STATUS CODE
		}
	}
	
	/**
	 * List all of resource based on parameters
	 *
	 * @return List of resources or empty if it doesn't exist
	 */
	protected java.util.List listAllActiveResources() {
		resource.findAllByIsInactive(false)
	}

}
