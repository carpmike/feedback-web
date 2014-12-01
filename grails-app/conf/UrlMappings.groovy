class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }
		
		// for restful interface
		"/api/reminders"(resources:'reminder', includes:['save'])
		"/api/guest/users"(resources:'user', includes:['save'])		
        "/api/feedbacks"(resources:'feedback')
		"/api/categories"(resources:'category')
		"/api/persons"(resources:'person')
		"/api/feedbackTypes"(resources:'feedbackType')
		
		
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
