import feedback.web.Person;
import grails.rest.render.hal.HalJsonRenderer

// Place your Spring DSL code here
beans = {
	halPersonRenderer(HalJsonRenderer, Person)
}

